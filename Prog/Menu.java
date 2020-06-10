package Software.Prog;

import java.util.Scanner;

public class Menu {
       public Menu() {
       }

       /**
        * @throws Exceptions
        */
       public static void onStart() throws Exceptions {
              Scanner in = new Scanner(System.in);
              int key;
              do {
                     System.out.println("1. quadratic equation");
                     System.out.println("2. calculate smth");
                     key = in.nextInt();
                     switch (key) {
                            case 1:
                                   quadraticEquation(in);
                                   break;
                            case 2:
                                   while (true) {
                                          String string = "";
                                          string = in.nextLine();
                                          if (string.equals("exit")) {
                                                 break;
                                          }
                                          DataBase database = new DataBase(string);
                                          database.calculate();
                                          System.out.println(database.toString());
                                   }
                                   break;
                            default:
                                   break;
                     }
              } while (key == 2 || key == 1);

              in.close();
       }

       /**
        * @param in
        * @throws Exceptions
        */
       public static void quadraticEquation(Scanner in) throws Exceptions {
              System.out.println("a = ");
              double a = setNumber(in);
              System.out.println("b = ");
              double b = setNumber(in);
              System.out.println("c = ");
              double c = setNumber(in);
              double result[] = new double[2];
              result = Calculator.quadraticEquation(a, b, c);
              printResultQuadraticEquation(result);
       }

       /**
        * @param in
        * @return double
        */
       public static double setNumber(Scanner in) {
              System.out.print("Enter a number: ");
              double number = in.nextDouble();
              return number;
       }

       /**
        * @param result
        */
       public static void printResultQuadraticEquation(double[] result) {
              if (result[0] == result[1]) {
                     System.out.println("x = " + result[0]);
              } else {
                     System.out.println("x1 = " + result[0]);
                     System.out.println("x2 = " + result[1]);
              }
       }

}
