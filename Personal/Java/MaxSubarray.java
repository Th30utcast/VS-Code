package Java;

public class MaxSubarray 
{
    public static void main(String[] args) 
    {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
    public static int maxSubArray(int[] nums)
    {
        int sum = nums[0];
        int max =nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(sum <0)
            {
                sum = 0;
            }
            sum+= nums[i];
            max = Math.max(max, sum);
        }  
        return max;
    }
}
