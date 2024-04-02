import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSisCycle {
	
	public static boolean bsf(int [][] al, int [] d) 
	{
		int [] col = new int [d.length];
		Queue<Integer> q = new LinkedList<Integer>();			
		for (int i = 0 ; i < al.length ; i++) 
		{
			if (col[i] == 0) 
			{
				q.add(i);
				col[i] = 1;
				while (!q.isEmpty())
				{
					int v = q.poll();
					col[v] = 2;
					for (int j = 0 ; j < d[v] ; j++) 
					{
						int w = al[v][j];
						if (col[w] == 1)
							return true;
						if (col[w] == 0) 
						{
							q.add(w);
							col[w] = 1;
						}
					}
				}
			}
		}
		return false;
	}	 

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("cp3.txt"));
		int n = sc.nextInt();
		int e = sc.nextInt();
		int [][] al = new int [n][n];
		int [] d = new int [n];		
		for (int i = 0 ; i < e ; i++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();			
			al[u][d[u]++] = v;
			al[v][d[v]++] = u;
		}
		if (bsf(al, d))
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
