class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlnum(s.charAt(left))) {
                left++;
            }
            while (left < right && !isAlnum(s.charAt(right))) {
                right--;
            }
            if (toLower(s.charAt(left)) != toLower(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isAlnum(char c) {
        return (c >= 'a' && c <= 'z')
            || (c >= 'A' && c <= 'Z')
            || (c >= '0' && c <= '9');
    }

    private static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }
}
