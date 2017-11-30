import java.util.Arrays;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {2,2,3,2,3,4};
		int result=removeElement(nums,4);
		System.out.print(result);
	}
	
	public static int removeElement(int[] nums, int val) {
        int result=0;
        if(nums.length==0||(nums.length==1 && nums[0]==val)) return result;
        Arrays.sort(nums);
        
        boolean b=false;int index=0;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]==val) {
        		result++;
        		index=i;
        		b=true;
        	}else {
        		if(b) {
        			break;
        		}
        	}       	
        }
        if(index==nums.length-1) return nums.length-result;
        int count=0;
        for(int j=index-result+1;j<=index;j++) {
        	nums[j]=nums[nums.length-1-count];
        	count++;
        }
        
        return nums.length-result;
    }
}
