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
        Node node=new Node(x);
        if(in.nextBoolean()){
            node.left=create_Tree();
        }
        if(in.nextBoolean()){
            node.right=create_Tree();
        }
        return node;
    }

    static void rtlsum(int sum, Node node, List<Integer> li, int k){
        if(node.left==null && node.right==null){
            if(node.data+sum==k){
                li.add(node.data);
                for(int i=0;i<li.size();i++){
                    System.out.print(li.get(i)+" ");
                }
                System.out.println();
                li.remove(li.size()-1);
            }
            return;
        }

        li.add(node.data);
        if(node.left!=null){
            
            rtlsum(sum+node.data, node.left, li,k);
        }
        if(node.right!=null){
            rtlsum(sum+node.data, node.right, li,k);
        }
        li.remove(li.size()-1);
    }

    public static void main(String args[]) {

        Node root=create_Tree();
        int k=in.nextInt();
        List<Integer> li=new ArrayList<>();
        rtlsum(0,root,li,k);

    }
}
