class Solution {
    // LeetCode 21. Merge Two Sorted Lists
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                prev.next = p1;
                p1 = p1.next;
            } else {
                prev.next = p2;
                p2 = p2.next;
            }
            prev = prev.next;
        }
        prev.next = (p1 != null) ? p1 : p2;
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        while (lists.length > 1) {
            int mergedSize = (lists.length + 1) / 2;
            ListNode[] merged = new ListNode[mergedSize];
            for (int i = 0; i < mergedSize; i++) {
                int index1 = i * 2;
                int index2 = i * 2 + 1;
                ListNode l1 = lists[index1];
                ListNode l2 = (index2 < lists.length) ? lists[index2] : null;
                merged[i] = mergeTwoLists(l1, l2);
            }
            lists = merged;
        }
        
        return lists[0];
    }
}