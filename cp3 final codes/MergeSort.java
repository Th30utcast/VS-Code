import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) 
	{
		int a[] = { 4, 3, 5, 10, 1, 0 };
		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void Merge(int arr[], int l, int mid, int r) {
		int n1 = mid - l + 1;
		int n2 = r - mid;
		int L[] = new int[n1];
		int M[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			M[j] = arr[mid + 1 + j];
		}
		int i, j, k;
		i = 0;
		j = 0;
		k = l;

		while (i < n1 && j < n2) {
			if (L[i] <= M[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = M[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = M[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			Merge(arr, l, mid, r);
		}
	}
}
