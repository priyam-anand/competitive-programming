class Solution {
    public int[] beautifulArray(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        // System.out.println(res);
        while (res.size() < N) 
        {
            ArrayList<Integer> tmp = new ArrayList<>();
            
            for (int i : res) 
                if (i * 2 - 1 <= N) 
                    tmp.add(i * 2 - 1);
            
            for (int i : res) 
                if (i * 2 <= N) 
                    tmp.add(i * 2);
            
            res = tmp;
            // System.out.println(res);
        }
        int ans[]=new int[N];
        for(int i=0;i<N;i++)
            ans[i]=res.get(i);
        return ans;
    }
}