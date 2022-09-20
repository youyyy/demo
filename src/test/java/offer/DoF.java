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

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2022/3/11
 **/
public class DoF {

    public static class Node{
        public String val;
        public Node next;

        public Node(String val) {
            this.val = val;
        }
    }
    public static boolean fun(Node head){
        if(head  == null) return false;
        Node fast = head;
        Node slow  = head;
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return  false;

    }
    public static void main(String[] args) {
        Node a1 = new Node("1");
        Node a2 = new Node("2");
        Node a3= new Node("3");
        Node a4 = new Node("4");
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a1;
        System.out.println(fun(a1));

    }
}
