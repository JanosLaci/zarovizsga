package hu.nive.ujratervezes.zarovizsga.workhours;

/*
A WorkHours osztályban implementáld a String minWork(String file) metódust!
A metódus paraméterként megkapja egy fájl elérési útvonalát.
A tesztesetben ez a
src/test/resources/hu/nive/ujratervezes/zarovizsga/workhours/workhours.txt
, így ebbe a könyvtárba tedd a fájlt!
A fájl formátuma:

John Doe,8,2021-01-01
Jack Doe,7,2021-01-02
Jack Doe,8,2021-01-03
John Doe,2,2021-01-04
John Doe,8,2021-01-05
John Doe,7,2021-01-06
A dolgozó neve, mennyi órát dolgozott egy nap, és a nap.
Azt kell visszaadni, hogy ki melyik nap dolgozott a legkevesebbet.
 A fenti fájl alapján John Doe 2021-01-04-én csak 2 órát dolgozott,
 így a következő Stringet kell visszaadni:
 John Doe: 2021-01-04.
 Egy napra, egy alkalmazotthoz mindig csak egy sor van.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkHours {

    public static String minWork(String file) {
        List<String> listOfNames = new ArrayList<>();
        List<Integer> listOfHours = new ArrayList<>();
        List<String> listOfDateStrings = new ArrayList<>();
        int minHour = 0;
        int indexOfLaziest = 0;

        try {
            List<String> lines = Files.readAllLines(Path.of(file));


            for (String line : lines) {
                String[] stringArrayFromLine = line.split(",");

                System.out.println(stringArrayFromLine[0]);
                System.out.println(stringArrayFromLine[1]);
                System.out.println(stringArrayFromLine[2]);

                listOfNames.add(stringArrayFromLine[0]);
                listOfHours.add(Integer.parseInt(stringArrayFromLine[1]));
                listOfDateStrings.add(stringArrayFromLine[2]);
            }

            //a legkisebb óra megkeresése (csak akkor egyértelmű, ha egyetlen ilyen legkisebb van)

            minHour = Collections.min(listOfHours);

            //a legkisebb órához tartozó index megkeresése (csak akkor egyértelmű, ha egyetlen ilyen legkisebb van)

            indexOfLaziest = listOfHours.indexOf(minHour);

        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read the file.");
        }

        return listOfNames.get(indexOfLaziest) + ": " + listOfDateStrings.get(indexOfLaziest);
    }

    /* kipróbálás main-ben
    public static void main(String[] args) {

        String result = minWork("src/test/resources/hu/nive/ujratervezes/zarovizsga/workhours/workhours.txt");
        System.out.println(result);

    }*/


}
