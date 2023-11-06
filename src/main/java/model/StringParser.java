package model;

import model.Exceptions.IncorrectInput;
public class StringParser {
    public Toy parseStringToToy(String toyInfo) throws IncorrectInput {
        String[] string  = toyInfo.split(" ");
        if (string.length != 3) throw new IncorrectInput();
        int id, chance;
        try{
            id = Integer.parseInt(string[0]);
            chance = Integer.parseInt(string[1]);
        } catch (NumberFormatException e){
            throw new IncorrectInput();
        }
        String name = string[2];
        for (char c: name.toCharArray()
             ) {
            if(!Character.isAlphabetic(c)) throw new IncorrectInput();
        }
        return new Toy(id,name,chance);
    }
}
