class Solution {
    public String addStrings(String num1, String num2) {
        
        List<Character> one=new ArrayList<>(),two=new ArrayList<>();
        
        int n=num1.length(),m=num2.length();
        
        for(int k=n-1;k>=0;k--)
            one.add(num1.charAt(k));
        for(int k=m-1;k>=0;k--)
            two.add(num2.charAt(k));
        
        String ans="";
        int carry=0; int i=0,j=0;
        while(i<n && j<m)
        {
            int c1=one.get(i)-'0';
            int c2=two.get(j)-'0';
            
            c1+=c2+carry;
            int toAdd=c1%10;
            ans=toAdd+ans;
            carry=c1/10;
            
            i++;
            j++;
        }
        while(i<n)
        {
            int c1=(one.get(i)-'0')+carry;
            int toAdd=c1%10;
            ans=toAdd+ans;
            carry=c1/10;
            i++;
        }
        while(j<m)
        {
            int c1=(two.get(j)-'0')+carry;
            int toAdd=c1%10;
            ans=toAdd+ans;
            carry=c1/10;
            j++;
        }
        if(carry>0)
            ans=carry+ans;
        return ans;
    }
}