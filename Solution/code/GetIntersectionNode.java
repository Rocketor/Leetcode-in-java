import addition.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个链表可以分为三个部分：
 *     1.相交的部分     c
 *     2.A多余的部分    a
 *     3.B多余的部分    b
 *  其中 a + b + c = b + c + a，也就是总的路径是一致的
 *
 *  创建两个指针分别指向两个链表，然后一步一步移动，当其
 *  中的某个指针走完了一个链表（a + c 或者 b + c，假设
 *  先走完了 a + c）,那么两个链表走过的路径都是 a + c，
 *  此时，两个指针剩下的路径都为 b，让走完的指针指向另一
 *  个链表从头开始走（另一指针同理），只要再走路径b，就
 *  一定会走到相交的节点
 *  如果，两个链表不相交，那么在走完整个路径时，两个指针
 *  会同时指向空节点
 *
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;

    }
}
