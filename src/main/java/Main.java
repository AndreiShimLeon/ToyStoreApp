import model.Controller;
import model.Exceptions.*;
import presenter.Presenter;
import view.View;

public class Main {
    public static void main(String[] args) {
        Presenter presenter = new Presenter(new View(), new Controller<>());
        presenter.start();


    }
}