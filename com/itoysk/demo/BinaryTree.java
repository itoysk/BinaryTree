package com.itoysk.demo;

import java.util.Stack;

class Node {
    private int data;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class BinaryTree {
    private Node root;
    public BinaryTree() {}
    public BinaryTree(Node root) {
        this.root = root;
    }
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    public static void initialTree(BinaryTree bt) {
        Node E = new Node(5, null, null);
        Node F = new Node(6, null, null);
        Node C = new Node(3, E, null);
        Node D = new Node(4, null, F);
        Node B = new Node(2, C, D);
        Node H = new Node(8, null, null);
        Node G = new Node(7, H, null);
        Node A = new Node(1, B, G);
        bt.setRoot(A);
    }

    public static void printData(int data) {
        System.out.print(data + " ");
    }

    public static void preOrder(Node root) {
        if (root != null) {
            printData(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            printData(root.getData());
            inOrder(root.getRight());
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            printData(root.getData());
        }
    }

    /**
     * 非递归先序遍历
     * @param root
     */
    public static void iteratePreOrder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {
            // 当遇到节点时，将所有左节点压入栈中
            while (node != null) {
                printData(node.getData());
                stack.push(node);
                node = node.getLeft();
            }
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

    /**
     * 非递归中序遍历
     * @param root
     */
    public static void iterateInOrder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {
            // 当遇到节点时，将所有左节点压入栈中
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (stack.size() > 0) {
                node = stack.pop();
                printData(node.getData());
                node = node.getRight();
            }
        }
    }

    /**
     * 非递归后序遍历
     * @param root
     */
    public static void iteratePostOrder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> temp = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                temp.push(node);
                node = node.getRight();
            }

            if (stack.size() > 0) {
                node = stack.pop();
                node = node.getLeft();
            }

        }
        while (temp.size() > 0) {
            node = temp.pop();
            printData(node.getData());
        }
    }

        public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        //初始化
        initialTree(bt);
        //preOrder(bt.getRoot());
        //inOrder(bt.getRoot());
        //postOrder(bt.getRoot());
        //iteratePreOrder(bt.getRoot());
        //iterateInOrder(bt.getRoot());
        iteratePostOrder(bt.getRoot());
    }
}

