class Solution {
    public void inorder(TreeNode root, List<TreeNode> arr){
        if(root==null) return ;
        inorder(root.left,arr);
        arr.add(root);
        inorder(root.right,arr);
    }
    public TreeNode bstToGst(TreeNode root) {
        List <TreeNode> arr = new ArrayList<>();
        inorder(root,arr);
        int n = arr.size();
        for(int i = n-2;i>=0; i--){
            arr.get(i).val += arr.get(i+1).val;
        }
        return root;
    }
}

//               Method 2 

// class Solution {
//     static int sum;
//     public void reverseInorder(TreeNode root) {
//         if(root==null) return;
//         reverseInorder(root.right);
//         root.val += sum;
//         sum = root.val;
//         reverseInorder(root.left);
//     }
//     public TreeNode bstToGst(TreeNode root){
//         sum = 0;
//         reverseInorder(root);
//         return root;
//     }
// }