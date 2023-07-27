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

  // jika dibutuhkan (untuk menampilkan hasil UMK dari semua kota)
  public static Map<String, Double> getAllUMK() {
    cityUMK.forEach((city, umk) -> {
      System.out.println(city + " : " + umk);
    });
    return cityUMK;
  }

  public Placement getPlacementByCity(String city) {
    for (String placementCity : cityUMK.keySet()) {
      if (placementCity.equalsIgnoreCase(city)) {
        return new Placement(placementCity);
      }
    }
    System.out.println("Placement not found");
    return null;
  }
}
