class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> arr=new ArrayList<>();
        solve(candidates,target,arr,0);
        return res;
        
    }
    void solve (int[] can,int target,List<Integer> arr,int index){
        if(target==0) {res.add(new ArrayList<>(arr)); return ;}
        if(target<0||index>=can.length) return;
        // take
        arr.add(can[index]);
        solve(can,target-can[index],arr,index);
        arr.remove(arr.size()-1);
        solve(can,target,arr,index+1);
    }
}