//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题
//思路:就指针，换就完事了
public class question_24 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(3)));
        swapPairs(l1).printList();
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode tmp = head.next;
        head.next = head.next.next;
        tmp.next = head;
        //头部换完后，此时head在第二个位置，因为是12换，34换的顺序，所以head每走两步换一次，至于head在第二个位置，其实相当于头节点
        ListNode tmp2 =new ListNode();
        for(int i=2;head.next!=null;i++){
            //i偶数说明走了两步，head.next.next!=null保证了head后面有两个节点，否则不用换
            if(i%2==0 && head.next.next!=null){
                tmp2 = head.next;
                head.next = tmp2.next;
                    tmp2.next = tmp2.next.next;
                head.next.next = tmp2;
            }
            head = head.next;
        }
        return tmp;
    }
}
