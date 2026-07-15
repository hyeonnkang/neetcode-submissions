class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int answer = 0;
        for(int num : nums){
            if(set.contains(num - 1)) continue;

            int len = 1;
            int cur = num+1;
            while(set.contains(cur)){
                cur++;
                len++;
            }
            answer = Math.max(answer, len);
        }
        return answer;
    }
}
