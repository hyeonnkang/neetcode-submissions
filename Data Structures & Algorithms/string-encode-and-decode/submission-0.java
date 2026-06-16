class Solution {
    HashMap<String, List<String>> map = new HashMap<>();

    public String encode(List<String> strs) {
        String key = strs.toString();
        map.put(key, strs);
        return key;
    }

    public List<String> decode(String str) {
        return map.get(str);
    }
}
