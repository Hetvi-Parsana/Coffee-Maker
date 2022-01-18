package Assignment2;/*
CSCI-1110  Juliano Franz
ID: B00877530
Assignment - 02
Problem-02 (The Coffee Machine and Coffee Grinder)
This problem will determine the making of coffee.
 */

import Assignment2.CoffeeBeans;
import Assignment2.CoffeeGrinder;

public class CoffeeMaker{

    private double waterLevel;
    private boolean isOn;
    private CoffeeBeans loadedCoffee;
    private double tankCapacity;
    private CoffeeGrinder grinder;

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param beans the parameter to be evaluated
     * @param size the size of tank user inputs
     */
    public CoffeeMaker(CoffeeBeans beans,double size){
        this.loadedCoffee = beans;
        this.tankCapacity = size;
        this.grinder = new CoffeeGrinder();
        this.waterLevel = 0;
        this.isOn = false;
    }

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param size the size of tank user inputs.
     */
    public CoffeeMaker (double size){
        this.tankCapacity = size;
        this.grinder = new CoffeeGrinder();
        this.waterLevel = 0;
        this.isOn = false;
    }

    /**
     *
     * @return the level of water.
     */
    public double getWaterLevel(){
        return waterLevel;
    }

    /**
     * This would switch the power of machine.
     */
    public void switchPower(){
        isOn = !isOn;
    }

    /**
     * Checks if switch is on or not.
     * @return the boolean value as per the result.
     */
    public boolean isOn(){
        return isOn;
    }

    /**
     * Checks whether coffee is there or not.
     * @return the boolean value as per the result.
     */
    public boolean hasCoffee(){
        if(loadedCoffee != null){
            return true;
        }
        return false;
    }

    /**
     * Loads the coffee and returns the value.
     * @param loadedCoffee the parameter which contains coffee.
     * @return the boolean value as per the result.
     */
    public boolean loadCoffee(CoffeeBeans loadedCoffee){
        if(loadedCoffee == null){
            return false;
        }
        this.loadedCoffee = loadedCoffee;
        return true;
    }

    /**
     * This method will just remove the loaded coffee and clear the water level.
     */
    public void clean(){
        this.loadedCoffee = null;
        this.waterLevel = 0.0;
    }

    /**
     * This method add the water based on the given parameters and conditions.
     * @param waterInMl the amount of water to be added.
     */
    public void addWater(double waterInMl){
        this.waterLevel += waterInMl;
        if(this.waterLevel > this.tankCapacity){
            this.waterLevel = this.tankCapacity;
        }
    }

    /**
     * This method makes the coffee after following all the conditions.
     * @param noOfCups the no of cups of coffee to be made.
     * @return boolean value as per the result.
     */
    public boolean brewCoffee(int noOfCups){
        if(loadedCoffee == null){
            return false;
        }
        if(isOn = false){
            return false;
        }
        if(!loadedCoffee.isGround()){
            grinder.grindCoffee(loadedCoffee);
        }
        if(getWaterLevel() < cupsToML(noOfCups)){
            return false;
        }
        isOn = true;
        waterLevel = waterLevel - cupsToML(noOfCups);
        return true;
    }

    /**
     * This method coverts the no of cups into millimeter.
     * @param cups the no of cups the user inputs.
     * @return the value after converting into millimeter
     */
    private double cupsToML(int cups){
        double noOfCups = 236.59 * cups;
        return noOfCups;
    }

    /**
     * This method gives the final outcome after checking the coffee status.
     * @return the string representation to be printed.
     */
    public String toString(){
        String outcome = "";
        if(loadedCoffee != null){
            outcome = String.format("isOn: %s\nwater left: %.2f\nloaded coffee:\nBrand: %s\nBlend: %s\nRoast type: %s\n%s.",isOn,
                    getWaterLevel(),loadedCoffee.getBrandName(),loadedCoffee.getBlendName(),loadedCoffee.roast(),loadedCoffee.CoffeeBean);
        }
        else{
            outcome = String.format("isOn: %s\nwater left: %.2f\nno coffee loaded.",isOn,getWaterLevel());
        }
        return outcome;
    }
}
