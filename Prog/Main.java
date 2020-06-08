package Software.Prog;

public class Main {

    /**
     * @param args
     * @throws Exceptions
     */
    public static void main(String[] args) throws Exceptions {
        try {
            Menu.onStart();
        } catch (Exception e) {
            System.err.print(e);
        }

    }

}
