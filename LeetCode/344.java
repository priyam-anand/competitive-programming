class Solution {
    public void reverseString(char[] s) {
        solve(s,0);
    }
    public void solve(char ch[],int n)
    {
        if(n==ch.length)
            return;
        
        char c=ch[n];
        solve(ch,n+1);
        ch[ch.length-(n+1)]=c;
    }
}