import addition.ListNode;

/**
 * 双指针遍历，指向当前节点的cur指针，和指向下一节点的next指针
 * 移动next，如果发现和当前节点值相等，就让next向后移动一步，
 * cur指针指向节点指向移动后的next，直到next移动到和cur不相等
 * 的节点，将cur移动到next
 *
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode curNode = head;
        ListNode nextNode = head.next;

        while(nextNode != null){
            if(curNode.val == nextNode.val){
                nextNode = nextNode.next;
                curNode.next = nextNode;
            } else{
                curNode = curNode.next;
                nextNode = nextNode.next;
            }
        }
        return head;

    }

}
