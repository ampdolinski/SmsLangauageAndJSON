package _02_Jezyk;


import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, APIError {

        DetectLanguage.apiKey = "488c5b1abf902e22f5a2f46cf6e5ad44";

// Enable secure mode (SSL) if passing sensitive information
// DetectLanguage.ssl = true;

        File folder = new File("src/main/resources/");
        File[] files = folder.listFiles();

        for (File file : files) {
//            String language = detectLanguageFromFile(file);
//            System.out.println("Plik " + file.getName() + " ma język " + language);
        }

    }

    private static void detectLanguageFromFile(File file) throws APIError, IOException {
        System.out.println(file.exists());
        Scanner scanner = new Scanner(file);

        String calyTekst = "";
        while (scanner.hasNextLine()) {
            String linia = scanner.nextLine();
            calyTekst += linia;
        }


//        File file = new File("src/main/resources/chunichi.txt");

        String tekscik = "";
        BufferedReader fileReader = null;

        try {
            fileReader = new BufferedReader(new FileReader(file));
            String linijkiTekstu = fileReader.readLine();
            tekscik = linijkiTekstu;
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        List<Result> results = DetectLanguage.detect(tekscik);

        Result result = results.get(0);

        System.out.println("Language: " + Locale.forLanguageTag(result.language).getDisplayLanguage(Locale.ENGLISH));
        System.out.println("Is reliable: " + result.isReliable);
        System.out.println("Confidence: " + result.confidence);
    }
}
