class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            String key = generateKey(str);

            if (!map.containsKey(key)) {

                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public String generateKey(String s) {


        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {

            freq[ch - 'a']++;
        }

        return Arrays.toString(freq);
    }
}
