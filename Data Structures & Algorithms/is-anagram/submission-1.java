class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch2);
        Arrays.sort(ch1);
        if (Arrays.equals(ch1, ch2)) {
            return true;
        }
        else {
            return false;
        }
    }
}
