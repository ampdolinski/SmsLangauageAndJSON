package zadDomAdamDolinski;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.Scanner;

//      brak testów... :(

public class Main {

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();

        Pieniadze[] wszystkiePieniadze = Pieniadze.values();


        for (Pieniadze pieniadze : wszystkiePieniadze) {

//            Jeżeli nie działa w wersji podstawowej,
//            należy od dzisiejszej daty odjąć jeden dzień,
//            bo najlprawdopodobniej nie ma jeszcze aktualnego
//            kursu z dnia dzisiejszego
//            LocalDate dataDzisiaj = LocalDate.now().minusDays(1);

            LocalDate dataDzisiaj = LocalDate.now().minusDays(1);

            String adresikDzisiaj = getAdresikDoDaty(pieniadze, dataDzisiaj);

            Kursik kursikDzisiejszy = getKursik(gson, pieniadze, adresikDzisiaj);

            System.out.printf("Kursik dzisiejszej sprzedaży waluty %s wynosi %.4f zł. %n",
                    kursikDzisiejszy.code.toUpperCase(), kursikDzisiejszy.getRates()[0].ask);

            System.out.printf("Za 100 złociszy dostaniesz dzisiaj %.2f waluty %s.%n",
                    getWartoscStowy(kursikDzisiejszy), kursikDzisiejszy.code.toUpperCase());

            LocalDate dataMiesiacTemu = LocalDate.now().minusMonths(1);

            String adresikMisioncTymu = getAdresikDoDaty(pieniadze, dataMiesiacTemu);

            Kursik kursikStary = getKursik(gson, pieniadze, adresikMisioncTymu);

            System.out.printf("Kursik sprzedaży miesiąc temu waluty %s wynosi %.4f zł. %n",
                    kursikStary.code.toUpperCase(), kursikStary.getRates()[0].ask);

            System.out.printf("Kursik dzisiejszego kupna waluty %s wynosi %.4f zł. %n",
                    kursikDzisiejszy.code.toUpperCase(), kursikDzisiejszy.getRates()[0].bid);

            jakBardzoSieOblowiles(kursikDzisiejszy, kursikStary);

        }

    }

    private static void jakBardzoSieOblowiles(Kursik kursikDzisiejszy, Kursik kursikStary) {
        double wartoscZyskuCzyStraty = (getWartoscStowy(kursikStary) * kursikDzisiejszy.getRates()[0].bid) - 100;

        if (wartoscZyskuCzyStraty > 0) {
            System.out.printf("W związku z tym, na tej drobnej malwe... inwestycji zarobiłeś: %.2f zł.%n%n",
                    wartoscZyskuCzyStraty);
        } else if (wartoscZyskuCzyStraty < 0) {
            System.out.printf("Straciłeś szalone, uwaga uwaga: %.2f zł.%n%n",
                    wartoscZyskuCzyStraty);
        } else {
            System.out.println("Twoje niezwykłe wyczucie rynku sprawiło, że nie straciłeś nawet 1 grosza!\n"
            + "Jednak nie zarobiłeś też nawet tego 1 grosza.\n"
            + "Smacznego przy wyjadaniu kitu z okien i powodzenia w szukaniu nowej pracy.");
        }
    }

    private static double getWartoscStowy(Kursik kursikAktualnieDoSprawdzenia) {
        return 100 / kursikAktualnieDoSprawdzenia.getRates()[0].ask;
    }

    private static Kursik getKursik(Gson gson, Pieniadze pieniadze, String adresikPoPiniondze) throws IOException {

        URL obj = new URL(adresikPoPiniondze);
        URLConnection con = obj.openConnection();

        InputStream in = con.getInputStream();
        Scanner scanner = new Scanner(in);

        return gson.fromJson(scanner.nextLine(), Kursik.class);
    }

    private static String getAdresikDoDaty(Pieniadze wszystkiePieniadze, LocalDate doJakiejDatyLecimy) {

        return "http://api.nbp.pl/api/exchangerates/rates/c/"
                + wszystkiePieniadze.toString().toLowerCase()
                + "/" + doJakiejDatyLecimy + "/?format=json";
    }

}