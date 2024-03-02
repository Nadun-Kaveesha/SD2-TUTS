public class methods {
    public static void main(String[] args){
        //Run the methods here
        greet();
        int maxNumber = findMax(25, 25);
        System.out.println("The maximum number is: " + maxNumber);

    }

    public static void greet() {
        System.out.println("Hello! Welcome to SimpleMethodsExample.");
    }


    public static int findMax(int num1, int num2) {
        return Math.max(num1, num2);
    }


}
