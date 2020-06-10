package Software.Prog;

import java.util.ArrayList;

public class Parser {

    /**
     * @param string
     * @return boolean
     */
    public static boolean tryParseDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param string
     * @return boolean
     */
    public static boolean tryParseChar(String string) {
        if (string.length() == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param string
     * @return char
     */
    public static char parseChar(String string) {
        char[] c = string.toCharArray();
        return c[0];
    }

    /**
     * @param string
     * @return DataType
     */
    public static DataType parseDataType(String string) {
        if (Parser.tryParseDouble(string)) {
            return new DataType(Double.parseDouble(string));
        } else if (Parser.tryParseChar(string)) {
            return new DataType(parseChar(string));
        } else {
            return new DataType(string);
        }
    }

    /**
     * @param string[]
     * @return ArrayList<DataType>
     */
    public static ArrayList<DataType> parseString(char string[]) {
        ArrayList<DataType> array = new ArrayList<>();
        String data = "";
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                if (data.length() > 0) {
                    array.add(parseDataType(data));
                    data = "";
                }
            } else {
                data = data + String.valueOf(string[i]);
            }
        }
        if (data.length() > 0) {
            array.add(parseDataType(data));
        }
        return array;
    }
}