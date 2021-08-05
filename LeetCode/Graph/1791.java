import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {
       
        Map<Integer,Integer> map = new HashMap<>();
        for(int a[] : edges)
        {
            for(int v : a)
            {
                map.put(v,map.getOrDefault(v,0)+1);
            }
        }
        
        int curr=-1,max=0;
        for(int key : map.keySet()){
            if(map.get(key)>max)
            {
                curr=key;
                max=map.get(key);
            }
        }
        
        return curr;
        
    }
}