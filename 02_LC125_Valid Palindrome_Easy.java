class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        
        
        String clean = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                clean = clean + ch;
            }
        }
        
        
        String reversed = "";
        for (int i = clean.length() - 1; i >= 0; i--) {
            reversed = reversed + clean.charAt(i);
        }
        
       
        if (clean.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }
}
