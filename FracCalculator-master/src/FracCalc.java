/**
* The FracCalc program recieves fraction operations and calculates it, then it returns 
* the correct result
* @author  Sungmin Lee
* @version final (?)
* @since   2022-12-02 
*/




import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"

    /**
     * produceAnswer calculates the input operations
     * @param input operations with mixed, improper, and whole number fractions
     * @return the solutions for the checkpoints ( the solved operations)
     */
    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input
        Scanner scan = new Scanner(input);
        // splits the given input
        scan.useDelimiter(" ");
        // sets first Fraction
        String firstFraction = (scan.next());
        // sets operator
        String operator = (scan.next());
        // sets second Fraction
        String secondFraction = (scan.next());

        //Checkpoint 1
        //return (secondFraction);

        //Checkpoint 2
        //return("whole:"+findWhole(secondFraction)+" numerator:"+findNumerator(secondFraction)+" denominator:"+findDenominator(secondFraction));


        // Sets all the important variables
        int firstFractionWhole = Integer.parseInt(findWhole(firstFraction));
        int firstFractionNumerator = Integer.parseInt(findNumerator(firstFraction));
        int firstFractionDenominator = Integer.parseInt(findDenominator(firstFraction));
        int secondFractionWhole = Integer.parseInt(findWhole(secondFraction));
        int secondFractionNumerator = Integer.parseInt(findNumerator(secondFraction));
        int secondFractionDenominator = Integer.parseInt(findDenominator(secondFraction));
        String finalNumber = "";
