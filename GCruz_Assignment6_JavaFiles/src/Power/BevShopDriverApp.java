/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: User friendly interface to aid in ordering beverages
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gianpaulo Cruz
*/

package Power;

import java.util.Scanner;

public class BevShopDriverApp {
	
	public static Size sizeChecker(String size, Size size1){
		if(size.equals("SMALL")) {
			return size1 = Size.SMALL;
		}else if(size.equals("MEDIUM")) {
			return size1 = Size.MEDIUM;
		}else if(size.equals("LARGE")) {
			return size1 = Size.LARGE;
		}
		return size1;
	}
	
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Welcome to Bradley's Beverage Shop!\nWhich beverage are you looking to order today?");
    	System.out.println("1. Alcohol");
    	System.out.println("2. Coffee");
    	System.out.println("3. Smoothie");
    	
    	System.out.print("Choice: ");
    	int choice1 = input.nextInt();
    	if(choice1 <= 3 && choice1 > 0) {
    		switch(choice1) {
    		case 1: AlcoholOrder();
    			break;
    		case 2: CoffeeOrder();
    			break;
    		case 3: SmoothieOrder();
    			break;
    			default: System.out.println("Thank you for your time");
    		}
    	}else{
    		return;
    	}
    	
    	input.close();
    	
    }
    
    @SuppressWarnings("resource")
	public static void AlcoholOrder() {
    	
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        
        System.out.println("\nWelcome to our alcoholic beverage section.");
        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");
        
        boolean continueOrdering = true;
        
        System.out.println("Would you like to start a new order?(yes/no)");
        String responsee = scanner.nextLine();
        if (responsee.equalsIgnoreCase("yes")) {
            continueOrdering = true;
        } else {
        	System.out.print("Thank you for your time. Have a nice day");
            continueOrdering = false;
            return;
        }
        
        BevShop bevShop = new BevShop();

        while (continueOrdering) {
        	System.out.println("Starting new order:");
            System.out.print("Your Total Order for now is " + total + "\n");
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();
            
            System.out.print("Would you please enter your age: ");
            int age = scanner.nextInt();
            
            scanner.nextLine();
            
            bevShop.startNewOrder(12, Day.MONDAY, name, age);

            if (bevShop.isValidAge(age)) {
                System.out.println("Your age is above 20 and you are eligible to order alcohol");
                
                int alcoholCount = 0;

                while (alcoholCount < bevShop.getMaxOrderForAlcohol()) {
                    System.out.println("Would you like to add an alcoholic beverage to your order? (yes/no)");
                    String choice = scanner.nextLine().toLowerCase();
                    
                    if (!choice.equals("yes")) {
                        break;
                    }

                    System.out.println("What alcoholic beverage would you like to add?");
                    String AD = scanner.nextLine();
                    
                    System.out.println("What size (Small/Medium/Large)?");
                    String sizeOfDrink = scanner.nextLine().toUpperCase();
                    Size size = Size.valueOf(sizeOfDrink);
                    
                    bevShop.processAlcoholOrder(AD, size);
                    alcoholCount++;

                    
                    System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                    System.out.println("The Total price on the Order is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
                }
                
                if (alcoholCount == bevShop.getMaxOrderForAlcohol()) {
                    System.out.println("You have reached the maximum limit for alcohol drinks in this order.");
                }
            } else {
                System.out.println("Your Age is not appropriate for an alcoholic beverage!!");
            }

            System.out.println("Do you want to place an entire new order? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                continueOrdering = true;
            } else {
                continueOrdering = false;
            }
        }

        System.out.println("Thank you for ordering!");
        scanner.close();	
    }
    
    @SuppressWarnings("resource")
	public static void CoffeeOrder() {
    	
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        
        System.out.println("\nWelcome to our coffee beverage section.\n");
        
        boolean continueOrdering = true;
        
        System.out.println("Would you like to start a new order?(yes/no)");
        String responsee = scanner.nextLine();
        if (responsee.equalsIgnoreCase("yes")) {
            continueOrdering = true;
        } else {
        	System.out.print("Thank you for your time. Have a nice day");
            continueOrdering = false;
            return;
        }
        
        BevShop bevShop = new BevShop();

        while (continueOrdering) {
        	System.out.println("Starting new order:");
            System.out.print("Your Total Order for now is " + total + "\n");
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();
            
            System.out.print("Would you please enter your age: ");
            int age = scanner.nextInt();
            
            scanner.nextLine();
            
            bevShop.startNewOrder(12, Day.WEDNESDAY, name, age);
                
            while (continueOrdering){
            	System.out.println("Would you like to add a coffee beverage to your order? (yes/no)");
            	String choice = scanner.nextLine().toLowerCase();
                    
            	if (!choice.equals("yes")) {
            		break;
            	}

            	System.out.println("What kind of coffee beverage would you like to add?");
            	String AD = scanner.nextLine();
                    
            	System.out.println("What size (Small/Medium/Large)?");
            	String sizeOfDrink = scanner.nextLine().toUpperCase();
            	Size size = Size.valueOf(sizeOfDrink);
                    
            	boolean extraS = false;
            	boolean extraSy = false;
                    
                System.out.println("Would you like to add an extra Shot?(yes/no)");
                String extraShot = scanner.nextLine().toLowerCase(); 
                    
                System.out.println("Would you like to add extra Syrup?(yes/no)");
                String extraSyrup = scanner.nextLine().toLowerCase(); 
                    
                if(extraShot.equals("yes")) {
                    	extraS = true;
                }
                    
                if(extraSyrup.equals("yes")) {
                    	extraSy = true;
                }

                bevShop.processCoffeeOrder(AD, size, extraS, extraSy);

                System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                System.out.println("The Total price on the Order is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
            }
                
            System.out.println("Do you want to place an entire new order? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
               continueOrdering = true;
            } else {
                continueOrdering = false;
            }
        }

        System.out.println("Thank you for ordering!");
        scanner.close();	
    }
    
    @SuppressWarnings("resource")
	public static void SmoothieOrder() {
    	
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        
        System.out.println("\nWelcome to our smoothie beverage section.\n");
        
        boolean continueOrdering = true;
        
        System.out.println("Would you like to start a new order?(yes/no)");
        String responsee = scanner.nextLine();
        if (responsee.equalsIgnoreCase("yes")) {
            continueOrdering = true;
        } else {
        	System.out.print("Thank you for your time. Have a nice day");
            continueOrdering = false;
            return;
        }
        
        BevShop bevShop = new BevShop();

        while (continueOrdering) {
        	System.out.println("Starting new order:");
            System.out.print("Your Total Order for now is " + total + "\n");
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();
            
            System.out.print("Would you please enter your age: ");
            int age = scanner.nextInt();
            
            scanner.nextLine();
            
            bevShop.startNewOrder(12, Day.FRIDAY, name, age);
                
            while (continueOrdering){
            	System.out.println("Would you like to add a smoothie beverage to your order? (yes/no)");
            	String choice = scanner.nextLine().toLowerCase();
                    
            	if (!choice.equals("yes")) {
            		break;
            	}

            	System.out.println("What kind of smoothie beverage would you like to add?");
            	String AD = scanner.nextLine();
                    
            	System.out.println("What size (Small/Medium/Large)?");
            	String sizeOfDrink = scanner.nextLine().toUpperCase();
            	Size size = Size.valueOf(sizeOfDrink);
                    
         
            	int numFruits;
            	boolean proteinAdded = false;
                    
                System.out.println("How many fruits would you like to add?");
                numFruits = scanner.nextInt(); 
                
                scanner.nextLine();
                    
                System.out.println("Would you like to add protien?(yes/no)");
                String protein = scanner.nextLine().toLowerCase(); 
                    
                if(protein.equals("yes")) {
                	proteinAdded = true;
                }

                bevShop.processSmoothieOrder(AD, size, numFruits, proteinAdded);

                System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                System.out.println("The Total price on the Order is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
            }
                
            System.out.println("Do you want to place an entire new order? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
               continueOrdering = true;
            } else {
                continueOrdering = false;
            }
        }

        System.out.println("Thank you for ordering!");
        scanner.close();	
    }
}

