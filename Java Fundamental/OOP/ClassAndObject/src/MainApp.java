public class MainApp {
  public static void main(String[] args) {
    /*
     * Instance Object dengan Constructor Default
     * TrafficLight trafficLight = new TrafficLight();
     * trafficLight.setColor("Red");
     * trafficLight.setDuration(5);
     */

    // Instance Object dengan Constructor Berparameter
    TrafficLight trafficLight = new TrafficLight("Green", 10);

    // Menampilkan output sebelum di ubah
    trafficLight.printInitialTrafficLight();

    // Mengubah warna dan durasinya
    trafficLight.changeColor();

    // Menampilkan output setelah diubah
    trafficLight.printNewTrafficLight();
  }
}
