class Solution {
    public int[] twoSum(int[] a, int target) {
        int n=a.length;
        int ans[]=new int[2];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {   
            List<Integer> l=map.getOrDefault(a[i],new ArrayList<>());
            l.add(i);
            map.put(a[i],l);
        }
        for(int key:map.keySet())
        {
            int req=target-key;
            if(map.containsKey(req))
            {
                List<Integer> l=map.get(key);
                if(req==key)
                {
                    if(l.size()>1)
                    {
                        ans[0]=l.get(0);
                        ans[1]=l.get(1);
                        break;
                    }
                }
                else
                {
                    ans[0]=map.get(key).get(0);
                    ans[1]=map.get(req).get(0);
                    break;
                }
                
            }
        }
        return ans;
    }
}