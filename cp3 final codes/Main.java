import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int dij(int graph[][],int start,int v){
        int dest[] =new int[v];
        boolean visited[]=new boolean[v];
        Arrays.fill(dest,1000000);
        Arrays.fill(visited,false);
        dest[start]=0;

        for(int i =0;i<v-1;i++){

            int u = min(dest,visited,v);
            visited[u]=true;
            for (int j=0;j<v;j++){

                if(!visited[j]&& graph[u][j]!=0&& dest[u]!=Integer.MAX_VALUE && dest[u]+graph[u][j]<dest[j])
                {
                    dest[j]=dest[u]+graph[u][j];
                }

            }

        }

        int finaSum =0;
        for(int k =0;k<dest.length;k++){
            finaSum=finaSum+dest[k];
        }
         return finaSum;

    }

    private static int min(int[] dest, boolean[] visited, int v) {
        int mini = Integer.MAX_VALUE;
        int index = -1;

        for(int i=0;i<v;i++){
            if(visited[i]==false && dest[i]<=mini){
                mini=dest[i];
                index=i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ver = scan.nextInt();
        int edg = scan.nextInt();
        int graph[][] = new int[ver][ver];
        int dest[] = new int[ver];

        for (int i = 0; i < edg; i++) {
            int src = scan.nextInt();
            int des = scan.nextInt();
            int c = scan.nextInt();
            graph[src][des] = c;
            graph[des][src] = c;

        }


        int min=Integer.MAX_VALUE;
        int location=-99;
        for(int i=0;i<ver;i++) {
            int temp =dij(graph, i, ver);
            if(temp<min) {
                 min=temp;
                 location=i;}

    }
        System.out.println(location);
        
    }
}