import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter count bills of 20, 50 and 100");
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(new CashSet(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        System.out.println("Enter amount you need to get:");
        System.out.println( atm.takeCash(scanner.nextInt()) );
        System.out.println(atm.getStorage());
    }
}