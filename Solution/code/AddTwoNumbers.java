import addition.ListNode;

/**
 * 同时遍历两个链表，每个节点只保存一个数字，相加时需要考虑几种情况：
 *    1.进位，上一次相加时的进位，要么为0，要么为1，每次相加都要带上进位
 *    2.两个链表的长度不一样时，需要判断是否一个链表是否已经走完，如果走
 *      完就不能再继续走这个链表，避免空指针
 *    3.考虑最后一位相加时出现进位的情况
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int addition = 0;

        while(l1 != null || l2 != null){
            ListNode tmp = new ListNode();
            int curNum = addition;
            if(l1 == null){
                curNum += l2.val;
                l2 = l2.next;
            } else if (l2 == null){
                curNum += l1.val;
                l1 = l1.next;
            } else {
                curNum += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            addition = curNum / 10; //进位
            curNum = curNum % 10; //当前节点的值
            tmp.val = curNum;
            pre.next = tmp;
            pre = pre.next;

            if(l1 == null && l2 == null && addition == 1){
                pre.next = new ListNode(addition);
            }
        }
        return dummy.next;
    }

}
