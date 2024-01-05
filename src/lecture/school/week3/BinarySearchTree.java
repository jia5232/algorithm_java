package lecture.school.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int data){
        if(this.data < data){
            if(this.right == null) this.right = new Node(data);
            else this.right.insert(data);
        }
        else{
            if(this.left == null) this.left = new Node(data);
            else this.left.insert(data);
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Node root = new Node(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < n - 1; j++) {
                root.insert(Integer.parseInt(st.nextToken()));
            }
            System.out.println(size(root));
            System.out.println(height(root));
            System.out.println(sumOfWeight(root));
            System.out.println(maxPathWeight(root));
            mirror(root);
            preOrder(root);
            System.out.println();
            inOrder(root);
            System.out.println();
            postOrder(root);
            System.out.println();
            root = destruct(root);
            if(root==null) System.out.println(0);
            else System.out.println(1);
        }
    }

    public static void preOrder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static int size(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        else return size(root.left)+size(root.right)+1;
    }

    public static int height(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right)+1;
    }

    public static int sumOfWeight(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.data;
        int left = sumOfWeight(root.left);
        int right = sumOfWeight(root.right);
        return left+right+root.data;
    }

    public static int maxPathWeight(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.data;
        int left = maxPathWeight(root.left);
        int right = maxPathWeight(root.right);
        return Math.max(left, right) + root.data;
    }

    public static void mirror(Node root){
        if(root==null) return;
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
    }

    public static Node destruct(Node root){
        if(root==null) return null;
        if(root.left!=null) destruct(root.left);
        if(root.right!=null) destruct(root.right);
        root = null;
        return root;
    }
}