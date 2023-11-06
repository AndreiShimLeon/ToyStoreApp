package model;

import java.io.*;

public class Exporter {
    public void saveToFile(String results) throws RuntimeException {
        try (FileWriter fw = new FileWriter("winners.csv", true)) {
            fw.write(results + '\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile() throws RuntimeException {
        try (FileWriter fw = new FileWriter("winners.csv")) {
            fw.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String loadFile() throws RuntimeException{
        String result = "";
        try(BufferedReader br = new BufferedReader(new FileReader("winners.csv"))){
            while (br.ready()){
                result += br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
