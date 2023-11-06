package model;

import model.Exceptions.DrawResultIsEmpty;
import model.Exceptions.NotEnoughToys;
import model.Exceptions.WrongIDException;

public class Controller<T extends Toy> {
    private Inventory<T> inventory;
    private Exporter exporter;
    private ToyDrawing<T> drawing;

    public Controller(Inventory<T> inventory) {
        this.inventory = inventory;
        this.exporter = new Exporter();
    }

    public Controller() {
        this.exporter = new Exporter();
        this.inventory = new Inventory<>();
    }

    public void addToy(int id, int chance, String name) {
        this.inventory.putToy((T) new Toy(id, name, chance));
    }

    public T draw() throws NotEnoughToys {
        if (this.drawing == null) {
            this.drawing = new ToyDrawing<>(inventory.getToys());
        }
        this.drawing.setDrawing();
        return drawing.getToy();
    }

    public String showInventory() {
        if (inventory.toString().isBlank()) return null;
        return inventory.toString();
    }

    public boolean clearInventory() {
        if (inventory.toString().isBlank()) return false;
        inventory.clear();
        return true;
    }

    public boolean toyInInventory(int id) {
        return inventory.contains(id);
    }

    public void correctToy(int correctID, String correctName, int correctChance) throws WrongIDException {
        inventory.correctToy(correctID, (T) new Toy(correctID, correctName, correctChance));
    }

    public String showResults() throws DrawResultIsEmpty {
        if (drawing == null || drawing.getResults() == null) throw new DrawResultIsEmpty();
        return drawing.getResults();
    }

    public void saveResults() throws DrawResultIsEmpty {
        if (drawing == null || drawing.getResults().isBlank()) throw new DrawResultIsEmpty();
        exporter.saveToFile(drawing.getResults());
        drawing.clearResults();
    }

    public void deleteResults() throws DrawResultIsEmpty {
        if (drawing == null || drawing.getResults().isBlank()) throw new DrawResultIsEmpty();
        drawing.clearResults();
    }

    public void clearFile() {
        exporter.clearFile();
    }
}
