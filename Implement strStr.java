public class Implement_strStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "hehlllo";
		String needle = "lll";
		
		System.out.print(strStr(haystack,needle));
	}
	
	public static int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        
        int result=-1;
        for(int i=needle.length()-1;i<haystack.length();i++) {
        	if(haystack.substring(i-needle.length()+1,i-needle.length()+1+needle.length()).equals(needle)) {
        		result=i-needle.length()+1;
        		break;
        	}
        }
        
        return result;
    }

}
