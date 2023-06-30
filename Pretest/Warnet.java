import java.util.Scanner;

public class Warnet {

  // Konstanta
  public static final int TARIF_REGULER = 5000;
  public static final int TARIF_VIP = 7000;
  public static final int HARGA_PAKET_MALAM_REGULER = 20000;
  public static final int HARGA_PAKET_MALAM_VIP = 30000;

  public static void main(String[] args) {
    // Deklarasi variabel
    int jam, biaya;
    int vip;
    boolean member, paketMalam;

    Scanner input = new Scanner(System.in);

    // Input data
    System.out.println("Selamat datang di warnet Cihampelas!");
    System.out.println("Apakah Anda menggunakan PC vip? (0 untuk reguler, 1 untuk vip)");
    vip = input.nextInt();
    System.out.println("Apakah Anda menjadi member warnet? (true/false)");
    member = input.nextBoolean();
    System.out.println("Berapa lama Anda bermain? (dalam jam)");
    jam = input.nextInt();
    System.out.println("Apakah Anda bermain di dalam paket malam? (true/false)");
    paketMalam = input.nextBoolean();

    // Proses perhitungan biaya
    if (paketMalam) {
      // Jika bermain di dalam paket malam, biaya terdiri dari harga paket ditambah
      // tarif reguler atau vip untuk jam-jam di luar paket
      biaya = vip == 1 ? HARGA_PAKET_MALAM_VIP : HARGA_PAKET_MALAM_REGULER;
      // Jika bermain lebih dari 7 jam, maka ada jam-jam di luar paket malam yang
      // harus dibayar dengan tarif reguler atau vip
      if (jam > 7) {
        biaya += (jam - 7) * (vip == 1 ? TARIF_VIP : TARIF_REGULER);
        // Jika menjadi member, ada bonus gratis satu jam setiap kelipatan 3 jam untuk
        // jam-jam di luar paket malam
        if (member) {
          biaya -= ((jam - 7) / 3) * (vip == 1 ? TARIF_VIP : TARIF_REGULER); // Mengurangi bonus gratis dari biaya total
        }
      }
    } else {
      // Jika bermain di luar paket malam, biaya tergantung jam dan jenis PC
      // Menggunakan switch-case untuk menangani kasus-kasus yang berbeda
      switch (vip) {
        case 1:
          biaya = jam * TARIF_VIP;
          break;
        case 0:
          biaya = jam * TARIF_REGULER;
          break;
        default:
          biaya = 0;
          break;
      }

      // Jika menjadi member, ada bonus gratis satu jam setiap kelipatan 3 jam untuk
      // jam-jam di luar paket malam
      if (member) {
        biaya -= (jam / 3) * (vip == 1 ? TARIF_VIP : TARIF_REGULER); // Mengurangi bonus gratis dari biaya total
      }
    }

    // Output hasil
    System.out.println("Biaya minimum yang harus Anda bayar adalah Rp. " + biaya);

    input.close();
  }
}
