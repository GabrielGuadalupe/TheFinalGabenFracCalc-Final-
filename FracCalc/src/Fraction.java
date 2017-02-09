
public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(String input) {
        //Separates whole number and fraction to be dealt with
        if (input.contains("_") && input.contains("/")) {
            String[] mixedFractionSplit = input.split("_");
            String sWholeNumber = mixedFractionSplit[0];
            String restOfNumber = mixedFractionSplit[1];

            String[] fracNumberSep = restOfNumber.split("/");

            String sNumerator = fracNumberSep[0];
            String sDenominator = fracNumberSep[1];

            int wholeNumber = Integer.parseInt(sWholeNumber);

            //Makes num and denom into ints
            numerator = Integer.parseInt(sNumerator);
            denominator = Integer.parseInt(sDenominator);

            numerator = wholeNumber * denominator + numerator;
        }

        //Separates fraction into String Numerator and String Denominator. s stands for String
        else if (input.contains("/")) {
            String[] fractionSplit = input.split("/");
            String sNumerator = fractionSplit[0];
            String sDenominator = fractionSplit[1];

            numerator = Integer.parseInt(sNumerator);
            denominator = Integer.parseInt(sDenominator);

        } else {
            numerator = Integer.parseInt(input);
            denominator = 1;

        }

    }

    //Getters to use instead of breaking up the fraction every time you need the numerator or the denominator
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    //The most awesome simplify method created by Ben
    public static String simplify(Fraction answer) {
        int num = answer.getNumerator();
        int den = answer.getDenominator();
        int simplifyFactor = 2;

        while (simplifyFactor < 1000) {

            //Finds a common factor that goes into num and den
            if (num % simplifyFactor == 0 && den % simplifyFactor == 0) {

                //Divides by the common factor
                num = num / simplifyFactor;
                den = den / simplifyFactor;

            } else {
                simplifyFactor++;
            }

            int wholeNum = num / den;
            num = num % den;

            if (wholeNum == 0 && den > 1) {

                //Doesn't print out a whole number and makes sure fraction isn't /1
                return num + "/" + den;
                //Makes the fraction into a whole number if the denominator is 1 and the whole number is greater than 0
            } else if (wholeNum > 0 && den == 1) {
                return Integer.toString(wholeNum + num);
                //If the numerator is 0 it just prints out the wholenumber, this may be repetitive, but we're running up on our final deadline
            } else if (num == 0) {
                return Integer.toString(wholeNum);

            } else {

                //Math.abs prevents a negative in numerator and in whole number
                return wholeNum + "_" + Math.abs(num) + "/" + den;
            }

        } return num + "/" + den;
    }
}



