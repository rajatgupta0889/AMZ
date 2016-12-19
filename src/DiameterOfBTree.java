/**
 * Created by rajat on 16/12/16.
 */


/*
* diameter of a binary tree
* The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between
* two leaves in the tree.
* The diagram below shows two trees each with diameter nine,
* the leaves that form the ends of a longest path are shaded
*
* http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
*
*
* */


/*
* SOLUTION
*
* the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
*
* */

public class DiameterOfBTree {
    static TreeNode root;

    public static void main(String[] args) {
        DiameterOfBTree tree = new DiameterOfBTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("The diameter of given binary tree is : "
                + tree.diameter(root));
    }

    static int diameter(TreeNode node) {
        /* base case if tree is empty */
        if (node == null)
            return 0;
        /*Calculate the height of left and right subTree*/
        int rightHeight = height(node.right);
        int leftHeight = height(node.left);

        /*Calculate the Diameter of left and right subTree*/
        int diameterLeft = diameter(node.left);
        int diameterRight = diameter(node.right);

        /*Calculate the Max between the left and right leaves and the diameter of left and right subtree*/
        return Math.max(rightHeight + leftHeight + 1,
                Math.max(diameterLeft, diameterRight));


    }

    static int height(TreeNode node) {
        /* base case tree is empty */
        if (node == null)
            return 0;
        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
