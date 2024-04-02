package Java;
public class buyandsell {
    public static void main(String[] args) 
    {
        int arr[] = {7,1,5,3,6,4};
        System.out.println(sol(arr));
    }
    public static int sol(int []arr)
        {
            int buy = Integer.MAX_VALUE;
            int sell = 0;
            int profit = 0;
            for(int i =0;i<arr.length;i++)
            {
                if(arr[i]<buy)
                {
                    buy = arr[i];
                }
                sell = arr[i] - buy;
                if(sell>profit)
                {
                    profit = sell;
                }
            }
            return profit;
        }
    }
