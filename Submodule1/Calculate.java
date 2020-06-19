package Software.Submodule1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Calculate {


    /** 
     * @param num1
     * @param num2
     * @param operation
     * @return Integer
     * @throws denomException
     */
    public static Integer calculate(int num1, int num2, char operation) throws denomException 
    {

        int result;
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
                    throw new denomException("denominator is incorrect");
                }
                result = num1 / num2;
                break;
            default:
            System.out.println("Wrong operation");
            return null;
        }
        return result;
    }



    /** 
     * @throws denomException
     */
    @Test
    public void testResult() throws denomException
    {
        assertEquals(Integer.valueOf(25), calculate(5,5,'*'));
        assertEquals(Integer.valueOf(17), calculate(10,7,'+'));
    }

} 