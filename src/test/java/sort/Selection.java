package sort;

import java.util.Arrays;

public class Selection<T extends Comparable<T>> extends Sort {
    @Override
    public void sort(Comparable[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] test = {5,8,7,3,1,9};
        Sort<Integer> selection = new Selection<>();
        System.out.println(Arrays.toString(test));
        selection.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
