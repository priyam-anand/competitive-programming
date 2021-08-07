class Solution {
    Set<Integer> g[];
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        int n=graph.length;
        g=new HashSet[n];
        
        for(int i=0;i<n;i++)
            g[i]=new HashSet<>();
        
        for(int i=0;i<n;i++)
            for(int j=0;j<graph[i].length;j++)
                g[graph[i][j]].add(i);
        
        int inOrder[]=new int[n];
        for(Set<Integer> set:g)
            for(int i:set)
                inOrder[i]++;
        
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)
            if(inOrder[i]==0)
                stack.push(i);
        
        List<Integer> ans=new ArrayList<>();
        
        while(!stack.isEmpty())
        {
            int curr=stack.pop();
            ans.add(curr);
            for(int i:g[curr])
            {
                inOrder[i]--;
                if(inOrder[i]==0)
                    stack.push(i);
            }    
        }
        Collections.sort(ans);
        return ans;
    }
}