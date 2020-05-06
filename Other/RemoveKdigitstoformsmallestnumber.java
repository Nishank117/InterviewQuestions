class Solution {
    public String removeKdigits(String num, int k) {

        if (num.length() == 0 || num.length() == k) return "0";
        if (k == 0) return num;
        
        int n = num.length();
        for (int i = 0; i < n-1; i++) {
            if (num.charAt(i) > num.charAt(i+1)) {
                String tmp = num.substring(0, i) + num.substring(i+1);
                //trim all zeros because the initial condition would be always true if there are 0s
                tmp = trim(tmp);
                return removeKdigits(tmp, k-1);
            }
        }
        return num.substring(0, n-k);//for monotonously increasing strings.
    }

    String trim(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
}