import java.util.Scanner;
import java.util.Random;

// class to calculate total income of different-tiered seats
class Sales{
    
    // class instance variables
    int seasonIncome;
    int nonSeasonIncome;
    int studentIncome;
    
    // class method to calculate income
    int getIncome(int num1, int num2, int num3){
        seasonIncome = num1 * 15;
        nonSeasonIncome = num2 * 12;
        studentIncome = num3 * 10;
        
        return seasonIncome + nonSeasonIncome + studentIncome;
    }
    
};

public class SalesPrediction {
    
    // object instantiation
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();
    static Sales sales = new Sales();
    static Combinations combo = new Combinations();
    static Combinations combo2;
    
    public static void main(String[] args) {
        
        // variable declaration
        int seasonSeats;
        int nonSeasonSeats;
        int studentSeats;
        
        int seasonIndexMax = 31;
        int nonSeasonIndexMax = 51;
        int studentIndexMax = 11;
        
        int newSeasonSeats = 0;
        int newNonSeasonSeats = 0;
        int newStudentSeats = 0;
        
        int totalIncome;
        int target, newTarget;
        boolean goalReached = false;
        boolean badIncomeDIff;

        // intializing values for seats
        seasonSeats = rand.nextInt(seasonIndexMax);
        nonSeasonSeats = rand.nextInt(nonSeasonIndexMax);
        studentSeats = rand.nextInt(studentIndexMax);
        
        // calculating income for said seats
        totalIncome = sales.getIncome(seasonSeats, nonSeasonSeats, studentSeats);
        
        // console output of number of seats and total income
        System.out.println("Season seats: " + seasonSeats + "\nNon-season seats: "
        + nonSeasonSeats + "\nStudent seats: " + studentSeats);
        System.out.println("Total income: $" + totalIncome);
        
        combo2 = new Combinations((seasonIndexMax-seasonSeats),
        (nonSeasonIndexMax-nonSeasonSeats), (studentIndexMax-studentSeats));
        
        // target income loop
        do {
            // initialize loop condition
            badIncomeDIff = false;
            
            // asking user for target income
            System.out.print("What is your target income? ");
            target = in.nextInt();
            
            // checks if number is possible with current ticket prices
            if (combo.badIncomeList.contains(target) || target > combo.getMaxNum() || target < 0){
                System.out.println("I'm sorry, the number you entered cannot be calculated with current ticket prices.");
            }
            
            /*  
                checks if target-totalIncome is possible with seats already sold, if the
                target is possible in general, as well as if the seats are maxed out
            */
            if ((combo.badIncomeList.contains((target-totalIncome)) && combo.badIncomeList.contains(target) == false) 
                || (combo2.badIncomeList.contains(target-totalIncome) && combo2.badIncomeList.contains(target) == false)){
                
                badIncomeDIff = true;
                if (((target-totalIncome) % 15 == 0) && seasonSeats == seasonIndexMax-1){
                    System.out.println("You can't fill any more season seats.");
                
                }
                else if (((target-totalIncome) % 12 == 0) && nonSeasonSeats == nonSeasonIndexMax-1){
                    System.out.println("You can't fill any more non-season seats.");
                
                }
                else if (((target-totalIncome) % 10 == 0) && studentSeats == studentIndexMax-1){
                    System.out.println("You can't fill any more student seats.");
               
                }
                else{
                    System.out.println("While we can hit that target with current ticket prices,\n"
                        + "we can't hit it with the amount of seats already sold.");
                }
            }
        } while (combo.badIncomeList.contains(target) || target > combo.getMaxNum() || target < 0 || badIncomeDIff == true);
        System.out.println();
        
        // creates new target
        newTarget = target - totalIncome;
        
        // checks if goal already reached
        if (totalIncome > target){
            goalReached = true;
        }
        else {
            while (totalIncome != newTarget){
                
                // calculating new seats based off seats already sold
                newStudentSeats = rand.nextInt(studentIndexMax - studentSeats);
                newNonSeasonSeats = rand.nextInt(nonSeasonIndexMax - nonSeasonSeats);
                newSeasonSeats = rand.nextInt(seasonIndexMax - seasonSeats);

                // calculates new target income
                totalIncome = sales.getIncome(newSeasonSeats, newNonSeasonSeats, newStudentSeats);
            }
        }
        
        // final output for number of seats to reach target income
        if (goalReached == false){
            System.out.println("This is how much you have to sell to reach your goal of $" +target+ ":");
            System.out.println("Season seats: " + (seasonSeats +newSeasonSeats) + "\nNon-season seats: "
                            + (nonSeasonSeats + newNonSeasonSeats) + "\nStudent seats: " + (studentSeats + newStudentSeats));            
        }
        else{
            System.out.println("You've reached your goal!");
        }
        
    }
}

        
//        do {
//            System.out.println("Enter season seats sold: ");
//            seasonSeats = in.nextInt();
//            if (seasonSeats > seasonIndexMax){
//                System.out.println("Not enough seats.");
//            }
//            else if (seasonSeats < 0){
//                System.out.println("Invalid input.");
//            }
//        } while (seasonSeats > seasonIndexMax || seasonSeats < 0);
//        
//        do{
//            System.out.println("Enter non-season seats sold: ");
//            nonSeasonSeats = in.nextInt();
//            if (nonSeasonSeats > nonSeasonIndexMax){
//                System.out.println("Not enough seats.");
//            }
//            else if (nonSeasonSeats < 0){
//                System.out.println("Invalid input.");
//            }
//        } while (nonSeasonSeats > nonSeasonIndexMax || nonSeasonSeats < 0);
//        
//        do{
//            System.out.println("Enter student seats sold: ");
//            studentSeats = in.nextInt();
//            if (studentSeats > studentIndexMax){
//                System.out.println("Not enough seats.");
//            }
//            else if (studentSeats < 0){
//                System.out.println("Invalid input.");
//            }
//        } while (studentSeats > studentIndexMax || studentSeats < 0);