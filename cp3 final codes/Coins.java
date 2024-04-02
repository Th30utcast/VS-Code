public class Coins {
    public static int coinChange(int[] coins, int amount) 
    {
        int[] minCoins = new int[amount + 1];
        minCoins[0] = 1;
        for (int coin : coins)
        {
            for (int i = 1; i < minCoins.length; i++) 
            {
                if (i >= coin) 
                {
                    minCoins[i] += minCoins[i-coin];
                }
            }
        }
        return minCoins[amount];
    }
    public static void main(String[] args) 
    {
        System.out.println(coinChange(new int []{1,2,5},12));
    }
}
