	
// UNION BY RANK CODE TIME COMPLEXITY OF O(lon N)

	public static void union(int Arr[ ],int size[ ],int A,int B)
	{
	    int root_A = root(Arr,A);
	    int root_B = root(Arr,B);
	    if(size[root_A] < size[root_B ])
	    {
	    	Arr[ root_A ] = Arr[root_B];
	    	size[root_B] += size[root_A];
	    }
	    else
	    {
	    	Arr[ root_B ] = Arr[root_A];
	    	size[root_A] += size[root_B];
	    }

	}
	
	public static int root (int arr[ ] ,int i)
	{
	    while(arr[ i ] != i)
	    {
	        arr[ i ] = arr[ arr[ i ] ] ; 
	        i = arr[ i ]; 
	    }
	    return i;
	}