public class SingleNumber {
    public static void main(String[] args) 
    {
        int l[] = {-1,-1,-2};
        int temp[] = new int[l.length];
        for(int i:l)
        {
            temp[i]+=1;
        }
        for(int i=0;i<temp.length;i++)
        {
            if(temp[i]==1)
            {
            System.out.println(i);
            }
        }
    }
}
