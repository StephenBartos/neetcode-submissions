class Solution {

    /*
    input = ["the", "quick"]
    encoded = "3#the5#quick"
    */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    /*
    input = "3#the5#quick"
    decoded = ["the", "quick"]
    */
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // Find next delimiter
            int j = str.indexOf("#", i);
            // Extract the length of the next string from the encoded string
            int length = Integer.parseInt(str.substring(i, j));
            // Move i to the start of the "real" part of the string
            i = j + 1;
            // Extract the "real" string
            result.add(str.substring(i, i + length));
            // Move i to the beginning of the next encoded string
            i += length;
        }
        return result;
    }
}
