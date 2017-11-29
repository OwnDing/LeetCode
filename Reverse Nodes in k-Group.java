public ListNode reverseKGroup(ListNode head, int k) {
	        ListNode result=head;
	        int count=0;
	        while(result!=null && count!=k) {
	        	result=result.next;
	        	count++;
	        }
	        
	        if(count<k) return head;
	        
	        result=reverseKGroup(result,k);
	        while(count-->0) {
	        	ListNode next=head.next;
	        	head.next=result;
	        	result=head;
	        	head=next;
	        }
	        head=result;
	        return head;
	}
