import org.junit.*;
import static org.junit.Assert.*;

public class RestaurantsTest {
  @Test
  public void Restaurant_instantiatesCorrectly_true() {
    Restaurant newRestaurant = new Restaurant("McDonalds", 5);
    assertEquals(true, newRestaurant instanceof Restaurant);
  }

  @Test
  public void getName_returnsCorrectName_McDonalds() {
    Restaurant newRestaurant = new Restaurant("McDonalds", 5);
    assertEquals("McDonalds", newRestaurant.getName());
  }

  @Test
  public void getStars_returnsCorrectStars_5() {
    Restaurant newRestaurant = new Restaurant("McDonalds", 5);
    Integer five = 5;
    assertEquals(five, newRestaurant.getStars());
  }
}
