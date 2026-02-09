class Solution {
    public int appendCharacters(String s, String t) {
        int l=0;
        int res=0;
        for(int i=0;i<s.length()&&l<t.length();i++ ){
            if(s.charAt(i)==t.charAt(l)){
                l++;
            }

        }
        return t.length()-l;
    }
}