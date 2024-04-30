/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: beverage class works as a blueprint for the child classes known as Coffee, Smoothie, Alcohol
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gianpaulo Cruz
*/
package Power;

public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	
	protected static final double BASE_PRICE = 2.0;
	private static final double SIZE_PRICE = 0.5;
	
	Beverage(String name, Type type, Size size){
	    this.bevName = name;
	    this.type = type;
	    this.size = size;
	}
	
	public String getName() {
		return bevName;
	}
	
	public void setName(String name) {
		this.bevName = name;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	public double getSizePrice() {
		return SIZE_PRICE;
	}
	
	public void addSizePrice() {
		 switch (size) {
	     	case MEDIUM:
	     		setBasePrice(BASE_PRICE + SIZE_PRICE);
	     		break;
	        case LARGE:
	        setBasePrice(BASE_PRICE + (SIZE_PRICE * 2));
	        	break;
	        default:
	        setBasePrice(BASE_PRICE);
	        break;
		 }
	}

	private void setBasePrice(double baseprice) {
		baseprice = BASE_PRICE;
	}

	public abstract double calcPrice();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Beverage)) return false;
        Beverage other = (Beverage) obj;
        return this.bevName.equals(other.bevName) &&
               this.type == other.type &&
               this.size == other.size;
    }
	
	@Override
	public String toString() {
		return "Beverage: " + bevName + " (" + size + ")";
	}
}
