package model;

import model.Exceptions.IdAlreadyExists;
import model.Exceptions.ToyAlreadyInTheList;
import model.Exceptions.WrongIDException;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory<T extends Toy> {
    private HashMap<Integer, T> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public void putToy(T toy) throws ToyAlreadyInTheList, IdAlreadyExists {
        if (inventory.containsKey(toy.getId())) throw new IdAlreadyExists();
        for (int key :  inventory.keySet()
             ) {
            if(inventory.get(key).getName().equals(toy.getName())) throw new ToyAlreadyInTheList();
        }
        this.inventory.put(toy.getId(), toy);
    }

    public ArrayList<T> getToys() {
        ArrayList<T> result = new ArrayList<>();
        for (int id : inventory.keySet()) {
            result.add(inventory.get(id));
        }
        return result;
    }

    public boolean contains(int id) {
        return inventory.containsKey(id);
    }

    @Override
    public String toString() {
        String result = "";
        for (T toy : inventory.values()
        ) {
            result += "[" + toy.getId() + "] " +
                    toy.getName() +
                    ", шанс выпадения " + toy.getChance() +
                    '\n';
        }
        return result;
    }

    public void clear() {
        this.inventory.clear();
    }

    public void correctToy(int correctID, T toy) throws WrongIDException {
        if (inventory.containsKey(correctID)) {
            inventory.replace(correctID, toy);
        } else throw new WrongIDException();
    }
}
