class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int optimall = 0, minLength = Integer.MAX_VALUE, have = 0, need = tmap.size();

        for (int r = 0; r < s.length(); r++) {
            smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0) + 1);
            if (tmap.containsKey(s.charAt(r))
                && smap.get(s.charAt(r)).intValue() == tmap.get(s.charAt(r)).intValue()) {
                have++;
            }

            while (have == need) {
                int currentLength = r - l + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    optimall = l;
                }
                smap.put(s.charAt(l), smap.get(s.charAt(l)) - 1);

                if (tmap.containsKey(s.charAt(l))
                && smap.get(s.charAt(l)) < tmap.get(s.charAt(l))) {
                    have--;
                }

                l++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(optimall, optimall + minLength);
    }
}
