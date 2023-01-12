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
    Node n;
    int d;
    Pair(Node node, int dis){
        n=node;
        d=dis;
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
        int cnt=0;

        while(!q.isEmpty()){
            
            x=in.nextInt();
            Node n=q.peek();
            if(cnt==0){
                if(x==-1){
                    n.left=null;
                }
                else{
                    Node new_node=new Node(x);
                    n.left=new_node;
                    q.add(new_node);
                }
                cnt++;
            }
            else if(cnt==1){
                if(x==-1){
                    n.right=null;
                }
                else{
                    Node new_node=new Node(x);
                    n.right=new_node;
                    q.add(new_node);
                }
                cnt++;
            }

            if(cnt==2){
                q.remove();
                cnt=0;
            }
        }
        return root;    
    }

    static void display(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        if(node.left!=null)
            display(node.left);
        if(node.right!=null)
            display(node.right);

    }

    public static void main (String args[]) {
        Node root=create_Tree();
        //display(root);

        Map<Integer,Node> map=new TreeMap<>();
        bfs(map,root);

        for(Map.Entry<Integer,Node> ite:map.entrySet()){
            System.out.print(ite.getValue().data+" ");
        }
    }

    static void bfs(Map<Integer,Node> map, Node root){
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty()){

            Pair p=q.remove();
            Node node=p.n;
            int dis=p.d;
            if(!map.containsKey(dis)){
                map.put(dis,node);
            }
            if(node.left!=null){
                q.add(new Pair(node.left,dis-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,dis+1));
            }
        }
    }      
}
