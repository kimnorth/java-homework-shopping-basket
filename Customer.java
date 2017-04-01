public class Customer {

  private String name;
  private Boolean loyaltyCard;

  public Customer(String name, Boolean loyaltyCard) {
    this.name = name;
    this.loyaltyCard = loyaltyCard;
  }

  public String getName(){
    return this.name;
  }

  public Boolean getLoyaltyCard(){
    return this.loyaltyCard;
  }

}