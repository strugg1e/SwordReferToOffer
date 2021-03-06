/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

/**
 * 就是快慢指针，快指针先走k-1步，然后快慢指针一起走，
 * 当快指针走到末尾，那么慢指针就到了倒数第K个节点了，可以自己举个例子。
 */
public class Solution {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {

        int length = 0;
        ListNode tempHead = head;

        while(tempHead != null) {
            length++;   //计算链表长度
            tempHead = tempHead.next;
        }

        if( k > length || k <= 0)
            return null;

        ListNode before = head;
        ListNode after = head;

        for (int i = 0; i < k - 1; i++) {
            before = before.next;
        }
        while(before.next != null) {
            before = before.next;
            after = after.next; //快慢指针一起走
        }

        return after;
    }
}
