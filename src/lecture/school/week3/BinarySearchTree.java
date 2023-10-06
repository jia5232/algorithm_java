package lecture.school.week3;

import java.util.Scanner;

public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int data) {
            if(this.data < data){
                if(this.right == null) this.right = new Node(data);
                else this.right.insert(data);
            }else{
                if(this.left == null) this.left = new Node(data);
                else this.left.insert(data);
            }
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

    public static void mirror(Node root){
        if(root==null) return;
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
    }

    private static Node destruct(Node root) {
        //자바는 부모 객체가 Null이 되면 그 객체를 참조하는 자식 객체들도 가비지 컬렉터의 처리 대상이 된다.
        return null;
    }

    private static int maxPathWeight(Node root) {
        if(root==null) return 0;
        int left = maxPathWeight(root.left);
        int right = maxPathWeight(root.right);
        return root.data + Math.max(left, right);
    }

    private static int sumOfWeight(Node root) {
        int result = 0;
        if(root==null) return 0;
        result += (root.data + sumOfWeight(root.left) + sumOfWeight(root.right));
        return result;
    }

    private static int height(Node root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right)+1;
    }

    private static int size(Node root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        return size(root.left)+size(root.right)+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            Node root = new Node(sc.nextInt());
            for (int j = 0; j < n-1; j++) {
                root.insert(sc.nextInt());
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
}
