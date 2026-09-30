class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        int[] alphabets = new int[26];

        for(int i = 0; i<s.length(); i++) {

            char c = s.charAt(i);

            alphabets[c-'a'] = alphabets[c-'a']+1;
        }

        //System.out.println(Arrays.toString(alphabets));

        for(int i = 0; i<t.length(); i++) {
            char c = t.charAt(i);

            alphabets[c-'a'] = alphabets[c-'a']-1;
        }

        for(int i = 0; i<alphabets.length; i++) {
            if(alphabets[i] != 0)
                return false;
        }

        return true;
    }
}
