public class TunjanganAnak {
  public static void main(String[] args) {
    System.out.println(kalkulasiTunjanganAnak(2, 1000000));
    System.out.println(kalkulasiTunjanganAnak(1, 1000000));
    System.out.println(kalkulasiTunjanganAnak(5, 1000000));
  }

  public static int kalkulasiTunjanganAnak(int jumlahAnak, int gajiPokok) {
    int result = 0;
    int maxJumlahAnak = 2;

    if (jumlahAnak > 2) {
      result = (int) (0.02 * gajiPokok * maxJumlahAnak);
    } else if (jumlahAnak > 0 && jumlahAnak <= maxJumlahAnak) {
      result = (int) (0.02 * gajiPokok * jumlahAnak);
    }

    return result;
  }
}
