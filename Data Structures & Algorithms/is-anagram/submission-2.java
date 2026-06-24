class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hash1 = new HashMap<>();
        HashMap<Character, Integer> hash2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char str1 = s.charAt(i);
            char str2 = t.charAt(i);

            hash1.put(str1, hash1.getOrDefault(str1, 0) + 1);
            hash2.put(str2, hash2.getOrDefault(str2, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!hash1.get(ch).equals(hash2.getOrDefault(ch, 0))) {
                return false;
            }
        }

        return true;
    }
}
