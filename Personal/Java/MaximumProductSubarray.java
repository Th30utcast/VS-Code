package Java;

public class MaximumProductSubarray 
{
    public static void main(String[] args) 
    {
        
    }
    public int maxProduct(int[] nums) 
    {
        int maxsum = 1;
        int minsum=1;
        int temp=0;
        int max = nums[0];
        for(int i:nums)
        {
            if(i == 0)
            {
                maxsum = 1;
                minsum =1;
                continue;
            }
            temp = maxsum*i;
            maxsum = Math.max(maxsum*i, Math.max(i,minsum*i));
            minsum = Math.max(temp, Math.max(i,minsum*i));
            max = Math.max(maxsum,minsum);
        }
        return max;
    }
}
