package dynamic_programming;

/**
 * @author Alexey Merezhin
 */
public class ParenthesesPerm {
    static void print_all_pairs(int num) {
        print_all_pairs("(", num-1, num);
    }

    static void print_all_pairs(String prefix, int openAmount, int closeAmount) {
        if (openAmount == 0 && closeAmount == 0) System.out.println(prefix);

        if (openAmount > 0) print_all_pairs(prefix + "(", openAmount - 1, closeAmount);
        if (openAmount < closeAmount) print_all_pairs(prefix + ")", openAmount, closeAmount - 1);
    }


    public static void main(String[] args) {
        print_all_pairs(3);
    }
}
