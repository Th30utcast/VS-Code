import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) 
	{
		int a[] = {5,21,6,875,236,0,1,3,2};
		SelectionSortt(a);
		System.out.println(Arrays.toString(a));
	}
	public static void SelectionSortt(int []a)
	{
		for(int i=1;i<a.length;i++)
		{
			FindMaxandSwap(a,a.length-i);
		}
	}
	public static void FindMaxandSwap(int []a, int l)
	{
		int  imax =0;
		for(int i=1;i<=l;i++)
		{
			if (a[i]>a[imax])
			{
				imax=i;
			}
			Swap(a,imax,l);
		}
	}
	public static void Swap(int []a, int b, int c)
	{
		int temp = a[b];
		a[b]=a[c];
		a[c]=temp;
	}
}