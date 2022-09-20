package offer;/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/

import lombok.SneakyThrows;
import sort.QuickSort.QuickSort;
import sort.Sort;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2022/3/3
 **/
public class Solution {

    public void quick(int[] array){
        quick(array,0,array.length-1);

    }

    public void quick(int[] array, int l, int r){
        if(l>=r) return;
        int m = partition(array,l,r);
        quick(array,l,m-1);
        quick(array,m+1,r);
    }

    public int[] search(int[] array,int k){
        return quickSearch(array,0,array.length-1,k-1);

    }
    public int[] quickSearch(int[] array, int l, int r,int k){
        int m = partition(array,l,r);
        if(m == k) return Arrays.copyOf(array,k+1);
        return m>k? quickSearch(array,l,m-1,k):quickSearch(array,m+1,r,k);
    }

    public int partition(int[] array, int l, int r){
        int i=l,j=r+1;
        int a = array[l];
        while (true){
            while (array[++i]<a && i!=r);
            while (array[--j]>a && i!=l);
            if(i>=j){
                break;
            }
            int te = array[i];
            array[i] = array[j];
            array[j] = te;
        }
        int te = array[l];
        array[l] = array[j];
        array[j] = te;
        return j;
    }

    public static void main(String[] args) {
        int[] test = {0,0,2,3,2,1,1,2,0,4};
        Solution a = new Solution();
        System.out.println(Arrays.toString(test));
//        a.quick(test);
        System.out.println(Arrays.toString(a.search(test,10)));
        System.out.println(Arrays.toString(test));

//        String s = "dasda";
//        s.toCharArray();
//        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b)->a-b);
//        q.offer(1);
//        q.offer(2);
//
//        while (!q.isEmpty()) {
//            System.out.println(q.poll());
//        }
    }

    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> queue = new LinkedList<>();
        while(head!=null){
            queue.addFirst(head);
        }
        int n = queue.size()/2;
        for(int i=0;i<n;i++){
            if(queue.getFirst().val == queue.getLast().val){
                queue.removeFirst();
                queue.removeLast();
            }else{
                return false;
            }
        }
        return queue.size()<=1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



}
