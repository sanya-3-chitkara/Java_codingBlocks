import java.util.*;
class Node{
    int data;
    Node left=null;
    Node right=null;

    Node(int n){
        data=n;
    }
}
public class Main {
    static Scanner in=new Scanner(System.in);

    static Node create_Tree(){

        int x=in.nextInt();
        if(x==-1){
            return null;
        }

        Node root=new Node(x);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        while( !q.isEmpty() ){

            Node node=q.peek();
            if(node.data==-1){
                break;
            }
            x=in.nextInt();
            Node new_node=new Node(x);
            if(node.left==null){
                node.left=new_node;
            }
            else if(node.right==null){
                node.right=new_node;     
                q.remove(node);
            }
            q.add(new_node);
        }
        return root;
    }

    static void display(Node node){
        if(node==null || node.data==-1){
            return;
        }
        System.out.print(node.data+" ");
        display(node.left);
        display(node.right);

    }

    public static void leaf(Node node){
        if(node.data==-1){
            return;
        }
        if(node.left.data==-1 && node.right.data==-1){
            System.out.print(node.data+" ");
            return;
        }
        leaf(node.left);
        leaf(node.right);
    }

    public static void main(String args[]) {
        
        Node root=create_Tree();
        //display(root);
        leaf(root); 
    }


}
