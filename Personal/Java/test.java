package Java;
import java.util.*;
public class test
{
    public static void main(String[] args) 
    {
        int arr[] = {6,3};
        System.out.println(solution(arr));
        System.out.println(Arrays.toString(arr)); 
    }
    public static int solution(int[] arr) 
    {
        sort(arr);
        int count = 0;
        for(int i=0;i<arr.length-1;i++)
        {
            int b =0;
            if(arr[i]+1!=arr[i+1])
            {
                b = (arr[i+1]-arr[i])-1;
                System.out.println("arr["+(i+1)+"]"+arr[i+1]);
                System.out.println("arr["+i+"]"+arr[i]);
                System.out.println(b);
                count+=b;
                System.out.println(count);
            }
        }
        return count;
    }
    
    
    static void sort(int[]arr)
    {
        for (int i = 0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
