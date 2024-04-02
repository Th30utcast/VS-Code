import java.util.*;

public class Cp3lab10p1 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int arr2[] = new int[n];
		for (int i =0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		for (int i =0;i<n;i++)
		{
			arr2[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		Arrays.sort(arr2);
		int m = Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			if (Math.abs(arr[i]-arr2[i])>m)
			{
				m = Math.abs(arr[i]-arr2[i]);
			}
		}
		System.out.println(m);
	}
}
