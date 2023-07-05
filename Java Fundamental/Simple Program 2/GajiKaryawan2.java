import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class GajiKaryawan2 {

  private static final int UMKBARUTT = 1961085;
  private static final int UMKBANDUNG = 3742276;
  private static final int UMKJAKARTA = 4453935;
  private static final int UMKBEKASI = 4782935;
  private static final int UMKBOGOR = 4330249;
  private static final int UMKPALEMBANG = 3289409;

  private static final Map<String, Integer> TUNJANGAN_PEGAWAI = new HashMap<>();

  static {
    TUNJANGAN_PEGAWAI.put("Admin", 200000);
    TUNJANGAN_PEGAWAI.put("Coordinator", 500000);
    TUNJANGAN_PEGAWAI.put("SPV", 700000);
    TUNJANGAN_PEGAWAI.put("Sprinter", 200000);
    TUNJANGAN_PEGAWAI.put("Officer", 200000);
    TUNJANGAN_PEGAWAI.put("Manager", 1000000);
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
    int tunjanganPegawai = TUNJANGAN_PEGAWAI.get(posisi);
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

  private static int getUMK(String cabang) {
    int umk = 0;
    switch (cabang) {
      case "Garut":
        umk = UMKBARUTT;
        break;
      case "Bandung":
        umk = UMKBANDUNG;
        break;
      case "Jakarta":
        umk = UMKJAKARTA;
        break;
      case "Bekasi":
        umk = UMKBEKASI;
        break;
      case "Bogor":
        umk = UMKBOGOR;
        break;
      case "Palembang":
        umk = UMKPALEMBANG;
        break;
      default:
        System.out.println("Cabang tidak valid.");
        break;
    }
    return umk;
  }

  private static int hitungGajiPokok(String posisi, int lamaBekerja, int umk) {
    int gajiPokok = 0;
    switch (posisi) {
      case "Admin":
      case "ADMIN":
      case "admin":
        if (lamaBekerja < 2) {
          gajiPokok = umk;
        } else {
          gajiPokok = (int) (umk * 1.2);
        }
        break;
      case "Coordinator":
      case "COORDINATOR":
      case "coordinator":
        if (lamaBekerja < 3) {
          gajiPokok = (int) (umk * 1.1);
        } else {
          gajiPokok = (int) (umk * 1.3);
        }
        break;
      case "SPV":
      case "spv":
      case "Spv":
        if (lamaBekerja < 2) {
          gajiPokok = (int) (umk * 1.25);
        } else if (lamaBekerja >= 2 && lamaBekerja <= 4) {
          gajiPokok = (int) (umk * 1.4);
        } else {
          gajiPokok = (int) (umk * 1.5);
        }
        break;
      case "Sprinter":
      case "sprinter":
      case "SPRINTER":
        gajiPokok = (int) (umk * 0.9);
        break;
      case "Officer":
      case "officer":
      case "OFFICER":
        gajiPokok = umk;
        break;
      case "Manager":
      case "manager":
      case "MANAGER":
        if (lamaBekerja < 3) {
          gajiPokok = (int) (umk * 1.5);
        } else {
          gajiPokok = (int) (umk * 2);
        }
        break;
      default:
        System.out.println("Posisi jabatan tidak valid.");
        break;
    }
    return gajiPokok;
  }

  private static int hitungTunjanganKeluarga(int gajiPokok, boolean statusPernikahan) {
    int tunjanganKeluarga = 0;
    if (statusPernikahan) {
      tunjanganKeluarga = (int) (gajiPokok * 0.1);
    }
    return tunjanganKeluarga;
  }

  private static int hitungTunjanganJabatan(String posisi, int lamaBekerja, int gajiPokok) {
    int tunjanganJabatan = 0;
    if (lamaBekerja > 4) {
      switch (posisi) {
        case "Admin":
        case "ADMIN":
        case "admin":
          tunjanganJabatan = (int) (gajiPokok * 0.05);
          break;
        case "Coordinator":
        case "COORDINATOR":
        case "coordinator":
          tunjanganJabatan = (int) (gajiPokok * 0.05);
          break;
        case "SPV":
        case "spv":
        case "Spv":
          tunjanganJabatan = (int) (gajiPokok * 0.05);
          break;
        case "Sprinter":
        case "sprinter":
        case "SPRINTER":
          tunjanganJabatan = 0;
          break;
        case "Officer":
        case "officer":
        case "OFFICER":
          tunjanganJabatan = 0;
          break;
        case "Manager":
        case "manager":
        case "MANAGER":
          tunjanganJabatan = (int) (gajiPokok * 0.05);
          break;

        default:
          System.out.println("Posisi jabatan tidak valid.");
          break;
      }
    }
    return tunjanganJabatan;
  }

  private static int hitungGajiKotor(int gajiPokok, int tunjanganKeluarga, int tunjanganJabatan, int tunjanganPegawai) {
    return gajiPokok + tunjanganKeluarga + tunjanganJabatan + tunjanganPegawai;
  }

  private static int hitungPotonganPensiun(int gajiKotor) {
    return (int) (gajiKotor * 0.02);
  }

  private static int hitungPotonganBPJS(int gajiKotor) {
    return (int) (gajiKotor * 0.02);
  }

  private static int hitungPotonganPPH(int gajiKotor) {
    return (int) (gajiKotor * 0.05);
  }

  private static int hitungGajiBersih(int gajiKotor, int potonganPensiun, int potonganBPJS, int potonganPPH) {
    return gajiKotor - potonganPensiun - potonganBPJS - potonganPPH;
  }
}
