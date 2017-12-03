public class DecodeString {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "3[a]2[bc]";
        System.out.print("Result: "+decodeString1(s).equals(decodeString(s))+"\n");
        String s1 = "3[a2[c]]";
        System.out.print("Result: "+decodeString1(s1).equals(decodeString(s1))+"\n");
        String s2 = "2[abc]3[cd]ef";
        System.out.print("Result: "+decodeString1(s2).equals(decodeString(s2))+"\n");
        String s3 = "2[abc]3[c2[sb]d]ef";//abcabc3[csbsbd]ef
        System.out.print("Result: "+decodeString1(s3).equals(decodeString(s3))+"\n");
        String s4 = "abcabc3[csbsbd]ef";
        System.out.print("Result: "+decodeString1(s4).equals(decodeString(s4))+"\n");
        String s5 = "";
        System.out.print("Result: "+decodeString1(s5).equals(decodeString(s5))+"\n");
        String s6 = "100[leetcode]";
        System.out.print("Result: "+decodeString1(s6).equals(decodeString(s6))+"\n");
        String s7 = "2[2[bc]3[xy]]xd4[rt]";
        System.out.print("Result: "+decodeString1(s7).equals(decodeString(s7))+"\n");

    }

    public static String decodeString(String s) {
        if(s.equals("")) return "";

        StringBuilder sb=new StringBuilder();
        Stack<String> stack=new Stack<String>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='[' && s.charAt(i)!=']'){
                sb.append(s.charAt(i));
                continue;
            }

            if(s.charAt(i)=='['){
                stack.push(sb.toString());
                sb.setLength(0);
            }

            if(s.charAt(i)==']'){
                String str=stack.pop();

                int r=0;
                int count=0;
                for(int j=str.length()-1;j>=0;j--){
                    if((int)str.charAt(j)-48>=0 && (int)str.charAt(j)-48<=9){
                        count++;
                        r=r+((int)str.charAt(j)-48)*(int)Math.pow(10,count-1);
                    }else{
                        break;
                    }
                }
                str=str.substring(0,str.length()-count);
                StringBuilder temp = new StringBuilder (str);
                for(int j=0;j<r;j++){
                    temp.append(sb);
                }
                sb=temp;
            }
        }
        
        return sb.toString();
    }
    //一下方法来自LeetCode讨论区，用来检验自己算法正确性的。
    public static String decodeString1(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
