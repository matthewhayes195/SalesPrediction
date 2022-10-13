import java.util.ArrayList;
import java.util.Collections;

public class Combinations {
    
    // declaring instance variables
    ArrayList<Integer> seasonList = new ArrayList();
    ArrayList<Integer> nonSeasonList = new ArrayList();
    ArrayList<Integer> studentList = new ArrayList();
    ArrayList<Integer> incomeList = new ArrayList();
    ArrayList<Integer> referenceList = new ArrayList();
    ArrayList<Integer> badIncomeList = new ArrayList();
    
    private int maxIncome;
    private int seasonSeatMax;
    private int nonSeasonSeatMax;
    private int studentSeatMax;
    
    // default constructor
    public Combinations(){
        // initializing max seats and max income
        seasonSeatMax = 30;
        nonSeasonSeatMax = 50;
        studentSeatMax = 10;
        maxIncome = 1150;
        
        // sets up reference list of numbers 1 - maxIncome
        for (int i = 1; i <= maxIncome; i++){
            referenceList.add(i);
        }
        
        /*  finds all possible incomes where
                seasonList = A
                nonSeasonList = B
                studentList = C 
            and puts them into incomeList
        */
        
        // possible incomes for A
        for (int i = 1; i <= seasonSeatMax; i++){
            int num = i * 15;
            seasonList.add(num);
            incomeList.add(num);
        }
        // possible incomes for B
        for (int i = 1; i <= nonSeasonSeatMax; i++){
            int num = i * 12;
            nonSeasonList.add(num);
            incomeList.add(num);
        }
        // possible incomes for C
        for (int i = 1; i <= studentSeatMax; i++){
            int num = i * 10;
            studentList.add(num);
            incomeList.add(num);

        }
        // possible incomes for A, B, and C
        for (int i = 1; i <= seasonList.size(); i++){
            for (int j = 1; j <=nonSeasonList.size(); j++){
                for(int k = 1; k <= studentList.size(); k++){
                    
                    int num = seasonList.get(i-1) + nonSeasonList.get(j-1) + studentList.get(k-1);
                    incomeList.add(num);
                }
            }
        }
        // possible incomes for A and B
        for (int i = 1; i <= seasonList.size(); i++){
            for (int j = 1; j <=nonSeasonList.size(); j++){
                
                int num = seasonList.get(i-1) + nonSeasonList.get(j-1);

                incomeList.add(num);
            }
        }
        // possible incomes for A and C
        for (int i = 1; i <= seasonList.size(); i++){
            for (int j = 1; j <=studentList.size(); j++){
                
                int num = seasonList.get(i-1) + studentList.get(j-1);

                incomeList.add(num);
            }
        }
        // possible incomes for B and C
        for (int i = 1; i <= nonSeasonList.size(); i++){
            for (int j = 1; j <=studentList.size(); j++){
                int num = nonSeasonList.get(i-1) + studentList.get(j-1);

                incomeList.add(num);
            }
        }
        // adding values to badIncomeList by checking if reference list doesn't contain incomeList nums
        for (int i = 0; i < referenceList.size(); i++){

            if (incomeList.contains(referenceList.get(i)) == false){
                badIncomeList.add(referenceList.get(i));
            }
        }
        
    }
    
    public Combinations(int a_season, int a_nonSeason, int a_student){
        // initializing max seats
        seasonSeatMax = a_season;
        nonSeasonSeatMax = a_nonSeason;
        studentSeatMax = a_student;
        
        /*  finds all possible incomes where
                seasonList = A
                nonSeasonList = B
                studentList = C 
            and puts them into incomeList
        */
        
        // possible incomes for A
        for (int i = 1; i < seasonSeatMax; i++){
            int num = i * 15;
            seasonList.add(num);
            incomeList.add(num);
        }
        // possible incomes for B
        for (int i = 1; i < nonSeasonSeatMax; i++){
            int num = i * 12;
            nonSeasonList.add(num);
            incomeList.add(num);
        }
        // possible incomes for C
        for (int i = 1; i < studentSeatMax; i++){
            int num = i * 10;
            studentList.add(num);
            incomeList.add(num);

        }
        // possible incomes for A, B, and C
        for (int i = 1; i <= seasonList.size(); i++){
            for (int j = 1; j <=nonSeasonList.size(); j++){
                for(int k = 1; k <= studentList.size(); k++){
                    
                    int num = seasonList.get(i-1) + nonSeasonList.get(j-1) + studentList.get(k-1);
                    incomeList.add(num);
                }
            }
        }
        // possible incomes for A and B
        for (int i = 1; i <= seasonList.size(); i++){
            for (int j = 1; j <=nonSeasonList.size(); j++){
                
                int num = seasonList.get(i-1) + nonSeasonList.get(j-1);

                incomeList.add(num);
            }
        }
        // possible incomes for A and C
        for (int i = 1; i <= seasonList.size(); i++){
            for (int j = 1; j <=studentList.size(); j++){
                
                int num = seasonList.get(i-1) + studentList.get(j-1);

                incomeList.add(num);
            }
        }
        // possible incomes for B and C
        for (int i = 1; i <= nonSeasonList.size(); i++){
            for (int j = 1; j <=studentList.size(); j++){
                int num = nonSeasonList.get(i-1) + studentList.get(j-1);

                incomeList.add(num);
            }
        }
        
        // sets max income
        maxIncome = Collections.max(incomeList);
        
        // sets up reference list of numbers 1 - maxIncome
        for (int i = 1; i <= maxIncome; i++){
            referenceList.add(i);

        }
        
        // adding values to badIncomeList by checking if referenceList doesn't contain incomeList nums
        for (int i = 0; i < referenceList.size(); i++){

            if (incomeList.contains(referenceList.get(i)) == false){
                badIncomeList.add(referenceList.get(i));
            }
        }
        
    }
    
    public int getMaxNum(){return maxIncome;}
}
