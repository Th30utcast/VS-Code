import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class isConnected {

	public static int ConnectedBFS(int al[][],int deg[])
	{
		int[] col = new int[deg.length];
		Queue<Integer> q = new LinkedList<Integer>();
		int count=0;
		for(int i =0;i<col.length;i++)
		{
			if(col[i]==0)
			{
				count++;
				q.add(i);
				col[i]=1;
				while(!q.isEmpty())
				{
					int v = q.poll();
					col[v]=2;
					for(int j=0;j<deg[v];j++)
					{
						int w = al[v][j];
						if(col[w]==0)
						{
							q.add(w);
							col[w]=1;
						}
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(new File("cp3.txt"));
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		int [][]al = new int[nodes][nodes];
		int deg [] = new int[nodes];
		for(int i = 0; i<edges;i++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			al[u][deg[u]++]= v;
			al[v][deg[v]++]= u;
		}
		System.out.println(ConnectedBFS(al,deg));
		sc.close();
	}
}
