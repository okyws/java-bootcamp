public class TunjanganKeluarga {
  public static void main(String[] args) {
    System.out.println(kalkulasiTunjanganKeluarga("Kawin", 1000000));
    System.out.println(kalkulasiTunjanganKeluarga("kawin", 2000000));
    System.out.println(kalkulasiTunjanganKeluarga("Belum Kawin", 1000000));
  }

  public static int kalkulasiTunjanganKeluarga(String statusPernikahan, int gajiPokok) {
    int result = 0;

    if (statusPernikahan.equalsIgnoreCase("Kawin")) {
      result = (int) (0.1 * gajiPokok);
    }

    return result;
  }
}
