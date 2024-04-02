import java.util.Scanner;

public class HeapSort 
{
	public void SortingAlgo(int arr[])
	{
		int N = arr.length;
		for(int i = N/(2-1);i >= 0 ;i--)
		{
			heap(arr,N,i);
		}
		for(int i = N-1;i > 0 ;i--)
		{
			int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
		}
	}
	public void heap(int arr[],int N,int i)
	{
		int leftChild = 2*i+1;
		int largest = i;
		int rightChild = 2*i;
		
        if (leftChild < N && arr[leftChild] > arr[largest])
            largest = leftChild;
 
        if (rightChild < N && arr[rightChild] > arr[largest])
            largest = rightChild;
 
        if (largest != i) {
            int diff = arr[i];
            arr[i] = arr[largest];
            arr[largest] = diff;
            heap(arr, N, largest);
        }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		HeapSort h = new HeapSort();
		for (int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		h.SortingAlgo(arr);
		for (int i = 0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}
