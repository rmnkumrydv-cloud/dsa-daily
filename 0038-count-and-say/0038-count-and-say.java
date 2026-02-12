class Solution {
    public String countAndSay(int n) {
        String s="1";

        if(n==1) return s;
        for(int i=2;i<=n;i++){
            s=get(s);
        }
        return s;
    }
    private String get(String s){
        String res="";
        for(int i=0;i<s.length();i++ ){
            int count =1;
            while(i<s.length()-1&&s.charAt(i)==s.charAt(i+1)){
                count++;
                i++;
            }
            res=res+count+s.charAt(i);
        }
        return res;
    }
}