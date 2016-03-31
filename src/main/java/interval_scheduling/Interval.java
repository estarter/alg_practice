package interval_scheduling;

/**
 * Created by amerezhi on 3/31/16.
 */
public class Interval {
    public String label;
    public int start;
    public int duration;
    public int finish;
    public int price;

    public Interval(String input) {
        String [] data = input.split(" ");
        start = Integer.parseInt(data[0]);
        duration = Integer.parseInt(data[1]);
        price = Integer.parseInt(data[2]);
        finish = start + duration;
    }

    public Interval(String label, int start, int finish) {
        this.label = label;
        this.start = start;
        this.finish = finish;
    }

    public boolean isInInterval(int from, int to) {
        return start >= from && finish <= to;
    }

    @Override
    public String toString() {
        return "Order{" +
                ((label != null) ? "label="+ label +"," : "") +
                "start=" + start +
                ", finish=" + finish +
                ", price=" + price +
                '}';
    }
}
