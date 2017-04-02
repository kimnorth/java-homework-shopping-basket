import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckoutTest {

  Checkout checkout;
  Customer steve;
  ShoppingBasket basket;
  Product milk;
  Product milk2;

  @Before
  public void before(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
    basket = new ShoppingBasket();
    milk = new Product("Milk", 400, true);
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

}