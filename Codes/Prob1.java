import java.util.*;
public class Prob1 {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int adjMat[][] = new int[V][V];
        int e[][] = new int[E][3];
        int current[] = new int[V];
        for(int i = 0;i<E;i++) 
        {
            int now = s.nextInt();
            int pos = s.nextInt();
            int que = s.nextInt();
            adjMat[now][pos] = que;
            e[i][0] = now;
            e[i][1] = pos;
            e[i][2] = que;
        }
        Arrays.fill(current, Integer.MAX_VALUE);
        for (int i = 1; i<V; i++) 
        {
            for(int j = 0; j<E; j++) 
            {
                int pp = e[j][0];
                int cer = e[j][1];
                int top = e[j][2];
                if (current[cer]>current[pp]+top)
                {
                    current[cer] = current[pp]+top;
                }
            }
        }
        boolean flagger = false;
        for(int j = 0;j<E;j++) 
        {
            int o = e[j][0];
            int pq = e[j][1];
            int u = e[j][2];
            if (current[pq]>current[o]+u)
            {
                flagger = true;
                break;
            }
        }
        if (flagger==true)
            System.out.println("yes");
        else
            System.out.println("no");
        s.close();
}
}