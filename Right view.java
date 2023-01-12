import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int n){
        data=n;
        left=null;
        right=null;
    }
}

public class Main {
    static Scanner in=new Scanner(System.in);

    static Node create_Tree(){

        int x=in.nextInt();
        Node root=new Node(x);
        Queue<Node> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node n=q.remove();
            int a=in.nextInt();
            int b=in.nextInt();

            if(a!=-1){
                n.left=new Node(a);
                q.add(n.left);
            }
            if(b!=-1){
                n.right=new Node(b);
                q.add(n.right);
            }
        }
        return root;
    }

    static void display(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        display(node.left);
        display(node.right);
    }

    static int depth;
    static public void rsv(Node node, int d){
        if(node==null){
            return;
        }

        if(d==depth){
            System.out.print(node.data+" ");
            depth++;
        }
        rsv(node.right,d+1);
        rsv(node.left,d+1);
    }
    public static void main (String args[]) {
        Node root=create_Tree();
        //display(root);
        depth=0;
        rsv(root,0);
    }
}
