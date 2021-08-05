class Solution {
    public int findJudge(int n, int[][] trust) {
        
        Set<Integer> options = new HashSet<>();
        
        for(int i=1;i<=n;i++)
            options.add(i);
        
        Set<Integer> g[]=new HashSet[n+1];
        for(int i =0; i<=n;i++)
            g[i]=new HashSet<Integer>();
        
        for(int pair[] : trust)
        {   
            g[pair[0]].add(pair[1]);
            if(options.contains(pair[0]))
                options.remove(pair[0]);
        }
        if(options.size()==0)
            return -1;
        out:
        for(int person : options)
        {
            for(int i=1;i<=n;i++)
            {
                if(i==person)
                    continue;
                if(!g[i].contains(person))
                    continue out;
            }
            return person;
        }
        return -1;
        
            
    }
}