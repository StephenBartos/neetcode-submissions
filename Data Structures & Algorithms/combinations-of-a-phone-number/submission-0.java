class Solution {

    private static final String[] MAPPING = new String[] {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz", // 9
        };

    public List<String> letterCombinations(String digits) {
        // Iterative
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        result.add("");
        for (char digit : digits.toCharArray()) {
            String letters = MAPPING[digit - '0'];
            List<String> next = new ArrayList<>();
            for (String combo : result) {
                for (char letter : letters.toCharArray()) {
                    next.add(combo + letter);
                }
                result = next;
            }
        }
        return result;
    }
}
