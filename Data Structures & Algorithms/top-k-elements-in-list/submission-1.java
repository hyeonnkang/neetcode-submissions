class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 각 숫자가 몇번 나왔는지 카운트
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums){
            hmap.putIfAbsent(num, 0);
            hmap.put(num, hmap.get(num)+1);
        }

        // 빈도수 -> 각 숫자들
        List<Integer>[] freq = new List[nums.length + 1];
         for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()){
            freq[e.getValue()].add(e.getKey());
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                ans[index++] = n;
                if (index == k) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
