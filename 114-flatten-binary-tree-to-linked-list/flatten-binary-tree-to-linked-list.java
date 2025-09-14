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

// class Solution{
//     public void flatten (TreeNode root){
//         if(root==null)return;
//         if(root==null && root.right==null) return ;
//         TreeNode lst = root.left;
//         TreeNode rst = root.right;
//         flatten(lst);
//         flatten(rst);
//         root.left = null;
//         root.right =lst;
//         TreeNode temp = root;
//         while(temp.right!=null) temp= temp.right;
//         temp.right = rst;

//     }
// }

//    Method 3 Morris Traversal without space using 

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr!=null){
            if(curr.left!=null){
                TreeNode r = curr.right;
                curr.right = curr.left;
                TreeNode pred = curr.left; 
                while (pred.right!=null) pred = pred.right;
                pred.right = r;
                curr.left = null; // IMPORTANT
                curr = curr.right;
            }
            else{
                curr = curr.right;
            }
        }
    }
}
