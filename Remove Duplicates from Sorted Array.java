public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
	    if(nums.length==0) return 0;    
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(){
			private static final long serialVersionUID = 1L;
		{}};
		
	        for(int i=0;i<nums.length;i++) {
	        	if(!map.containsKey(nums[i])) {
	        		map.put(nums[i], i);
	        	}
	        }
//	        for (Integer key : map.keySet()) {
//	            System.out.println("Key: " + key + ", Value: " + map.get(key));
//	        }
	        return map.size();
	    }
	
	public int removeDuplicates1(int[] nums) {
		if(nums.length==0||nums.length==1) return nums.length; 
		
		int count=1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]!=nums[count-1]) {
				nums[count]=nums[i];
				count++;
			}
		}
		return count;
	}
}
