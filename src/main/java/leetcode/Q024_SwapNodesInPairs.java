package leetcode;

/*
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the 
 list, only nodes itself can be changed. 
 */
public class Q024_SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;

		return n;
	}
}