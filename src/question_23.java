//合并k个链表
//思路:没啥好说的，就是合并双链表稍微改改,但是速度很慢
public class question_23 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode l3 = new ListNode(2,new ListNode(6));
        ListNode[] lists = {l1,l2,l3};
        mergeKLists2(lists).printList();
    }
    static int index=0;
    static ListNode tmp = new ListNode();
    public static ListNode mergeKLists(ListNode[] lists) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<lists.length;i++){
            if(lists[i] == null) continue;
            if(lists[i].val<min){
                min =lists[i].val;
                index = i;
            }
        }
        if(min == Integer.MAX_VALUE){
            return null;
        }
        tmp = lists[index];
        if(lists[index].next==null)
            lists[index] =null;
        else
            lists[index] = lists[index].next;
        tmp.next = mergeKLists(lists);
        return tmp;

    }
    /////////////////////////////////
    public static ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1){
            return lists[0];
        }
        for(int i=0,j=1;j<lists.length;j++){
            lists[i] = mergeTwoLists(lists[i],lists[j]);
        }
        return lists[0];
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }
        else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
