package model.Exceptions;

import java.io.IOException;

public class WrongIDException extends IOException {
    @Override
    public String getMessage() {
        return "Игрушки с таким ID не найдено.";
    }
}
