import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private List<Adventurer> adventurers;

    Guild(){
        name = "";
    }

    //getter and setter for name
    public void setName(String s){
        if(!s.equals("") && !s.equals(name)){
            name = s;
        }
    }

    public String getName(){
        return name;
    }

    //getter and setter for adventurers
    public List<Adventurer> getAdventurers(){
        return adventurers;
    }

    public void setAdventurers(ArrayList<Adventurer> adventurers){
        this.adventurers = adventurers;
    }

    public String toString(){
        String s;
        s = "Name: " + getName() + " Adventurers: " + getAdventurers();
        return s;
    }
}
