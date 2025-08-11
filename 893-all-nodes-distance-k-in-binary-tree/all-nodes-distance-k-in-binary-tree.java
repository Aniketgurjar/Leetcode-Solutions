/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode>hm1=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,Integer>hm=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        ArrayList<Integer>list=new ArrayList<>();
        inorder(root,null);
        hm.put(target,0);
        q.add(target);
        while(q.size()>0){
            TreeNode temp=q.poll();
            int level=hm.get(temp);
            TreeNode left=temp.left;
            TreeNode right=temp.right;
            TreeNode papa=hm1.get(temp);

            if(level==k){
                list.add(temp.val);
            }
            if(left!=null&&!hm.containsKey(left)){
                q.add(left);
                hm.put(left,level+1);
            }
            if(right!=null&&!hm.containsKey(right)){
                q.add(right);
                hm.put(right,level+1);
            }
             if(papa!=null&&!hm.containsKey(papa)){
                q.add(papa);
                hm.put(papa,level+1);
            }
        }
        return list;
       
    }
public void inorder(TreeNode curr,TreeNode parent){
    if(curr==null){
        return ;
    }
    hm1.put(curr,parent);
    inorder(curr.left,curr);
    inorder(curr.right,curr);


}
}