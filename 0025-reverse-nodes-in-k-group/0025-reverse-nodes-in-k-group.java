class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        
        if (count < k) return head; // fewer than k nodes left, don't reverse
        
        ListNode prev = reverseKGroup(node, k); // reversed remainder
        ListNode cur = head;
        while (count-- > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}