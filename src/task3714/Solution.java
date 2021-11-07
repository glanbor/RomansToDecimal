package task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));

    }

    public enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);
        private int number;

        Roman(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

    public static int romanToInteger(String s) {
        int ourNumber = 0;
        int previousFigure = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            String st = String.valueOf(c);
            for (Roman e : Roman.values()) {
                if (st.equals(e.name())) {
                    if (e.getNumber() >= previousFigure) {
                        ourNumber += e.getNumber();
                    } else {
                        ourNumber -= e.getNumber();
                    }
                    previousFigure = e.getNumber();
                    break;
                }
            }
        }
        return ourNumber;
    }
}
