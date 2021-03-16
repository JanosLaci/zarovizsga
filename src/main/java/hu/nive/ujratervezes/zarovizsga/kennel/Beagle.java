package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    private String name;
    private int happiness;

    public Beagle(String name) {
        this.name = name;
        this.happiness=0;
    }

    void feed(){
        this.happiness += 2;
    }
    void play(int hours){
        this.happiness += 2 * hours;
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
