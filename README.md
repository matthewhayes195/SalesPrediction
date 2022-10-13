# SalesPrediction READ ME

      This project stemmed from an assignment in my first programming class. I have revised it over this past year with the latest revision being the biggest yet. The 
project initially aimed to calculate the combined income from three different tiers of seats in a university stadium. Each tier has its own price – season seats are 
$15, non-season seats are $12, and student seats are $10, with a seat cap of 30, 50, and 10, respectively. After completing the assignment, the first revision began. I 
wanted the program to also calculate the number of seats in each tier that have to be sold to reach the user’s desired income. Finally, the latest revision sought to 
make it a more robust program, by checking if the desired income is possible from the amount of seats already sold, or just possible in general, effectively 
eradicating infinite loops from the program. The program started in Python and used the procedural programming paradigm to execute the code. As the program currently 
stands, it is written in Java, a strictly object-oriented programming language, as that is what I’m currently learning. 

      The program has a java main file with a short class named Sales at the top that has three instance variables: “seasonIncome”, “nonSeasonIncome”, and 
“studentIncome”. These are used in the class’s only method called “getIncome” that takes three integers as parameters and multiplies them by 15, 12, and 10 to get the 
individual incomes of each seat tier. The products are then stored in the respective instance variables of the class and the method itself returns the total income, or 
the sum of the instance variables. The program also includes a java class file with another class named Combinations that handles error-checking calculations. It does 
this by first having four integer instance variables: “maxIncome”, “seasonSeatMax”, “nonSeasonSeatMax”, and “studentMax”, as well as ArrayList objects for each seat 
tier, the possible and impossible incomes, and a reference list. In the default constructor for the Combinations class, the primitive instance variables are 
initialized, and there are 5 basic for-loops, three two-dimensional for-loop, and one three-dimensional for-loop for combination calculations. The first part of the 
default constructor calculates every possible income from the different combinations of seats with the season seat list being referred to as “A”, the non-season seat 
list referred to as “B”, and the student list referred to as “C”. There are three basic for-loops that store the individual seat incomes for “A”, “B”, and “C” in the 
possible income list, or “incomeList”. Then, using two-dimensional for-loops, it stores the possible incomes from “A” and “B”, “A” and “C”, “B” and “C”, and finally, 
with a three-dimensional for-loop, “A”, “B”, and “C” in “incomeList” as well. The next part of the constructor runs the reference list through a basic for-loop and 
initializes it with values from 0 to the maximum income for that object. Finally, there is a for-loop to check the contents of “incomeList” against the contents of 
“referenceList”, and if a value is in the reference list but not in the income list, it gets put into the impossible income list, or “badIncomeList”. This accounts for 
every possible value for the program.
      
      The main method itself starts with a Scanner object used to take input from the console, a Random object, a Sales object, two Combinations objects. Then, the   
user is asked for three inputs: the amount of season seats, non-season seats, and student seats sold. Each is stored in its own variable, and then passed to the 
“getIncome” method of the Sales class, which is stored in a “totalIncome” variable, and displays it to the console along with the number of seats entered in each tier. 
The program then uses the second Combinations object mentioned earlier that takes three parameters: the difference of the max number of seats and the current seat 
number for each tier. This brings the program over to a constructor with parameters that is largely the same as the default constructor. The only differences are the 
numbers taken in as parameters are stored in the respective “Max” variable for each seat tier, and, after “incomeList” has all of its possible values, this constructor 
uses the “Collections.max()” function to find the highest number in “incomeList” and store it in “maxIncome”.
      
      The next phase of the program asks the user, inside a do-while loop, for a target income which is stored in a “target” variable. The loop has two if statements. 
The first statement checks, for both Combinations objects, if the target income is in the bounds of the possible values of 0 to the maximum income (each seat being 
sold out) of 1150, or if the target is in “badIncomeList”, and displays to the console, if these conditions are true, that the target cannot be reached with current 
ticket prices. The second if statement checks if the difference of “target” and “totalIncome” is in “badIncomeList”, and if “target” itself is not in “badIncomeList”. 
If these conditions are true, the program displays to the console that the target can be reached with current ticket prices but cannot be reached with the amount of 
seats already sold. There is also a nested if statement in the second if statement that checks if any of the seats are at their max, and if the difference of “target” 
and “totalIncome” are divisible by each seats’ ticket prices with no remainder using the modulus (%) operator. On the surface, it would make sense to just check 
“incomeList” instead of making a completely new list to check. However, in most cases “badIncomeList” is a great deal smaller, and therefore quicker to check. I also 
included the use of a Boolean variable in the loop conditions that is set in the second selection statement as I have found having the loop itself check 
“badIncomeList”, however small, multiple times in the loop conditions slows the program down considerably. 
      
      Finally, the last part of the main method stores the difference of “target” and “totalIncome” into a new variable called “newTarget”, and checks if “target”, 
once a possible value is inputted, is greater than “totalIncome”. This would mean the user has already reached their goal, and the program sets a Boolean variable 
“goalReached” to true. It then cuts down to a selection statement at the bottom of the program that has “goalReached” equal to false as a condition, and when it’s true 
displays in the console that the user reached their goal. If “goalReached” remains false, the program continues to a while loop that checks if “totalIncome” is equal 
to “newTarget”. Using “newTarget” instead of “target” allows the loop to only calculate how many more seats are needed to reach the user’s goal. The while loop itself 
contains “new” versions of the variables for each seat tier, appropriately named “newSeasonSeats”, “newNonSeasonSeats”, and “newStudentSeats”, which are all initially 
set to zero. Then, in these new variables, the loop stores randomly generated numbers between 0 and the maximum number of seats for each tier for the second 
Combinations object. These are then passed as parameters to “totalIncome”, with “totalIncome” containing the “getIncome” method of the Sales object, again. The loop 
continues until the conditions are met. Lastly, the program goes down to the selection statement mentioned before. Since “goalReached” is still false in this case, the 
program instead displays in the console “This is how many seats you have to sell to reach your goal:”, and right under it displays the sum of each original seat tier 
variable and the “new” version of the respective original to display the total number of seats for each tier calculated in this program.
      
      The resulting program ensures that the user can enter any value for the target income and not break the program by doing so. I’ve learned so much over the course 
of writing this program, with countless hours put into it. Until this program, I had only coded for assignments or followed someone else writing code online for a 
project. I was finally able to write a robust program and all the algorithms completely independently, even if I didn’t know the algorithms already existed. However, I 
recognize that there are still improvements to be made. For instance, I think in the future I will merge the two classes into one as the decision to separate them was 
completely arbitrary. I also plan on converting the program into a GUI (Graphical User Interface) as I think that would be overall more intuitive.
