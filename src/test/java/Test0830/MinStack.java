package Test0830;/*
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

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2021/9/10
 **/
class MinStack {
    private Node head;

    public class Node{
        int val;
        int min;
        Node next;
        public Node(){

        }
        public Node(int val,int min,Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        if(head == null){
            head = new Node(val,val,null);
        }else{
            head = new Node(val,Math.min(val,head.min),head);
        }
    }

    public void pop() {
        if(head != null){
            head = head.next;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
