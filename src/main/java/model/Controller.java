package model;

import model.Exceptions.WrongIDException;

public class Controller<T extends Toy> {
    private Inventory<T> inventory;
    private ToyDrawing<T> drawing;

    public Controller(Inventory<T> inventory) {
        this.inventory = inventory;
    }

    public Controller() {
        this.inventory = new Inventory<>();
    }

    public void addToy(int id, int chance, String name){
        this.inventory.putToy((T) new Toy(id, name, chance));
    }

    public T draw(){
        this.drawing = new ToyDrawing<>(inventory.getToys());
        this.drawing.setDrawing();
        return drawing.getToy();
    }

    public String showInventory(){
        return inventory.toString();
    }

    public void clearInventory(){
        inventory.clear();
    }

    public void correctToy(int correctID, String correctName, int correctChance) throws WrongIDException {
        inventory.correctToy(correctID, (T) new Toy(correctID,correctName,correctChance));
    }
}
