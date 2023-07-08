public class TujanganJabatan {
  public static void main(String[] args) {
    System.out.println(kalkulasiTunjanganUmumJabatan(5));
  }

  public static int kalkulasiTunjanganUmumJabatan(int golonganPangkat) {
    int tunjanganUmumJabatan = 0;

    switch (golonganPangkat) {
      case 1:
        tunjanganUmumJabatan = 175000;
        break;
      case 2:
        tunjanganUmumJabatan = 180000;
        break;
      case 3:
        tunjanganUmumJabatan = 185000;
        break;
      case 4:
        tunjanganUmumJabatan = 190000;
        break;
      default:
        tunjanganUmumJabatan = 0;
    }

    return tunjanganUmumJabatan;
  }
}
