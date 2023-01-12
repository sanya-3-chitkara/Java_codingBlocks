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

class Pair{
    boolean bool;
    Node ans;
    Pair(){
        bool=false;
        ans=null;
    }
}

public class Main {
    static Scanner in=new Scanner(System.in);

    static Node create_Tree(){
        int x=in.nextInt();
        Node node=new Node(x);
        if(in.nextBoolean()){
            node.left=create_Tree();
        }
        if(in.nextBoolean()){
            node.right=create_Tree();
        }
        return node;
    }

    static Pair lca(Node node, int p, int q){
        if(node==null){
            return new Pair();
        }

        Pair res=new Pair();
        if(node.data==p || node.data==q){
            res.ans=node;
            res.bool=true;
            return res;
        }
        Pair x=lca(node.left,p,q);
        Pair y=lca(node.right,p,q);
        if(x.bool && y.bool){
            res.bool=true;
            res.ans=node;
            return res;
        }
        else if(x.bool){
            return x;
        }
        else if(y.bool){
            return y;
        }
        return res;
    }

    public static void main(String args[]) {
        
        Node root=create_Tree();
        int p=in.nextInt();
        int q=in.nextInt();
        Pair res=lca(root,p,q);
        if(res.bool==true)
        System.out.println(res.ans.data);
     }
}
