/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Creates Alcohol attributes used in taking orders
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gianpaulo Cruz
*/

package Power;

public class Alcohol extends Beverage {
    private static final double WEEKEND_COST = 0.6;
	private static final double SIZE_PRICE = 0.5;

    private boolean offeredInWeekend;

    public Alcohol(String bevName, Size size, boolean offeredInWeekend) {
        super(bevName, Type.ALCOHOL , size);
        this.offeredInWeekend = offeredInWeekend;
    }

    public Alcohol(String bevName, Size size) {
        super(bevName, null, size);
    }

    @Override
    public String toString() {
        return super.toString() + ", Offered in Weekend: " + offeredInWeekend + ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Alcohol)) return false;
        Alcohol other = (Alcohol) obj;
        return super.equals(obj) && this.offeredInWeekend == other.offeredInWeekend;
    }

    @Override
    public double calcPrice() {
        double totalPrice = BASE_PRICE;
        if (offeredInWeekend) {
            totalPrice += WEEKEND_COST;
        }
        if (getSize() != null) {
            switch (getSize()) {
                case MEDIUM:
                    totalPrice += SIZE_PRICE;
                    break;
                case LARGE:
                    totalPrice += SIZE_PRICE * 2; 
                    break;
                default:
                    break; 
            }
        }
        return totalPrice;
    }

    public boolean isOfferedInWeekend() {
        return offeredInWeekend;
    }

    public void setOfferedInWeekend(boolean offeredInWeekend) {
        this.offeredInWeekend = offeredInWeekend;
    }
}