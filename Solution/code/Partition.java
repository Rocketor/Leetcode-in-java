import addition.ListNode;

/**
 * 头插法
 * 维护三个指针
 *    1.头指针，始终指向链表的首元素
 *    2.当前指针，当前遍历的指针
 *    3.前指针，指向当前指针
 * 如果当前节点小于给定值，将当前节点移动到首元素的位置，具体实现为：
 *    1.断开前节点与当前节点的连接，让前节点指向当前节点的下一节点
 *    2.断开当前节点与下一节点的连接，让当前节点指向头指针指向的节点
 *    3.让头指针指向当前节点
 *
 * 空间 O(1)
 * 时间 O(n)
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head;
        head = head.next;

        while(head != null){
            if(head.val < x){
                prev.next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = prev.next;
            }else{
                prev = prev.next;
                head = head.next;
            }
        }

        return dummy.next;
    }
}
