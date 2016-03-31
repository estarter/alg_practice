import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testAmount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testAmount; i++) {
            int ordersAmount = Integer.parseInt(reader.readLine());
            Order[] orders = new Order[ordersAmount];
            for (int j = 0; j < ordersAmount; j++) {
                orders[j] = new Order(reader.readLine());
            }
            int maxPrice = findMaxPrice(orders);
            System.out.println(maxPrice);
        }
    }

    public static int findMaxPrice(Order[] orders) {
        return findMaxPrice_DP(orders);
//        return findMaxPrice_DP_onTimeIntervals(orders);
    }

    public static int findMaxPrice_DP(Order[] orders) {
        if (orders.length == 0) return 0;

        // O(n*logN)
        Arrays.sort(orders, (o1, o2) -> o1.finish - o2.finish);

        // 2*N + O(n*logN) => O(n*logN)
        int[] prevIntervalIndex = getPrevIntervals(orders);

        int[] maxPrices = new int[orders.length];
        for (int i = 0; i < orders.length; i++) {
            int additionalPrice = prevIntervalIndex[i] < 0 ? 0 : maxPrices[prevIntervalIndex[i]];
            maxPrices[i] = Math.max(orders[i].price + additionalPrice, i == 0 ? 0 : maxPrices[i-1]);
        }

        return maxPrices[orders.length-1];
    }

    static int[] getPrevIntervals(Order[] orders) {
        int[] finish = new int[orders.length];
        for (int i = 0; i < orders.length; i++) {
            finish[i] = orders[i].finish;
        }

        int[] intervals = new int[orders.length];
        for (int i = 0; i < orders.length; i++) {
            intervals[i] = weakBinarySearch(finish, orders[i].start);
        }
        return intervals;
    }

    /**
     * Modified bin search alg that return the previous closest element if exact element is not in the array
     * @param array sorted array of integers
     * @param key search int value
     * @return index of the element
     *          which value is equal to the key
     *          or the biggest element which value is smaller that the key
     */
    static int weakBinarySearch(int[] array, int key) {
        if (array.length == 0) return -1;
        return weakBinarySearch(array, key, 0, array.length - 1);
    }

    private static int weakBinarySearch(int[] array, int value, int from, int to) {
        if ((to - from) == 0) { // one elem
            if (value >= array[from]) return from;
            else return from - 1;
        }

        int midKey = (to - from) / 2 + from;
        int midValue = array[midKey];
        if ((to - from) < 3) {
            if (value < array[from]) {
                return from - 1;
            }
            if (value < midValue) {
                return from;
            } else if (value == midValue) {
                return midKey;
            } else if (value < array[to]) {
                return midKey;
            } else {
                return to;
            }
        } else {
            if (value == midValue) {
                return midKey;
            } else if (value > midValue) {
                return weakBinarySearch(array, value, midKey+1 , to);
            } else {
                return weakBinarySearch(array, value, from, midKey-1);
            }
        }
    }

    public static int findMaxPrice_DP_onTimeIntervals(Order[] orders) {
        int maxTime = getMaxTime(orders);
        int[] maxPrices = new int[maxTime+1];
        maxPrices[0] = 0;
        for (int i = 1; i < maxPrices.length; i++) {
            int maxPrice = 0;
            for (int j = 0; j < i; j++) {
                maxPrice = Math.max(maxPrice, maxPrices[j] + getBestForTimeInterval(orders, j, i));
            }
            maxPrices[i] = maxPrice;
        }
        return maxPrices[maxTime];
    }

    private static int getBestForTimeInterval(Order[] orders, int from, int to) {
        int maxPrice = 0;
        for (Order order : orders) {
            if (order.isInInterval(from, to)) {
                maxPrice = Math.max(maxPrice, order.price);
            }
        }
        return maxPrice;
    }

    private static int getMaxTime(Order[] orders) {
        int max = 0;
        for (Order order : orders) {
            max = Math.max(max, order.start + order.duration);
        }
        return max;
    }


}

class Order {
    int start;
    int duration;
    int finish;
    int price;

    public Order(String input) {
        String [] data = input.split(" ");
        start = Integer.parseInt(data[0]);
        duration = Integer.parseInt(data[1]);
        price = Integer.parseInt(data[2]);
        finish = start + duration;
    }

    public boolean isInInterval(int from, int to) {
        return start >= from && finish <= to;
    }

    @Override
    public String toString() {
        return "Order{" +
                "start=" + start +
                ", finish=" + finish +
                ", price=" + price +
                '}';
    }
}