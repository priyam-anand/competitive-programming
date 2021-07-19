class Solution {
    public boolean isSubsequence(String s, String t) {
        
        char ch[]=s.toCharArray();
        if(ch.length==0)
            return true;
        int idx=0;
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)==ch[idx])
                idx++;
            if(idx==ch.length)
                return true;
        }
        return false;
    }
}