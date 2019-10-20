package _01_SMS;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        System.out.println("Wpisz treść SMS-a:");

        Scanner scanner = new Scanner(System.in);
        String nowySMS =  scanner.nextLine();
        scanner.close();

        String[] nowySMSTablica = nowySMS.split(" ");
        String wyjsciowySMS = "";

        for (String slowo : nowySMSTablica) {

            if (slowo.isEmpty()) {
                continue;   // break spowodowałby przewanie pętli i koniec,
                            // continue omija dany element i kontynuuje pętlę
            }

            String pierwsza = slowo.substring(0,1);
            pierwsza = pierwsza.toUpperCase();
            wyjsciowySMS += pierwsza + slowo.substring(1);
        }

        System.out.println(wyjsciowySMS);


        if (wyjsciowySMS.length() <= 160) {
            System.out.println("Wysłałeś 1 sms");
        } else {
            double iloscSMSwewn = (wyjsciowySMS.length() + 152) / 153;
            System.out.printf("Wysłałeś %.0f smsów", iloscSMSwewn);
        }

    }
}
