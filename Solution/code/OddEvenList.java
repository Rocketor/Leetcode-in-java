import addition.ListNode;

/**
 * 维护两个指针，分别指向首节点和第二个节点，即奇指针、偶指针，
 * 1.奇节点指向偶节点的下一节点
 * 2.将奇指针指向奇节点的下一节点
 * 3.偶节点指向奇节点的下一节点
 * 4.将偶指针指向偶节点的下一节点
 * 重复以上四个步骤，知道偶节点为空，这时，链表被一分为二，一部分是奇链
 * 表，另一部分是偶链表，最后，将奇链表的尾节点指向偶链表的首节点
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preFirst = new ListNode();
        preFirst.next = head;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenFirst = evenNode;

        while (evenNode.next != null) {
            oddNode.next = evenNode.next;
            if (oddNode.next == null) {
                break;
            }
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenFirst;
        return preFirst.next;
    }
}