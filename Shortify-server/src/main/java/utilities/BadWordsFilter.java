package utilities;

import java.io.*;
import java.util.ArrayList;


/**
 * Contains functions needed to filter forbidden words
 * Created by Giuseppe Perniola on 16/03/2016.
 */
public class BadWordsFilter {

    private static final String filePath = "/Shortify-server/src/main/java/utilities/files/badwords_eng.txt";
    private static final ArrayList<String> badwords = new ArrayList<String>();

    /**
     * Loads the list of bad words from a text file.
     */
    static {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(System.getProperty("user.dir").replace("/target", "") + filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str;

        try {
            while((str = in.readLine()) != null){
                badwords.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Finds if a given word is forbidden.
     * @param word the word to find in the list of forbidden words.
     * @return true if the word is forbidden, false otherwise.
     */
    public static boolean isBadword(String word){
        for (String badword : badwords){
            if (word.contains(badword))
                return true;
        }
        return false;
    }
}
