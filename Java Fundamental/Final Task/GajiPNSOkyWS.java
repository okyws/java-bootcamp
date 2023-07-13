import java.util.HashMap;
import java.util.Scanner;

/*
 * Created By : Oky Wahyu Setyaji
 * Created At : Jam Hari, xx - July - 2023
 */

public class GajiPNSOkyWS {
  public static void main(String[] args) {
    // inisialisasi variabel dan scanner
    int masaKerja, golonganPangkat, gajiPokok, jumlahAnak, tunjanganAnak, tunjanganKeluarga,
        tunjanganBeras, tunjanganUmumJabatan, gajiKotor, potonganPPH, potonganIWP, potonganTaperum, gajiBersih;
    String nama, statusPernikahan, tipeGolongan;
    Scanner input = new Scanner(System.in);

    // deklarasi variabel
    System.out.println("Input Nama: ");
    nama = input.nextLine();
    System.out.println("Input Masa Kerja: ");
    masaKerja = Integer.valueOf(input.nextLine());
    System.out.println("Input Tipe Golongan: A s/d E ");
    tipeGolongan = input.nextLine();
    System.out.println("Input Golongan Pangkat: ");
    golonganPangkat = Integer.valueOf(input.nextLine());

    // gajiPokok = kalkulasiGajiPokok(masaKerja, tipeGolongan, golonganPangkat);

    // menampilkan semua output
    displayOutput(nama);
    System.out.println("masaKerja" + getMasaKerja(masaKerja));
    System.out.println("tipeGolongan" + getTipeGolongan(tipeGolongan));
    System.out.println("golonganPangkat" + getGolonganPangkat(golonganPangkat));
    input.close();
  }

  // cek apakah nama hanya huruf dan spasi
  public static boolean isAllLetters(String nama) {
    return nama.chars().allMatch(c -> Character.isLetter(c) || c == ' ');
  }

  // menampilkan nama
  public static String getName(boolean isAllLetters, String nama) {
    nama = isAllLetters(nama) ? nama : "Nama harus huruf Alphabet!!!";
    return String.format("Nama: %s", nama);
  }

  public static int getMasaKerja(int masaKerja) {
    int lamaMasaKerja = 0;
    int[] dataMasaKerja = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
        26, 27, 28, 29, 30, 31, 32, 33 };
    lamaMasaKerja = dataMasaKerja[masaKerja - 1];

    return lamaMasaKerja;
  }

  public static String getTipeGolongan(String tipeGolongan) {
    HashMap<Character, Integer> groupSubTypes = new HashMap<>();
    groupSubTypes.put('A', 1);
    groupSubTypes.put('B', 2);
    groupSubTypes.put('C', 3);
    groupSubTypes.put('D', 4);
    groupSubTypes.put('E', 5);

    if (tipeGolongan.length() != 1) {
      return "Input Error!!!";
    }

    char subGroup = tipeGolongan.charAt(0);
    if (!groupSubTypes.containsKey(subGroup)) {
      return "Input Error!!!";
    }

    return tipeGolongan;
  }

  public static int getGolonganPangkat(int golonganPangkat) {
    int hasilGolonganPangkat = 0;
    int[] dataGolonganPangkat = { 1, 2, 3, 4 };
    hasilGolonganPangkat = dataGolonganPangkat[golonganPangkat - 1];

    return hasilGolonganPangkat;
  }

  public static int kalkulasiGajiPokok(int masaKerja, String tipeGolongan, int golonganPangkat) {

    return 0;
  }

  public static int kalkulasiTunjanganKeluarga(String statusPernikahan, int gajiPokok) {
    return 0;
  }

  public static int kalkulasiTunjanganAnak(int jumlahAnak, int gajiPokok) {
    return 0;
  }

  public static int kalkulasiTunjanganBeras(String statusPernikahan, int jumlahAnak) {
    return 0;
  }

  public static int kalkulasiTunjanganUmumJabatan(int golonganPangkat) {
    return 0;
  }

  public static int kalkulasiGajiKotor(int gajiPokok, int tunjanganAnak, int tunjanganKeluarga,
      int tunjanganUmumJabatan, int tunjanganBeras) {
    return 0;
  }

  public static int kalkulasiPotonganPPH(int gajiPokok, String statusPernikahan, int gajiKotor, int jumlahAnak,
      int tunjanganKeluarga, int tunjanganAnak) {
    return 0;
  }

  public static int kalkulasiPotonganIWP(int gajiPokok, int tunjanganAnak, int tunjanganKeluarga) {
    return 0;
  }

  public static int kalkulasiPotonganTaperum(int golonganPangkat) {
    return 0;
  }

  public static int kalkulasiGajiBersih(int gajiKotor, int potonganPPH, int potonganIWP, int potonganTaperum) {
    return 0;
  }

  public static void displayOutput(String nama
  // int gajiPokok, int tunjanganKeluarga, int tunjanganAnak,
  // int tunjanganBeras, int tunjanganUmumJabatan, int gajiKotor, int potonganPPH,
  // int potonganIWP,
  // int potonganTaperum, int gajiBersih
  ) {
    System.out.println(getName(isAllLetters(nama), nama));
  }

}
