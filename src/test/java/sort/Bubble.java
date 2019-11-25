package sort;

import java.util.Arrays;

public class Bubble<T extends Comparable<T>> extends Sort{

    @Override
    public void sort(Comparable[] nums) {
        int N = nums.length;
        boolean hasSorted = false;
        for (int i = N - 1; i > 0 && !hasSorted; i--) {
            hasSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    hasSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] test = {5,8,7,3,1,9};
        Sort<Integer> selection = new Bubble<>();
        System.out.println(Arrays.toString(test));
        selection.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
