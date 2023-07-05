import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GajiKaryawan3 {
  private static final Map<String, Integer> umkMap = new HashMap<>();

  static {
    umkMap.put("Garut", 1961085);
    umkMap.put("Bandung", 3742276);
    umkMap.put("Jakarta", 4453935);
    umkMap.put("Bekasi", 4782935);
    umkMap.put("Bogor", 4330249);
    umkMap.put("Palembang", 3289409);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Masukkan cabang perusahaan: ");
    String cabang = scanner.nextLine();

    System.out.print("Masukkan posisi jabatan: ");
    String posisi = scanner.nextLine();

    System.out.print("Masukkan lama bekerja (dalam tahun): ");
    int lamaBekerja = scanner.nextInt();

    System.out.print("Apakah karyawan sudah menikah? (true/false): ");
    boolean statusPernikahan = scanner.nextBoolean();
    scanner.close();

    int umk = getUMK(cabang);
    int gajiPokok = hitungGajiPokok(posisi, lamaBekerja, umk);
    int tunjanganKeluarga = hitungTunjanganKeluarga(gajiPokok, statusPernikahan);
    int tunjanganJabatan = hitungTunjanganJabatan(posisi, lamaBekerja, gajiPokok);
    int tunjanganPegawai = hitungTunjanganPegawai(posisi);
    int gajiKotor = hitungGajiKotor(gajiPokok, tunjanganKeluarga, tunjanganJabatan, tunjanganPegawai);
    int potonganPensiun = hitungPotonganPensiun(gajiKotor);
    int potonganBPJS = hitungPotonganBPJS(gajiKotor);
    int potonganPPH = hitungPotonganPPH(gajiKotor);
    int gajiBersih = hitungGajiBersih(gajiKotor, potonganPensiun, potonganBPJS, potonganPPH);

    System.out.println("Gaji Pokok: " + gajiPokok);
    System.out.println("Tunjangan Keluarga: " + tunjanganKeluarga);
    System.out.println("Tunjangan Jabatan: " + tunjanganJabatan);
    System.out.println("Tunjangan Pegawai: " + tunjanganPegawai);
    System.out.println("Gaji Kotor: " + gajiKotor);
    System.out.println("Potongan Pensiun: " + potonganPensiun);
    System.out.println("Potongan BPJS: " + potonganBPJS);
    System.out.println("Potongan PPH: " + potonganPPH);
    System.out.println("Gaji Bersih: " + gajiBersih);
  }

  public static int getUMK(String cabang) {
    Integer umk = umkMap.get(cabang);
    if (umk == null) {
      System.out.println("Cabang tidak valid.");
      System.exit(1);
    }
    return umk;
  }

  public static int hitungGajiPokok(String posisi, int lamaBekerja, int umk) {
    double multiplier;
    switch (posisi) {
      case "Admin":
        multiplier = lamaBekerja < 2 ? 1.0 : 1.2;
        break;
      case "Coordinator":
        multiplier = lamaBekerja < 3 ? 1.1 : 1.3;
        break;
      case "SPV":
        if (lamaBekerja < 2)
          multiplier = 1.25;
        else if (lamaBekerja <= 4)
          multiplier = 1.4;
        else
          multiplier = 1.5;
        break;
      case "Sprinter":
        multiplier = 0.9;
        break;
      case "Officer":
        multiplier = 1.0;
        break;
      case "Manager":
        multiplier = lamaBekerja < 3 ? 1.5 : 2.0;
        break;
      default:
        System.out.println("Posisi jabatan tidak valid.");
        System.exit(1);
        return 0;
    }
    return (int) (umk * multiplier);
  }

  public static int hitungTunjanganKeluarga(int gajiPokok, boolean statusPernikahan) {
    return statusPernikahan ? (int) (gajiPokok * 0.1) : 0;
  }

  public static int hitungTunjanganJabatan(String posisi, int lamaBekerja, int gajiPokok) {
    if (lamaBekerja > 4) {
      switch (posisi) {
        case "Admin":
        case "Coordinator":
        case "SPV":
        case "Manager":
          return (int) (gajiPokok * 0.05);
        case "Sprinter":
        case "Officer":
          return 0;
        default:
          System.out.println("Posisi jabatan tidak valid.");
          System.exit(1);
          return 0;
      }
    }
    return 0;
  }

  public static int hitungTunjanganPegawai(String posisi) {
    switch (posisi) {
      case "Admin":
        return 200000;
      case "Coordinator":
        return 500000;
      case "SPV":
        return 700000;
      case "Sprinter":
      case "Officer":
        return 200000;
      case "Manager":
        return 1000000;
      default:
        System.out.println("Posisi jabatan tidak valid.");
        System.exit(1);
        return 0;
    }
  }

  public static int hitungGajiKotor(int gajiPokok, int tunjanganKeluarga, int tunjanganJabatan, int tunjanganPegawai) {
    return gajiPokok + tunjanganKeluarga + tunjanganJabatan + tunjanganPegawai;
  }

  public static int hitungPotonganPensiun(int gajiKotor) {
    return (int) (gajiKotor * 0.02);
  }

  public static int hitungPotonganBPJS(int gajiKotor) {
    return (int) (gajiKotor * 0.02);
  }

  public static int hitungPotonganPPH(int gajiKotor) {
    return (int) (gajiKotor * 0.05);
  }

  public static int hitungGajiBersih(int gajiKotor, int potonganPensiun, int potonganBPJS, int potonganPPH) {
    return gajiKotor - potonganPensiun - potonganBPJS - potonganPPH;
  }
}
