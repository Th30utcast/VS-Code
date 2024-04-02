import java.util.HashMap;
import java.util.Map;

public class Pattern {
    public static void main(String[] args) 
    {
        String pattern = "aaaa";
        String name = "dog cat cat dog"; // this is now equal to ["dog","cat","cat","dog"]

        String[] strings = name.split(" ");
        if(strings.length!=pattern.length())
        {
            System.out.println(false+" line 13");
        }
        Map<Character, String> charstostring = new HashMap<>();
        Map<String,Character> stringtocahrs = new HashMap<>();

        for(int i=0;i<pattern.length();i++)
        {
            char c = pattern.charAt(i);
            String s = strings[i];
            System.out.println();
            if(!charstostring.containsKey(c))
            {
                charstostring.put(c,s);
                // System.out.println("line 25 "+c+" "+s);
                System.out.println("chars to string c= "+c+" <--this is a key");
                System.out.println("chars to string s= "+s); 
            }
            System.out.println();
            if(!stringtocahrs.containsKey(s))
            {
                stringtocahrs.put(s, c);
                // System.out.println("line 30 "+s + " "+ c);
                System.out.println("string to chars c= "+c);
                System.out.println("string to chars s= "+s+" <--this is a key");
            }
            if(!charstostring.get(c).equals(s) || !stringtocahrs.get(s).equals(c))
            {
                System.out.println("\n"+false +" line 32");
                break;
            }
        }
        // for (String i : stringtocahrs.keySet()) 
        // {
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        // for (Character i : stringtocahrs.values()) 
        // {
        //     System.out.print(i+" ");
        // }
        // System.out.println();


        System.out.println(true);


        // String a ="abba";
        // Character listString[] = new Character[a.length()];
        // for(int i=0;i<a.length();i++)
        // {
        //     char c = a.charAt(i);
        //     listString[i]=c;
        // }        
        // HashMap<Character,Integer> Firstcheck = new HashMap<Character,Integer>();
        // for(Character str: listString)
        // {
        //     if(Firstcheck.containsKey(str))
        //     {
        //         int count = Firstcheck.get(str);
        //         Firstcheck.put(str,count+1);
        //     }
        //     else
        //     {
        //         Firstcheck.put(str, 1);
        //     }
        // }
        // for(Character i:Firstcheck.keySet())
        // {
        //     System.out.println("key "+i+" value: "+Firstcheck.get(i));
        // }
        // String Pattern = "cat dog dog cat";
        // String sep = " ";
        // String listPattern[] = Pattern.split(sep);      
        // HashMap<String,Integer> Secondcheck = new HashMap<String,Integer>();
        // for(String str: listPattern)
        // {
        //     if(Secondcheck.containsKey(str))
        //     {
        //         int count = Secondcheck.get(str);
        //         Secondcheck.put(str,count+1);
        //     }
        //     else
        //     {
        //         Secondcheck.put(str, 1);
        //     }
        // }
        // for(String i:Secondcheck.keySet())
        // {
        //     System.out.println("key "+i+" value: "+Secondcheck.get(i));
        // }
    }
}