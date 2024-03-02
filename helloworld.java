import java.util.Arrays;
import java.util.Scanner;

class helloworld
{
    public static void main( String[] args)
    {       
        /*System.out.println("Hows the weather: ");
        Scanner scanner = new Scanner(System.in);
        String weather =scanner.next();
        weather = weather.toLowerCase();

        switch (weather) {
            case "rain":
                System.out.println("Take Umbrella.");
                break;
            case "cloudy":
                System.out.println("Take train.");
                break;
            default:
                System.out.println("Take bike.");;
        }*/


        /*System.out.println("Enter a number smaller than 10: ");
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        while (number < 10 )
        {
            System.out.println(number+1);
            number++;
        }*/


        /*String password ="welcome@123";
        System.out.print("Enter the correct password: ");
        Scanner scanner=new Scanner(System.in);
        String user_password=scanner.next();

        while (true) 
        {   if (!password.equals(user_password))
            {
                System.out.print("Password is incorrect Try again: ");
                user_password = scanner.next();
            }else
            {
                System.out.println("\nYou Entered the correct password!");
                break;
            }
        }*/


        /*System.out.print("Enter a number: ");
        Scanner scanner=new Scanner(System.in);
        int number = scanner.nextInt();

        do
        {
            System.out.println(number+1);
            number++;
        }while(number<=10);*/

        for (int i=0; i<10;i++)
        {
            System.out.println(i);
        }
    }
}