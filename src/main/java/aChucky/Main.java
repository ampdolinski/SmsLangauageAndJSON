package aChucky;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();

        zarcik(gson);


    }

    private static void zarcik(Gson gson) throws IOException {
        URL obj = new URL("https://api.chucknorris.io/jokes/random");
        URLConnection con = obj.openConnection();


        InputStream in = con.getInputStream();
        Scanner scanner = new Scanner(in);

        Joke zarcik = gson.fromJson(scanner.nextLine(), Joke.class);

        System.out.println(zarcik.value);
    }
}
