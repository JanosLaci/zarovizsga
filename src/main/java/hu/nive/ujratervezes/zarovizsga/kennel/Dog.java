package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {

    private String name;
    private int happiness;

    protected Dog() {
    }

    public Dog(String name) {
        this.name = name;
        this.happiness=0;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    void feed(){}
    void play(int hours){}

}
