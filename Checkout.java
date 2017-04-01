public class Checkout {

  private Customer customer;

  public Checkout(){
    this.customer = new Customer("", false);
  }

  public void addCustomer(Customer passedCustomer){
    customer = passedCustomer;
  }

  public Customer getCustomer(){
    return this.customer;
  }

}