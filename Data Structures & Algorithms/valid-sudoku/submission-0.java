class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowToSeen = new HashMap<>();
        Map<Integer, Set<Character>> colToSeen = new HashMap<>();
        Map<Integer, Set<Character>> squareToSeen = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int squareIndex = i / 3 * 3 + j / 3;
                if (rowToSeen.computeIfAbsent(i, k -> new HashSet<>()).contains(c)
                        || colToSeen.computeIfAbsent(j, k -> new HashSet<>()).contains(c)
                        || squareToSeen.computeIfAbsent(squareIndex, k -> new HashSet<>()).contains(c)) {
                    return false;
                }
                rowToSeen.get(i).add(c);
                colToSeen.get(j).add(c);
                squareToSeen.get(squareIndex).add(c);
            }
        }
        return true;
    }
}
