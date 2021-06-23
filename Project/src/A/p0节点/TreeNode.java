package A.p0节点;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public static TreeNode root;
    static {
        root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);

        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
    }

    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return ""+val;
    }
}

