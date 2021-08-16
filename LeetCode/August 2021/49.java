class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n=strs.length;
        int words[][]=new int[n][26];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<strs[i].length();j++)
                words[i][strs[i].charAt(j)-'a']++;
        }
        List<List<String>> ans=new ArrayList<>();
        
        int vis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==1)
                continue;
            
            List<String> list=new ArrayList<>();
            list.add(strs[i]);
            vis[i]=1;
            for(int j=i+1;j<n;j++)
            {   
                boolean poss=true;
                for(int idx=0;idx<26;idx++)
                {
                    if(words[i][idx]!=words[j][idx])
                    {
                        poss=false;
                        break;
                    }
                }
                if(poss)
                {   
                    vis[j]=1;
                    list.add(strs[j]);
                }    
            }
            ans.add(list);
        }
        return ans;
    }
}