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
    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input
        Scanner scan = new Scanner(input);
        scan.useDelimiter(" ");
        String firstFraction = (scan.next());
        String operator = (scan.next());
        String secondFraction = (scan.next());

        //return (secondFraction);
        //return("whole:"+findWhole(secondFraction)+" numerator:"+findNumerator(secondFraction)+" denominator:"+findDenomenator(secondFraction));

        int firstFractionWhole = Integer.parseInt(findWhole(firstFraction));
        int firstFractionNumerator = Integer.parseInt(findNumerator(firstFraction));
        int firstFractionDenomenator = Integer.parseInt(findDenomenator(firstFraction));
        int secondFractionWhole = Integer.parseInt(findWhole(secondFraction));
        int secondFractionNumerator = Integer.parseInt(findNumerator(secondFraction));
        int secondFractionDenomenator = Integer.parseInt(findDenomenator(secondFraction));
        String finalnumber = "";
        if (operator.equals("+")) {
            //addition
            if (!(("" +(secondFractionDenomenator * firstFractionNumerator)+( firstFractionDenomenator * secondFractionNumerator)+(firstFractionWhole+secondFractionWhole)*(firstFractionDenomenator*secondFractionDenomenator))).equals("0")){
                finalnumber = (((secondFractionDenomenator * firstFractionNumerator)+( firstFractionDenomenator * secondFractionNumerator)+(firstFractionWhole+secondFractionWhole)*(firstFractionDenomenator*secondFractionDenomenator))+"/"+(firstFractionDenomenator*secondFractionDenomenator));
            }else{
                finalnumber = "0";
            }
            if ((firstFractionDenomenator*secondFractionDenomenator) == 1){
                finalnumber =(""+ (secondFractionDenomenator * firstFractionNumerator)+( firstFractionDenomenator * secondFractionNumerator)+(firstFractionWhole+secondFractionWhole)*(firstFractionDenomenator*secondFractionDenomenator));
            }

        } else if (operator.equals("-")) {
            //subtraction
            finalnumber =(((secondFractionDenomenator * firstFractionNumerator)-( firstFractionDenomenator * secondFractionNumerator)+(firstFractionWhole-secondFractionWhole)*(firstFractionDenomenator*secondFractionDenomenator))+"/"+(firstFractionDenomenator*secondFractionDenomenator));
        } else if (operator.equals("*")) {
            //multiplication
            if ((((firstFractionWhole*firstFractionDenomenator)+(firstFractionNumerator))*((secondFractionWhole*secondFractionDenomenator)+(secondFractionNumerator))) == 0){
                finalnumber = "0";
            }else if ((firstFractionDenomenator*secondFractionDenomenator) == 1){
                finalnumber = (""+(((firstFractionWhole*firstFractionDenomenator)+(firstFractionNumerator))*((secondFractionWhole*secondFractionDenomenator)+(secondFractionNumerator))));
            }else{
                if ((((firstFractionWhole*firstFractionDenomenator)+(firstFractionNumerator))*((secondFractionWhole*secondFractionDenomenator)+(secondFractionNumerator))) % (firstFractionDenomenator*secondFractionDenomenator) == 0){
                    finalnumber = ("" + (((firstFractionWhole*firstFractionDenomenator)+(firstFractionNumerator))*((secondFractionWhole*secondFractionDenomenator)+(secondFractionNumerator)))/(firstFractionDenomenator*secondFractionDenomenator));
                }else {
                    finalnumber = ((((firstFractionWhole * firstFractionDenomenator) + (firstFractionNumerator)) * ((secondFractionWhole * secondFractionDenomenator) + (secondFractionNumerator))) + "/" + (firstFractionDenomenator * secondFractionDenomenator));
                }
            }
        } else if (operator.equals("/")) {
            //division
            if (((firstFractionWhole*firstFractionDenomenator)+(firstFractionNumerator))*(secondFractionDenomenator) == 0){
                finalnumber = "0";
            }else {
                finalnumber = (((firstFractionWhole * firstFractionDenomenator) + (firstFractionNumerator)) * (secondFractionDenomenator) + "/" + (firstFractionDenomenator) * ((secondFractionWhole * secondFractionDenomenator) + secondFractionNumerator));
            }
            }

        return finalnumber;
    }



    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String findWhole(String fraction){
        String whole = "0";
        if (fraction.contains("/")){
            if (fraction.contains("_")){
                Scanner scan = new Scanner(fraction);
                scan.useDelimiter("_");
                whole = scan.next();
            }
        }else{
            whole = fraction;
        }
        return(whole);
    }
    public static String findNumerator(String fraction){
        String numerator = "0";
        if (fraction.contains("/")){
            if (fraction.contains("_")){
                Scanner scan = new Scanner(fraction);
                scan.useDelimiter("/");
                Scanner secondScan = new Scanner(scan.next());
                secondScan.useDelimiter("_");
                if ((secondScan.next()).charAt(0) == '-'){
                    numerator="-";
                }
                numerator += secondScan.next();

            }else{
                Scanner scan = new Scanner(fraction);
                scan.useDelimiter("/");
                numerator = scan.next();
            }
        }
        return(numerator);
    }
    public static String findDenomenator(String fraction){
        String denomenator = "1";
        if (fraction.contains("/")){
            Scanner scan = new Scanner(fraction);
            scan.useDelimiter("/");
            scan.next();
            denomenator = scan.next();

        }
        return(denomenator);
    }

}
