class Solution {
    public void setZeroes(int[][] a) {
        
        int n=a.length;
        int m=a[0].length;
        
        Set<Integer> row=new HashSet<>(),col=new HashSet<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]==0)
                {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {   
            if(row.contains(i))
                for(int j=0;j<m;j++)
                    a[i][j]=0;
            else
                for(int j=0;j<m;j++)
                    if(col.contains(j))
                        a[i][j]=0;
        }
    }
}