public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
	        if(head==null) return null;
	        if(head.next==null) return head;
	        
	        ListNode result=head.next;
	        head.next=swapPairs(head.next.next);
	        result.next=head;
	        return result;
	    }
}
