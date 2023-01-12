import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt = m.new BinaryTree();
		bt.levelOrderZZ();
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

		public void levelOrderZZ() {
			
			// write your code here
			Queue<Node> q=new LinkedList<>();
			int i=1;
			int cnt=1;
			q.add(this.root);
			List<Integer> li=new ArrayList<>();

			while(!q.isEmpty()){

				Node n=q.remove();
				cnt--;
				li.add(n.data);

				if(n.left!=null){
					q.add(n.left);
				}
				if(n.right!=null){
					q.add(n.right);
				}

				if(cnt==0){
					cnt=q.size();
					if(i%2==0){
						printRL(li);
					}
					else{
						printLR(li);
					}
					li.clear();
					i++;
				}
			}

		}

		public void printLR(List<Integer> li){
			for(int i=0;i<li.size();i++){
				System.out.print(li.get(i)+" ");
			}
		}

		public void printRL(List<Integer> li){
			for(int i=li.size()-1;i>=0;i--){
				System.out.print(li.get(i)+" ");
			}
		}

	}

}
