import java.util.List;

public class Adventurer {
    private String name;
    private int age;
    private String role;
    double goldEarned;
    private List<Skill> skills;

    Adventurer(){
        name = "";
        age = 0;
        role = "";
        goldEarned = 0.0;
    }

    //getter and setter for name
    public void setName(String n){
        if(!n.equals("") && !n.equals(name)){
            name = n;
        }
    }

    public String getName(){
        return name;
    }

    //getter and setter for age
    public void setAge(int a){
        if(a != age && a > 0){
            age = a;
        }
    }

    public int getAge(){
        return age;
    }

    //getter and setter for role
    public void setRole(String r){
        if(r.equalsIgnoreCase("warrior") || r.equalsIgnoreCase("wizard") ||
        r.equalsIgnoreCase("rogue")){
            role = r;
        }
        else{
            System.out.println("There was an error assigning the role");
        }
    }

    public String getRole(){
        return role;
    }

    //getter and setter for goldEarned
    public void setGoldEarned(double g){
        if(g >= 0){
            goldEarned = 0;
        }
    }

    public double getGoldEarned(){
        return goldEarned;
    }

    //getter and setter for skills
    public void setSkills(List<Skill> skills){
        this.skills = skills;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public String toString(){
        String s = "";
        s = "Name: " + getName() + " Age: " + getAge() + " Roles: " + getRole()
                + " Gold Earned: " + getGoldEarned() + " Skills: " + getSkills();

        return s;
    }

}
