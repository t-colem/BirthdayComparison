import java.util.*;
public class Birthdays {
    // Define new Scanner and Random methods outside of main, so they're accessible everywhere
    public static Scanner in = new Scanner(System.in);

    public static Random rng = new Random();

    public static void main(String[] args) {
        // Contain the entire main method in a do while loop to continue until the user stops the program
        do{
            // Display the introduction
            displayIntroduction();
            // Define necessary variables and assign them to user inputs
            int todayDay, todayMonth, todayAbsolute;
            todayMonth = in.nextInt();
            todayDay = in.nextInt();

            // Solve for the absolute value of today using the findAbsolute method
            todayAbsolute = findAbsolute(todayMonth,todayDay);
            // Display today's date using the displayTodayDate method
            displayTodayDate(todayMonth, todayDay, todayAbsolute);

            // Define the variables needed to store the differences between person 1 and person 2 using the getBirthdayDifference method
            int personOneDifference = getBirthdayDifference(todayAbsolute, 1);
            int personTwoDifference = getBirthdayDifference(todayAbsolute, 2);

            // Compare the birthdays to each other using the compareBirthdays method
            compareBirthdays(personOneDifference, personTwoDifference);
            // Finally, print a random fun fact using the printFunFact function
            printFunFact();

        }while(continueLoop(in)); // If the continueLoop boolean function condition returns false, end the program. Otherwise, restart the program.
    }
    // Define the displayIntroduction method which returns nothing but prints an introduction to the user. This method takes no parameters.
    public static void displayIntroduction() {
        System.out.println("This program compares two birthdays");
        System.out.println("and displays which one is sooner.");
        System.out.println("What is today's month and day?");
    }
    // Define the findAbsolute method which takes two int parameters.
    public static int findAbsolute(int month, int day){
        // Define an array daysInEachMonth with 12 elements, each representing the number of days in the respective month from January to December. Since we are assuming a leap year February has 29 days.
        int[] daysInEachMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Define a dayOfYear int which holds the value of day
        int dayOfYear = day;
        // Begin a for loop to iterate from 0 till month-1. The loop ends before the specified month to cumulative sum all the values proceeding it.
        for (int i = 0; i < month - 1; i++) {
            // Add the number of days in the month to dayOfYear
            dayOfYear += daysInEachMonth[i];
        }
        // Return dayOfYear which represents the absolute day of the year for the given month and day.
        return dayOfYear;
    }
    // Define a new method displayTodayDate which takes the month, day and absoluteDay as parameters.
    public static void displayTodayDate(int month, int day, int absoluteDay) {
        // This method just prints today's date with the absoluteDay calculation included
        System.out.printf("Today is %d/%d/2024, day #%d of the year.\n", month, day, absoluteDay);
    }
    // Define a new method calculateDaysUntilBirthday which takes the todayAbsolute, birthMonth and birthDay parameters.
    public static int calculateDaysUntilBirthday(int todayAbsolute, int birthMonth, int birthDay) {
        // Call the findAbsolute method with the birthMonth and birthDay as parameters
        int birthAbsolute = findAbsolute(birthMonth, birthDay);
        // Solve for the difference between the birthAbsolute and todayAbsolute
        int difference = birthAbsolute - todayAbsolute;

        // If the difference is less than 0, we need to add 366 to the difference to get the actual difference. This happens when the days cross over the new year.
        if (difference < 0) {
            difference += 366;
        // Else if the birthAbsolute is equal to todayAbsolute, that means today is this persons birthday, we can print the values we need to and return difference along with a happy birthday message.
        }else if(birthAbsolute == todayAbsolute){
            System.out.printf("%d/%d/2024 falls on day #%d of 366.\n",birthMonth,birthDay,birthAbsolute);
            System.out.println("Happy birthday!");
            return difference;
        }
        // If none of those cases are met, we just continue on down to print the necessary information
        System.out.printf("%d/%d/2024 falls on day #%d of 366.\n",birthMonth,birthDay,birthAbsolute);
        System.out.println("Your next birthday is in " + difference + " day(s)");
        // We can solve for the percentage of a year away using (difference / 366) * 100 and casting that data into a double.
        double percentage = ((double) difference / 366) * 100;
        // We can then print that value to 1 decimal place and end the method by returning difference
        System.out.printf("That is %.1f percent of a year away\n", percentage);
        return difference;
    }
    // Define a new method getBirthdayDifference which takes todayAbsolute and personNumber as parameters
    public static int getBirthdayDifference(int todayAbsolute, int personNumber) {
        // Start by printing what person were talking about and asking them what day and month they were born
        System.out.println("Person " + personNumber + ":");
        System.out.print("What month and day were you born? ");
        // Prompt the user for input and store those values in int variables
        int month = in.nextInt();
        int day = in.nextInt();
        // Return the value of calculateDaysUntilBirthday using todayAbsolute, month and day for computation
        return calculateDaysUntilBirthday(todayAbsolute, month, day);
    }
    // Lastly we define a compareBirthdays method which takes the two differences as parameters that we solve for and compares them using conditionals
    public static void compareBirthdays(int difference1, int difference2) {
        // If difference1 is less than difference2, that means person 1's birthday is sooner
        if (difference1 < difference2) {
            System.out.println("\nPerson 1's birthday is sooner.");
        } else if (difference2 < difference1) {
            // If difference2 is less than difference1, that means person 2's birthday is sooner
            System.out.println("\nPerson 2's birthday is sooner.");
        } else {
            // Otherwise, they share the same birthday, so we print that out
            System.out.println("\nWow, you share the same birthday!\n");
        }
    }
    // Define a void printFunFact method
    public static void printFunFact(){
        // I stored some fun facts in a String array to choose from randomly each time the program runs.
        String[] funFacts = {
            "\nDid you know January 4th is World Braille Day? Louis Braille invented Braille to help blind people read!\n",
            "\nDid you know? March 14th is Pi Day! It's also Albert Einstein's Birthday!\n",
            "\nMay 25th is Towel Day! Remember, a towel is the most useful thing a interstellar hitchhiker can have with them. So long and thanks for all the fish!\n",
            "\nJune 8th is World Oceans Day! Protecting the ocean is extremely important and this day was coined to commemorate that fact and to raise awareness about ways we can protect it and the life it contains.\n",
            "\nThe United Nations in 2011 proclaimed July 30th is International Friendship day! Peace be with you.\n",
            "\nDid you meow? August 8th is International Cat Day!\n"
        };
        // Define a new random that uses the length of the funFacts array as a boundary, this way we can add more facts as we please without having to adjust the boundary every time
        int random = rng.nextInt(funFacts.length);
        // Print a random fun fact chosen from the array
        System.out.println(funFacts[random]);
    }
    // Finally, we define a boolean continueLoop function that takes a scanner input as a parameter
    public static boolean continueLoop(Scanner in) {
        // Prompt the user to either continue the loop or not
        System.out.println(
                "Would you like to compare two more birthdays?\n" +
                "Type 1 and then <enter/return> to compare two more birthdays\n" +
                "Type 2<enter/return> to end the program");
        // Store that value in an int variable, userInput
        int userInput = in.nextInt();
        // Add some spacing
        System.out.println();
        if (userInput == 1) {
            // If userInput is 1, we return true and begin the program again
            return true;
        } else if (userInput == 2) {
            // If userInput is 2, we return false and end the program after printing a goodbye message
            System.out.println("Thank you for using the program! Have a good day!");
            return false;
        } else {
            // If userInput is anything other than a 1 or 2, we want the user to try again with a valid input, so we return to the beginning of the function
            System.out.println("Invalid input. Please try again.");
            return continueLoop(in);
        }
    }
}
