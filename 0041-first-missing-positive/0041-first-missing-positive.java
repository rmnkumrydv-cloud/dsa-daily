class Solution {
    public int firstMissingPositive(int[] nums) {
       HashSet<Integer> set=new HashSet<>();
       for(int num: nums){
        set.add(num);
       } 
       boolean t=true;
       int count=1;
       while(t){
        if(set.contains(count)) {t=true;count++;}
        else return count;
       }
       return count;
    }
}