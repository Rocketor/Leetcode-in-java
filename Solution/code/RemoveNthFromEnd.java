import addition.ListNode;

/**
 * 删除倒数第n个节点，就是删除正数第 (链表长度 - n + 1) 个节点
 * 遍历链表，获得链表长度
 * 再根据公式找到这个节点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curNode = head;
        int length = 0;
        //链表长度
        while(curNode != null){
            length++;
            curNode = curNode.next;
        }
        curNode = head;
        for(int delIndex = length - n; delIndex > 0; delIndex--){
            pre = pre.next;
            curNode = curNode.next;
        }
        pre.next = curNode.next;
        curNode.next = null;
        return dummy.next;
    }
}
