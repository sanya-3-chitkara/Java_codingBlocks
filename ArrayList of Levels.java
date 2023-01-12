import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt1 = m.new BinaryTree();
		System.out.println(bt1.levelArrayList());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public ArrayList<ArrayList<Integer>> levelArrayList() {
			return lvl(this.root);

			// write your code here
		}
		private ArrayList<ArrayList<Integer>> lvl(Node root){

			ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
			
			Queue<Node> q=new LinkedList<>();
			q.add(root);
			int cnt=1;
			ArrayList<Integer> li=new ArrayList<>();

			while(!q.isEmpty()){
				Node node=q.remove();
				cnt--;
				li.add(node.data);

				if(node.left!=null){
					q.add(node.left);
				}
				if(node.right!=null){
					q.add(node.right);
				}
				if(cnt==0){

					ans.add(li);
					li=new ArrayList<>();
					cnt=q.size();
				}

			}
			return ans;
		}

	}

}
