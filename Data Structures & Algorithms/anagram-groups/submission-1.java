class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // strs[i]에 해당하는 문자 코드 맞추기
        String[] codes = new String[strs.length];
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            codes[i] = new String(chars);
        }
        
        Map<String, List<String>> hmap = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            hmap.putIfAbsent(codes[i], new ArrayList<>());
            hmap.get(codes[i]).add(strs[i]);
        }

        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String, List<String>> e : hmap.entrySet()){
            answer.add(e.getValue());
        }
        return answer;
    }
}
