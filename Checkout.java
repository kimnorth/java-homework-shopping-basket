import java.util.*;

public class Checkout {

  private Customer customer;
  private Integer grandTotal;
  private HashMap<String, Integer> bogofItems;

  public Checkout(){
    this.customer = new Customer("", false);
    this.grandTotal = 0;
    this.bogofItems = new HashMap<String, Integer>();
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
    this.customer.getBasket().addUpBasket();
    Integer bogofDiscount = calculateBOGOF();
    Integer subTotal = this.customer.getBasket().getBasketTotal();
    subTotal -= bogofDiscount;
    this.grandTotal = subTotal;
  }

  public Integer calculateBOGOF(){

    populateBogofItems();
    Integer discount = calculateBOGOFTotalDiscount();
    return discount;

  }

  public void populateBogofItems(){

    for ( Product product : this.customer.getBasket().getBasketItems() ){

      if ( product.getBogof().equals(true) ){
        if ( !this.bogofItems.containsKey(product.getName()) ) {
            this.bogofItems.put(product.getName(), 1);
        } 
        else {
          this.bogofItems.put(product.getName(), this.bogofItems.get(product.getName()) + 1);
        }
      }
    }

  }

  // Loops through customer's basket
  // Gets the number of items to see how many bogof deals there are
  // if the bogof listing for that item only has 1, loops onto next item in cutomer basket
  // if the bogof listening for that item is even, it sets the total bogof item up by half the total price of the bogof items in the list
  // but it then goes on to the next item in the basket and does the same again!
  // so how do we stop that happening? Delete the item from the bogof list?

  // maybe just delete it from the list of bogof items? We'll only need the list once.

  public Integer calculateBOGOFTotalDiscount(){

    Integer bogofTotalDiscount = 0;

    for ( Product product : this.customer.getBasket().getBasketItems() ){

      int bogofItemValue = bogofItems.get(product.getName());

      if (bogofItemValue == 1){
        continue;
      }
      else if (bogofItemValue % 2 == 0){
        bogofTotalDiscount += ( (product.getPrice() * bogofItemValue) / 2 ); 
        this.bogofItems.put(product.getName(), 1);
      }
      else if (bogofItemValue % 2 != 0){
        
        Integer numberOfApplicableItems = (bogofItemValue - 1);
        bogofTotalDiscount += ( (product.getPrice() * numberOfApplicableItems ) / 2 );
        this.bogofItems.put(product.getName(), 1);
      }

    }

    return bogofTotalDiscount;

  }

}