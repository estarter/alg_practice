package magic_number_square;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alexey Merezhin
 */
public class MNS {
    public int combos(int[] numbers) {
        Set<Integer> hash = new HashSet<>();
        findAll(numbers, 0, hash);
        return hash.size();
    }

    private void findAll(int[] nums, int p, Set<Integer> hash) {
        // permutations
        for (int k = p; k < nums.length; k++) {
            swap(nums, k, p);
            findAll(nums, p+1, hash);
            swap(nums, k, p);
        }
        // if the square is magic - add to results
        if (nums[0] + nums[1] + nums[2] == nums[3] + nums[4] + nums[5] &&
            nums[0] + nums[1] + nums[2] == nums[6] + nums[7] + nums[8] &&
            nums[0] + nums[3] + nums[6] == nums[1] + nums[4] + nums[7] &&
            nums[0] + nums[3] + nums[6] == nums[2] + nums[5] + nums[8]) {
            int h = 0;
            for (int i = 0; i < nums.length; i++) {
                h = h*10 + nums[i];
            }
            hash.add(h);
        }
    }

    private void swap(int[] numbers, int k, int p) {
        int x = numbers[k];
        numbers[k] = numbers[p];
        numbers[p] = x;
    }

    @Test
    public void test() {
        assertEquals(18, combos(new int[]{1,2,3,3,2,1,2,2,2}));
        assertEquals(1,  combos(new int[]{4,4,4,4,4,4,4,4,4}));
        assertEquals(36, combos(new int[]{1,5,1,2,5,6,2,3,2}));
        assertEquals(0,  combos(new int[]{1,2,6,6,6,4,2,6,4}));
    }
}
