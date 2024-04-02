import java.util.*;

public class LCS {
	public static void main(String args[]) 
    {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(LCSm(s1, s2));
        sc.close();
	}


	static int LCSm(String x , String y) 
    {
		int dp[][] = new int [x.length()+1][y.length()+1];
		for(int i = 1 ; i <= x.length() ; i++ ) 
        {
			for(int j = 1 ; j <= y.length() ; j++) 
            {
				if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		//print(dp);
		return dp[x.length()][y.length()];
	}

    
	static void print(int arr[][]) 
    {
		for(int i = 0 ; i < arr.length ; i++) 
        {
			for(int j = 0 ; j <arr[i].length ; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
}