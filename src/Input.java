import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getString() {
        return scanner.nextLine();
    }
    public boolean yesNo() {
//        if scanner input = y or yes , then return true or else return false
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
    }
    public int getInt(int min, int max) {
//        System.out.println("Enter a number 1-10:");
        int userInput = scanner.nextInt();
        if (userInput <= max && userInput >= min) {
//            System.out.println("This is your number: " + userInput);
            return userInput;
        } else {
            return getInt(min,max);
        }

    }
    public int getInt() {
        while (true) {

            try {
                return Integer.parseInt(getString());
            } catch (NumberFormatException e) {
                System.out.println("This is not an int");
            }

        }
    }

    public double getDouble(double min, double max) {
        System.out.println("Enter a number 1-10:");
        double userInput = scanner.nextDouble();
        if (userInput <= max && userInput >= min) {
            System.out.println("This is your number: " + userInput);
            return userInput;
        } else {
            return getDouble(min,max);
        }
    }
    public double getDouble() {
        while (true) {
            try {
                return Double.parseDouble(getString());
            } catch (NumberFormatException e) {
                System.out.println("this isn't a double");
            }
        }
    }





    public static void main(String[] args) {
        Input in = new Input();
//        System.out.println("enter a string" );
//        System.out.println(in.getString());
//        System.out.println("[y/n]?");
//        System.out.println(in.yesNo());
//        System.out.println("enter min, max");
//        System.out.println(in.getInt(1,10));
        System.out.println("enter an int");
        System.out.println("your int is: " + in.getInt());
        System.out.println("enter a double");
        System.out.println("this is your double: " + in.getDouble());
//        System.out.println("enter the double: ");
////        System.out.println(in.getDouble(1,10));
//        System.out.println("plain double: ");
//        System.out.println("this is the plain double: " + in.getDouble());

    }

}