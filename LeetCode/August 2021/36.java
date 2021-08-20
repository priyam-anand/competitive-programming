class Solution {
    public boolean isValidSudoku(char[][] ch) {
        
        Set<Character> set=new HashSet<>();
        
        for(int i=0;i<9;i++)
        {   
            set=new HashSet<>();
            for(int j=0;j<9;j++)
            {   
                if(ch[i][j]=='.')
                    continue;
                if(set.contains(ch[i][j]))
                {       
                    System.out.println(set);
                    System.out.println(ch[i][j]);
                    return false;
                }    
                set.add(ch[i][j]);
            }
        }
        
        for(int i=0;i<9;i++)
        {
            set=new HashSet<>();
            for(int j=0;j<9;j++)
            {   
                if(ch[j][i]=='.')
                    continue;
                if(set.contains(ch[j][i]))
                    return false;
                set.add(ch[j][i]);
            }
        }

        for(int start=0;start<9;start+=3)
        {
            for(int y=0;y<9;y+=3)
            {
                if(!isOk(start,y,ch))
                    return false;
            }
        }
        return true;
    }
    boolean isOk(int x,int y,char ch[][])
    {   
        Set<Character> set=new HashSet<>();
        for(int i=x;i<x+3;i++)
        {
            for(int j=y;j<y+3;j++)
            {   
                if(ch[i][j]=='.')
                    continue;
                if(set.contains(ch[i][j]))
                    return false;
                set.add(ch[i][j]);
            }
        }
        return true;
    }
}