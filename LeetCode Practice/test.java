import java.util.Scanner;

public class test {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int initial = sc.nextInt(); //93
        int temp = 0;
        temp = initial/20;
        System.out.println("this is 20: "+initial/20);//20
        System.out.println("this is 10: "+(initial-(temp*20))/10);//10
        temp = (initial-(temp*20)-((initial-(temp*20))/10)*10);//assigining the initial to the correct number
        // System.out.println("the number is for me "+ temp);
        temp = (temp/5);
        System.out.println("this is 5: "+temp);
        temp = (initial-(temp*20)-(((initial-(temp*20))/10)*10)-initial-(temp*20)-(((initial-(temp*20))/10)*10));//assigining the initial to the correct number
        System.out.println("check: "+temp);
        temp = temp/2;
        System.out.println("this is 2: "+temp);
        temp = (((initial-(temp*20)-((initial-(temp*20))/10)*10)-((initial-(temp*20))/10)*10)*2);//assigining the initial to the correct number
        
        if(initial/2 == 0)
        {
            System.out.println("this is 1: "+0);
        }
        else
        {
            System.out.println("this is 1: "+1);
        }
        //temp = (initial-(temp*20)-((initial-(temp*20))/10)*10)-((initial-(temp*20)-((initial-(temp*20))/10)*10)/2*2);//assigining the initial to the correct number

    }
}