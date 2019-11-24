package List;

public class LinkedListInsertionSort {
	/*
	 * hMMMMMM problem is here
	 */
	private static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int x) {
			this.val = x;
		}
	}
	
	public static ListNode insertionSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy, curr = head;
		dummy.next = head;
		while(curr != null) {
			prev = dummy;
			while(prev.next != null && prev.next != curr && prev.next.val < curr.val) {
				prev = prev.next;
			}
			if (prev.next == curr) {
				curr = curr.next;
				continue;
			}
			ListNode next = curr.next;
			prev.next.next = next;
			curr.next = prev.next;
			prev.next = curr;
			curr = next;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
//		head.next.next.next = new ListNode(1);
		ListNode res = insertionSort(head);
		System.out.println(res.val);
		System.out.println(res.next.val);
		System.out.println(res.next.next.val);
	}
}
