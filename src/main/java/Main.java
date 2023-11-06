import model.Controller;
import model.Exceptions.*;
import presenter.Presenter;
import view.View;

public class Main {
    public static void main(String[] args) {
        Presenter presenter = new Presenter(new View(), new Controller<>());
        try {
            presenter.start();
        } catch (WrongIDException e) {
            throw new RuntimeException(e);
        } catch (DrawResultIsEmpty e) {
            throw new RuntimeException(e);
        } catch (NotEnoughToys e) {
            throw new RuntimeException(e);
        } catch (ToyAlreadyInTheList e) {
            throw new RuntimeException(e);
        } catch (IncorrectInput e) {
            throw new RuntimeException(e);
        }

    }
}