
public class PalindromeNumber {
    public static void main(String[] args) 
    {
        int a = 12323;
        int b = a;
        int c = a;
        int count1 = 0;
        while(c!=0)
        {
            c=c/10;
            count1++;
        }
        int i;
        int d[] = new int[count1];
        int count=-1;
        while(b!=0)
        {
            i = b%10;
            b=b/10;
            count++;
            d[count]=i;
        }
        int h[] = new int[d.length];
        int j=0;
        for (int f=d.length-1;f>=0;f--)
        {
            h[j]=d[f];
            j++;
        }
        for (int k=0;k<d.length;k++)
        {
            if (d[k]!=h[k])
            {
                break;
            }
        }
    }
}
