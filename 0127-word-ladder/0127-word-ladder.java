class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> map = new HashMap<>();
        int count1 = 1;
        for (String s : wordList) {
            if (!s.equals(beginWord)) {
                map.put(s, count1);
                count1++;
            }
        }
        map.put(beginWord, 0);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            arr.add(new ArrayList<>());
        }
        int n = wordList.size();
        for (int i = 0; i < n; i++) {
            String s = wordList.get(i);
            int val = map.get(s);
            for (int j = 0; j < n; j++) {
                if (check(wordList.get(i), wordList.get(j))) {
                    int something = map.get(wordList.get(j));
                    arr.get(val).add(something);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (check(beginWord, wordList.get(i))) {
                int v = map.get(wordList.get(i));
                arr.get(0).add(v);
            }
        }
        int src = 0;
        if (map.get(endWord) == null)
            return 0;
        int des = map.get(endWord);
        int[] dist = new int[map.size()];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        int[] visi = new int[map.size()];
        visi[0] = 1;
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        q.add(0);
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int x = q.poll();
                for (int i = 0; i < arr.get(x).size(); i++) {
                    int u = arr.get(x).get(i);
                    if (visi[u] == 0) {
                        dist[u] = count;
                        q.add(u);
                        visi[u] = 1;
                    }
                }
            }

        }
        if (dist[des] == -1)
            return 0;
        return dist[des]+1;

    }

    private boolean check(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1)
                return false;
        }
        return count == 1;
    }
}