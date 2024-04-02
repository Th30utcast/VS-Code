package Java;

import java.util.*;

public class LargerstNumber 
{
    public static void main(String[] args) 
    {
        int nums[] = {10,2,9,39,17};
        System.out.println(largestNumber(nums));
    }
    public static String largestNumber(int[] nums) 
    {
        int max=nums[0];
        for(int i=0;i<nums.length;i++)
            if(nums[i]>max)max=nums[i];
        String s = Integer.toString(max);
        int arr[] = new int[s.length()*nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        System.out.println(Arrays.toString(arr));
        int check = 0;
        for(int i=0;i<nums.length;i++)
        {
            while(nums[i]>9)
            {
                arr[check]=nums[i]%10;
                nums[i]/=10;
                check++;
            }
            arr[check]=nums[i];
            check++;
        }
        System.out.println(Arrays.toString(arr));
        return addWithZerosLast(arr);
    }
    public static String addWithZerosLast(int[] arr) 
    {
        int zeros = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]>0)
            {
                sb.append(arr[i]);
            }
            else if(arr[i]==0)
            {
                zeros++;
            }
        }
        for(int i=0;i<zeros;i++)
        {
            sb.append(0);
        }
        return sb.toString();
    }
}
