//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

//思路：如果能倒着数就好了，于是就能想到递归，递归到最后一个的时候，返回时开始计数，这样就实现了倒数
public class question_19 {
    public static int count=1;
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode head = new ListNode(1,listNode);
        for(int i=3;i<6;i++){
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode head2 = removeNthFromEnd(head,5);
        head2.printList();


    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(count==1 && n==1)
            return null;
        if(head.next!=null){
            removeNthFromEnd(head.next,n);
            count++;
        }

        if(count==n+1){
            if(n==1){
                head.next=null;
            }
            if(head.next!=null)
                head.next = head.next.next;
            return head;
        }
        if(count==n)
            return head.next;
        return head;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    void printList(){
        System.out.print(this.val);
        if(this.next!=null){
            this.next.printList();
        }
    }
}
