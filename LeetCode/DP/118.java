class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> one=new ArrayList<>();
        one.add(1);
        list.add(one);
        
        if(numRows==1)
            return list;
        
        for(int i=0;i<numRows-1;i++)
        {
            one=new ArrayList<>();
            List<Integer> prev=list.get(i);
            for(int j=0;j<i+2;j++)
            {
                if(j==0 || j==i+1)
                    one.add(1);
                else
                {
                    int val = prev.get(j-1)+prev.get(j);
                    one.add(val);
                }
            }
            list.add(one);
        }    
        
        return list;
    }
}