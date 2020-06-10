package Software.Prog;

public class DataType {
    public DataType() {
    }

    public DataType(String string) {
        this.string = string;
        if ((this.string.equals("cos")) || (this.string == "sin") || (this.string == "tan")
                || (this.string == "ctan")) {
            flag = "trigonometricFunction";
        } else {
            flag = "logarithm";
        }
    }

    public DataType(char character) {
        this.character = character;
        if (character == '+' || character == '-' || character == '*' || character == '/') {
            flag = "arithmeticOperation";
        } else if (character == '!') {
            flag = "factorial";
        } else {
            flag = "pow";
        }
    }

    public DataType(double number) {
        this.number = number;
        flag = "number";
    }

    
    /** 
     * @param number
     */
    public void setNumber(double number) {
        this.number = number;
        flag = "number";
        string = "";
        character = '\0';
    }

    /**
     * @return String
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @return double
     */
    public double getNumber() {
        return number;
    }

    /**
     * @return String
     */
    public String getString() {
        return string;
    }

    /**
     * @return char
     */
    public char getCharacter() {
        return character;
    }

    /**
     * @return String
     */
    public String toString() {
        if (flag == "pow" || flag == "factorial") {
            return String.valueOf(character);
        } else if (flag == "number") {
            return String.valueOf(number);
        } else {
            return string;
        }
    }

    private String flag;
    private double number;
    private String string;
    private char character;
}