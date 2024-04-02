public class CoinsChange {

    public static int count(int n,int m,int arr[])
    {
        if (n==0)
            return 1;
        if (n<0)
            return 0;
        if(m<=0 && n>=1)
            return 0;
        return count(n,m-1,arr)+count(n-arr[m-1],m,arr);
    } 

    public static int ways(int a[],int n,int c)
    {
        int matrix[] = new int [c+1];
        matrix[0]=1;
        for(int i=0;i<n;i++)
        {
            for(int j=a[i];j<=c;j++)
            {
                matrix[j]+=matrix[j-a[i]];
            }
        }
        return matrix[c];
    }

    public static void main(String[] args)
    {

    }
}
