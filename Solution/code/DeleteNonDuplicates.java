import addition.ListNode;

/**
 * 双指针，head指针指向当前待比较的节点，next指针用来比较是否节点值是否相等
 * next指针初始在head的下一个节点的位置
 * head指针遍历链表，每遇到一个节点，head指针保持不动，next指针向后移动，逐
 * 个比较和head指向节点的值，如果值相等，则说明是重复节点，next继续移动，直到
 * 移动到和head指向节点值不相等的位置。此时，需要判断next指针是否发生移动，如
 * 果移动了，则说明head之后有重复的节点。如果没有移动，head节点是不重复的。然
 * 后将head移动到next
 *
 */
public class DeleteNonDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode next;
        while(head != null){
            next = head.next;
            while (next != null && next.val == head.val) {
                next = next.next;
            }
            if(next == head.next){
                prev.next = head;
                prev = prev.next;
                prev.next = null;
            }
            head = next;
        }
        return dummy.next;
    }
}
