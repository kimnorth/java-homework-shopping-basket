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
    Integer over20Discount = calculate20Discount(subTotal);
    subTotal -= over20Discount;
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
      else if (product.getBogof().equals(false)){
        continue;
      }
    }

  }

  public Integer calculateBOGOFTotalDiscount(){
    Integer bogofTotalDiscount = 0;
    for ( Product product : this.customer.getBasket().getBasketItems() ){
      if ( bogofItems.get(product.getName()) != null ){
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
  }
    return bogofTotalDiscount;
  }

  public Integer calculate20Discount(Integer subTotal){

    if (subTotal > 2000){
      Double subTotalToDouble = subTotal.doubleValue();
      Double doubleSubTotal = subTotalToDouble * 0.1;
      Integer discount = doubleSubTotal.intValue();
      return discount;
    }
    else {
      return 0;
    }
  }

}