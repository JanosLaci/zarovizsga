package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {

   private String name;
    private int happiness;

    public Husky(String name) {
        this.name=name;
        this.happiness=0;

    }

    void feed(){
        this.happiness += 4;
    }

    void play(int hours){
        this.happiness += 3 * hours;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHappiness() {
        return this.happiness;
    }
}
