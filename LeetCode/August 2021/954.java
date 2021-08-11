class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        TreeSet<Integer> set=new TreeSet<>();
        for(int key:map.keySet())
            set.add(key);
        
        int count=0;
        for(int i:set)
        {   
            if(i==0)
            {   
                count+=map.get(i)/2;
                continue;
            }
            int req=2*i;
            if(map.containsKey(req))
            {
                int val1=map.get(req);
                int val2=map.get(i);
                
                int min=Math.min(val1,val2);
                count+=min;
                val1-=min;
                val2-=min;
                map.put(req,val1);
                map.put(i,val2);
            }
        }
        if(count>=n/2)
            return true;
        return false;
    }
}