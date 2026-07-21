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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode pre = null;
        ListNode cur = null;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(cur != null) pre = cur;
                cur = list1;
                if(pre != null) pre.next = cur;
                head = (head == null) ? cur : head;
                list1 = list1.next;
            }else{
                 if(cur != null) pre = cur;
                cur = list2;
                if(pre != null) pre.next = cur;
                head = (head == null) ? cur : head;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            if(cur != null) cur.next = list1;
            else head = list1;
        }
        if(list2 != null){
            if(cur != null) cur.next = list2;
            else head = list2;
        }
        return head;
    }
}