import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int[] pre = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(pre, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
			Node(int n){
				data=n;
			}
		}

		private Node root;
		private int size;
		private int cnt;
		public BinaryTree(int[] pre, int[] in) {
			cnt=0;
			this.root = this.construct(pre, in, 0, in.length - 1);
		}
		
		private Node construct(int[] pre, int[] in, int ilo, int ihi) {
			if(ilo>ihi){
				return null;
			}
			// write your code here
			int x=pre[cnt];
			cnt++;
			int i=get_Index(x,in,ilo,ihi);

			Node root=new Node(x);
			root.left=construct(pre,in,ilo,i-1);
			root.right=construct(pre,in,i+1,ihi);

			return root;
		}

		int get_Index(int x, int[] arr, int ilo, int ihi){
			for(int i=ilo;i<=ihi;i++){
				if(arr[i]==x){
					return i;
				}
			}
			return -1;
		}

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";

			if (node.left != null) {
				str += node.left.data;
			} else {
				str += "END";
			}

			str += " => " + node.data + " <= ";

			if (node.right != null) {
				str += node.right.data;
			} else {
				str += "END";
			}

			System.out.println(str);

			this.display(node.left);
			this.display(node.right);
		}

	}

}
