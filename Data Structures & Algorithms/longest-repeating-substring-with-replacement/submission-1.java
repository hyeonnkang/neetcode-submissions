class Solution {
    public int characterReplacement(String s, int k) {
        // 문자 : 갯수
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int answer = 0;
        int maxCnt = 0;
        for(int r = 0; r < s.length(); r++){
            // 현재 문자 추가
            map.putIfAbsent(s.charAt(r), 0);
            map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
            maxCnt = Math.max(maxCnt, map.get(s.charAt(r)));

            // 변경해야할 문자가 k개보다 많은지 확인
            while(r-l+1 - maxCnt > k){
                map.put(s.charAt(l), map.get(s.charAt(l++)) - 1);
            }
            
            answer = Math.max(r-l+1, answer);
        }
        return answer;
    }
}
