/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Creates Smoothie attributes used in taking orders
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gianpaulo Cruz
*/

package Power;

public class Smoothie extends Beverage {

    private static final double FRUIT_COST = 0.5;
    private static final double PROTEIN_COST = 1.5;
    private static final double SIZE_PRICE = 0.5;

    private int numFruits;
    private boolean proteinAdded;

    public Smoothie(String bevName, Size size, int numFruits, boolean proteinAdded) {
        super(bevName, Type.SMOOTHIE , size);
        this.numFruits = numFruits;
        this.proteinAdded = proteinAdded;
    }
    
    public int getNumFruits() {
        return numFruits;
    }

    public void setNumFruits(int numFruits) {
        this.numFruits = numFruits;
    }

    public boolean isProteinAdded() {
        return proteinAdded;
    }

    public void setProteinAdded(boolean proteinAdded) {
        this.proteinAdded = proteinAdded;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Smoothie)) return false;
        Smoothie other = (Smoothie) obj;
        return super.equals(obj) && this.numFruits == other.numFruits && this.proteinAdded == other.proteinAdded;
    }

    @Override
    public double calcPrice() {
        double basePrice = BASE_PRICE;
        if (proteinAdded) {
            basePrice += PROTEIN_COST;
        }
        if (numFruits > 0) {
            basePrice += (numFruits * FRUIT_COST);
        }
        if (getSize() == Size.MEDIUM) {
            basePrice += SIZE_PRICE;
        } else if (getSize() == Size.LARGE) {
            basePrice += (SIZE_PRICE * 2); 
        }
        return basePrice;
    }



    @Override
    public String toString() {
        return super.toString() + ", Protein Added: " + proteinAdded + ", Number of Fruits: " + numFruits +
                ", Price: $" + calcPrice();
    }
}
