public class Dijkstras {

	public static void dijkstra(int graph[][],int s) 
    {
		int dist[] = new int[graph.length];
		int set[] = new int[dist.length];
		
		for(int i = 0 ; i < graph.length ; i++) 
        {
			dist[i] = Integer.MAX_VALUE;
			set[i] = -1;
		}
		dist[s] = 0;
		//set[s] = 0;
		
		for(int i = 0 ; i < set.length - 1; i++) 
        {
			int u = findMin(dist, set);
			set[u] = 1;
			
			for(int v = 0 ; v < dist.length ; v++) 
            {
				if(set[v] == -1 && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + graph[u][v])
                {
					dist[v] = dist[u] + graph[u][v]; 
                }
			}
		}
		for (int i = 0 ; i < dist.length ; i++) 
        {
			System.out.println(s+" "+dist[i]);
		}
	}

    public static int findMin(int key[],int set[]) 
    {
		int minValue = Integer.MAX_VALUE, minIndex = -1;
		for (int i = 0 ; i < key.length ; i++) 
        {
			if(key[i]<minValue && set[i] == -1) 
            {
				minValue = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

    public static void main(String[] args) 
    {
		int graph [][] = {{0,1,2,0},{1,0,4,6},{2,4,0,5},{0,6,5,0}};
		dijkstra(graph, 0);
		
	}
}