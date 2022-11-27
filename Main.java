package bullscows;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scsn = new Scanner(System.in);
            System.out.println("Please, enter the secret code's length:");
            String str_dlina = scsn.nextLine();
            if (!str_dlina.matches("[-+]?\\d+")) {
                System.out.println("Error: \"" + str_dlina + "\" isn't a valid number.");
                break;
            }
            Integer dlina = Integer.parseInt(str_dlina);
            if (dlina == 0) {
                System.out.println("error");
                break;
            }
            System.out.println("Input the number of possible symbols in the code:");
            String str_numbers = scsn.nextLine();
            if (!str_numbers.matches("[-+]?\\d+")) {
                System.out.println("Error: \"" + str_dlina + "\" isn't a valid number.");
                break;
            }
            Integer numbers = Integer.parseInt(str_numbers);
            if (numbers > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                break;
            } else if (numbers < dlina) {
                System.out.println("Error: it's not possible to generate a code with a length of "
                        + dlina + " with " + numbers + " unique symbols.");
                break;
            }
            String pin_in = Generator10.randomgen(dlina, numbers);
            System.out.print("The secret is prepared: ");
            for (int i = 0; i < dlina; i++) {
                System.out.print("*");
            }
            if (numbers <= 10) {
                System.out.print(" (0-" + Generator10.alfabet_code.charAt(numbers - 1) + ").");
            } else System.out.print(" (0-9, a-" + Generator10.alfabet_code.charAt(numbers - 1) + ").");
            //System.out.println(pin_in);
            System.out.println("Okay, let's start a game!");
            int sch = 1;
            int byki = 0;
            int korovy = 0;
            while (byki != dlina) {
                byki = 0;
                korovy = 0;
                System.out.println("Turn " + sch + ":");
                Scanner scsn2 = new Scanner(System.in);
                StringBuilder pin = new StringBuilder(scsn2.nextLine());
                for (int i = 0; i <= dlina - 1; i++) {
                    Character pafh_of_pin_in = pin_in.charAt(i);
                    for (int j = 0; j <= dlina - 1; j++) {
                        if (pafh_of_pin_in == pin.charAt(j) & i == j) {
                            byki++;
                        } else if (pafh_of_pin_in == pin.charAt(j) & i != j) {
                            korovy++;
                        }
                    }
                }
                String out_str = "";
                if (byki == 0 & korovy == 0) {
                    out_str = "None";
                } else if (byki != 0 & korovy == 0) {
                    out_str = (byki + " bull(s)");
                } else if (byki == 0 & korovy != 0) {
                    out_str = (korovy + " cow(s)");
                } else {
                    out_str = (byki + " bull(s) and " + korovy + " cow(s)");
                }
                System.out.println("Grade: " + out_str + ".");
                sch++;
            }
            System.out.println("Congratulations! You guessed the secret code.");
            break;
        }
    }
}