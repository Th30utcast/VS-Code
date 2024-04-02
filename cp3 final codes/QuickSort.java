import java.util.Arrays;

public class QuickSort 
{
public static void quickSort(int []A, int l, int r)
{
	if(l<r)
	{
		int j= partition(A,l,r);
		quickSort(A,l,j-1);
		quickSort(A,j+1,r);
	}
}
public static int partition(int []A, int l,int r)
{
	int i=l;
	int j=r;
	int pivot=A[l];
	while(i<j)
	{
		if(A[i]<=pivot)
		{
			i++;
		}
		else if (A[j]>=pivot)
		{
			j--;
		}
		if (i<j)
		{
			swap(A,i,j);
		}
	}
	swap(A,l,j);
	return j;
}
public static void swap(int []A, int j, int i)
{
	int temp=A[i];
	A[i]=A[j];
	A[j]=temp;
}
public static void main(String[] args) 	
	{
		int [] A= {3,2,6,4,20,50};
		quickSort(A,0,A.length-1);
		System.out.println(Arrays.toString(A));
	}
}
