import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckoutTest {

  Checkout checkout;
  Customer steve;
  ShoppingBasket basket;
  Product milk;
  Product washingPowder;
  Product beerKeg;

  @Before
  public void before(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
    basket = new ShoppingBasket();
    milk = new Product("Milk", 400, true);
    beerKeg = new Product("Beer Keg", 2500, false);
  }

  @Test
  public void testCanAddCustomer(){
    checkout.addCustomer(steve);
    assertEquals( "Steve", checkout.getCustomer().getName() );
  }

  @Test
  public void testGetGrandTotal(){
    checkout.addCustomer(steve);
    Integer expected = 0;
    assertEquals(expected, checkout.getGrandTotal());
  }

  @Test
  public void testCanCalculateGrandTotal(){
    steve.getBasket().addItem(milk);
    checkout.addCustomer(steve);
    checkout.calculateGrandTotal();
    Integer expected = 400;
    assertEquals(expected, checkout.getGrandTotal());
  }

  @Test
  public void testCanCalculateBOGOF(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    checkout.addCustomer(steve);
    checkout.calculateGrandTotal();
    Integer expected = 400;
    assertEquals(expected, checkout.getGrandTotal() );
  }

  @Test
  public void testCanCalculateBOGOFWithOnlyOneItem(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
    steve.getBasket().addItem(milk);
    checkout.addCustomer(steve);
    checkout.calculateGrandTotal();
    Integer expected = 400;
    assertEquals(expected, checkout.getGrandTotal());
  }

  @Test
  public void testCanCalculateBOGOFWithThreeItems(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    checkout.addCustomer(steve);
    checkout.calculateGrandTotal();
    Integer expected = 800;
    assertEquals(expected, checkout.getGrandTotal());
  }

  @Test
  public void testCanCalculateBOGOFWithTenItems(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    checkout.addCustomer(steve);
    checkout.calculateGrandTotal();
    Integer expected = 2000;
    assertEquals(expected, checkout.getGrandTotal());
  }

  @Test
  public void testCanCalculateBOGOFWithMultipleAppicableItems(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
    washingPowder = new Product("Washing Powder", 200, true);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(washingPowder);
    steve.getBasket().addItem(washingPowder);
    checkout.addCustomer(steve);
    checkout.calculateGrandTotal();
    Integer expected = 600;
    assertEquals(expected, checkout.getGrandTotal());
  }

  @Test
  public void testCanCalculateBOGOFWithSomeApplicableSomeNot(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
    washingPowder = new Product("Washing Powder", 200, false);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(milk);
    steve.getBasket().addItem(washingPowder);
    steve.getBasket().addItem(washingPowder);
    checkout.addCustomer(steve);
    checkout.calculateGrandTotal();
    Integer expected = 800;
    assertEquals(expected, checkout.getGrandTotal());
  }

  @Test
  public void testCanTake10PercentOff(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
    steve.getBasket().addItem(beerKeg);
    checkout.addCustomer(steve);
    checkout.calculateGrandTotal();
    Integer expected = 2250;
    assertEquals(expected, checkout.getGrandTotal());
  }

}