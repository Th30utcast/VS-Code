import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) 
	{
		int a[] = {7,2,0,5,10,8,3};
		for(int i=0;i<a.length;i++)
		{
			int j=i;
			while(j>0 && a[j]<a[j-1])
			{
				Swap(a,j,j-1);
				j--;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	public static void Swap(int []a, int b, int c)
	{
		int temp = a[b];
		a[b]=a[c];
		a[c]=temp;
	}
}
