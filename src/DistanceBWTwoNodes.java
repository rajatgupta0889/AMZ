/**
 * Created by rajat on 19/12/16.
 */

/*
* Find distance between two given keys of a Binary Tree
* */
public class DistanceBWTwoNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new  TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        DistanceBWTwoNodes distanceBWTwoNodes = new DistanceBWTwoNodes();
        System.out.println(distanceBWTwoNodes.findDistance(root,4,5));


    }

    public int findDistance(TreeNode root, int n1, int n2) {
        int x = Pathlength(root, n1) - 1;
        int y = Pathlength(root, n2) - 1;
        int lcaData = findLCA(root, n1, n2).value;
        int lcaDistance = Pathlength(root, lcaData) - 1;
        return (x + y) - 2 * lcaDistance;
    }

    public int Pathlength(TreeNode root, int n1) {
        if (root != null) {
            int x = 0;
            if ((root.value == n1) || (x = Pathlength(root.left, n1)) > 0
                    || (x = Pathlength(root.right, n1)) > 0) {
                // System.out.println(root.data);
                return x + 1;
            }
            return 0;
        }
        return 0;
    }

    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root != null) {
            if (root.value == n1 || root.value == n2) {
                return root;
            }
            TreeNode left = findLCA(root.left, n1, n2);
            TreeNode right = findLCA(root.right, n1, n2);

            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }

}
