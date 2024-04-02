import java.util.*;
import java.io.*;
import java.lang.*;
public class Primalgo 
{

    // number of vertices in the graph
    private static final int V = 5;

    // A funtion to find the vertex with min key value,
    // from the set of vertices not yet included int MST
    public int minKey(int key[], Boolean mstSet[])
    {
        //initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = 0; i<V ; i++)
        {
            if (mstSet[i]== false && key[i]<min)
            {
                min = key[i];
                min_index = i;
            }
        }
        return min_index;
    }
    // print the MST 
    public void printMST(int parent [], int graph [][])
    {
        System.out.println("Edge \tWeight");
        for(int i=1; i<V;i++)
        {
            System.out.println(parent[i]+"-"+i+"\t"+graph[i][parent[i]]);
        }
    }
    // construct and print MST for a graph represented
    // using al matrix 
    public void primMST(int graph [][])
    {
        // Array to store the MST
        int parent[] = new int [V];
        
        // Key values used to pick min weight edge in cut
        int key[] = new int [V];

        // To represent set of vertices included in the MST
        Boolean mstSet[] = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i=0; i<V; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        // Alwasy include 1st vertex in MST
        key[0] = 0;
        // We intialized it as 0 so it is picked first
        
        // First node is always the root of the MST
        parent[0] = -1;
        
        // The MST will have V vertices

        for(int i=0;i<V-1;i++)
        {
            // We pick the min key of the vertex that
            // is not in the MST
            int u = minKey(key,mstSet);
            
            // Add the key into the set
            mstSet[u] = true;
            
            // Update the key value and parent index 
            // of the graph of the picked vertex
            // Only add the vertices that are not in the MST
            for(int j=0;j<V;j++)
            {
                // Graph[i][j] is all non zeros 
                // vertices of m mstSet[j] are all false
                // for vertices that aren not included in the MST
                // Only update the key if graph[i][j] < key[j]
                
                if(graph[u][j]!=0 && mstSet[j] == false && graph[u][j] < key[j])
                {
                    parent[j] = u;
                    key[j] = graph[u][j];
                }
            }
        }
        printMST(parent, graph);
    }
    public static void main(String[] args)
	{
		/* Let us create the following graph
		2 3
		(0)--(1)--(2)
		| / \ |
		6| 8/ \5 |7
		| /	 \ |
		(3)-------(4)
			9		 */
		MST t = new MST();
		int graph[][] = new int[][] {{5,8},{0,2},{2,0}};
		// Print the solution
		t.primMST(graph);
	}
}
