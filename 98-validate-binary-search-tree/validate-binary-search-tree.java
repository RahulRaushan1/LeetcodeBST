class Solution {
    private long max(TreeNode root){
        if(root==null) return Long.MIN_VALUE;
        long a = root.val, b = max(root.left), c=max(root.right);
        return Math.max(a,Math.max(b,c));
    }
    private long min(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
        long a = root.val, b = min(root.left), c = min(root.right);
        return Math.min(a,Math.min(b,c));
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.val<=max(root.left))return false;
        if(root.val>=min(root.right)) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}