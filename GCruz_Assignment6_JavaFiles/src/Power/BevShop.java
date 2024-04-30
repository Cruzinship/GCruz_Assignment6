/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: BevShop
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

public class BevShop implements BevShopInterface {
    // Instance variable
    private ArrayList<Order> orders;

    // Constructor
    public BevShop() {
        this.orders = new ArrayList<>();
    }

    // Interface methods
    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return getNumOfAlcoholDrink() < getMaxOrderForAlcohol();
    }

    @Override
    public int getNumOfAlcoholDrink() {
        if (orders.isEmpty()) return 0;
        return orders.get(orders.size() - 1).findNumOfBeveType(Type.ALCOHOL);
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        orders.add(new Order(time, day, new Customer(customerName, customerAge)));
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        getCurrentOrder().addNewBeverage(bevName, size);
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            Order order = orders.get(index);
            double total = 0;
            for (int i = 0; i < order.getTotalItems(); i++) {
                Beverage beverage = order.getBeverage(i);
                if (beverage != null) {
                	total += beverage.calcPrice();
                }
            }
            return total;
        }
        return 0;
    }



    @Override
    public double totalMonthlySale() {
        double totalSale = 0;
        for (Order order : orders) {
            totalSale += order.calcOrderTotal();
        }
        return totalSale;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        if (orders.isEmpty()) {
            return null;
        }
        return orders.get(orders.size() - 1);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    @Override
    public void sortOrders() {
        // Using selection sort algorithm to sort orders by order number
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
                    minIndex = j;
                }
            }
            Order temp = orders.get(minIndex);
            orders.set(minIndex, orders.get(i));
            orders.set(i, temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monthly Sale: $").append(totalMonthlySale()).append("\n");
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        return sb.toString();
    }
}
