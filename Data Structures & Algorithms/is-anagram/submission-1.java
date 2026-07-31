class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charToCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charToCount[s.charAt(i) - 'a']++;
            charToCount[t.charAt(i) - 'a']--;
        }
        for (int count : charToCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
