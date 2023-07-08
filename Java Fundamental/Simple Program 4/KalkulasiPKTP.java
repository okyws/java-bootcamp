public class KalkulasiPKTP {
  public static void main(String[] args) {
    System.out.println(kalkulasiPTKP("Kawin", 1));
    System.out.println(kalkulasiPTKP("Belum Kawin", 0));
  }

  public static int kalkulasiPTKP(String statusPernikahan, int jumlahAnak) {
    int anak = 0;
    int biayaPerAnak = 3000000;
    int kawin = 0;
    int maxJumlahAnak = 3;
    int pegawai = 36000000;
    int result = 0;

    if (statusPernikahan.equalsIgnoreCase("Kawin")) {
      kawin = 3000000;
    }

    if (jumlahAnak > maxJumlahAnak) {
      anak = maxJumlahAnak * biayaPerAnak;
    } else {
      anak = jumlahAnak * biayaPerAnak;
    }

    result = pegawai + kawin + anak;

    return result;
  }
}
