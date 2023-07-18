import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created By : Oky Wahyu Setyaji
 * Created At : 21:00 Jumat, 14 - July - 2023
 */

public class GajiPNSOkyWS {
  public static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    String nama, tipeGolongan, statusPernikahan;
    int masaKerja, golonganPangkat, jumlahAnak;
    double gajiKotor, biayaJabatan, iuranPensiun, gajiPokok, tunjanganAnak, tunjanganKeluarga, tunjanganUmumJabatan,
        tunjanganBeras, penghasilanNeto, potonganPPH, potonganIWP, potonganTaperum, pph21, jumlahPotonganPPH21,
        penghasilanKenaPajak, penghasilanNetoPerTahun, ptkp, gajiBersih, potonganGajiKotor;

    System.out.print("Input Nama: ");
    nama = validateString("[a-zA-Z ]+", "Nama tidak valid!");

    System.out.print("Masukkan Golongan Pangkat (1-4): ");
    golonganPangkat = validateInteger("^[1-4]+$", "Golongan pangkat tidak valid!");

    System.out.print("Masukkan Tipe Golongan (A, B, C, D, E): ");
    tipeGolongan = validateGolongan("A", "B", "C", "D", "E");

    System.out.print("Masukkan Masa Kerja (0-50): ");
    masaKerja = validateInteger("^(?:[0-9]|[1-4][0-9]|50)$", "Masa kerja tidak valid!");

    System.out.print("Masukkan Status Pernikahan (Belum Kawin, Kawin, Cerai): ");
    statusPernikahan = validateString("[a-zA-Z ]+", "Input tidak valid!");

    System.out.print("Masukkan Jumlah Anak: ");
    jumlahAnak = validateInteger("^[0-9]+$", "Jumlah anak tidak valid!");

    gajiPokok = kalkulasiGajiPokok(masaKerja, tipeGolongan, golonganPangkat);
    tunjanganAnak = kalkulasiTunjanganAnak(jumlahAnak, gajiPokok);
    tunjanganKeluarga = kalkulasiTunjanganKeluarga(statusPernikahan, masaKerja, tipeGolongan, golonganPangkat);
    tunjanganUmumJabatan = kalkulasiTunjanganUmumJabatan(golonganPangkat);
    tunjanganBeras = kalkulasiTunjanganBeras(jumlahAnak, statusPernikahan);
    gajiKotor = kalkulasiGajiKotor(gajiPokok, tunjanganAnak, tunjanganKeluarga, tunjanganUmumJabatan, tunjanganBeras);
    biayaJabatan = kalkulasiBiayaJabatan(gajiKotor);
    iuranPensiun = kalkulasiIuranPensiun(gajiPokok, tunjanganAnak, tunjanganKeluarga);
    potonganGajiKotor = kalkulasiPotonganGajiKotor(biayaJabatan, iuranPensiun);
    penghasilanNeto = kalkulasiPenghasilanNeto(gajiKotor, potonganGajiKotor);
    penghasilanNetoPerTahun = kalkulasiPenghasilanNetoPerTahun(penghasilanNeto);
    ptkp = kalkulasiPTKP(jumlahAnak, statusPernikahan);
    penghasilanKenaPajak = kalkulasiPenghasilanKenaPajak(penghasilanNetoPerTahun, ptkp);
    pph21 = kalkulasiPPH21(penghasilanKenaPajak);
    potonganIWP = kalkulasiPotonganIWP(gajiPokok, tunjanganAnak, tunjanganKeluarga);
    potonganTaperum = kalkulasiPotonganTaperum(golonganPangkat);
    potonganPPH = kalkulasiPotonganPPH(gajiKotor, penghasilanNetoPerTahun, pph21, ptkp);
    jumlahPotonganPPH21 = kalkulateJumlahPotonganPPH21(potonganPPH, potonganIWP, potonganTaperum);
    gajiBersih = kalkulasiGajiBersih(gajiKotor, jumlahPotonganPPH21);

