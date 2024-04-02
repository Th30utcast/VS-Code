public class RodCutting 
{
    public static int rc(int p[], int n)
    {
        int sol[] = new int [n+1];
        sol[0]=0;
        for(int i=1;i<=n;i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j=0;j<i;j++)
            {
                min = Math.min(min, p[j]+sol[i-j-1]);
            }
            sol[i] = min;
        }
        return sol[n];
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = arr.length;
        System.out.println(rc(arr,n));
    }
}
