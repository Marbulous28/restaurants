public class Restaurant{
  private String mName;
  private Integer mStars;

  public Restaurant(String name, Integer stars){
    mName = name;
    mStars = stars;
  }

  public String getName() {
    return mName;
  }

  public Integer getStars() {
    return mStars;
  }
}
