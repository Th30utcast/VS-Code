import java.util.*;
public class BellmanFord {
	
    public static class EdgesSet 
    {
        int u, v, w;
    }
    public static class Graph 
    {
        int n,e;
        EdgesSet edge[];
    }
    static Graph graph(int n, int e) 
    {
        Graph g = new Graph();
        g.n = n;
        g.e = e;
        g.edge = new EdgesSet[g.e];
        for (int i = 0; i < g.e; i++) 
            g.edge[i] = new EdgesSet();
        return g;
    }
    static boolean bellmanFord(Graph g, int x) 
    {
        int n = g.n;
        int e = g.e;
        int[] dis = new int[n];
        for (int i = 0; i < n; i++)
        {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[x] = 0;
        for (int i = 1; i < n ; i++) 
        {
            for (int j = 0; j < e; j++) 
            {
                int u = g.edge[j].u;
                int v = g.edge[j].v;
                int w = g.edge[j].w;
                if (dis[u] != Integer.MAX_VALUE && dis[v]> dis[u] + w )
                    dis[v] = dis[u] + w;
            }
        }
        for (int i = 0; i < e; i++)
        {
            int u = g.edge[i].u;
            int v = g.edge[i].v;
            int w = g.edge[i].w;
            if (dis[u] != Integer.MAX_VALUE && dis[u] + w < dis[v])
                return true;
        }
        return false;
        }


        public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int nodes=sc.nextInt();
        int edges=sc.nextInt();
        Graph am = graph(nodes,edges);
        
        for(int i=0;i<edges;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            am.edge[i].u = a;
            am.edge[i].v = b;
            am.edge[i].w = c;
            am.edge[i].u = b;
            am.edge[i].v = a;
            am.edge[i].w = c;
        }
        boolean bf=false;
        for(int i=0;i<am.edge[i].u;i++)
            if (bellmanFord(am, i))
            {
                bf=true;
            }
        if(bf)
            System.out.print("yes");
        else
            System.out.print("no");
        sc.close();
    }
}