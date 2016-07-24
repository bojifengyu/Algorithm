package leetcode;

public class leetcode002 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution002 s = new Solution002();
		ListNode test1 = new ListNode(2);
		ListNode test2 = new ListNode(4);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(5);
		ListNode test5 = new ListNode(6);
		ListNode test6 = new ListNode(4);
		test1.next = test2;
		test2.next = test3;
		test3.next = null;
		test4.next = test5;
		test5.next = test6;
		test6.next = null;
/*		ListNode test1 = new ListNode(0);
		test1.next = null;
		ListNode test2 = new ListNode(0);
		test2.next = null;*/
		ListNode test = new ListNode(0);
		test = s.addTwoNumbers(test1, test4);
		System.out.println(test.val);
		System.out.println(test.next.val);
		System.out.println(test.next.next.val);
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	  val = x; 
	}
}
class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode l3 = null;
    	ListNode p = null;
    	ListNode p1 = new ListNode(0);
    	ListNode p2 = new ListNode(0);
    	ListNode p3 = new ListNode(0);
    	int intVal = 0;
    	p1 = l1;
		p2 = l2;
		l3 = p3;
		while((p1 != null) && (p2 != null)){
			p3.val = (p1.val + p2.val + intVal) % 10;
			intVal = (p1.val + p2.val + intVal) / 10;
			p3.next = new ListNode(0);
			p = p3;
			p1 = p1.next;
			p2 = p2.next;
			p3 = p3.next;
		}
    	while(p1 != null){
    		p3.val = (p1.val + intVal) % 10;
			intVal = (p1.val + intVal) / 10;
			p3.next = new ListNode(0);
			p = p3;
			p1 = p1.next;
			p3 = p3.next;
    	}
    	while(p2 != null){
    		p3.val = (p2.val + intVal) % 10;
			intVal = (p2.val + intVal) / 10;
			p3.next = new ListNode(0);
			p = p3;
			p2 = p2.next;
			p3 = p3.next;
    	}
    	if(intVal > 0){
    		p3.val = intVal;
    		return l3;
    	}
    	p.next = null;
		return l3;        
    }
}