import java.util.*;

public class Checkout {

  private Customer customer;
  private Integer grandTotal;

  public Checkout(){
    this.customer = new Customer("", false);
    this.grandTotal = 0;
  }

  public void addCustomer(Customer passedCustomer){
    customer = passedCustomer;
  }

  public Customer getCustomer(){
    return this.customer;
  }

  public Integer getGrandTotal(){
    return this.grandTotal;
  }

  public void calculateGrandTotal(){
    Integer subTotal = 0;
    this.customer.getBasket().addUpBasket();
    Integer bogofDiscount = calculateBOGOF();
    subTotal = this.customer.getBasket().getBasketTotal();
    subTotal -= bogofDiscount;
    this.grandTotal = subTotal;
  }

  public Integer calculateBOGOF(){

    // Create a hashmap to track how many double bogof items we have

    HashMap<String, Integer> bogofItems = new HashMap<String, Integer>();

    // Loop through basket and count up how many bogof items there are

    for ( Product product : this.customer.getBasket().getBasketItems() ){

      if ( product.getBogof().equals(true) ){
        if ( !bogofItems.containsKey(product.getName()) ) {
            bogofItems.put(product.getName(), 1);
        } 
        else {
          bogofItems.put(product.getName(), bogofItems.get(product.getName()) + 1);
        }
      }
    }

    // loop through bogofItems. If greater than 1 and even (modulus) find the value of
    // half the items in that bogof entry

    for ( Product product : this.customer.getBasket().getBasketItems() ){

      Integer bogofTotalDiscount = 0;

      if (bogofItems.get(product.getName()).equals(1)){
        continue;
      }
      else if (bogofItems.get(product.getName()) % 2 = 0){
        bogofTotalDiscount += ( (product.getPrice() * bogofItems.get(product.getName()) / 2 )); 
        // total + individual item price times number of items with doubles, divided by 2
      }
      else if ((bogofItems.get(product.getName())) % 2 != 0){
        // store the number of bogof items -1
        
        Integer numberOfApplicableItems = (bogofItems.get(product.getName()) - 1);

        // do the sum above for that number

        bogofTotalDiscount += ( (product.getPrice() * numberOfApplicableItems ) / 2 );

      }

      return bogofTotalDiscount;

    }



  // Currently halving the price even if only one BOGOF product - need to setup a counter
  // for each BOGOF item and do it on the second

  }

}