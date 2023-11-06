package model.Exceptions;

import java.io.IOException;

public class IdAlreadyExists extends IOException {
    @Override
    public String getMessage() {
        return "Игрушка с таким ID уже есть в списке.";
    }
}
