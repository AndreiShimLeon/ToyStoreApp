package model;

import model.Exceptions.EmptyResultFileException;

import java.io.*;
import java.time.LocalDate;

public class Exporter {
    public void saveToFile(String results) throws RuntimeException {
        LocalDate logTime = LocalDate.now();
        try (FileWriter fw = new FileWriter("winners.csv", true)) {
            fw.write("Розыгрыш от " + logTime.toString() + '\n');
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

    public String loadFile() throws RuntimeException, EmptyResultFileException {
        String result = "";
        boolean emptyFlag = true;
        try (BufferedReader br = new BufferedReader(new FileReader("winners.csv"))) {
            while (br.ready()) {
                String line = br.readLine();
                if(!line.isBlank()) emptyFlag = false;
                result += line + '\n';
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(emptyFlag) throw new EmptyResultFileException();
        return result;
    }
}
