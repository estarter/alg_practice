package interval_scheduling.weighted;

/**
 * Created by amerezhi on 3/31/16.
 */
public class WeakBinarySearch {
    /**
     * Modified bin search alg that return the previous closest element if exact element is not in the array
     * @param array sorted array of integers
     * @param key search int value
     * @return index of the element
     *          which value is equal to the key
     *          or the biggest element which value is smaller that the key
     */
    static int search(int[] array, int key) {
        if (array.length == 0) return -1;
        return search(array, key, 0, array.length - 1);
    }

    private static int search(int[] array, int value, int from, int to) {
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
                return search(array, value, midKey + 1, to);
            } else {
                return search(array, value, from, midKey-1);
            }
        }
    }
}
