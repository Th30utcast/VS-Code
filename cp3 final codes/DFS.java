import java.io.File;
import java.util.Scanner;

public class DFS {
	
	public static void DFSTraversal(int al[][],int deg[])
	{
		int col[]= new int [deg.length];
		for(int i=0;i<al.length;i++)
		{
			if(col[i]==0)
			{
				DFSRec(al,deg,col,i);
			}
		}
	}

	public static void DFSRec(int al[][],int deg[],int col[],int v)
	{
		col[v]=1;
		System.out.print(v+" ");
		for(int j =0;j<deg[v];j++)
		{
			int w = al[v][j];
			if(col[w]==0)
			{
				DFSRec(al,deg,col,w);
			}
		}
		col[v]=2;
	}
	
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(new File("cp3.txt"));
		int n = sc.nextInt();
		int e = sc.nextInt();
		int al [] [] = new int [n][n];
		int deg [] = new int [n];
		for(int i=0;i<e;i++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			al[u][deg[u]++]=v;
			al[v][deg[v]++]=u;
		}
		DFSTraversal(al,deg);
		sc.close();
	}

}
