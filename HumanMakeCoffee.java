package Assignment2;/*
CSCI-1110  Juliano Franz
ID: B00877530
Assignment - 02
Problem-03
This problem gives user various options for selection.
 */

import Assignment2.CoffeeBeans;

import java.util.Scanner;

public class HumanMakeCoffee {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //The following things has been initialised with the values for different classes.
        CoffeeBeans[] coffeeObjects = new CoffeeBeans[4];
        CoffeeMaker coffeeMaker = new CoffeeMaker(2500);
        coffeeMaker.switchPower();

        String brandName, blendType, roastType;

        // This loop fills the array with the objects and its parameters the user inputs.
        for(int i=0; i<4; i++){

            brandName = in.nextLine();
            blendType = in.nextLine();
            roastType = in.nextLine();
            CoffeeBeans beans = new CoffeeBeans(brandName,blendType, CoffeeBeans.Roast.valueOf(roastType));
            coffeeObjects[i] = beans;
        }

        System.out.println("Welcome! Please select an option:");
        int option = in.nextInt();

        // Based on the option user inputs the conditions are provided. (i.e. 1,2,3,4)
        // 0 to exit.
        while (option != 0){

            // Prints the array object
            if(option==1){
                System.out.println("Here are your coffee options");
                for(int i=0; i<4; i++){
                    System.out.printf("(%d)\n",i+1);
                    System.out.println(coffeeObjects[i]);
                    System.out.println("---------");
                }

                System.out.print("Make a selection: ");

                int selection = in.nextInt();

                // Based on the selection the coffee beans are checked if its null or not.
                coffeeMaker.loadCoffee(coffeeObjects[selection-1]);
            }

            // Print the machine String representation.
            if(option==2){
                System.out.println(coffeeMaker.toString());
            }

            // This option is selected if user wants to add water and based on that function are called.
            if(option==3){
                System.out.print("How much water?");
                double water = in.nextDouble();
                coffeeMaker.addWater(water);
            }

            // This option is selected if user wants to make the coffee(no.of cups given)
            if(option==4){
                System.out.print(" How many cups?");
                int cups = in.nextInt();

                // The following statements are printed based on the conditions.
                if(coffeeMaker.brewCoffee(cups)){
                    System.out.println(" Brewing coffee...");
                }
                else if (!coffeeMaker.brewCoffee(cups)){
                    System.out.println("  Hmm... something went wrong");
                }
;           }

            option = in.nextInt();

        }
    }

}
