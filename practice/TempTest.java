

public class TempTest {


    public static void main(String[] args) {
        Node four = new Node();
        four.date = 4;
        four.next = null;


        Node three = new Node();
        three.date = 3;
        three.next = four;

        Node two = new Node();
        two.date = 2;
        two.next = three;

        Node one = new Node();
        one.date = 1;
        one.next = two;


        reverseList2(one);

        int k = 2;


    }






    /**
     *  recursion  easy
     */
    public static int flog(int n){

        if (n <= 1){
            return 1;
        }

        return flog(n-1) + flog(n-2);

    }


    /**
     *
     */

    //用递归的方法反转链表
    public static Node reverseList2(Node head){
        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 子链表
        Node newList = reverseList2(head.next);

        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        Node t1  = head.next;

        // 让 2 的 next 指向 1
        t1.next = head;

        // 1 的 next 指向 null.
        head.next = null;

        // 把调整之后的链表返回。
        return newList;
   }




    public static class Node{
        int date;
        Node next;
    }









}
