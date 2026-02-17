class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res=new ArrayList<>();
        for (int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn)
                if(Integer.toString(j).length()==1)
                res.add(Integer.toString(i)+":0"+Integer.toString(j));
                else{
                    res.add(Integer.toString(i)+":"+Integer.toString(j));
                }
            }
        }
        return res;
    }
}