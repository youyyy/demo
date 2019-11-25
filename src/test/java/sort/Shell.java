package sort;

import java.util.Arrays;

public class Shell<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {

        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
    public static void main(String[] args) {
        Integer[] test = {5,8,7,3,1,9};
        Sort<Integer> selection = new Shell<>();
        System.out.println(Arrays.toString(test));
        selection.sort(test);
        System.out.println(Arrays.toString(test));
    }
}