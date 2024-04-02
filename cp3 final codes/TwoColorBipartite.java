import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TwoColorBipartite {

	public static boolean TwoColor(int al[][],int deg[])
	{
		int col[]=new int [deg.length];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<col.length;i++)
		{
			if(col[i]==0)
			{
				q.add(i);
				col[i]=1;
				
				while(!q.isEmpty())
				{
					int v = q.poll();
					for(int j=0;j<deg[v];j++)
					{
						int w = al[v][j];
						if(col[w]==col[v])
						{
							return false;
						}
						if(col[w]==0)
						{
							q.add(w);
							col[w]=3-col[v];
						}
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n!=0)
		{
		int e = sc.nextInt();
		int al [][]=new int[n][n];
		int deg [] = new int[n];
		for(int i=0;i<e;i++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			al[u][deg[u]++]=v;
			al[v][deg[v]++]=u;
		}
		if(TwoColor(al,deg))
		{
			System.out.println("BICOLORABLE");
		}
		else
			System.out.println("NOT BICOLORABLE");
		n = sc.nextInt();
	}
		sc.close();
	}
}
