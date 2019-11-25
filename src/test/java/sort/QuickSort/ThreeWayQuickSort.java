package sort.QuickSort;

import sort.Sort;

import java.util.Arrays;

public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {

    @Override
    public void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }
    public static void main(String[] args) {
        Integer[] test = {5,8,7,3,1,9};
        Sort<Integer> selection = new ThreeWayQuickSort<>();
        System.out.println(Arrays.toString(test));
        selection.sort(test);
        System.out.println(Arrays.toString(test));
    }
}