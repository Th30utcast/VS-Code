public class LIS {
    public static int LISm(int arr[])
    {
        int result[] = new int[arr.length];
        for(int i=0; i<result.length;i++)
        {
            result[i]=1;
        }
        for(int i=1;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i])
                {
                    if(result[j]+1>result[j])
                    {
                        result[i]=result[j]+1;
                    }
                }
            }
        }
        int temp = 0;
        for(int i =0;i<result.length;i++)
        {
            if(temp<result[i])
            {
                temp = result[i];
            }
        }
        return temp;
    }

    public void main(String[] args)
    {

    }
}
