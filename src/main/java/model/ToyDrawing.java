package model;

import model.Exceptions.NotEnoughToys;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyDrawing<T extends Toy> {
    private PriorityQueue<T> drawQueue;
    private ArrayList<T> inventory;

    private String results;

    public String getResults() {
        return results;
    }

    public void setResults(T winnerToy) {
        if (results == null) {
            this.results = winnerToy.getName() + '\n';
        } else {
            this.results += winnerToy.getName() + '\n';
        }
    }

    public ToyDrawing(ArrayList<T> inventory) {
        this.drawQueue = new PriorityQueue<>();
        this.inventory = inventory;
    }

    public ToyDrawing() {
        this.drawQueue = new PriorityQueue<>();
        this.inventory = new ArrayList<>();
    }

    /**
     * Метод заполняет очередь игрушками с вероятностью 'chance' у игрушки,
     * Таким образом, очередь может быть как пустой, так и полностью заполненной.
     * Если очередь пустая, метод перезапускается.
     */
    public void setDrawing() throws NotEnoughToys {
        if(inventory.size()<3) throw new NotEnoughToys();
        int totalChance = 0;
        int lowerDrawLimit = 0;
        int upperDrawLimit = lowerDrawLimit;
        Random random = new Random();
        for (T toy : this.inventory
        ) {
            totalChance += toy.getChance();
        }
        for (T toy : this.inventory
        ) {
            upperDrawLimit = lowerDrawLimit + toy.getChance();
            int draw = random.nextInt(totalChance);
            if (draw >= lowerDrawLimit && draw < upperDrawLimit) {
                this.drawQueue.add(toy);
            }
            lowerDrawLimit = upperDrawLimit;

        }
        if (drawQueue.isEmpty()) {
            setDrawing();
        }

    }

    /**
     * Метод возвращает имя Игрушки из очереди.
     * Возвращается игрушка с наибольшим весом chance.
     * После происходит очистка очереди.
     *
     * @return возвращает имя Игрушки из очереди
     */
    public String getToyName() {
        String result = drawQueue.poll().getName();
        drawQueue.clear();
        return result;
    }

    /**
     * Метод возвращает имя Игрушки из очереди.
     * Возвращается игрушка с наибольшим весом chance.
     * После происходит очистка очереди.
     *
     * @return возвращает имя Игрушки из очереди
     */
    public T getToy() {
        T result = drawQueue.poll();
        drawQueue.clear();
        setResults(result);
        return result;
    }
    public void clearResults() {
        this.results = null;
    }

    public static void main(String[] args) {

        Toy first = new Toy(1, "Robot", 30);
        Toy second = new Toy(2, "Car", 20);
        Toy third = new Toy(3, "Kitten", 50);
        Inventory<Toy> inventory = new Inventory<>();
        inventory.putToy(first);
        inventory.putToy(second);
        inventory.putToy(third);

        ToyDrawing<Toy> d = new ToyDrawing<>(inventory.getToys());
        try {
            d.setDrawing();
        } catch (NotEnoughToys e) {
            throw new RuntimeException(e);
        }
        System.out.println(d.drawQueue.poll().getName());

        try (FileWriter fw = new FileWriter("test.txt")) {
            for (int i = 0; i < 100; i++) {
                d.setDrawing();
                String queue = "";
                for (Toy toy : d.drawQueue
                ) {
                    queue += toy.getName() + ":" + toy.getChance() + " ";

                }
                String result = d.getToyName();
                fw.write(result + " in queue: " + queue + '\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
