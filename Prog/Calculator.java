package Software.Prog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Calculator 
{
    

    /**
     * @param num1
     * @param num2
     * @param operation
     * @return Integer
     * @throws Exception
     */
    public static double calculate(double num1, double num2, char operation) throws Exceptions
    {
        
        double result;
        switch (operation) 
        {
            case '+':
                result = num1 + num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '/':
                if (num2 == 0)
                {
                    throw new Exceptions("Denominator is incorrect");
                }
                result = num1 / num2;
                break;
            default:
            throw new Exceptions("Wrong operation");
        }
        return result;
    }
    
    
    /** 
     * @param num1
     * @param num2
     * @return double
     * @throws Exceptions
     */
    public static double pow(double num1, double num2) throws Exceptions 
    {
        
        double result = Math.pow(num1, num2);
        
        return result;
    }
    
    
    
    /** 
     * @throws Exceptions
     */
    @Test
    public void test() throws Exceptions
    {
        assertEquals(25, calculate(5, 5, '*'));
        assertEquals(25, pow(5, 2));
    }

}