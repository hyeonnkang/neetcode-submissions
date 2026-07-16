class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int answer = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            if(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }else{
                set.add(c);
                r++;
                answer = Math.max(answer, r - l);
            }
            
        }
        return answer;

    }
}
