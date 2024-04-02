import java.util.Arrays;

public class Mergetest {

	public static void main(String[] args) 
	{
		int a[] = {-2,-1,0,1,2,3,4};
		int b[] = {5,6,7,8,9,10,11,12};
		System.out.println(Arrays.toString(Merge(a,b)));
		}
	public static int[] Merge(int [] a, int [] b)
	{
		int i,j,k;
		int v = a.length + b.length;
		int c[] = new int[v];
		i = 0;
		j = 0;
		k = 0;
		while(i<a.length && j<b.length)
		{
			if(a[i]<=b[j])
			{
				c[k]=a[i];
				i++;
			}
			else
			{
				c[k]=b[j];
				j++;
			}
			k++;
		}
		while(i<a.length)
		{
			c[k]=a[i];
			i++;
			k++;
		}
		while(j<b.length)
		{
			c[k]=b[j];
			j++;
			k++;
		}
		return c;
	}
}

