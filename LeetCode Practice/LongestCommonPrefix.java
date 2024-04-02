public class LongestCommonPrefix {
    public static void main(String[] args) 
    {
        //Use Dp approach in order to solve the question
        String strs[] = {"flower","flow","flight"};
        //N is the number of strings = 3

        //size of the strings array
        int NumStrings = strs.length;
        //create new array of the size of the array in order to do a 3D DP array
        int strLengths[] = new int[NumStrings];

        //get the length of each string in order to place it in the array
        for(int i=0;i<NumStrings;i++)
        {
            strLengths[i]=strs[i].length();
        }
        //create a the 3D DP array

        int [][][] dp = new int[strLengths[0]+1][strLengths[1]+1][strLengths[2]+1];

        //Initialize the DP array
        for(int i=1;i<=strLengths[0];i++)
        {
            for(int j=1;j<=strLengths[1];j++)
            {
                for(int k=1;k<=strLengths[2];k++)
                {
                    if //Characters  match
                    ((strs[0].charAt(i-1)==strs[1].charAt(j-1) ) 
                                    && 
                    (strs[0].charAt(i-1)==strs[2].charAt(k-1)) )
                    {
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1;
                    }
                    else //Characters do not match choose the max in all 3 directions
                    {
                        dp[i][j][k]= Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        //Backtrack in order to find the LCS
        StringBuilder lcs = new StringBuilder();
        int i = strLengths[0];
        int j = strLengths[1];
        int k = strLengths[2];

        while (i>0 && j>0 && k>0)
        {
            if
            ((strs[0].charAt(i-1)==strs[1].charAt(j-1) ) 
                            && 
            (strs[0].charAt(i-1)==strs[2].charAt(k-1)))
            {
                //Current characters match in all three strings. add to lcs
                lcs.insert(0, strs[0].charAt(i-1));
                i--;
                j--;
                k--;
            }
            else if 
            (dp[i-1][j][k]>=dp[i][j-1][k]
            &&
            dp[i-1][j][k]>=dp[i][j][k-1])
            {
                //Move to the cell with the maximum value
                i--;
            }
            else if 
            (dp[i][j-1][k]>=dp[i-1][j][k]
            &&
            dp[i][j-1][k]>=dp[i][j][k-1])
            {
                j--;
            }
            else
            {
                k--;
            }
        }
        return lcs.toString().isEmpty() ? "" : lcs.toString();
    }
}
