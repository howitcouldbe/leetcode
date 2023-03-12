//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
//        k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

//思路:第一反应是构建一个函数，专门用来反转链表，然后不断的把需要反转的部分给送到函数中去
public class question_25 {
    public static void main(String[] args) {
        ListNode test = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode tail = test;
        while(tail.next!=null){
            tail = tail.next;
        }
        reverseKGroup(test,2).printList();

    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        /*
        * flag 用来标注何时停止移动指针
        * first,second 则是用来移动的两个指针
        * tmp则是用来交换的指针,同时还确保不会丢失链接
        * */
        int count=0;
        ListNode tmp = new ListNode();
        boolean flag = true;
        ListNode first = head;
        ListNode second = head;

        //先移动到第k个节点，找到需要反转的子链
        for(int i=0;i<k-1;i++){
            if(second.next!=null)
                second = second.next;
        }

        while(flag) {
            //先确保需要交换的子链的next，避免丢失
            ListNode tail = second.next;
            //交换
            reverse(first, second);
            //将头部子链与交换好的子链链接
            tmp.next = second;

            //找到头节点，之后返回的就是这个头节点
            if(count==0) {
                head = second;
                count++;
            }
            //因为反转后，first和second的前后关系换了，所以要交换回来
            tmp = first;
            first = second;
            second = tmp;
            //链接尾部子链，避免丢失
            second.next = tail;
            //移动指针，直到second不能移动
            for(int i=0;i<k;i++) {
                if (second.next != null) {
                    first = first.next;
                    second = second.next;
                }else flag = false;
            }
        }

        return head;
    }
    static ListNode tmp = new ListNode();
    public static ListNode reverse(ListNode head,ListNode tail){
        if(head.next == tail.next)
            return head;
        tmp = reverse(head.next,tail);
        tmp.next = head;
        head.next = null;
        return tmp.next;
    }

}
