package model.Exceptions;

import java.io.IOException;

public class DrawResultIsEmpty extends IOException {
    @Override
    public String getMessage() {
        return "Результатов розыгрыша пока нет.";
    }
}
