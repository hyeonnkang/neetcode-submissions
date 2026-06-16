class Solution {
    int[] cnt = new int[26];
    public boolean isAnagram(String s, String t) {
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        for(char c : t.toCharArray()){
            cnt[c-'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(cnt[i] != 0) return false;
        }
        return true;
    }
}
