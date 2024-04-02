package Java;
import java.util.Arrays;

//You are given a large integer represented as an integer array digits
//where each digits[i] is the ith digit of the integer. 
//The digits are ordered from most significant to least significant in left-to-right order. 
//The large integer does not contain any leading 0's.
//Increment the large integer by one and return the resulting array of digits.

//Example:
//Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Incrementing by one gives 123 + 1 = 124.
// Thus, the result should be [1,2,4].

public class PlusOne {
    public static void main(String[] args) 
    {
        int arr[] = {9,9};
        System.out.print(Arrays.toString(Method(arr)));
    }
    public static int[] Method(int [] arr)
    {
        int n = arr.length;
        for (int i = n-1;i>0;i--)
        {
            if (arr[i]<9)
            {
                arr[i]++;
                return arr;
            }
            
            else
            {
                arr[i]=0;
            }
        }
        int[] arrnew = new int[n+1];
        arrnew[0]=1;
        return arrnew;
    }
}