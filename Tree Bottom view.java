import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception{
        BinaryTree bt=new BinaryTree();
        
        //bt.display();
        bt.bottomview();
        
    }
}

class BinaryTree
{
    static Scanner in=new Scanner(System.in);
    private class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
            left=null;
            right=null;
        }
    }

    class Pair{
        int d;
        Node n;
        Pair(Node node, int dis){
            n=node;
            d=dis;
        }
    }

    Node root;

    BinaryTree()
    {
        this.root=create_Tree();
    }

    public void bottomview()
    {
        Map<Integer,Node> map=verticalTraversalBottom(this.root);
        for(Map.Entry<Integer,Node> it:map.entrySet()){
            System.out.print(it.getValue().data+" ");
        }
    }

   private Map<Integer,Node> verticalTraversalBottom(Node root) {

       Map<Integer,Node> map=new TreeMap<>();
       Queue<Pair> q=new LinkedList<>();
       q.add(new Pair(root, 0));

       while(!q.isEmpty()){
           Pair p=q.remove();
           int dis=p.d;
           Node node=p.n;
           map.put(dis,node);
           
           if(node.left!=null){
               q.add(new Pair(node.left,dis-1));
           }
            if(node.right!=null){
               q.add(new Pair(node.right,dis+1));
           }
       }
       return map;
   }


     Node create_Tree(){

        int x=in.nextInt();
        Node roo=new Node(x);
        Queue<Node> q=new LinkedList<>();
        q.add(roo);

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
        return roo;
    }

    public void display()
    {
        display_tree(this.root);
    }

    private void display_tree(Node root)
    {
        if(root==null)
        return;
        String str=root.data+"";
        if(root.left!=null)
        {
            str=root.left.data+" <= "+str;
        }
        else
        {
            str="END <= "+str;
        }

        if(root.right!=null)
        {
            str=str+" => "+root.right.data;
        }
        else
        {
            str=str+" => END";
        }
        System.out.println(str);
        display_tree(root.left);
        display_tree(root.right);

    }


}
