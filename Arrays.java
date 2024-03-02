import java.util.Scanner;



public class Arrays {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] array={1,2,3,4};
        /*for(int i =0; i<array.length; i++){
            System.out.println(array[i]);
        }*/

        /*int i = 0;
        while (i<array.length) {
            System.out.println(array[i]);
            i++;
        }*/

        /*ARRAY TEST        
        Scanner scanner = new Scanner(System.in);
        String[] name_array={"Nadun","Ashen","Venuka","Vihnaga"};
        double[] marks_array=new double[4];
        


        int i=0;
        while (i<name_array.length) {
            System.out.print("Please Enter the Marks of "+name_array[i]+" : " );
            marks_array[i]=scanner.nextDouble();
            i++;          
        }
        System.out.println("\n");




        Calculating the sum of the array 
        double sum=0;
        for ( int x = 0; x < marks_array.length; x++) {
            
            sum += marks_array[x];
        }

        Calculating the average 
        double ave=sum/marks_array.length;


        Final display 
        int y=0;
        while (y<marks_array.length) {
            System.out.print("Student : "+name_array[y]+" - Personal Score="+marks_array[y]+" ,   Overall Average="+ave );
            System.out.println("\n");
            y++;          
        }*/


        /*Searching */
        /*int[] num_array={10,25,55,8,55,4,6,25};
        int num_to_find=25;

        int i=0;
        boolean not_found=true;
        while (i<num_array.length && not_found) {
            if (num_array[i] == num_to_find) {
                System.out.println("Found item in index "+i);
            }
            i++;
        }*/
        /*Transversinng a 2d array */
        /*int [][] sample = {{ 1, 2, 3 },{ 4, 5, 6 }};
        for(int r=0; r<sample.length; r++){
            for(int c=0; c<sample[r].length; c++){
                System.out.println(sample[r][c]);
            }
        }*/

        /* 
        int numCities =2;
        int numDays = 5;
        double[][] temperatures = new double[numCities][numDays];


        for(int city = 0; city< numCities; city++){
            for(int day=0; day<numDays; day++){
                System.out.print("Enter the temperature for city " + (city +1) + "Day " + (day+1) + ": ");
                temperatures[city][day] = scanner.nextDouble();
            }
        }


        double maxTemperature = temperatures[0][0];
        int maxCity = 0;
        int maxDay = 0;
        for (int city = 0; city < numCities; city++) {
            for (int day = 0; day < numDays; day++) {
                if (temperatures[city][day] > maxTemperature) {
                    maxTemperature = temperatures[city][day];
                    maxCity = city;
                    maxDay = day;
                }
            }
        }

        // Find the lowest temperature and its corresponding city and day
        double minTemperature = temperatures[0][0];
        int minCity = 0;
        int minDay = 0;
        for (int city = 0; city < numCities; city++) {
            for (int day = 0; day < numDays; day++) {
                if (temperatures[city][day] < minTemperature) {
                    minTemperature = temperatures[city][day];
                    minCity = city;
                    minDay = day;
                }
            }
        }

        // Print the results
        System.out.println("Highest Temperature: " + maxTemperature + " in City " + (maxCity + 1) + " on Day " + (maxDay + 1));
        System.out.println("Lowest Temperature: " + minTemperature + " in City " + (minCity + 1) + " on Day " + (minDay + 1));

        scanner.close();*/

        
    }
}
