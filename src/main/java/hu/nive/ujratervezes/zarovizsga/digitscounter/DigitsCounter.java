package hu.nive.ujratervezes.zarovizsga.digitscounter;

//A DigitsCounter osztálynak legyen egy int getCountOfDigits(String s) metódusa,
// mely megszámolja, hogy hány különböző számjegy van a bemeneti Stringben.

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null || s == "") return 0;

        String[] arrayOfStrings = s.split("");
        Set<String> setOfDigits = new HashSet<>();

        for (String element : arrayOfStrings) {
            if (isNumeric(element)) {
                setOfDigits.add(element);
            }
        }
        return setOfDigits.size();
    }

    //segédmetódus annak eldöntésére, hogy egy String szám-e:

    private static boolean isNumeric(String inputString) {
        //Jelen esetben fölösleges az ellenőrzés:
        //if (inputString == null || inputString.length() == 0) return false;

        //ha sikerül a parse-olás, számjegy volt az input, egyébként nem:
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

}
