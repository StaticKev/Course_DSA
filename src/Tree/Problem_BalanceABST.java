package Tree;

import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_BalanceABST {

    public static void main(String[] args) throws InterruptedException {

        BinaryTreeNode<Integer> case1 = new BinaryTreeNode<>(4);

        case1.left = new BinaryTreeNode<>(3);
        case1.right = new BinaryTreeNode<>(5);
        case1.left.left = new BinaryTreeNode<>(2);
        case1.right.right = new BinaryTreeNode<>(6);
        case1.left.left.left = new BinaryTreeNode<>(1);
        case1.right.right.right = new BinaryTreeNode<>(7);

        List<Integer> sortedValues = getSortedValues(case1);
        preOrder(case1);
        System.out.println(sortedValues);

        BinaryTreeNode<Integer> balancingResult = balanceTree(sortedValues);
        preOrder(balancingResult);

    }

    public static List<Integer> getSortedValues(BinaryTreeNode<Integer> root) {
        if (root == null) return null;
        List<Integer> result = new ArrayList<>();

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> temp = root;
        while (!stack.isEmpty() || temp != null) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }

            temp = stack.pop();
            result.add(temp.data);
            temp = temp.right;
        }

        return result;
    }

    public static BinaryTreeNode<Integer> balanceTree(List<Integer> sortedElements) {
        return balanceTree(sortedElements, 0, sortedElements.size() - 1);
    }

    public static BinaryTreeNode<Integer> balanceTree(List<Integer> sortedElements, int start, int end) {
        if (start > end) return null;

        int middle = (start + end) / 2;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(sortedElements.get(middle));

        node.left = balanceTree(sortedElements, start, middle - 1);
        node.right = balanceTree(sortedElements, middle + 1, end);

        return node;
    }

    public static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = stack.pop();
            System.out.println(currentNode.data);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

}
