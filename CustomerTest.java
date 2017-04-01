import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class CustomerTest {

  Customer steve;

  @Before
  public void before(){

    steve = new Customer("Steve", true);

  }

  @Test
  public void canGetName(){
    assertEquals( "Steve", steve.getName() );
  }

  @Test
  public void canGetLoyaltyCard(){
    assertEquals(true, steve.getLoyaltyCard() );
  }

}