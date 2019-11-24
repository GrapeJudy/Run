package List;

public class DesignLinkedList {
	private static class ListNode {
		int val;
		ListNode prev;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static class MyLinkedList {
		private ListNode head;
		private ListNode tail;
		private int size;
		
		// while initialize, head is head, tail.next = null?
		public MyLinkedList() {
			this.head = this.tail = null;
			this.size = 0;
		}
		
		public int get(int index) {
			if (index < 0 || this.size <= index) {
				return -1;
			}
			ListNode p = head;
			int count = 0;
			while(count < index) {
				p = p.next;
				count++;
			}
			
			return p.val;
		}
		
		public void addAtHead(int val) {
			ListNode node = new ListNode(val);
			this.size++;
			if(head == null) {
				// first element
				head = node;
				tail = node;
				return;
			}
			
			ListNode p = head;
			node.next = p;
			p.prev = node;
			head = node;		
		}
		
		public void addAtTail(int val) {
			ListNode node = new ListNode(val);
			this.size++;
			if (tail == null) {
				tail = node;
				head = node;
				return;
			}
			
			ListNode p = tail;
			p.next = node;
			node.prev = p;
			tail = node;
		}
		
		public void addAtIndex(int index, int val) {
			if (index > this.size) {
				return;
			}
			
			if (index == this.size) {
				this.addAtTail(val);
				return;
			}
			
			if (index == 0) {
				this.addAtHead(val);
				return;
			}
			
			ListNode p = head;
			ListNode node = new ListNode(val);
			for(int i = 0; i < index - 1; i++) {
				p = p.next;
			}
			node.next = p.next;
			p.next.prev = node;
			p.next = node;
			node.prev = p;
			this.size++;
		}
		
		public void deleteAtIndex(int index) {
			if(this.get(index) == -1) {
				return;
			}
			
			this.size--;
			if(index == this.size) {
				// so don't have to manually check the prev or next equals to null
				tail = tail.prev;
				tail.next = null;
				return;
			}
			
			if(index == 0) {
				head = head.next;
				head.prev = null;
				return;
			}
			
			ListNode p = head;
			for(int i = 0; i < index - 1; i++) {
				p = p.next;
			}
			
			ListNode node = p.next.next;
			node.prev = p;
			p.next = node;
		}
		
		public ListNode getHead() {
			return this.head;
		}
		
		public ListNode getTail() {
			return this.tail;
		}
		
		public void printList() {
			ListNode p = head;
			while(p != null) {
				System.out.print(p.val + " ");
				p = p.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		System.out.println(obj.get(0));
		obj.addAtHead(1);
		obj.addAtTail(4);
		obj.addAtTail(6);
		obj.addAtHead(5);
		obj.addAtIndex(4, 19);
		obj.addAtIndex(3, 10);
//		ListNode head = obj.getHead();
//		ListNode tail = obj.getTail();
		obj.printList();
		System.out.println(obj.size);
		obj.deleteAtIndex(0);
		obj.printList();
		obj.deleteAtIndex(4);
		obj.printList();
		obj.deleteAtIndex(2);
		obj.printList();
		System.out.println(obj.size);
	}
}
