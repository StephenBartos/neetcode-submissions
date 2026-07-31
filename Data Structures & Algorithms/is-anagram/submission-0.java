class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charToCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charToCount[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            charToCount[c - 'a']--;
        }
        for (int i = 0; i < charToCount.length; i++) {
            if (charToCount[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
