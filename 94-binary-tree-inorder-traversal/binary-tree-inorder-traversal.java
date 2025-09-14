// class Solution {
//     private void helper(TreeNode root, List<Integer> ans){
//         if(root == null) return;
//         helper(root.left, ans);
//         ans.add(root.val);
//         helper(root.right,ans);
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         helper(root, ans);
//         return ans;
//     }
// }

// class Solution{
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List <Integer> ans = new ArrayList<>();
//         Stack<TreeNode> st = new Stack<>();
//         TreeNode temp = root;
//        while(true){
//         if(temp!=null){
//             st.push(temp);
//             temp = temp.left;
//         }
//         else {
//             if(st.size()==0) break;
//             TreeNode top = st.pop();
//             ans.add(top.val);
//             temp = top.right;
//         }
//        }
//        return ans;
//    }
    
// }

// Method 3 with TC -> O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr!=null){
            if(curr.left!=null){
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right !=curr)
                pred = pred.right;
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                } 
                else {// pred.right = curr : Unlink
                   pred.right = null;
                   ans.add(curr.val);
                   curr = curr.right;
                }
            }
            else {
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans ;
    }
}