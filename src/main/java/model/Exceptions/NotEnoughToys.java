package model.Exceptions;

import java.io.IOException;

public class NotEnoughToys extends IOException {
    @Override
    public String getMessage() {
        return "Недостаточно игрушек для розыгрыша.";
    }
}
