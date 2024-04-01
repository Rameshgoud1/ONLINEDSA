import java.util.*;
import javax.swing.tree.TreeNode;
public class Tress {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }
    public static Node root;
    public static void levelTraverseSequence(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.remove();
            System.out.print(temp.data+" ");
           if(temp.left!=null) q.add(temp.left);
           if(temp.right!=null) q.add(temp.right);
        }

    }
    public static void levelTraverseLevelwise(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node temp=q.remove();
            if(temp==null){
                if(q.isEmpty())  break;
                else {
                    System.out.println();
                    q.add(null);
                 }
                }
            else{
                System.out.print(temp.data+" ");
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }

    }
    public static void dfsInorder(Node root){
        Node temp=root;
        if(temp==null) return;
        dfsInorder(temp.left);
        System.out.print(temp.data+" ");
        dfsInorder(temp.right);
    }
    public static void dfsPreorder(Node root){
        Node temp=root;
        if(temp==null) return;
        System.out.print(temp.data+" ");
        dfsPreorder(temp.left);
        dfsPreorder(temp.right);
    }
    public static void dfsPostorder(Node root){
        Node temp=root;
        if(temp==null) return;
        dfsPostorder(temp.left);
        dfsPostorder(temp.right);
        System.out.print(temp.data+" ");
    }
    public static int countNodes(Node root) {
        if(root==null) return 0;
        int count=0;
        Queue<Node> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.remove();
            count++;
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            
        }
        return count;
    }
    public static int sumBT(Node root){
        //Code
        if(root==null) return 0;
        Queue<Node> q=new LinkedList<>();
        int sum=0;
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.remove();
            sum+=temp.data;
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
        return sum;
    }
    //static int sumBT(Node head){
        //Code
       // if(head==null) return 0;
      //  return sumBT(head.left)+sumBT(head.right)+head.data;
   // }
   public static int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int leftmax=maxDepth(root.left);
        int rightmax=maxDepth(root.right);
        return Math.max(leftmax,rightmax)+1;
        
    }
    public static void inorderIterative(){
        Stack<Node> st=new Stack<>();
        Node curr=root;
        while(true){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                if(st.isEmpty()) break;
                curr=st.pop();
                System.out.print(curr.data+" ");
                curr=curr.right;
            }
        }
    }
    public static void preorderIterative(){
        Stack<Node> st=new Stack<>();
        Node curr=root;
        while(true){
            if(curr!=null){
                st.push(curr);
                System.out.print(curr.data+" ");
                curr=curr.left;
            }
            else{
                if(st.isEmpty()) break;
                curr=st.pop();
                curr=curr.right;
            }
        }
    }
    public static  List<Integer> postorderTraversal(Node root) {
        List<Integer> al=new ArrayList<>();
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        if(root==null) return al;
        Node temp=root;
        st1.push(temp);
        while(!st1.isEmpty()){
            temp=st1.pop();
            st2.push(temp);
            if(temp.left!=null) st1.push(temp.left);
            if(temp.right!=null) st1.push(temp.right);
        }
        while(!st2.isEmpty()){
            Node curr=st2.pop();
            al.add(curr.data);
        }
        return al;
    }
    public static boolean isIdentical(Node root,Node subroot){
        if(root==null && subroot==null) return true;
        if(root==null || subroot==null || subroot.data!=root.data) return false;
        if(!isIdentical(root.left,subroot.left)) return false;
        if(!isIdentical(root.right,subroot.right)) return false;
        return true; 
    }
    public static  boolean isSubtree(Node root, Node subRoot) {
        if(root==null) return false;
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        
    }

    public static void main(String[] args){
       root= new Node(1);
       root.left =new Node(2);
       root.right=new Node(3);
       root.left.left=new Node(4);
       root.left.right=new Node(5);
       root.right.left=new Node(6);
       root.right.right=new Node(7);
       //levelTraverseSequence();
       //levelTraverseLevelwise();
       //dfsInorder(root);
      // System.out.println();
      // dfsPreorder(root);
       //System.out.println();
       //dfsPostorder(root);
       //System.out.println(countNodes(root));
       //System.out.println(sumBT(root));
       //System.out.println(maxDepth(root));
       //inorderIterative();
       //preorderIterative();
       //System.out.print(postorderTraversal(root));
       //Node subRoot=new Node(3);
       //subRoot.left=new Node(6);
       //subRoot.right=new Node(7);
      // System.out.println(isSubtree(root,subRoot));
    }
}
    
