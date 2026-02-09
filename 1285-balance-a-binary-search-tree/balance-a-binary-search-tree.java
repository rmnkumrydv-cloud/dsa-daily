/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
       ArrayList<Integer> tree=new ArrayList<>();
       inorder(tree,root);
       int size=tree.size();
       return build(tree,0,size-1);
        
    }
    private void inorder(ArrayList<Integer> tree,TreeNode root){
        if (root==null) return ;
        inorder(tree,root.left);
        if(root!=null) tree.add(root.val);
        inorder(tree,root.right);
        
    }
    private TreeNode build(ArrayList<Integer> tree,int start,int last){
        if(start>last){
            return null;
        }
        int mid =start +(last-start)/2;
        int val=tree.get(mid);
        TreeNode t=new TreeNode(val,build(tree,start,mid-1),build(tree,mid+1,last));
        return t;

        
    }
}