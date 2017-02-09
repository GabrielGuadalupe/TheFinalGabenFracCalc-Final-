import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.println("Enter equation in ( 1_1/2 + 2/3 ) format or enter quit to close");

            //Check to see if user wants to continue
            if (userInput.hasNext("quit")) {
                done = true;
            } else {
                String fractionEquation = userInput.nextLine();
                fractionEquation = fractionEquation.trim();

                //Splits input into 3. The fractions and the operator
                String[] thirds = fractionEquation.split(" ");
                String number1 = thirds[0];
                String operator = thirds[1];
                String number2 = thirds[2];
                //Creates 2 fractions
                Fraction frac1 = new Fraction(number1);
                Fraction frac2 = new Fraction(number2);

                //uses our brand new getters to make some variables!
                int num1 = frac1.getNumerator();
                int num2 = frac2.getNumerator();
                int num3 = 0;

                int den1 = frac1.getDenominator();
                int den2 = frac2.getDenominator();
                int den3 = 0;

                //We condensed all of our operators into one simple script to alleviate repetition and minimize confusion
                if (operator.equals("+")) {
                    num3 = (num1 * den2) + (num2 * den1);
                    den3 = (den1 * den2);
                } else if (operator.equals("-")) {
                    num3 = (num1 * den2) - (num2 * den1);
                    den3 = (den1 * den2);
                } else if (operator.equals("*")) {
                    num3 = (num1 * num2);
                    den3 = (den1 * den2);
                } else {
                    num3 = (num1 * den2);
                    den3 = (num2 * den1);
                }
                //creates a new fraction called answer that contains the answer!!!!
                Fraction answer = new Fraction(num3 + "/" + den3);
                //Simplifies the answer and prints it out!!!!! YAYAYAYYAYAYAYYAAYYAYAYAYYAYAYAYYA
                String finalAnswer = answer.simplify(answer);
                System.out.println(finalAnswer);
            }
        }
    }
}