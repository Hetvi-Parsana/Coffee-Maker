package Assignment2;/*
CSCI-1110  Juliano Franz
ID: B00877530
Assignment - 02
Problem-01
This problem is based on Coffee and its type selection.
 */

public class CoffeeBeans {

    private boolean isGround;
    private String blendName;
    private String brandName;
    private Roast roast;
    String CoffeeBean = "";
    enum Roast{
        LIGHT, MEDIUM, MEDIUM_DARK, DARK;
    }

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param brand the name of brand received from user.
     * @param blendType the type of coffee blend the user inputs.
     * @param roast the type of coffee beans (from the enum list given).
     * @param groundType whether its ground or whole bean.
     */
    public CoffeeBeans(String brand,String blendType, Roast roast, boolean groundType){
        this.blendName = blendType;
        this.brandName = brand;
        this.roast = roast;

        if(groundType){
            CoffeeBean = "ground";
        }
        else{
            CoffeeBean = "whole bean";
        }
    }

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param brand the name of brand received from user.
     * @param blendType the type of coffee blend the user inputs.
     * @param roast the type of coffee beans (from the enum list given).
     */
    public CoffeeBeans(String brand,String blendType, Roast roast){
        this.blendName = blendType;
        this.brandName = brand;
        this.roast = roast;
        CoffeeBean = "whole bean";
    }

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param brand the name of brand received from user.
     * @param blendType the type of coffee blend the user inputs.
     */
    public CoffeeBeans(String brand,String blendType){
        this.blendName = blendType;
        this.brandName = brand;
        this.roast = Roast.MEDIUM;
        CoffeeBean = "whole bean";
    }

    /**
     * Checks the coffee beans if coffee is ground or not.
     * @return the boolean value as per the result.
     */
    public boolean isGround(){
        if(CoffeeBean.equals("whole bean")){
            return false;
        }

        return true;
    }

    /**
     *
     * @return the type of coffee beans.
     */
    public Roast roast(){
        return roast;
    }

    /**
     *
     * @return the brand name of coffee.
     */
    public String getBrandName(){
        return brandName;
    }

    /**
     *
     * @return the blend name of coffee.
     */
    public String getBlendName(){
        return blendName;
    }

    /**
     * Grins the coffee beans if it is not grinned.
     * @return the boolean value as per the result.
     */
    public boolean grind(){
        if(CoffeeBean.equals("whole bean")){
            CoffeeBean = "ground";
            return true;
        }
        return false;
    }

    /**
     *
     * @return the print statement.
     */
    public String toString(){
        String outcome = String.format("Brand: %s\nBlend: %s\nRoast type: %s\n%s",
                brandName,blendName,roast,CoffeeBean);
        return outcome;
    }
}