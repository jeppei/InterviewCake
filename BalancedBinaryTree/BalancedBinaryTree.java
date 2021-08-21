package Projects.InterviewCake.BalancedBinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jesper Lundin on 13 Nov 2016.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode n2 = root.insertLeft(2);
        BinaryTreeNode n3 = root.insertRight(3);
        BinaryTreeNode n4 = n2.insertLeft(4);
        BinaryTreeNode n5 = n2.insertRight(5);
        BinaryTreeNode n6 = n3.insertRight(6);
        BinaryTreeNode n7 = n4.insertLeft(7);
        BinaryTreeNode n8 = n5.insertLeft(8);
        BinaryTreeNode n9 = n5.insertRight(9);
        BinaryTreeNode n10 = n6.insertLeft(10);
        BinaryTreeNode n11 = n6.insertRight(11);
        BinaryTreeNode n12 = n3.insertLeft(12);
        BinaryTreeNode n18 = n7.insertLeft(18);

        boolean isBalanced = superBalanced(root);
        System.out.println("This tree is " + (!isBalanced?"not ":"") + "balanced");
    }


    public static boolean superBalanced(BinaryTreeNode a) {
        // Initialize
        HashMap<BinaryTreeNode, Integer> visited = new HashMap<>(); // This one is not needed since we have a binary tree (no cycles)
        boolean dfs = true;
        Stack<BinaryTreeNode> stackNode = new Stack<>();
        Stack<Integer> stackDepth = new Stack<>();
        Queue<BinaryTreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueDepth = new LinkedList<>();

        if (dfs) {
            stackNode.push(a);
            stackDepth.push(0);

        } else {
            queueNode.add(a);
            queueDepth.add(0);
        }


        Integer lowestDepth = null;
        Integer highestDepth = null;

        // DFS starts
        while (dfs && !stackNode.isEmpty() || !dfs && !queueNode.isEmpty()) {
            BinaryTreeNode currentNode = (dfs) ? stackNode.pop():queueNode.poll();
            Integer currentDepth = (dfs) ? stackDepth.pop():queueDepth.poll();
            if (visited.get(currentNode) == null) {
                visited.put(currentNode, 1);

                // Leaf check
                if (currentNode.left == null && currentNode.right == null) {
                    lowestDepth = (lowestDepth != null && lowestDepth < currentDepth) ?
                                    lowestDepth: currentDepth;
                    highestDepth = (highestDepth != null && highestDepth > currentDepth) ?
                                    highestDepth: currentDepth;
                    if (highestDepth-lowestDepth > 1) {
                        System.out.println(currentNode.value + ":\t" + (currentDepth) + "\tDepths: " + lowestDepth + "-" + highestDepth);
                        return false;
                    }
                } else {
                    if (currentNode.left != null) {
                        if (dfs) {
                            stackNode.push(currentNode.left);
                            stackDepth.push(currentDepth+1);
                        } else {
                            queueNode.add(currentNode.left);
                            queueDepth.add(currentDepth+1);
                        }
                    }
                    if (currentNode.right != null) {
                        if (dfs) {
                            stackNode.push(currentNode.right);
                            stackDepth.push(currentDepth+1);
                        } else {
                            queueNode.add(currentNode.right);
                            queueDepth.add(currentDepth+1);
                        }
                    }
                }
            }
            System.out.println(currentNode.value + ":\t" + (currentDepth) + "\tDepths: " + lowestDepth + "-" + highestDepth);
        }
        return true;
    }


    public static class BinaryTreeNode {


        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;


        public BinaryTreeNode(int value) {
            this.value = value;
        }


        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }


        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

}
