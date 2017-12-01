public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(divide1(2147483647,1)+"\n");
		System.out.print(divide1(1,-1)+"\n");
		System.out.print(divide1(-2147483648,1)+"\n");
		System.out.print(divide1(-2147483648,-3)+"\n");
		System.out.print(divide1(-2147483648,2)+"\n");
		System.out.print(divide1(-1010369383,-2147483648)+"\n");
	}
	
	public static int divide(int dividend, int divisor) {
        if(divisor==0||(dividend==Integer.MIN_VALUE && divisor==-1)) return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE && divisor==1) return Integer.MIN_VALUE ;
        if(dividend==0) return 0;
        
        boolean negative=false;
        if((divisor>0 && dividend<0) ||(divisor<0 && dividend>0))
        	negative=true;
        
        long ldividend=Math.abs((long)dividend);
        long ldivisor=Math.abs((long)divisor);
        if(ldividend<ldivisor) return 0;
        
		int result=0;
		long sum=0;
		while(sum<=ldividend) {
			sum+=ldivisor;
			if(sum<=ldividend)
				result++;
		}
        
        return negative? (-1)*result:result;
    }
	
	public static int divide1(int dividend, int divisor) {
		if(divisor==0||(dividend==Integer.MIN_VALUE && divisor==-1)) return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE && divisor==1) return Integer.MIN_VALUE ;       
        if(dividend==0) return 0;
        
        boolean negative=false;
        if((divisor>0 && dividend<0) ||(divisor<0 && dividend>0))
        	negative=true;
        
        long ldividend=Math.abs((long)dividend);
        long ldivisor=Math.abs((long)divisor);
        if(ldividend<ldivisor) return 0;
        
		int result=1;
		long sum=ldivisor;
		while((sum+sum)<=ldividend) {
			sum+=sum;
			result+=result;
		}

        return negative? (-1)*(result+divide2((ldividend-sum),ldivisor)):result+divide2((ldividend-sum),ldivisor);
    }
	
	public static int divide2(long dividend, long divisor) {
		if(dividend<divisor) return 0;
		if(dividend==0) return 0;
		
		int result=1;
		long sum=divisor;
		while((sum+sum)<=dividend) {
			sum+=sum;
			result+=result;
		}
		
		return result+divide2((dividend-sum),divisor);
	}

}
