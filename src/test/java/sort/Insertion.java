package sort;

import java.util.Arrays;

public class Insertion<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }
    public static void main(String[] args) {
        Integer[] test = {5,8,7,3,1,9};
        Sort<Integer> selection = new Insertion<>();
        System.out.println(Arrays.toString(test));
        selection.sort(test);
        System.out.println(Arrays.toString(test));
    }
}