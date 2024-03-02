import java.util.Scanner;

public class TUT2
{
    public static void main(String[] args)
    {
        //Question 1
        /*System.out.print("Enter a decimal value: ");
        Scanner scanner=new Scanner(System.in);
        Double user_input=scanner.nextDouble();
        
        System.out.print("Enter a decimal value: ");
        Scanner scanner1=new Scanner(System.in);
        Double user_input1=scanner1.nextDouble();

        Double sum=user_input+user_input1;
        System.out.println("The sum is "+sum);*/


        /*int i=0;
        while (i<10)
        {
            System.out.print("Enter your Marks :");
            Scanner scanner=new Scanner(System.in);
            int marks=scanner.nextInt();
            i++;

            if (marks > 74) {
                System.out.println("A");
            } else if (marks >= 60) {
                System.out.println("B");
            } else if (marks >= 40) {
                System.out.println("C");
            } else {
                System.out.println("F");
            }
        }*/


        /*======================================= */  


        /*Question 3
        System.out.print("Enter your age :");
        Scanner scanner=new Scanner(System.in);
        int age_input=scanner.nextInt();

        if (age_input>=18)
        {
            System.out.println("Over 18!");
        }else if(age_input<18)
        {
            System.out.println("Under 18");
        }else if(age_input<0)
        {
            System.out.println("The age is incorrect");
        }*/


        /*======================================= */  


        /*Question 4
        System.out.print("Enter your ICT Marks :");
        Scanner scanner=new Scanner(System.in);
        Double ict_marks=scanner.nextDouble();

        System.out.print("Enter your CW Marks :");
        Scanner scanner1=new Scanner(System.in);
        Double cw_marks=scanner1.nextDouble();

        Double final_marks=(ict_marks+cw_marks)/2;

        if (cw_marks>30 && ict_marks >30 && final_marks>=40)
        {
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }*/


        /*======================================= */  


        /*Q5
        System.out.print("Enter the First Number :");
        Scanner scanner=new Scanner(System.in);
        double num_1=scanner.nextDouble();

        System.out.print("Enter the Second Number :");
        Scanner scanner1=new Scanner(System.in);
        double num_2=scanner1.nextDouble();

        System.out.print("Enter the Arithmetic operation :");
        Scanner scanner2=new Scanner(System.in);
        String operator=scanner2.next();


        switch (operator) {
            case "+":
                double answer=num_1+num_2;
                System.out.println(answer);
                break;
            case "-":
                double answer1=num_1-num_2;
                System.out.println(answer1);
                break;
            case "*":
                double answer2=num_1*num_2;
                System.out.println(answer2);
                break;
            case "/":
                if(num_2 !=0){
                    double answer3=num_1/num_2;
                    System.out.println(answer3);
                    break;
                }else{
                    System.out.println("Cannot divide from 0");
                    break;
                }
            default:
                break;
        }*/


        /*======================================= */  


        Scanner scanner = new Scanner(System.in);
        double balance;
        double withdraw_amount;
        double deposit_amount;
        String choice;

        /*Welcome part */
        System.out.println("\n"+" ".repeat(10)+"WElCOME TO BANK");
        

        while (true) 
            {
                System.out.print("Please Enter your Acoount Balance :");

                if (scanner.hasNextDouble())
                {
                    balance=scanner.nextDouble();
                    break;
                }else
                {
                    System.out.println("Enter a valid amount!\n");
                    scanner.next();
                }
            }



        try {
            Thread.sleep(1000); // Delay for 1000 milliseconds (1 second)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }       


        /*menu */
        while (true) 
        {   
            System.out.println("\nYour balance is Rs."+balance+" How can I help you?\n");
            System.out.println("(1.)Withdraw Funds ");
            System.out.println("(2.)Deposit Funds ");
            System.out.println("(3.)Check Fraud \n");
            int option;

            while (true) 
            {
                System.out.print("Please Select an Option :");
                option=scanner.nextInt();

                if (option >=1 && option <=3)
                {
                    break;
                }else
                {
                    System.out.println("Enter a valid input!\n");
                    continue;
                }
            }


    
            /*Main Part */
            switch (option)
            {
                case 1:                  
                    while (true) 
                    {
                        System.out.print("How much do you need to withdraw :");

                        if (scanner.hasNextDouble())
                        {
                            withdraw_amount=scanner.nextDouble();
                            break;
                        }else
                        {
                            System.out.println("Enter a valid amount!\n");
                            scanner.next();
                        }
                    }
                    
                    if (withdraw_amount<balance) 
                    {
                        balance=balance-withdraw_amount;
                        System.out.println("Please Wait !");
                        try {
                            Thread.sleep(3000); // Delay for 1000 milliseconds (1 second)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("\n"+"** "+withdraw_amount+" LKR has been successfully withdrawn.Your balance is "+balance+"LKR **");
                    }else{
                        System.out.println("Please Wait !");
                        try {
                            Thread.sleep(3000); // Delay for 1000 milliseconds (1 second)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("\n"+"** "+"You dont have enough balance.Try again with lower amount! **");
                    }
                    break;
                case 2:
                    while (true) 
                    {
                        System.out.print("How much do you need to Deposit :");

                        if (scanner.hasNextDouble())
                        {
                            deposit_amount=scanner.nextDouble();
                            break;
                        }else
                        {
                            System.out.println("Enter a valid amount!\n");
                            scanner.next();
                        }
                    }                  
                    
                    balance=balance+deposit_amount;
                    System.out.println("Please wait !");
                    try {
                        Thread.sleep(3000); // Delay for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\n"+"** "+deposit_amount+" LKR has been successfully credited to your account.Your balance is "+balance+"LKR **");
                    break;
                case 3:
                    System.out.print("Please wait while checking your Account!\n");

                    try {
                        Thread.sleep(3000); // Delay for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (balance<=100) 
                    {
                        System.out.println("\nThis is a warnig that you account balance is under 100.0LKR!");
                        
                    }else{
                        System.out.println("\nYour balance is Perfectly Fine!");
                    }
                    break;
            
                default:
                    break;
            }
            

            while (true) 
            {
                System.out.print("\nDo you want to use the service again?(Yes/No) :");
                choice=scanner.next();

                if (choice.equalsIgnoreCase("yes"))
                {
                    break;
                }else if (choice.equalsIgnoreCase("no"))
                {
                    break;
                }else
                {
                    System.out.println("Enter a valid input!\n");
                    continue;
                }
            }

            if (choice.equalsIgnoreCase("Yes")) 
            {
                System.out.println("\n==================================================");
                try 
                {
                        Thread.sleep(1500); // Delay for 1000 milliseconds (1 second)
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                continue;
            }else if (choice.equalsIgnoreCase("No")) 
            {
                try {
                        Thread.sleep(1000); // Delay for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println("Thank you for banking with us!");
                System.out.println("\n==================================================\n");
                break;
            }
        }
    }
}
