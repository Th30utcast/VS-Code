import java.util.*;
 
public class Cp3lab10pr2 {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(Fib(n));
	}
 
	public static int Fib(int n) 
    {
		if (n == 0)
				return 1;
		int[] arr = new int[n+1];
		int count = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++)
        {
			arr[i] = arr[i - 2] + arr[i - 1];
			if (arr[i] > n)
            {
			    break;
            }
		}
        int a = n;
		for (int i = n; i >= 0; i--) {
			if (arr[i] == n)
            {
				return 1;
            }
            else if (a - arr[i] >= 0 && arr[i] != 0)
            {
				a -= arr[i];
				count++;
			}
		}
		return count;
	}
 
}