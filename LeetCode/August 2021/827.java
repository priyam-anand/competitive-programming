class Solution 
{
    public int largestIsland(int[][] grid) 
    {
        int m=grid.length, n=grid[0].length, res=0;
        
        int[] f= new int[m*n];
        Arrays.fill(f, -1);
        
        int[] c= new int[m*n];
        int[] d= {1,-1,n,-n};
        
        for (int i=0; i<m; i++)
        {    
            for (int j=0; j<n; j++)
            {   
                if (grid[i][j]==1)
                {
                    int cur= i*n+j;
                    c[cur]=1;
                    f[cur]=cur;
                    for (int k=0;k<4;k++)
                    {
                        int child= cur+d[k];
                        if (child<0 || child>=m*n || cur%n==0 && child==cur-1 ||
                            child%n==0 && cur==child-1 || f[child]==-1) 
                            continue;
                        
                        int prev=find(f, child);
                        if (prev==cur) 
                            continue;
                        
                        f[prev]=cur;
                        c[cur]+=c[prev];
                    }
                }
            }   
        }
        for (int i=0;i<m;i++)
        {    
            for (int j=0;j<n;j++)
            {
                 if (grid[i][j]==0)
                {
                    int cur= i*n+j, cnt=1;
                    Set<Integer> vis= new HashSet<>();
                    for (int k=0; k<4; k++)
                    {
                        int child= cur+d[k];
                        if (child<0 || child>=m*n || cur%n==0 && child==cur-1 ||
                            child%n==0 && cur==child-1 || f[child]==-1) 
                            continue;
                        
                        int childRoot=find(f, child);
                        
                        if (vis.add(childRoot)) 
                            cnt+=c[childRoot];
                    }
                    res=Math.max(res, cnt);
                }
            }
        }
        return res==0?m*n:res;
    }
    public int find(int[] f, int id){
        while (id!=f[id]){
            f[id]=f[f[id]];
            id=f[id];
        }
        return id;
    }
}