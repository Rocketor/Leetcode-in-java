import addition.ListNode;

/**
 *  两个步骤：
 *  1.检测链表是否存在环
 *    设置快慢指针，快指针每次移动两个节点，慢指针每次移动一个节点
 *      如果快指针走到了null,则说明没有环
 *      如果两个指针相遇，则说明有环
 *  2.当两个指针相遇，将快指针移动到首节点，然后两个指针每次移动
 *    一个节点，再次相遇时，就是环的起点
 *
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;

        while(true){
            if(fastNode == null || fastNode.next == null){
                return null;
            }
            //快指针的两步
            fastNode = fastNode.next.next;
            //慢指针的一步
            slowNode = slowNode.next;
            //相遇时，将快指针移动到首节点
            if(fastNode == slowNode){
                fastNode = head;
                break;
            }
        }
        while(fastNode != slowNode){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return fastNode;

    }
}
