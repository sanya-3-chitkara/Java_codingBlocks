import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced());
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

		public boolean isBalanced() {
			return this.isBal(this.root).iB;
		}

		private Pair isBal(Node node) {
			// write your code here
			if(node==null){
				return new Pair(-1,true);
			}

			Pair x=isBal(node.left);
			Pair y=isBal(node.right);
			Pair res=new Pair(Math.max(x.h,y.h)+1,false);
			if(x.iB && y.iB){
				if(x.h-y.h<=1 && x.h-y.h>=-1){
					res.iB=true;
					return res;
				}
			}
			res.iB=false;
			return res;
		}

		private class Pair {
			int h;
			boolean iB;
			Pair(int a, boolean b){
				h=a;
				iB=b;
			}
		}

	}
}
