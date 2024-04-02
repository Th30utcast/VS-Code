public class ValidPalindrome 
{
    public static void main(String[] args) 
    {
        String s = "A man, a plan, a canal: Panama";
        String sp;
        sp = s.replaceAll("[^a-zA-Z0-9]","");
        String p= "";
        for(int i=sp.length()-1;i>=0;i--)
        {
            p+=sp.charAt(i);
        }
        p = p.toLowerCase();
        sp = sp.toLowerCase();
        if(p.equals(sp))
            System.out.println("true");
        else
            System.out.println("false");
    }
}