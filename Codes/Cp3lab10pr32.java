import java.util.*;

public class Cp3lab10pr32 {

	static boolean Isnegativecycle(int al[][], int src) 
	{
		int dis[] = new int[al.length];
		int c = 0;
		for (int i = 0; i < al.length; i++)
		{
			dis[i] = Integer.MAX_VALUE;
		}
		dis[src] = 0;
		for (int i = 0; i <= al.length - 1; i++) 
		{
			for (int j = 0; j < al.length; j++) 
			{
				c = 0;
				for (int k = 0; k < al[j].length; k++) 
				{
					if (dis[k] > al[j][k] + dis[j] && dis[j] != Integer.MAX_VALUE && al[j][k] != 0) 
					{
						dis[k] = al[j][k] + dis[j];
						c++;
					}
				}
				if (c == 0)
					break;
			}
		
		}
		for (int i = 0; i < al.length ; i++) 
		{
			for (int j = 0; j < al[i].length ; j++) 
			{
				if (dis[j] > al[i][j] + dis[i])
				{
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		int edge = sc.nextInt();
		int al[][] = new int[nodes][nodes];
		for (int i = 0; i < nodes; i++) 
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			al[u][v] = w;
			
		}
		boolean flag = false;
		for (int i = 0; i < nodes; i++) 
		{
			if (Isnegativecycle(al, i)) 
			{
				flag = true;
				break;
			}
		}
		if (flag)
			System.out.println("yes");
		else
			System.out.println("no");
	}

}