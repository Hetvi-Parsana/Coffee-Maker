package Assignment2;/*
CSCI-1110  Juliano Franz
ID: B00877530
Assignment - 02
Problem-02 (The Coffee Machine and Coffee Grinder)
This problem will determine the grinding of coffee beans.
 */

import Assignment2.CoffeeBeans;

public class CoffeeGrinder{

    /**
     * This method grinds the coffee if its not.
     * @param beans the parameter beans to be evaluated
     * @return the boolean value as per the result.
     */
    public boolean grindCoffee(CoffeeBeans beans){
        if(beans.isGround()){
            return false;
        }
        else{
            beans.grind();
        }
        return true;
    }

}
