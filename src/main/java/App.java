import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("restaurants", request.session().attribute("restaurants"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/restaurants", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Restaurant> restaurants = request.session().attribute("restaurants");

      if(restaurants == null) {
        restaurants = new ArrayList<Restaurant>();
        request.session().attribute("restaurants", restaurants);
      }

      String restName = request.queryParams("restaurantName");
      Integer restStars = Integer.parseInt(request.queryParams("starNumber"));
      Restaurant newRestaurant = new Restaurant(restName, restStars);
      //restaurants is the arraylist
      restaurants.add(newRestaurant);
      request.session().attribute("restaurants", restaurants);

      model.put("template", "templates/success.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
