package leetcode;

/**
 * Two players play a turn based game on a binary tree.  We are given the root of this binary tree, and the number of nodes n in the tree.
 * n is odd, and each node has a distinct value from 1 to n.
 *
 * Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x.
 * The first player colors the node with value x red, and the second player colors the node with value y blue.
 *
 * Then, the players take turns starting with the first player.  In each turn, that player chooses a node of their color
 * (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child,
 * or parent of the chosen node.)
 *
 * If (and only if) a player cannot choose such a node in this way, they must pass their turn.
 * If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
 *
 * You are the second player.  If it is possible to choose such a y to ensure you win the game, return true.
 * If it is not possible, return false.
 */
public class Q1145_BinaryTreeColoringGame {

    private int leftCount = 0;
    private int rightCount = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        if (leftCount + rightCount + 1 <= n / 2) {
            return true;
        }
        if (leftCount > n / 2 || rightCount > n / 2) {
            return true;
        }
        return false;
    }

    int count(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int left = count(node.left, val);
        int right = count(node.right, val);
        if (node.val == val) {
            leftCount = left;
            rightCount = right;
        }
        return left + right + 1;
    }
}
