package model.Exceptions;

import java.io.IOException;

public class IncorrectInput extends IOException {
    @Override
    public String getMessage() {
        return "Неверный ввод информации об игрушке. ";
    }
}
