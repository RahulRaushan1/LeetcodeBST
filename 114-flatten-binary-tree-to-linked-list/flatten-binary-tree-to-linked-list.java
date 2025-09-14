// class Solution {
//     public void preorder(TreeNode root,List<TreeNode> pre){
//         if(root==null) return ;
//         pre.add(root);
//         preorder(root.left,pre);
//         preorder(root.right,pre);
//     }
//     public void flatten(TreeNode root) {
//         List <TreeNode > pre = new ArrayList<>();
//         preorder(root,pre);
//         int n = pre.size();
//         for(int i=0;i<n;i++){
//             if(i!=n-1) pre.get(i).right=pre.get(i+1);
//             pre.get(i).left = null;
//         }
//     }
// }

//    Method 2 -->  Recursion 

class Solution{
    public void flatten (TreeNode root){
        if(root==null)return;
        if(root==null && root.right==null) return ;
        TreeNode lst = root.left;
        TreeNode rst = root.right;
        flatten(lst);
        flatten(rst);
        root.left = null;
        root.right =lst;
        TreeNode temp = root;
        while(temp.right!=null) temp= temp.right;
        temp.right = rst;

    }
}