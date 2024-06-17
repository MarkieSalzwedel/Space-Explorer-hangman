import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadWordFile {

    private List<String> wordList; //stores words

    //constructor
    public ReadWordFile(){
        this.wordList = new ArrayList<>();
    }

    //reading file
    public void readFile(InputStream inputStream){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //shuffle word list, THEN get random word
    public String chooseRandWord(){
        //check if list is empty
        if (wordList.isEmpty()){
            return null;
        }
        //shuffle! and return first
        Collections.shuffle(wordList);
        return wordList.get(0);
    }

}
