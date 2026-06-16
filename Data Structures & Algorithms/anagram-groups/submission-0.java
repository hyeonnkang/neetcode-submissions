class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 구성 글자 카운트, 애너그램 그룹 구성 문자열)
        Map<String, List<String>> group = new HashMap<>();
        for(String str : strs){
            // 구성 글자 세기
            int[] cnt = new int[26];
            Arrays.fill(cnt, 0);
            for(char c : str.toCharArray()){
                cnt[c-'a']++;
            }

            String key = Arrays.toString(cnt);

            group.putIfAbsent(key, new ArrayList<>());
            group.get(key).add(str);
        }

        // 배열로 변환
        return new ArrayList<>(group.values());
    }
}
