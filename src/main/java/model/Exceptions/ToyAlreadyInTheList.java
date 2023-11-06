package model.Exceptions;

import java.io.IOException;

public class ToyAlreadyInTheList extends IOException {
    @Override
    public String getMessage() {
        return "Игрушка уже добавлена в список.";
    }
}
