class Solution {
    public boolean isPalindrome(String s) {
        String req = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(req);

        int end = req.length() - 1;
        int start = 0;
        while(start <= end){
            if(req.charAt(start) == req.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
