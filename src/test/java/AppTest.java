import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
}

  @ClassRule
    public static ServerRule server = new ServerRule();

  @Test
  public void rootTest(){
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Restaurants!");
  }

  @Test
  public void successPage(){
    goTo("http://localhost:4567/");
    fill("#restaurantName").with("McDonalds");
    fill("#starNumber").with("5");
    submit(".btn");
    assertThat(pageSource()).contains("Full of Success");
  }

  @Test
  public void restaurantIsDisplayed(){
    goTo("http://localhost:4567/");
    fill("#restaurantName").with("McDonalds");
    fill("#starNumber").with("5");
    submit(".btn");
    click("a", withText("Go Away"));
    assertThat(pageSource()).contains("McDonalds");
  }

  @Test
  public void multipleRestaurantsDisplayed(){
    goTo("http://localhost:4567/");
    fill("#restaurantName").with("McDonalds");
    fill("#starNumber").with("5");
    submit(".btn");
    click("a", withText("Go Away"));
    fill("#restaurantName").with("John");
    fill("#starNumber").with("5");
    submit(".btn");
    click("a", withText("Go Away"));
    assertThat(pageSource()).contains("McDonalds");
    assertThat(pageSource()).contains("John");
  }
}
