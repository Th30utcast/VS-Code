import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Shortest_Path {
	
	public static int shortBFS(int[][] al , int[] deg, int start, int dis[],int end) {
		int color[]= new int[deg.length];	
		Queue<Integer> q= new LinkedList<>();
		for (int i=0;i<color.length;i++) 
		{
			q.add(start);
			color[start]=1;
			while(!q.isEmpty()) 
			{
				int	v=q.poll();
				color[v]=2;
				for (int j=0; j<deg[v];j++) 
				{
					int w = al[v][j];
					if (color[w]==0) 
					{
						q.add(w);
						color[w]=1;
						dis[w]=dis[v]+1;
					}
				}
			}  
		}
		return dis[end];
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cp3.txt"));
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		 
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
		int [] dis = new int[nodes];
		System.out.println(shortBFS(al,deg,start,dis,end));
	}

}
