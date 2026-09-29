class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();

        int l = 0;
        int max = 0;

        for(int r = 0; r<s.length(); r++){
            while(window.contains(s.charAt(r))){
                window.remove(s.charAt(l));
                l++;
            }
            window.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
