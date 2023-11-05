package model;

public class Toy implements Comparable<Toy>{
    private int id;
    private String name;
    private int chance;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public Toy(int id, String name, int chance) {
        this.id = id;
        this.name = name;
        this.chance = chance;
    }

    @Override
    public int compareTo(Toy o) {
        return o.chance-this.chance;
    }
}
