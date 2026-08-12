/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = helper(cur,k);
        return dummy.next;
    }
    public ListNode helper(ListNode cur,int k){
        if(cur==null) return null;
        ListNode prev = null;
        int cnt = 0;
        ListNode temp = cur;
        ListNode tt = cur;
        for(int i=0;i<k;i++){
            if(tt==null) return cur;
            tt = tt.next;
        }
        while(cnt<k && cur!=null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
            cnt++;
        }
        temp.next = helper(cur,k);
        return prev;
    }
}