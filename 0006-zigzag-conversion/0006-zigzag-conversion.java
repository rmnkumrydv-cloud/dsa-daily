class Solution {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> set=new ArrayList<>();
        for (int i=0;i<numRows;i++){
            set.add(new ArrayList<>());
        }
        int i=0;
        int curr=0;
        
        while(i<s.length()){
            for(int j=curr;j<numRows&&i<s.length();j++){
                set.get(j).add(s.charAt(i));
                i++;
            }
            curr=numRows-1;
            for(int j=curr-1;j>0&&i<s.length();j--){
                set.get(j).add(s.charAt(i));
                i++;
            }
            curr=0;
        }
        String res="";
        for( i=0;i<set.size();i++){
            for(int j=0;j<set.get(i).size();j++){
                res+=set.get(i).get(j);
            }
        }
        return res;
    }
}