/*
        //checkpoint 3
        if (operator.equals("+")) {
            //addition
            finalNumber = (((secondFractionDenominator * firstFractionNumerator)+( firstFractionDenominator * secondFractionNumerator)+(firstFractionWhole+secondFractionWhole)*(firstFractionDenominator*secondFractionDenominator))+"/"+(firstFractionDenominator*secondFractionDenominator));
        } else if (operator.equals("-")) {
            //subtraction
            finalNumber =(((secondFractionDenominator * firstFractionNumerator)-( firstFractionDenominator * secondFractionNumerator)+(firstFractionWhole-secondFractionWhole)*(firstFractionDenominator*secondFractionDenominator))+"/"+(firstFractionDenominator*secondFractionDenominator));
        } else if (operator.equals("*")) {
            finalNumber = ((((firstFractionWhole * firstFractionDenominator) + (firstFractionNumerator)) * ((secondFractionWhole * secondFractionDenominator) + (secondFractionNumerator))) + "/" + (firstFractionDenominator * secondFractionDenominator));
        } else if (operator.equals("/")) {
            //division
            finalNumber = (((firstFractionWhole * firstFractionDenominator) + (firstFractionNumerator)) * (secondFractionDenominator) + "/" + (firstFractionDenominator) * ((secondFractionWhole * secondFractionDenominator) + secondFractionNumerator));
        }
        return finalNumber;
    }
*/

        ///*


        // Final

        // when the operation is addition
        if (operator.equals("+")) {
            //addition

            // Calculates the operations and sets its numerator and denominator values
            int numerator = ((secondFractionDenominator * firstFractionNumerator)+( firstFractionDenominator * secondFractionNumerator)+(firstFractionWhole+secondFractionWhole)*(firstFractionDenominator*secondFractionDenominator));
            int denominator = (firstFractionDenominator*secondFractionDenominator);

            //Simplifying the fraction
            // Ex: "20/-1 -> -20" or "17/4 -> 4_1/4"

            //if the denominator is 1 the finalNumber is numerator
            if (denominator == 1) {
                finalNumber = ("" + numerator);
            //if the denominator is -1 the finalNumber is the (-1) times the numerator
            }else if(denominator == -1) {
                finalNumber = ("-" + numerator);
            //checks if the fraction is an improper fraction
            }else if (Math.abs(numerator % denominator) > 0 && Math.abs(numerator/denominator) >0){
                for (int k = 0; k < 10; k++) {
                    for (int i = 2; i < 11; i++) {
                        //checks if the numerator and denominator is divisible by values between 2 and 10 (the value i)
                        if ((numerator % i == 0) && (denominator % i == 0)) {
                            //sets the numerator and denominator into the value divided by value i
                            numerator = numerator / i;
                            denominator = denominator / i;
                        }
                    }
                }
                // sets the whole value
                int whole = numerator/denominator;
                //checks if the whole value is negative and the numerator is also negative
                if ((whole + "").charAt(0) == '-' && ((numerator + "").charAt(0) == '-')){
                    // removes the negative in the numerator as it is already inside the whole value
                    numerator = numerator*(-1);
                }
                // sets the finalNumber
                finalNumber = (whole+"_"+numerator%denominator+"/"+denominator);
            }
            else {
                for (int k = 0; k < 10; k++) {
                    for (int i = 2; i < 11; i++) {
                        //checks if the numerator and denominator is divisible by values between 2 and 10 (the value i)
                        if ((numerator % i == 0) && (denominator % i == 0)) {
                            //sets the numerator and denominator into the value divided by value i
                            numerator = numerator / i;
                            denominator = denominator / i;
                        }
                    }
                }
                // checks if the numerator and denominator are the same number
                if (numerator/denominator==1){
                    // sets the finalNumber to 1
                    finalNumber = ""+1;
                }else {
                    // sets the finalNumber
                    finalNumber = (numerator + "/" + denominator);
                }
            }

        //When the operation is subtraction
        } else if (operator.equals("-")) {
            //subtraction

            // Calculates the operations and sets its numerator and denominator values
            int numerator = ((secondFractionDenominator * firstFractionNumerator) - (firstFractionDenominator * secondFractionNumerator) + (firstFractionWhole - secondFractionWhole) * (firstFractionDenominator * secondFractionDenominator));
            int denominator = (firstFractionDenominator*secondFractionDenominator);

            //Simplifying the fraction
            // Ex: "20/-1 -> -20" or "17/4 -> 4_1/4"

            //if the denominator is 1 the finalNumber is numerator
            if (denominator == 1) {
                finalNumber = ("" + numerator);
            //if the denominator is -1 the finalNumber is the (-1) times the numerator
            }else if(denominator == -1){
                finalNumber = ("-"+numerator);
            //if the numerator is 0, then the finalNumber is 0
            }else if (numerator == 0){
                finalNumber = (""+0);
            //checks if the fraction is an improper fraction
            }else if (Math.abs(numerator % denominator) > 0 && Math.abs(numerator/denominator) >0){
                for (int k = 0; k < 10; k++) {
                    for (int i = 2; i < 11; i++) {
                        //checks if the numerator and denominator is divisible by values between 2 and 10 (the value i)
                        if ((numerator % i == 0) && (denominator % i == 0)) {
                            //sets the numerator and denominator into the value divided by value i
                            numerator = numerator / i;
                            denominator = denominator / i;
                        }
                    }
                }
                // sets the whole value
                int whole = numerator/denominator;
                //checks if the whole value is negative and the numerator is also negative
                if ((whole + "").charAt(0) == '-' && ((numerator + "").charAt(0) == '-')){
                    // removes the negative in the numerator as it is already inside the whole value
                    numerator = numerator*(-1);
                }
                // sets the finalNumber
                finalNumber = (whole+"_"+numerator%denominator+"/"+denominator);
            }
            else {
                for (int k = 0; k < 10; k++) {
                    for (int i = 2; i < 11; i++) {
                        //checks if the numerator and denominator is divisible by values between 2 and 10 (the value i)
                        if ((numerator % i == 0) && (denominator % i == 0)) {
                            //sets the numerator and denominator into the value divided by value i
                            numerator = numerator / i;
                            denominator = denominator / i;
                        }
                    }
                }
                // sets the finalNumber
                finalNumber = (numerator + "/" + denominator);
            }

        //When the operation is multiplication
        } else if (operator.equals("*")) {
            //multiplication

            // Calculates the operations and sets its numerator and denominator values
            int numerator = (((firstFractionWhole*firstFractionDenominator)+(firstFractionNumerator))*((secondFractionWhole*secondFractionDenominator)+(secondFractionNumerator)));
            int denominator = firstFractionDenominator*secondFractionDenominator;

            //Simplifying the fraction
            // Ex: "20/-1 -> -20" or "17/4 -> 4_1/4"

            //if the numerator is 0, then the finalNumber is 0
            if ((numerator) == 0){
                finalNumber = "0";
            //if the denominator is 1 the finalNumber is numerator
            }else if (denominator == 1){
                finalNumber = (""+(numerator));
            //checks if the fraction is an improper fraction
            }else if (Math.abs(numerator % denominator) > 0 && Math.abs(numerator/denominator) >0){
                for (int k = 0; k < 10; k++) {
                    for (int i = 2; i < 11; i++) {
                        //checks if the numerator and denominator is divisible by values between 2 and 10 (the value i)
                        if ((numerator % i == 0) && (denominator % i == 0)) {
                            //sets the numerator and denominator into the value divided by value i
                            numerator = numerator / i;
                            denominator = denominator / i;
                        }
                    }
                }
                // sets the whole value
                int whole = numerator/denominator;
                //checks if the whole value is negative and the numerator is also negative
                if ((whole + "").charAt(0) == '-' && ((numerator + "").charAt(0) == '-')){
                    // removes the negative in the numerator as it is already inside the whole value
                    numerator = numerator*(-1);
                }
                // sets the finalNumber
                finalNumber = (whole+"_"+numerator%denominator+"/"+denominator);
            }else{
                // checks if the numerator and denominator is divisible
                if ((numerator) % (firstFractionDenominator*secondFractionDenominator) == 0){
                    finalNumber = ("" + (numerator)/denominator);
                }else {
                    finalNumber = ((numerator) + "/" + denominator);
                }
            }

        //When the operation is division
        } else if (operator.equals("/")) {
            //division

            // Calculates the operations and sets its numerator and denominator values
            int numerator = (((firstFractionWhole*firstFractionDenominator)+(firstFractionNumerator))*(secondFractionDenominator));
            int denominator = ((firstFractionDenominator) * ((secondFractionWhole * secondFractionDenominator) + secondFractionNumerator));

            //if the denominator is negative, it moves it to the numerator (or makes it positive if it is
            // already negative) and sets the denominator positive
            if ((denominator + "").charAt(0) == ('-')) {
                numerator *= (-1);
                denominator *= (-1);
            //if the numerator is 0, then the finalNumber is 0
            }if (numerator == 0){
                finalNumber = "0";
            // checks if the numerator and denominator is divisible
            }else if(numerator == denominator) {
                finalNumber = "1";
            //if the denominator is 1 the finalNumber is numerator
            }else if(Math.abs(denominator) == 1) {
                finalNumber = "" + numerator;
            //if the denominator is 0 the finalNumber is 0
            } else if (denominator == 0) {
                finalNumber = "" + 0;
            //checks if the fraction is an improper fraction
            }else if (Math.abs(numerator % denominator) > 0 && Math.abs(numerator/denominator) >0){
                for (int k = 0; k < 10; k++) {
                    for (int i = 2; i < 11; i++) {
                        //checks if the numerator and denominator is divisible by values between 2 and 10 (the value i)
                        if ((numerator % i == 0) && (denominator % i == 0)) {
                            //sets the numerator and denominator into the value divided by value i
                            numerator = numerator / i;
                            denominator = denominator / i;
                        }
                    }
                }
                // sets the whole value
                int whole = numerator/denominator;
                //checks if the whole value is negative and the numerator is also negative
                if ((whole + "").charAt(0) == '-' && ((numerator + "").charAt(0) == '-')){
                    // removes the negative in the numerator as it is already inside the whole value
                    numerator = numerator*(-1);
                }
                // sets the finalNumber
                finalNumber = (whole+"_"+numerator%denominator+"/"+denominator);
            } else {
                for (int k = 0; k < 10; k++) {
                    for (int i = 2; i < 11; i++) {
                        //checks if the numerator and denominator is divisible by values between 2 and 10 (the value i)
                        if ((numerator % i == 0) && (denominator % i == 0)) {
                            //sets the numerator and denominator into the value divided by value i
                            numerator = numerator / i;
                            denominator = denominator / i;
                        }
                    }
                }

                // sets the finalNumber
                finalNumber = (numerator + "/" + denominator);
            }
        }
        // returns the finalNumber
        return finalNumber;
    }
    //*/



    // TODO: Fill in the space below with any helper methods that you think you will need

    /**
     * findWhole method determines if the given fraction has a whole and returns it if it does, if not, it returns 0
     * @param fraction a string form of the given fraction
     * @return the whole value of the fraction
     */
    public static String findWhole(String fraction){
        // sets the whole value inherently 0 as it could not exist
        String whole = "0";
        // checks if the fraction has a numerator and denominator (is a fraction) or if it is just a number
        if (fraction.contains("/")){
            //checks if the fraction has a whole number
            if (fraction.contains("_")){
                Scanner scan = new Scanner(fraction);
                scan.useDelimiter("_");
                // splits the fraction so it returns the whole number
                whole = scan.next();
            }
        //when the fraction isn't a fraction but just a number
        }else{
            // sets the number into the whole
            whole = fraction;
        }
        // returns the whole value
        return(whole);
    }
    /**
     * findNumerator method determines if the given fraction has a numerator and returns it if it does, if not, it returns 0
     * @param fraction a string form of the given fraction
     * @return the numerator value of the fraction
     */
    public static String findNumerator(String fraction){
        // sets the numerator value inherently 0 as it could not exist
        String numerator = "0";
        // checks if the fraction has a numerator and denominator (is a fraction) or if it is just a number
        if (fraction.contains("/")){
            //checks if the fraction has a whole number
            if (fraction.contains("_")){
                Scanner scan = new Scanner(fraction);
                scan.useDelimiter("/");
                Scanner secondScan = new Scanner(scan.next());
                // splits the fraction so it can find the numerator
                secondScan.useDelimiter("_");
                // checks if the numerator is a negative
                if ((secondScan.next()).charAt(0) == '-'){
                    //sets the numerator as negative
                    numerator="-";
                }
                numerator += secondScan.next();
            //when the fraction doesn't have a whle number
            }else{
                Scanner scan = new Scanner(fraction);
                // splits the fraction so it can find the numerator
                scan.useDelimiter("/");
                // sets the numerator
                numerator = scan.next();
            }
        }
        // returns the numerator
        return(numerator);
    }

    /**
     * findDenominator method determines if the given fraction has a denominator and returns it if it does, if not, it returns 1
     * @param fraction a string form of the given fraction
     * @return the denominator value of the fraction
     */
    public static String findDenominator(String fraction){
        // sets the denominator value inherently 1 as it could not exist
        String denominator = "1";
        // checks if the fraction has a numerator and denominator (is a fraction) or if it is just a number
        if (fraction.contains("/")){
            Scanner scan = new Scanner(fraction);
            // splits the fraction so it can find the denominator
            scan.useDelimiter("/");
            scan.next();
            // sets the denominator
            denominator = scan.next();
        }
        // returns the denominator
        return(denominator);
    }

}
