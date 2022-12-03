package subway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> inputStringsWithComma() {
        try {
            InputStream in = System.in;
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(reader);

            return new ArrayList<>(Arrays.asList(
                    br.readLine().split(",")
            ));
        } catch (IOException e) {
            return null;
        }
    }

    public static String input() {
        try {
            InputStream in = System.in;
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(reader);
            String result = br.readLine();
            return result;
        } catch (IOException e) {
            return null;
        }
    }
}