public class TrafficLight {
  public String color;
  public int duration;

  // constructor default
  public TrafficLight() {
  }

  // constructor dengan parameter
  public TrafficLight(String color, int duration) {
    this.color = color;
    this.duration = duration;
  }

  // getter dan setter
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  // method / function untuk mengubah warna
  public void changeColor() {
    switch (color) {
      case "Red":
        color = "Green";
        duration = 10;
        break;
      case "Green":
        color = "Yellow";
        duration = 3;
        break;
      default:
        color = "Red";
        duration = 5;
        break;
    }
  }

  // method / funtion untuk menampilkan output sebelum dilakukan perubahan
  public void printInitialTrafficLight() {
    System.out.println("Initial color: " + getColor());
    System.out.println("Initial duration: " + getDuration());
  }

  // method / funtion untuk menampilkan output setelah dilakukan perubahan
  public void printNewTrafficLight() {
    System.out.println("New color: " + getColor());
    System.out.println("New duration: " + getDuration());
  }
}
