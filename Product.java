public class Product {

  private String name;
  private Integer price;
  private Boolean bogof;

  public Product(String name, Integer price, Boolean bogof){
    this.name = name;
    this.price = price;
    this.bogof = bogof;
  }

  public String getName(){
    return this.name;
  }

  public Integer getPrice(){
    return this.price;
  }

  public void halfPrice(){
    this.price = (this.price / 2);
  }

  public Boolean getBogof(){
    return this.bogof;
  }

  public void setBogof(Boolean adjustBogof){
    this.bogof = adjustBogof;
  }

}