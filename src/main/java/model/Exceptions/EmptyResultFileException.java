package model.Exceptions;

import java.io.IOException;

public class EmptyResultFileException extends IOException {
    @Override
    public String getMessage() {
        return "Файл с результатами пуст.";
    }
}
