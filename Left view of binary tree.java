import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	static class BinaryTreeFromLvlOrder {

		private Scanner s = new Scanner(System.in);

		private class Node {
			int val;
			Node left;
			Node right;

			public Node(int val) {
				this.val = val;
			}
		}

		private Node root;

		public BinaryTreeFromLvlOrder() {
			// TODO Auto-generated constructor stub
			root = construct();// 2k
		}

		private Node construct() {
			// TODO Auto-generated method stub

			int val = s.nextInt();
			Node nn = new Node(val);
			Queue<Node> lvl = new LinkedList<>();
			lvl.add(nn);

			while (!lvl.isEmpty()) {
				Node front = lvl.remove();
				int a = s.nextInt();
				int b = s.nextInt();

				if (a != -1) {
					Node na = new Node(a);
					front.left = na;
					lvl.add(na);
				}

				if (b != -1) {
					Node nb = new Node(b);
					front.right = nb;
					lvl.add(nb);
				}
			}
			return nn;// 2k
		}

		//Write your function here
		static int depth;
		public void leftside(){
			depth=0;
			lsv(this.root,0);
		}
		private void lsv(Node node, int d){
			if(node==null){
				return;
			}
			if(depth==d){
				System.out.print(node.val+" ");
				depth++;
			}
			lsv(node.left,d+1);
			lsv(node.right,d+1);
		}

	}

	public static void main(String[] args) {
		BinaryTreeFromLvlOrder bt = new BinaryTreeFromLvlOrder();
		bt.leftside();
		
	}
}
