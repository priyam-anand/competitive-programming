import java.util.*;

class Solution {
    int val=-1;
    public int findTheWinner(int n, int k) {
        List<Integer> list=new ArrayList<>();
		for(int i=1;i<=n;i++)
			list.add(i);
		solve(list,0,k);
        return val;
    }
    void solve(List<Integer> arr,int start,int k)
	{	
		if(arr.size()==1)
		{	
			val=arr.get(0);
			return;
		}
		int idx=(start+k-1)%(arr.size());
		List<Integer> list=new ArrayList<>();
		for(int i:arr)
			if(i!=arr.get(idx))
				list.add(i);
		int next=idx;
		if(next==arr.size()-1)
			next=0;
		solve(list,next,k);
	}
}