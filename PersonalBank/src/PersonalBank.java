import java.util.Scanner;

//BANK 2.17.26-2.18.26
public class PersonalBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        int bankNumber, oneTimePin;
        int bal = 0;

        System.out.println("WELCOME TO RAINYBANK\nPLEASE LOGIN");
        // LOGIN
        do {
            System.out.print("Enter your bank number (6 digits): ");
            bankNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter your OTP (4 digits): ");
            oneTimePin = scanner.nextInt();
            scanner.nextLine();
            if(bankNumber<=99999||bankNumber>=1000000||oneTimePin<=999||oneTimePin>=10000){
                System.out.println("INVALID CREDENTIALS!");
            }
        }while(bankNumber<=99999||bankNumber>=1000000||oneTimePin<=999||oneTimePin>=10000);

        System.out.println("WELCOME TO RAINYBANK!\nHow may we help you today?");
        do {
            System.out.print("\nPick one: Deposit, Withdraw, Balance, Exit\n: ");
            userChoice = scanner.nextLine().toLowerCase().trim();

            switch (userChoice) {
                case "deposit":
                    System.out.print("How much do you want to deposit? ");
                    int depo = scanner.nextInt();
                    scanner.nextLine();
                    if (depo <= 0) {
                        System.out.println("Invalid deposit amount.");
                    } else {
                        bal += depo;
                        System.out.printf("Deposited: %,d\nNew balance: %,d", depo, bal);
                    }
                    break;
                case "withdraw":
                    System.out.print("How much do you want to withdraw? ");
                    int cashout = scanner.nextInt();
                    scanner.nextLine();
                    if (cashout <= 0) {
                        System.out.println("Invalid withdrawal amount.");
                    } else if (cashout > bal) {
                        System.out.printf("NOT ENOUGH BALANCE. Current balance: %,d", bal);
                    } else {
                        bal -= cashout;
                        System.out.printf("Withdrawn: %,d | New balance: %,d", cashout, bal);
                    }
                    break;

                case "balance":
                    System.out.printf("Current balance: %,d", bal);
                    break;

                case "exit":
                    System.out.println("Thank you for using RAINYBANK.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (!userChoice.equals("exit"));

        scanner.close();
    }
}
