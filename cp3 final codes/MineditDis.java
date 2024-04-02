import java.util.*;

public class MineditDis {

	public static int findMinDistance(String s1,String s2,int m,int n) {
		int arr[][] = new int[n+1][m+1];

		for (int i = 0; i < n +1 ; i++) 
		{
            arr[i][0] = i;
        }
		for (int j = 0 ; j < m +1 ; j++)
		{
            arr[0][j] = j;
        }
        //Itiration starts here
		for (int i = 1; i < n+1 ; i++) 
        {
			for (int j = 1; j < m+1 ; j++) 
            {

				if (s1.charAt(j-1) == s2.charAt(i-1))
				{	
                    arr[i][j] = arr[i-1][j-1];
                }    
				else
                {
					arr[i][j] = min(arr,i,j)+1;
                }
			}
		}
		return arr[n][m];
	}

	public static int min(int arr[][],int i,int j) 
    {
		if (arr[i-1][j-1] < arr[i-1][j] && arr[i-1][j-1] < arr[i][j-1])
		{
            return arr[i-1][j-1];
        }
		else if (arr[i-1][j] < arr[i][j-1])
        {
			return arr[i-1][j];
        }
		else
        {
			return arr[i][j-1];
        }
    }

    public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int m = s1.length();
		int n = s2.length();
		System.out.println(findMinDistance(s1, s2, m, n));
        sc.close();
	}
}