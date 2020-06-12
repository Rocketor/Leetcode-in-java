import addition.ListNode;

/**
 * 倒数第k个节点，正着数就是第 (总数 - k + 1) 个
 * 遍历链表，先统计链表的长度，再次遍历链表找到第
 * (总数 - k + 1) 个节点
 *
 */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {

        ListNode countHead = head;
        int count = 0;
        while(countHead != null){
            count++;
            countHead = countHead.next;
        }

        for(int index = count - k; index > 0; index--){
            head = head.next;
        }
        return head.val;

    }

}
