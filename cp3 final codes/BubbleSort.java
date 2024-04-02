import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) 
	{
		int a[] = {6,2,3,8};
		Bubblesort(a);
		System.out.println(Arrays.toString(a));
	}
	public static void Bubblesort(int [] arr)
	{
		int swaps;
		for (int i = 1;i<arr.length-1;i++)
		{
			swaps = 0;
			for(int j=0;j<arr.length-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					Swap(arr,j,j+1);
					swaps++;
				}
			}
			if(swaps==0)
			{
				break;
			}
		}
		int count = 0;
	    for(int i=0;i<arr.length-1;i++)
	    {
	        if(arr[i]+1!=arr[i+1]&&arr[i]==0)
	        {
	            count += (arr[i+1] - arr[i]); 
	        }
	    }
		System.out.println(count);
	}
	public static void Swap(int []a, int b, int c)
	{
		int temp = a[b];
		a[b]=a[c];
		a[c]=temp;
	}
}
