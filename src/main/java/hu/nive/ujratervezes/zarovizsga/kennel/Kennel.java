package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kennel {

    private List<Dog> dogs;


    public Kennel() {
        this.dogs = new ArrayList<>();
    }

    //hozzáaad egy kutyát
    public void addDog(Dog dog) {
        this.dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return this.dogs;
    }

    //összes kutya feed() metódusát meghívja
    public void feedAll() {
        for (Dog dog: this.dogs) {
            dog.feed();
        }
    }

    //kikeresi a kutyát név alapján, kivételt dob, ha nem találja
    public Dog findByName(String inputDogName) {
        for (Dog dog: this.dogs){
            if (dog.getName().equals(inputDogName)) return dog;
        }
        throw new IllegalArgumentException("No dog was found.");
    }

    //a paraméterként megadott kutyát kikeresi, és meghívja a play() metódusát az átadott hours paraméterrel
    public void playWith(String inputDogName, int hoursToPlay) {
        for (Dog dog: this.dogs) {
            if (dog.getName().equals(inputDogName)) {
                dog.play(hoursToPlay);
            }
        }
    }

    //visszaadja azon kutyák neveit, melyeknek boldogsága nagyobb, mint a paraméterként átadott érték
    public List<String> getHappyDogNames(int thresholdHappiness) {
        List<String> happyDogsNames = new ArrayList<>();

        for (Dog dog: this.dogs){
            if (dog.getHappiness()>thresholdHappiness) {
                happyDogsNames.add(dog.getName());
            }
        }

        //teszt abc sorrendben teszteli
        happyDogsNames.sort(Comparator.naturalOrder());
        return happyDogsNames;
    }
}