    displayOutput(nama, masaKerja, tipeGolongan, golonganPangkat, statusPernikahan, jumlahAnak, gajiKotor, gajiPokok,
        tunjanganAnak, tunjanganKeluarga, tunjanganUmumJabatan, tunjanganBeras, penghasilanNeto, potonganPPH,
        potonganIWP, potonganTaperum, gajiBersih, penghasilanNetoPerTahun, jumlahPotonganPPH21, potonganGajiKotor);

    input.close();
  }

  public static String validateString(String regex, String errorMessage) {
    String inputString = input.nextLine();
    if (inputString.matches(regex)) {
      return inputString;
    } else {
      System.out.println(errorMessage);

      return null;
    }
  }

  // validasi input integer
  public static int validateInteger(String regex, String errorMessage) {
    String inputString = input.nextLine();
    if (inputString.matches(regex)) {
      return Integer.parseInt(inputString);
    } else {
      System.out.println(errorMessage);

      return 0;
    }
  }

  // validasi input golongan
  public static String validateGolongan(String... validGolongan) {
    String inputString = input.nextLine();
    for (String golongan : validGolongan) {
      if (golongan.equalsIgnoreCase(inputString)) {
        return golongan;
      }
    }
    System.out.println("Invalid Golongan");

    return null;
  }

  // menampilkan nama pegawai
  public static String getName(String nama) {
    return String.format("Nama: %s", nama);
  }

  // menampilkan status pernikahan
  public static String getStatusPernikahan(String statusPernikahan) {
    return String.format("Status Pernikahan: %s", statusPernikahan);
  }

  // ambil value masa kerja
  public static int getMasaKerja(int masaKerja, int getGolonganPangkat) {
    int[][] dataMasaKerja = {
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 },
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30,
            31, 32, 33 },
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30,
            31, 32 },
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30,
            31, 32 }
    };

    if (isValidGolonganPangkat(getGolonganPangkat)) {
      int[] indexDataMasaKerja = dataMasaKerja[getGolonganPangkat - 1];

      if (isValidMasaKerja(masaKerja) && masaKerja <= indexDataMasaKerja.length) {
        return indexDataMasaKerja[masaKerja];
      } else if (isValidMasaKerja(masaKerja)) {
        return indexDataMasaKerja[indexDataMasaKerja.length - 1];
      }
    }

    int getMasaKerja = dataMasaKerja[0][masaKerja - 1];

    return getMasaKerja;
  }

  // validasi input integer
  public static boolean isValidInput(int input, String regex) {
    String inputString = String.valueOf(input);
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(inputString);

    return matcher.matches();
  }

  // cek apakah golongan pangkat valid
  public static boolean isValidGolonganPangkat(int golonganPangkat) {
    return isValidInput(golonganPangkat, "^[1-4]+$");
  }

  // cek apakah masa kerja valid
  public static boolean isValidMasaKerja(int masaKerja) {
    return isValidInput(masaKerja, "^(?:[0-9]|[1-4][0-9]|50)$");
  }

  // cek apakah jumlah anak valid
  public static String ValidasiJumlahAnak(int jumlahAnak) {
    boolean isValid = isValidInput(jumlahAnak, "^[0-9]+$");
    return isValid ? String.valueOf(jumlahAnak) : "Input tidak valid";
  }

  // ambil value golongan pangkat
  public static int getGolonganPangkat(int golonganPangkat) {
    int hasilGolonganPangkat = 0;
    int[] dataGolonganPangkat = { 1, 2, 3, 4 };
    hasilGolonganPangkat = dataGolonganPangkat[golonganPangkat - 1];

    return hasilGolonganPangkat;
  }

  // function utama untuk keperluan konvert String ke Integer
  public static int convertStringToInt(String value, String[] array) {
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      if (value.equalsIgnoreCase(array[i])) {
        result = i + 1;
        break;
      }
    }
    return result;
  }

  // konversi nilai tipe golongan ke integer
  public static int convertTipeGolonganToInt(String getTipeGolongan) {
    String[] tipeGolonganArray = { "A", "B", "C", "D", "E" };
    return convertStringToInt(getTipeGolongan, tipeGolonganArray);
  }

  // konversi nilai status pernikahan ke integer
  public static int convertStatusPernikahanToInt(String statusPernikahan) {
    String[] statusPernikahanArray = { "Belum Kawin", "Kawin", "Cerai" };
    return convertStringToInt(statusPernikahan, statusPernikahanArray);
  }

  // kalkulasi gaji pokok
  public static double kalkulasiGajiPokok(int masaKerja, String tipeGolongan, int golonganPangkat) {
    int masaKerjaIndex = getMasaKerja(masaKerja, golonganPangkat);
    int golonganIndex = getGolonganPangkat(golonganPangkat);
    int tipeGolonganIndex = convertTipeGolonganToInt(tipeGolongan);
    return getFormattedGajiPokok(masaKerjaIndex, tipeGolonganIndex, golonganIndex);
  }

  public static double getFormattedGajiPokok(int masaKerjaIndex, int tipeGolonganIndex, int golonganIndex) {
    // Dimensi: Golongan 1
    double[][] golongan1 = {
        // Dimensi: Tipe Golongan yang berisikan gaji pokok untuk tiap masa kerja
        // Dimensi: Tipe Golongan A
        { 1560800, 1560800, 1610000, 1610000, 1660700, 1660700, 1713000, 1713000,
            1766900, 1766900, 1822600, 1822600,
            1880000, 1880000, 1939200, 1939200, 2000300, 2000300, 2063300, 2063300,
            2128300, 2128300, 2195300, 2195300,
            2264400, 2264400, 2335800, 2335800 },
        // Dimensi: Tipe Golongan B
        { 1560800, 1560800, 1610000, 1704500, 1704500, 1758200, 1758200, 1813600,
            1813600, 1870700, 1870700, 1929600,
            1929600, 1990400, 1990400, 2053100, 2053100, 2117700, 2117700, 2184400,
            2184400, 2253200, 2253200, 2324200,
            2324200, 2397400, 2397400, 2472900 },
        // Dimensi: Tipe Golongan C
        { 1560800, 1560800, 1610000, 1776600, 1776600, 1832600, 1832600, 1890300,
            1890300, 1949800, 1949800, 2011200,
            2011200, 2074600, 2074600, 2139900, 2139900, 2207300, 2207300, 2276800,
            2276800, 2348500, 2348500, 2422500,
            2422500, 2498800, 2498800, 2557500 },
        // Dimensi: Tipe Golongan D
        { 1560800, 1560800, 1610000, 1851800, 1851800, 1910100, 1910100, 1970200,
            1970200, 2032300, 2032300, 2096300,
            2096300, 2162300, 2162300, 2230400, 2230400, 2300700, 2300700, 2373100,
            2373100, 2447900, 2447900, 2525000,
            2525000, 2604500, 2604500, 2686500 } };

    // Dimensi: Golongan 2
    double[][] golongan2 = {
        // Dimensi: Tipe Golongan yang berisikan gaji pokok untuk tiap masa kerja
        // Dimensi: Tipe Golongan A
        { 2022200, 2054100, 2054100, 2118800, 2118800, 2185500, 2185500, 2254300,
            2254300, 2325300, 2325300, 2398600,
            2398600, 2474100, 2474100, 2552000, 2552000, 2632400, 2632400, 2715300,
            2715300, 2800800, 2800800, 2889100,
            2889100, 2980000, 2980000, 3073900, 3073900, 3170700, 3170700, 3270600,
            3270600, 3373600 },
        // Dimensi: Tipe Golongan B
        { 2022200, 2054100, 2054100, 2208400, 2208400, 2277900, 2277900, 2349700,
            2349700, 2423700, 2423700, 2500000,
            2500000, 2578800, 2578800, 2660000, 2660000, 2743800, 2743800, 2830200,
            2830200, 2919300, 2919300, 3011200,
            3011200, 3106100, 3106100, 3203900, 3203900, 3304800, 3304800, 3408900,
            3408900, 3516300 },
        // Dimensi: Tipe Golongan C
        { 2022200, 2054100, 2054100, 2301800, 2301800, 2374300, 2374300, 2449100,
            2449100, 2526200, 2526200, 2605800,
            2605800, 2687800, 2687800, 2772500, 2772500, 2859800, 2859800, 2949900,
            2949900, 3042800, 3042800, 3138600,
            3138600, 3237500, 3237500, 3339400, 3339400, 3444600, 3444600, 3553100,
            3553100, 3665000 },
        // Dimensi: Tipe Golongan D
        { 2022200, 2054100, 2054100, 2399200, 2399200, 2474700, 2474700, 2552700,
            2552700, 2633100, 2633100, 2716000,
            2716000, 2801500, 2801500, 2889800, 2889800, 2980800, 2980800, 3074700,
            3074700, 3171500, 3171500, 3271400,
            3271400, 3374400, 3374400, 3480700, 3480700, 3590300, 3590300, 3703400,
            3703400, 3820000 } };

    // Dimensi: Golongan 3
    double[][] golongan3 = {
        // Dimensi: Tipe Golongan yang berisikan gaji pokok untuk tiap masa kerja
        // Dimensi: Tipe Golongan A
        { 2579400, 2579400, 2660700, 2660700, 2744500, 2744500, 2830900, 2830900,
            2920100, 2920100, 3012000, 3012000,
            3106900, 3106900, 3204700, 3204700, 3305700, 3305700, 3409800, 3409800,
            3517200, 3517200, 3627900, 3627900,
            3742200, 3742200, 3860100, 3860100, 3981600, 3981600, 4107000, 4107000,
            4236400 },
        // Dimensi: Tipe Golongan B
        { 2688500, 2688500, 2773200, 2773200, 2860500, 2860500, 2950600, 2950600,
            3043600, 3043600, 3139400, 3139400,
            3238300, 3238300, 3340300, 3340300, 3445500, 3445500, 3554000, 3554000,
            3665900, 3665900, 3781400, 3781400,
            3900500, 3900500, 4023300, 4023300, 4150100, 4150100, 4280800, 4280800,
            4415600 },
        // Dimensi: Tipe Golongan C
        { 2802300, 2802300, 2890500, 2890500, 2981500, 2981500, 3075500, 3075500,
            3172300, 3172300, 3272200, 3272200,
            3375300, 3375300, 3481600, 3481600, 3591200, 3591200, 3704300, 3704300,
            3821000, 3821000, 3941400, 3941400,
            4065500, 4065500, 4193500, 4193500, 4325600, 4325600, 4461800, 4461800,
            4602400 },
        // Dimensi: Tipe Golongan D
        { 2920800, 2920800, 3012800, 3012800, 3107700, 3107700, 3205500, 3205500,
            3306500, 3306500, 3410600, 3410600,
            3518100, 3518100, 3628900, 3628900, 3743100, 3743100, 3861000, 3861000,
            3982600, 3982600, 4108100, 4108100,
            4237500, 4237500, 4370900, 4370900, 4508600, 4508600, 4650600, 4650600,
            4797000 } };

    // Dimensi: Golongan 4
    double[][] golongan4 = {
        // Dimensi: Tipe Golongan yang berisikan gaji pokok untuk tiap masa kerja
        // Dimensi: Tipe Golongan A
        { 3044300, 3044300, 3140200, 3140200, 3239100, 3239100, 3341100, 3341100,
            3446400, 3446400, 3554900, 3554900,
            3666900, 3666900, 3782400, 3782400, 3901500, 3901500, 4024400, 4024400,
            4151100, 4151100, 4281800, 4281800,
            4416700, 4416700, 4555800, 4555800, 4699300, 4699300, 4847300, 4847300,
            5000000 },
        // Dimensi: Tipe Golongan B
        { 3173100, 3173100, 3272100, 3272100, 3376100, 3376100, 3482500, 3482500,
            3592100, 3592100, 3705300, 3705300,
            3822000, 3822000, 3942400, 3942400, 4066500, 4066500, 4194600, 4194600,
            4326700, 4326700, 4463000, 4463000,
            4603500, 4603500, 4748500, 4748500, 4898100, 4898100, 5052300, 5052300,
            5211500 },
        // Dimensi: Tipe Golongan C
        { 3307300, 3307300, 3411500, 3411500, 3518900, 3518900, 3629800, 3629800,
            3744100, 3744100, 3862000, 3862000,
            3983600, 3983600, 4109100, 4109100, 4238500, 4238500, 4372000, 4372000,
            4509700, 4509700, 4651800, 4651800,
            4798300, 4798300, 4949400, 4949400, 5105300, 5105300, 5266100, 5266100,
            5431900 },
        // Dimensi: Tipe Golongan D
        { 3447200, 3447200, 3555800, 3555800, 3667800, 3667800, 3783300, 3783300,
            3902500, 3902500, 4025400, 4025400,
            4152200, 4152200, 4282900, 4282900, 4417800, 4417800, 4557000, 4557000,
            4700500, 4700500, 4848500, 4848500,
            5001200, 5001200, 5158700, 5158700, 5321200, 5321200, 5488800, 5488800,
            5661700 },
        // Dimensi: Tipe Golongan E
        { 3593100, 3593100, 3706200, 3706200, 3822900, 3822900, 3943300, 3943300,
            4067500, 4067500, 4195700, 4195700,
            4327800, 4327800, 4462100, 4462100, 4604700, 4604700, 4749700, 4749700,
            4899300, 4899300, 5053600, 5053600,
            5212800, 5212800, 5377000, 5377000, 5546300, 5546300, 5721000, 5721000,
            5901200 } };

    // satukan semua array golongan
    double[][][] gajiPokokArray = { golongan1, golongan2, golongan3, golongan4 };
    // double gajiPokok = gajiPokokArray[golonganIndex - 1][tipeGolonganIndex -
    // 1][masaKerjaIndex];

    try {
      double gajiPokok = gajiPokokArray[golonganIndex - 1][tipeGolonganIndex -
          1][masaKerjaIndex];
      // return String.format("%.2f", gajiPokok);
      return gajiPokok;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid input!");
      return 0; // Or any other default value
    }
  }

  public static double kalkulasiTunjanganAnak(int jumlahAnak, double gajiPokok) {
    double[] tunjanganAnakPercentage = { 0.0, 0.02, 0.02 };
    int maxJumlahAnak = tunjanganAnakPercentage.length - 1;
    jumlahAnak = Math.min(jumlahAnak, maxJumlahAnak);
    double tunjanganAnak = tunjanganAnakPercentage[jumlahAnak] * gajiPokok * jumlahAnak;

    return tunjanganAnak;
  }

  // kalkulasi tunjangan keluarga
  public static double kalkulasiTunjanganKeluarga(String statusPernikahan, int masaKerja, String tipeGolongan,
      int golonganPangkat) {
    double[] tunjanganKeluargaPercentages = { 0.0, 0.0, 0.1, 0.0 };
    int indexStatusPernikahan = convertStatusPernikahanToInt(statusPernikahan);
    double gajiPokok = kalkulasiGajiPokok(masaKerja, tipeGolongan, golonganPangkat);
    double tunjanganKeluarga = gajiPokok * tunjanganKeluargaPercentages[indexStatusPernikahan];

    return tunjanganKeluarga;
  }

  // kalkulasi tunjangan beras
  public static double kalkulasiTunjanganBeras(int jumlahAnak, String statusPernikahan) {
    int maxJumlahAnak = 2;
    int berasPerAnggota = 10;
    int hargaBeras = 15000;

    int totalAnggotaKeluarga = 1 + Math.min(jumlahAnak, maxJumlahAnak);
    if (statusPernikahan.equalsIgnoreCase("Kawin")) {
      totalAnggotaKeluarga += 1;
    }

    double tunjanganBeras = totalAnggotaKeluarga * berasPerAnggota * hargaBeras;

    return tunjanganBeras;
  }

  // kalkulasi tunjangan umum jabatan
  public static double kalkulasiTunjanganUmumJabatan(int golonganPangkat) {
    double[] tunjanganJabatan = { 0, 175000, 180000, 185000, 190000 };
    golonganPangkat = getGolonganPangkat(golonganPangkat);
    double tunjanganUmumJabatan = tunjanganJabatan[golonganPangkat];

    return tunjanganUmumJabatan;
  }

  // kalkulasi tunjangan IWP
  public static double kalkulasiPotonganIWP(double gajiPokok, double tunjanganAnak, double tunjanganKeluarga) {
    double iwpPercentage = 0.1;
    double IWP = gajiPokok + tunjanganAnak + tunjanganKeluarga;
    double potonganIWP = IWP * iwpPercentage;

    return potonganIWP;
  }

  // kalkulasi potongan Taperum
  public static double kalkulasiPotonganTaperum(int golonganPangkat) {
    int[] taperumValues = { 3000, 5000, 7000, 10000 };
    int indexGolonganPangkat = getGolonganPangkat(golonganPangkat);
    int potonganTaperum = taperumValues[indexGolonganPangkat - 1];

    return potonganTaperum;
  }

  // kalkulasi gaji kotor
  public static double kalkulasiGajiKotor(double gajiPokok, double tunjanganAnak, double tunjanganKeluarga,
      double tunjanganUmumJabatan, double tunjanganBeras) {
    double gajiKotor = gajiPokok + tunjanganKeluarga + tunjanganAnak + tunjanganBeras + tunjanganUmumJabatan;

    return gajiKotor;
  }

  // kalkulasi biaya jabatan
  public static double kalkulasiBiayaJabatan(double gajiKotor) {
    double biayaJabatanPercentage = 0.05;
    double biayaJabatan = gajiKotor * biayaJabatanPercentage;

    return biayaJabatan;
  }

  // kalkulasi iuran pensiun
  public static double kalkulasiIuranPensiun(double gajiPokok, double tunjanganAnak, double tunjanganKeluarga) {
    double iuranPensiunPercentage = 0.0475;
    double iuranPensiun = (gajiPokok + tunjanganAnak + tunjanganKeluarga) * iuranPensiunPercentage;

    return iuranPensiun;
  }

  // kalkulasi pengurangan bruto
  public static double kalkulasiPotonganGajiKotor(double biayaJabatan, double iuranPensiun) {
    double potonganGajiKotor = biayaJabatan + iuranPensiun;

    return potonganGajiKotor;
  }

  // kalkulasi penghasilan neto
  public static double kalkulasiPenghasilanNeto(double gajiKotor, double potonganGajiKotor) {
    double penghasilanNeto = gajiKotor - potonganGajiKotor;

    return penghasilanNeto;
  }

  // penghasilan neto dalam 1 tahun
  public static double kalkulasiPenghasilanNetoPerTahun(double penghasilanNeto) {
    double satuTahun = 12;
    double penghasilanNetoPerTahun = penghasilanNeto * satuTahun;

    return penghasilanNetoPerTahun;
  }

  // kalkulasi potongan PPH
  public static double kalkulasiPotonganPPH(double gajiKotor, double penghasilanNetoPerTahun, double pph21,
      double ptkp) {
    double potonganPPH = 0;
    double minWajibPajak = 4500000;

    if (gajiKotor > minWajibPajak && penghasilanNetoPerTahun > ptkp) {
      potonganPPH = pph21;
    }

    return potonganPPH;
  }

  // kalkulasi ptkp
  public static double kalkulasiPTKP(int jumlahAnak, String statusPernikahan) {
    double ptkpDiriSendiri = 36000000;
    double ptkpIstriSuami = 0;
    double ptkpPerAnak = 3000000;
    int maxJumlahAnak = 3;

    ptkpIstriSuami = hitungPTKPIstriSuami(statusPernikahan);

    double ptkp = ptkpDiriSendiri + ptkpIstriSuami + (ptkpPerAnak * Math.min(jumlahAnak, maxJumlahAnak));
    return ptkp;
  }

  // hitung ptkp istri suami
  public static double hitungPTKPIstriSuami(String statusPernikahan) {
    int ptkpIstriSuami = 0;

    if (statusPernikahan.equalsIgnoreCase("Kawin")) {
      ptkpIstriSuami = 3000000;
    }

    return ptkpIstriSuami;
  }

  // kalkulasi Penghasilan Kena Pajak
  public static double kalkulasiPenghasilanKenaPajak(double penghasilanNetoPerTahun, double ptkp) {
    double penghasilanKenaPajak = penghasilanNetoPerTahun - ptkp;
    return penghasilanKenaPajak;
  }

  // kalkulasi PPH21
  public static double kalkulasiPPH21(double penghasilanKenaPajak) {
    int tahun = 12;
    double pph21Percentage = 0.05;
    double pph21 = 0;

    pph21 = (penghasilanKenaPajak * pph21Percentage) / tahun;

    return pph21;
  }

  // kalkulate jumlah potongan untuk pph
  public static double kalkulateJumlahPotonganPPH21(double potonganPPH, double potonganIWP, double potonganTaperum) {
    double jumlahPotonganPPH21 = potonganPPH + potonganIWP + potonganTaperum;

    return jumlahPotonganPPH21;
  }

  // kalkulasi gajiTakeHomePay
  public static double kalkulasiGajiBersih(double gajiKotor, double jumlahPotonganPPH21) {
    double gajiTakeHomePay = gajiKotor - jumlahPotonganPPH21;
    return gajiTakeHomePay;
  }

  // menampilkan semua output
  public static void displayOutput(String nama, int masaKerja, String tipeGolongan, int golonganPangkat,
      String statusPernikahan, int jumlahAnak, double gajiKotor, double gajiPokok, double tunjanganAnak,
      double tunjanganKeluarga, double tunjanganUmumJabatan, double tunjanganBeras, double penghasilanNeto,
      double potonganPPH, double potonganIWP, double potonganTaperum, double gajiBersih, double penghasilanNetoPerTahun,
      double jumlahPotonganPPH21, double potonganGajiKotor) {
    System.out.println("===================================");
    System.out.println(getName(nama));
    System.out.println("Golongan Pangkat: " + golonganPangkat);
    System.out.println("Tipe Golongan: " + tipeGolongan);
    System.out.println("Masa Kerja: " + getMasaKerja(masaKerja, golonganPangkat));
    System.out.println(getStatusPernikahan(statusPernikahan));
    System.out.println("Jumlah Anak: " + jumlahAnak);
    System.out.println("************************************");
    System.out.printf("Gaji Pokok: %.2f\n", gajiPokok);
    System.out.printf("Tunjangan Keluarga: %.2f\n", tunjanganKeluarga);
    System.out.printf("Tunjangan Anak: %.2f\n", tunjanganAnak);
    System.out.printf("Tunjangan Beras: %.2f\n", tunjanganBeras);
    System.out.printf("Tunjangan Umum Jabatan: %.2f\n", tunjanganUmumJabatan);
    System.out.printf("Gaji Bruto: %.2f\n", gajiKotor);
    System.out.printf("PPH21: %.2f\n", potonganPPH);
    System.out.printf("Potongan IWP: %.2f\n", potonganIWP);
    System.out.printf("Potongan Taperum: %.2f\n", potonganTaperum);
    System.out.printf("Gaji Take Home Pay: %.2f\n", gajiBersih);
    System.out.println("************************************");
    System.out.printf("Potongan Gaji Kotor: %.2f\n", potonganGajiKotor);
    System.out.printf("Penghasilan Neto: %.2f\n", penghasilanNeto);
    System.out.printf("Neto per tahun: %.2f\n", penghasilanNetoPerTahun);
    System.out.printf("Potongan gaji PPH21: %.2f\n", jumlahPotonganPPH21);
    System.out.println("===================================");
  }
}
