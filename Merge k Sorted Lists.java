public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null) return l2;
	        if(l2==null) return l1;
	        
	        ListNode result=null;
	        if(l1.val<=l2.val) {
	        	result=l1;
	        	result.next=mergeTwoLists(l1.next,l2);
	        }
	        else {
	        	result=l2;
	        	result.next=mergeTwoLists(l1,l2.next);
	        }
	        
	        return result;
	    }
	
	public  ListNode divided(ListNode[] lists,int start,int end){
	    if(start==end)  return lists[start];
	    if(start<end){
	        int middle = start + (end -start) / 2;
	        ListNode l1=divided(lists,start,middle);
	        ListNode l2=divided(lists,middle+1,end);
	        return mergeTwoLists(l1,l2);
	    }else
	        return null;
	}
	
public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length==0) return null;
	if(lists.length==1) return lists[0];
	return divided(lists,0,lists.length-1);   
//        ListNode result=mergeTwoLists(lists[0],lists[1]);
//        for(int i=2;i<lists.length;i++) {
//        	result=mergeTwoLists(result,lists[i]);
//        }
//        
//        return result;
    }
