/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Aids in taking customer Order
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gianpaulo Cruz
*/

package Power;

import java.util.ArrayList;
import java.util.Random;

public class Order {
	
	private int orderNumber;
	private int orderTime;
	private Day day;
	private Customer c;
	private ArrayList<Beverage> beverages;
	
	public Order(int orderTime, Day Day, Customer c) {
		this.orderNumber = generateOrder();
	    this.orderTime = orderTime;
	    this.day = Day;
	    this.c = c;
	    this.beverages = new ArrayList<>();
	}

	
	public int generateOrder() {
		Random rand = new Random();
	    return rand.nextInt(80001) + 10000;
	}

	public int getOrderNo() {
		return orderNumber;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public Day getOrderDay() {
		return day;
	}

	public Customer getCustomer() {
		return c;
	}

	public boolean isWeekend(Day day) {
		return day == Day.SATURDAY || day == Day.SUNDAY;
	}

	    
	public Beverage getBeverage(int itemNo) {
		if (itemNo >= 0 && itemNo < beverages.size()) {
			return beverages.get(itemNo);
	    }
	        return null;
	}

	public int getTotalItems() {
		return beverages.size();
	}

	    
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, isWeekend(day)));
	}

	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	    
	public double calcOrderTotal() {
	    double total = 0;
	    for (Beverage beverage : beverages) {
	        if (beverage != null) {
	            total += beverage.calcPrice();
	        }
	    }
	    return total;
	}
	

	    public int findNumOfBeveType(Type type) {
	        int count = 0;
	        for (Beverage beverage : beverages) {
	            if (beverage.getType() == type) {
	                count++;
	            }
	        }
	        return count;
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Order Number: ").append(orderNumber).append("\n");
	        sb.append("Order Time: ").append(orderTime).append("\n");
	        sb.append("Order Day: ").append(day).append("\n");
	        sb.append("Customer: ").append(c.toString()).append("\n");
	        sb.append("Beverages:\n");
	        for (Beverage beverage : beverages) {
	            sb.append(beverage.toString()).append("\n");
	        }
	        sb.append("Order Total: ").append(calcOrderTotal()).append("\n");
	        return sb.toString();
	    }

	    public int compareTo(Order anotherOrder) {
	        return Integer.compare(this.orderNumber, anotherOrder.getOrderNo());
	    }
}
