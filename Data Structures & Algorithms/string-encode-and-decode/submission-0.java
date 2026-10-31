class Solution {

    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {

            encoded.append(String.valueOf(str.length()))
                   .append("*")
                   .append(str);
        }

        return encoded.toString();
    }

    // Encoded: 5*Hello5*World
    public List<String> decode(String str) {

        List<String> decoded = new ArrayList<>();
        int start = 0;

        while (start < str.length()) {

            int len = 0;
            while (start < str.length() && str.charAt(start) != '*') {

                len = len * 10 + (str.charAt(start) - '0');
                start++;
            }

            // After calculating the "len", my pointer is atanding at "*",
            // so move it to the first character of the new word.
            start++;

            StringBuilder sb = new StringBuilder();
            int sbLength = len + start;
            while (start < str.length() && start < sbLength) {

                sb.append(str.charAt(start));
                start++;
            }

            decoded.add(sb.toString());
        }

        return decoded;
    }
}
