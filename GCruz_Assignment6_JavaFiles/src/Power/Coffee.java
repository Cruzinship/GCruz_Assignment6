/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Creates Coffee attributes used in taking orders
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gianpaulo Cruz
*/
package Power;

public class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	
	private static final double EXTRA_COST = 0.5;	
	private static final double SIZE_PRICE = 0.5;

	Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup){
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
    
	boolean getExtraShot() {
		return extraShot;
	}
	
    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

	boolean getExtraSyrup() {
		return extraSyrup;
	}
	
    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
	
    @Override
    public double calcPrice() {
        double basePrice = BASE_PRICE;
        if (extraShot) {
            basePrice += EXTRA_COST;
        }
        if (extraSyrup) {
            basePrice += EXTRA_COST;
        }
        if (getSize() == Size.MEDIUM) {
            basePrice += SIZE_PRICE; // Additional cost for medium size
        } else if (getSize() == Size.LARGE) {
            basePrice += (SIZE_PRICE * 2); // Additional cost for large size
        }
        return basePrice;
    }
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Coffee)) return false;
        Coffee other = (Coffee) obj;
        return super.equals(obj) && this.extraShot == other.extraShot && this.extraSyrup == other.extraSyrup;
    }

	

    public String toString() {
        String extraShotStr = extraShot ? "with extra shot" : "without extra shot";
        String extraSyrupStr = extraSyrup ? "with extra syrup" : "without extra syrup";
        return super.toString() + ", " + extraShotStr + ", " + extraSyrupStr + ", Price: $" + calcPrice();
    }
}
