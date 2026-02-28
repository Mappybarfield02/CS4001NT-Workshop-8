public class KhanaGhar
{//attributes
 String itemName;
 int price;
 String category;
 boolean isVegetarian;
 boolean isAvailable;
 //constructor
public KhanaGhar(String name, int price, String category, boolean veg, boolean available){
    this.itemName = name;
    this.price = price;
    this.category = category;
    this.isVegetarian = veg;
    this.isAvailable = available;
}
//method
public void displayItem(){
    System.out.printf("%-27s %10s%n",itemName, "Rs."+price);
}
//main method
public static void main(String[] args){
    //creating objects
    KhanaGhar item1 = new KhanaGhar("bhat", 250, "Dal-Bhat", true, true);
    KhanaGhar item2 = new KhanaGhar("Momo", 100, "Momo", false, false);
    KhanaGhar item3 = new KhanaGhar("Dharane Kalo Bungur", 400, "curry", false, true);
    KhanaGhar item4 = new KhanaGhar("Masala Chiya", 15, "Chiya-Nasta", true, true); 
    System.out.println("------------ Dharan KhanaGhar ---------------");
    //printf is print formated it helps to print in formatted way
        //at heading column
        System.out.printf("%-27s %10s%n","Item name","Price");
        
        KhanaGhar[] items = {item1, item2, item3, item4};// array constructs & declare
        //to display menu, accesing value from array. here only itemname and price 
            System.out.printf("%-27s %10s%n", item1.itemName, "Rs."+item1.price);
            System.out.printf("%-27s %10s%n", item2.itemName, "Rs."+item2.price);
            System.out.printf("%-27s %10s%n", item3.itemName, "Rs."+item3.price);
            System.out.printf("%-27s %10s%n", item4.itemName, "Rs."+item4.price);
        System.out.println("==============================================");
        System.out.println("Veg items");
        //again creating an heading column for veg items
        System.out.printf("%-27s %10s%n","Item name","Price");
        // creating kg reference variable to access value from each objects , using enhanced for loop
        for(KhanaGhar kg : items){
            if(kg.isVegetarian == true){//using if statement to check the boolean value
                kg.displayItem();//calling method on object
            }
        }
        System.out.println("==============================================");
        System.out.println("Non-Veg items");
        //creating an heading column 
        System.out.printf("%-27s %10s%n","Item name","Price");
        for(KhanaGhar kg : items){
            if(kg.isVegetarian == false){
            kg.displayItem();
        }
    }
    System.out.println("==============================================");
    //creating an heading column
    System.out.println("Non-Veg items price greater than 100 and available");
    System.out.printf("%-27s %10s%n","Item name","Price");
    for(KhanaGhar kg : items){
        if(kg.isVegetarian == false && kg.price > 100 && kg.isAvailable == true){
            kg.displayItem();
        }
    }
    System.out.println("==============================================");
    System.out.println("Veg items price lesser than 50 and available");
    // creating an heading column
    System.out.printf("%-27s %10s%n","Item name","Price");
    for(KhanaGhar kg : items){
        if(kg.isVegetarian == true && kg.price < 50 && kg.isAvailable == true){
            kg.displayItem();
        }
    }
}
}
