import java.util.Scanner;

public class MyAVLtree {
	
	public class BTNode {
		private int height;
		private int data;
		private BTNode left;
		private BTNode right;
		
		public BTNode(int data) 
		{
			this.data = data;
			height = 1;
			left = null;
			right = null;
		}

		public String toString()
		{
		      return "Value=" + this.data;
		}
		
	}

	private BTNode root;
	public int height(BTNode node)
	{
		return (node == null)?0:node.height;
	}
	public void setheight(BTNode node)
	{
		node.height=Math.max(height(node.left), height(node.right));
	}
	public void insert (int value)
	{
		root = insertrec(root, value);
	}
	public int balancefactor(BTNode node)
	{
		return (node == null)?0:height(node.left)-height(node.right);
	}
	public boolean isrightheavy(BTNode node)
	{
		return balancefactor(node)<-1;
	}
	public boolean isleftheavy(BTNode node)
	{
		return balancefactor(node)>1;
	}
	
	public BTNode rotateleft(BTNode root)
	{
		BTNode newroot = root.right;
		
		root.right = newroot.left;
		newroot.left = root;
		
		setheight(root);
		setheight(newroot);
		
		return newroot;
	}
	public BTNode rotateright(BTNode root)
	{
		BTNode newroot = root.left;
		
		root.left = newroot.right;
		newroot.right = root;
		
		setheight(root);
		setheight(newroot);
		
		return newroot;
	}
	public BTNode balance(BTNode root)
	{
		if(isleftheavy(root))
		{
			if(balancefactor(root.left)<0)
				root.left = rotateleft(root.left);
			else
				return rotateright(root);
		}
		else if (isrightheavy(root))
		{
			if(balancefactor(root.right)>0)
				root.right = rotateright(root.right);
			else
				return rotateleft(root);
		}
		return root;
	}
	public BTNode insertrec(BTNode root, int data) {
		if(root==null)
			return new BTNode(data);
		if(data<root.data)
			root.left=insertrec(root.left,data);
		else if(root.data<data)
			root.right=insertrec(root.right,data);
		else
			return root;
		root.height=Math.max(height(root.left),height(root.right))+1;
		int diff=balancefactor(root);
		if(diff>1 && data<root.left.data)
			return rotateright(root);
		if(diff<-1 && data>root.right.data)
			return rotateleft(root);
		if(diff>1 && data>root.left.data) {
			root.left=rotateleft(root.left);
			return rotateright(root);
		}
		if(diff<-1 && data<root.right.data) {
			root.right=rotateright(root.right);
			return rotateleft(root);
		}
		return root;
		
	}
	public void levelatm(BTNode root, int level)
	{
		if (root == null)
			return;
		else if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1)
		{
			levelatm(root.left,level-1);
			levelatm(root.right,level-1);
		}
	}
	public void printbylevel()
	{
		int h = height(root);
		for(int i=0;i<=h;i++)
		{
			levelatm(root,i);
		}
	}
	public static void main(String[] args) 
	{
		MyAVLtree avl = new MyAVLtree();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			avl.insert(sc.nextInt());
		}
		avl.printbylevel();
		sc.close();
	}

}
