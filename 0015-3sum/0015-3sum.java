class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // sorting helps with duplicates too
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>(); // to avoid duplicates

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> map = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (map.contains(third)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(triplet);  // normalize order
                    set.add(triplet);
                } else {
                    map.add(nums[j]);
                }
            }
        }

        res.addAll(set);
        return res;
    }
}
