import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckoutTest {

  Checkout checkout;
  Customer steve;

  @Before
  public void before(){
    checkout = new Checkout();
    steve = new Customer("Steve", true);
  }

  @Test
  public void testCanAddCustomer(){
    checkout.addCustomer(steve);
    assertEquals( "Steve", checkout.getCustomer().getName() );
  }

}