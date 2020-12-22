package unknow;

import java.util.Arrays;
import java.util.List;

public class IntToRoman {

    public String intToRoman(int num) {
        if (num < 1) {
            return "";
        }

        List<Integer> keys = Arrays.asList(1000,900,500,400,100,
                90,50,40,10,9,5,4,1);
        List<String> vals = Arrays.asList("M","CM","D","CD",
                "C","XC","L","XL","X","IX","V","IV","I");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < keys.size(); i++) {
            if (num < keys.get(i)) {
                continue;
            } else {
                while (num >= keys.get(i)) {
                    num -= keys.get(i);
                    result.append(vals.get(i));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntToRoman roman = new IntToRoman();
        System.out.println(roman.intToRoman(3));
        System.out.println(roman.intToRoman(4));
        System.out.println(roman.intToRoman(9));
        System.out.println(roman.intToRoman(58));
        System.out.println(roman.intToRoman(1994));
    }
}
