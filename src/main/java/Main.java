import model.Controller;
import model.Exceptions.WrongIDException;
import model.Exporter;
import presenter.Presenter;
import view.View;

public class Main {
    public static void main(String[] args) {
        Presenter presenter = new Presenter(new View(), new Controller<>(), new Exporter<>());
        try {
            presenter.start();
        } catch (WrongIDException e) {
            throw new RuntimeException(e);
        }

    }
}