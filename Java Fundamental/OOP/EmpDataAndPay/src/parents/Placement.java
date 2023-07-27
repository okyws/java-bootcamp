package parents;

import java.util.LinkedHashMap;
import java.util.Map;
import interfaces.IUMKProvider;

public class Placement implements IUMKProvider {
  private static final Map<String, Double> cityUMK = new LinkedHashMap<>();
  private String city;

  static {
    cityUMK.put("Garut", 1961085.0);
    cityUMK.put("Bandung", 3742276.0);
    cityUMK.put("Jakarta", 4453935.0);
    cityUMK.put("Bekasi", 4782935.0);
    cityUMK.put("Bogor", 4330249.0);
    cityUMK.put("1", 1000000.0);
  }

  public Placement() {
    super();
  }

  public Placement(String city) {
    super();
    this.city = city;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public double getUMK() {
    return cityUMK.get(city);
  }

  public static Map<String, Double> getAllUMK() {
    cityUMK.forEach((city, umk) -> {
      System.out.println(city + " : " + umk);
    });
    return cityUMK;
  }
}
