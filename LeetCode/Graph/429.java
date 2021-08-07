/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int currSize=1,nextSize=0;
        int sizeNow=0;
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty())
        {   
            sizeNow++;
            Node curr=q.remove();
            list.add(curr.val);
            for(Node child:curr.children)
            {
                q.add(child);
                nextSize++;  
            }
            if(sizeNow==currSize)
            {
                ans.add(list);
                list=new ArrayList<>();
                currSize=nextSize;
                nextSize=0;
                sizeNow=0;
            }
            
        }
        if(list.size()>0)
            ans.add(list);
        return ans;
    }
}