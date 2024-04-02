public class Knapsack {
    //Knapsack using Dynamic programing

    static int ks(int weight, int wt[], int val[], int n)
    {
        int i, j;
        int dp[][] = new int[n + 1][weight + 1];
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) 
        {
            for (j = 0; j <= weight; j++) 
            {
                if (i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                }
                else if (wt[i - 1] <= j)
                {
                    dp[i][j]= Math.max(val[i - 1]+ dp[i - 1][j - wt[i - 1]],dp[i - 1][j]);
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][weight];
    }
    // Driver code
    public static void main(String[] args)
    {
        int val[] = { 1,2,5,6};
        int wt[] = { 2,3,4,5 };
        int W = 8;
        int n = val.length;
        System.out.print(ks(W, wt, val, n));
    }
}