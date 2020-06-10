package Software.Prog;

import java.util.ArrayList;

public class DataBase {

    public DataBase(String string) {
        char charArray[] = string.toCharArray();
        array = Parser.parseString(charArray);
    }
    
    /**
     * @return String
     */
    public String toString() {
        String string = "";
        for (DataType data : array) {
            string = string + data.toString() + "      ";
        }
        return string;
    }

    /**
     * @throws Exceptions
     */
    public void calculate() throws Exceptions {
        this.functions();
        this.factorialAndPow();
        this.arithmetics();

    }

    /**
     * @throws Exceptions
     */
    public void arithmetics() throws Exceptions {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCharacter() == '*' || array.get(i).getCharacter() == '/') {
                array.set(i - 1, Calculator.arithmetics(array.get(i - 1).getNumber(), array.get(i + 1).getNumber(),
                        array.get(i).getCharacter()));
                array.remove(i + 1);
                array.remove(i);
                i--;
            }
        }

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCharacter() == '-' || array.get(i).getCharacter() == '+') {
                array.set(i - 1, Calculator.arithmetics(array.get(i - 1).getNumber(), array.get(i + 1).getNumber(),
                        array.get(i).getCharacter()));
                array.remove(i + 1);
                array.remove(i);
                i--;
            }
        }
    }

    /**
     * @throws Exceptions
     */
    public void factorialAndPow() throws Exceptions {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCharacter() == '!') {
                array.set(i - 1, Calculator.factorial(array.get(i - 1).getNumber()));
                array.remove(i);
            } else if (array.get(i).getCharacter() == '^') {
                array.set(i - 1, Calculator.pow(array.get(i - 1).getNumber(), array.get(i + 1).getNumber()));
                array.remove(i + 1);
                array.remove(i);
                i--;
            }
        }
    }

    /**
     * @throws Exceptions
     */
    public void functions() throws Exceptions {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getFlag() == "trigonometricFunction") {
                array.set(i, Calculator.trigonometry(array.get(i + 1).getNumber(), array.get(i).getString()));
                array.remove(i + 1);
            } else if (array.get(i).getFlag() == "logarithm") {
                array.set(i, Calculator.logarithm(array.get(i + 1).getNumber(), array.get(i + 2).getNumber()));
                array.remove(i + 2);
                array.remove(i + 1);
                i--;
            }
        }
    }

    private ArrayList<DataType> array = new ArrayList<>();
}