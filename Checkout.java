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
    subTotal = this.customer.getBasket().getBasketTotal();
    this.grandTotal = subTotal;
  }

}