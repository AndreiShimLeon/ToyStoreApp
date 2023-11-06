package model.Exceptions;

import java.io.IOException;

public class WrongChoiceException extends IOException {
    @Override
    public String getMessage() {
        return "Неверный ввод, повторите выбор.";
    }
}
