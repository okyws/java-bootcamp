import java.util.Scanner;

/*
 * Created By : Oky Wahyu Setyaji
 * Created At : Jam Hari, xx - July - 2023
 */

public class GajiPNS {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Input Nama: ");
    String nama = input.nextLine();
    System.out.print("Input Masa Kerja: ");
    int masaKerja = Integer.valueOf(input.nextLine());
    System.out.print("Input Tipe Golongan (A s/d E): ");
    String tipeGolongan = input.nextLine();
    System.out.print("Input Golongan Pangkat: ");
    int golonganPangkat = Integer.valueOf(input.nextLine());

    displayOutput(nama, masaKerja, tipeGolongan, golonganPangkat);

    input.close();
  }

  // cek apakah nama hanya huruf dan spasi
  public static boolean isAllLetters(String nama) {
    return nama.chars().allMatch(c -> Character.isLetter(c) || c == ' ');
  }

  // menampilkan nama
  public static String getName(String nama) {
    boolean isAllLetters = isAllLetters(nama);
    nama = isAllLetters ? nama : "Nama harus huruf Alphabet!!!";
    return String.format("Nama: %s", nama);
  }

  // ambil value masa kerja
  public static int getMasaKerja(int masaKerja, int getGolonganPangkat) {
    int minMasaKerja = 0;
    int[][] dataMasaKerja = {
        { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32 }
    };

    if (isValidGolonganPangkat(getGolonganPangkat)) {
      int[] indexDataMasaKerja = dataMasaKerja[getGolonganPangkat - 1];

      if (isValidMasaKerja(masaKerja, indexDataMasaKerja)) {
        return (masaKerja == minMasaKerja) ? 0 : indexDataMasaKerja[masaKerja - 1];
      } else {
        return indexDataMasaKerja[indexDataMasaKerja.length - 1];
      }
    }

    return dataMasaKerja[0][masaKerja - 1];
  }

  // cek apakah golongan pangkat valid
  public static boolean isValidGolonganPangkat(int golonganPangkat) {
    return golonganPangkat >= Integer.MIN_VALUE && golonganPangkat <= Integer.MAX_VALUE;
  }

  // cek apakah masa kerja valid
  public static boolean isValidMasaKerja(int masaKerja, int[] indexDataMasaKerja) {
    return masaKerja >= 0 && masaKerja <= 50 && masaKerja <= indexDataMasaKerja.length;
  }

  // ambil value tipe golongan
  public static String getTipeGolongan(String tipeGolongan, int getGolonganPangkat) {
    String[] dataTipeGolongan = { "A", "B", "C", "D" };

    if (getGolonganPangkat == 4) {
      dataTipeGolongan = addElementToArray(dataTipeGolongan, "E");
    }

    return isValidGolongan(tipeGolongan, dataTipeGolongan)
        ? tipeGolongan
        : "Invalid Golongan";
  }

  // tambah element ke array
  public static String[] addElementToArray(String[] array, String element) {
    String[] newArray = new String[array.length + 1];
    System.arraycopy(array, 0, newArray, 0, array.length);
    newArray[array.length] = element;
    return newArray;
  }

  // cek apakah tipe golongan valid
  public static boolean isValidGolongan(String tipeGolongan, String[] dataTipeGolongan) {
    for (String golongan : dataTipeGolongan) {
      if (golongan.equals(tipeGolongan)) {
        return true;
      }
    }
    return false;
  }

  // ambil value golongan pangkat
  public static int getGolonganPangkat(int golonganPangkat) {
    int hasilGolonganPangkat = 0;
    int[] dataGolonganPangkat = { 1, 2, 3, 4 };
    hasilGolonganPangkat = dataGolonganPangkat[golonganPangkat - 1];

    return hasilGolonganPangkat;
  }

  // konversi nilai tipe golongan ke integer
  public static int convertTipeGolonganToInt(String getTipeGolongan) {
    int result = 0;
    String[] tipeGolonganArray = { "A", "B", "C", "D", "E" };

    for (int i = 0; i < tipeGolonganArray.length; i++) {
      if (getTipeGolongan.equalsIgnoreCase(tipeGolonganArray[i])) {
        result = (i + 1);
      }
    }

    return result;
  }

  // kalkulasi gaji pokok
  public static String kalkulasiGajiPokok(int masaKerja, String tipeGolongan, int golonganPangkat) {

    int masaKerjaIndex = getMasaKerja(masaKerja, golonganPangkat);
    int golonganIndex = getGolonganPangkat(golonganPangkat);
    int tipeGolonganIndex = convertTipeGolonganToInt(tipeGolongan);

    double[][][] gajiPokok = {
        // Dimensi: Golongan 1
        {
            // Dimensi: Tipe Golongan yang berisikan gaji pokok untuk tiap masa kerja
            // Dimensi: Tipe Golongan A
            { 1560800, 1560800, 1610000, 1610000, 1660700, 1660700, 1713000, 1713000, 1766900, 1766900, 1822600,
                1822600, 1880000, 1880000, 1939200, 1939200, 2000300, 2000300, 2063300, 2063300, 2128300, 2128300,
                2195300, 2195300, 2264400, 2264400, 2335800, 2335800 },
            // Dimensi: Tipe Golongan B
            { 1560800, 1560800, 1610000, 1704500, 1704500, 1758200, 1758200, 1813600, 1813600, 1870700, 1870700,
                1929600, 1929600, 1990400, 1990400, 2053100, 2053100, 2117700, 2117700, 2184400, 2184400, 2253200,
                2253200, 2324200, 2324200, 2397400, 2397400, 2472900 },
            // Dimensi: Tipe Golongan C
            { 1560800, 1560800, 1610000, 1776600, 1776600, 1832600, 1832600, 1890300, 1890300, 1949800, 1949800,
                2011200, 2011200, 2074600, 2074600, 2139900, 2139900, 2207300, 2207300, 2276800, 2276800, 2348500,
                2348500, 2422500, 2422500, 2498800, 2498800, 2557500 },
            // Dimensi: Tipe Golongan D
            { 1560800, 1560800, 1610000, 1851800, 1851800, 1910100, 1910100, 1970200, 1970200, 2032300, 2032300,
                2096300, 2096300, 2162300, 2162300, 2230400, 2230400, 2300700, 2300700, 2373100, 2373100, 2447900,
                2447900, 2525000, 2525000, 2604500, 2604500, 2686500 }
        },
        // Dimensi: Golongan 2
        {
            // Dimensi: Tipe Golongan yang berisikan gaji pokok untuk tiap masa kerja
            // Dimensi: Tipe Golongan A
            { 2022200, 2054100, 2054100, 2118800, 2118800, 2185500, 2185500, 2254300, 2254300, 2325300, 2325300,
                2398600, 2398600, 2474100, 2474100, 2552000, 2552000, 2632400, 2632400, 2715300, 2715300, 2800800,
                2800800, 2889100, 2889100, 2980000, 2980000, 3073900, 3073900, 3170700, 3170700, 3270600, 3270600,
                3373600 },
            // Dimensi: Tipe Golongan B
            { 2022200, 2054100, 2054100, 2208400, 2208400, 2277900, 2277900, 2349700, 2349700, 2423700, 2423700,
                2500000, 2500000, 2578800, 2578800, 2660000, 2660000, 2743800, 2743800, 2830200, 2830200, 2919300,
                2919300, 3011200, 3011200, 3106100, 3106100, 3203900, 3203900, 3304800, 3304800, 3418900, 3418900,
                3532700 },
            // Dimensi: Tipe Golongan C
            { 2022200, 2054100, 2054100, 2301800, 2301800, 2374300, 2374300, 2449100, 2449100, 2526200, 2526200,
                2605800, 2605800, 2687800, 2687800, 2772500, 2772500, 2859800, 2859800, 2949900, 2949900, 3042800,
                3042800, 3138600, 3138600, 3237500, 3237500, 3339400, 3339400, 3444600, 3444600, 3553100, 3553100,
                3670500 },
            // Dimensi: Tipe Golongan D
            { 2022200, 2054100, 2054100, 2399200, 2399200, 2474700, 2474700, 2552700, 2552700, 2633100, 2633100,
                2716000, 2716000, 2801500, 2801500, 2889800, 2889800, 2980800, 2980800, 3074700, 3074700, 3171500,
                3171500, 3271400, 3271400, 3374400, 3374400, 3480700, 3480700, 3590300, 3590300, 3703400, 3703400,
                3820000 }
        },
        // Dimensi: Golongan 3
        {
            // Dimensi: Tipe Golongan yang berisikan gaji pokok untuk tiap masa kerja
            // Dimensi: Tipe Golongan A
            { 2579400, 2579400, 2660700, 2660700, 2744500, 2744500, 2830900, 2830900, 2920100, 2920100, 3012000,
                3012000, 3106900, 3106900, 3204800, 3204800, 3305700, 3305700, 3409600, 3409600, 3516600, 3516600,
                3626700, 3626700, 3739900, 3739900, 3856200, 3856200, 3975700, 3975700, 4098300, 4098300, 4224100,
                4224100, 4353000 },
            // Dimensi: Tipe Golongan B
            { 2688500, 2688500, 2773200, 2773200, 2860500, 2860500, 2950600, 2950600, 3043600, 3043600, 3139400,
                3139400, 3238300, 3238300, 3340300, 3340300, 3445500, 3445500, 3554100, 3554100, 3666200, 3666200,
                3781800, 3781800, 3901000, 3901000, 4023900, 4023900, 4150500, 4150500, 4280900, 4280900, 4415300,
                4415300, 4553700 },
            // Dimensi: Tipe Golongan C
            { 2802300, 2802300, 2890500, 2890500, 2981500, 2981500, 3075500, 3075500, 3172300, 3172300, 3272200,
                3272200, 3375300, 3375300, 3484700, 3484700, 3590300, 3590300, 3703500, 3703500, 3827500, 3827500,
                3956500, 3956500, 4089300, 4089300, 4226600, 4226600, 4373400, 4373400, 4525300, 4525300, 4688600,
                4688600, 4853200 },
            // Dimensi: Tipe Golongan D
            { 2920800, 2920800, 3012800, 3012800, 3107700, 3107700, 3205500, 3205500, 3306500, 3306500, 3410600,
                3410600, 3518100, 3518100, 3638900, 3638900, 3743100, 3743100, 3858600, 3858600, 3976100, 3976100,
                4097200, 4097200, 4213300, 4213300, 4339900, 4339900, 4477500, 4477500, 4639700, 4639700, 4814600,
                4814600, 4990900 }
        },
        // Dimensi: Golongan 4
        {
            // Dimensi: Tipe Golongan yang berisikan gaji pokok untuk tiap masa kerja
            // Dimensi: Tipe Golongan A
            { 3044300, 3044300, 3140200, 3140200, 3239100, 3239100, 3341100, 3341100, 3446400, 3446400, 3554900,
                3554900, 3666700, 3666700, 3781700, 3781700, 3899900, 3899900, 4021300, 4021300, 4145900, 4145900,
                4273600, 4273600, 4404400, 4404400, 4538200, 4538200, 4675000, 4675000, 4814800, 4814800, 4957600,
                4957600, 5103400 },
            // Dimensi: Tipe Golongan B
            { 3173100, 3173100, 3272100, 3272100, 3376100, 3376100, 3482500, 3482500, 3592300, 3592300, 3705300,
                3705300, 3821600, 3821600, 3940900, 3940900, 4063300, 4063300, 4188800, 4188800, 4317600, 4317600,
                4459500, 4459500, 4604500, 4604500, 4752500, 4752500, 4903500, 4903500, 5057600, 5057600, 5214900,
                5214900, 5375500 },
            // Dimensi: Tipe Golongan C
            { 3307300, 3307300, 3406500, 3406500, 3518900, 3518900, 3629600, 3629600, 3743800, 3743800, 3861400,
                3861400, 3982400, 3982400, 4105200, 4105200, 4232200, 4232200, 4361200, 4361200, 4494500, 4494500,
                4651800, 4651800, 4812400, 4812400, 4974800, 4974800, 5144700, 5144700, 5313500, 5313500, 5483300,
                5483300, 5657900 },
            // Dimensi: Tipe Golongan D
            { 3447200, 3447200, 3545800, 3545800, 3667800, 3667800, 3782400, 3782400, 3900100, 3900100, 4022900,
                4022900, 4149100, 4149100, 4275100, 4275100, 4406900, 4406900, 4541500, 4541500, 4679700, 4679700,
                4851900, 4851900, 5028500, 5028500, 5205400, 5205400, 5395300, 5395300, 5579300, 5579300, 5762200,
                5762200, 5951100 },
            // Dimensi: Tipe Golongan E
            { 3593100, 3593100, 3690200, 3690200, 3822900, 3822900, 3941300, 3941300, 4062500, 4062500, 4190600,
                4190600, 4322200, 4322200, 4451600, 4451600, 4589400, 4589400, 4729900, 4729900, 4872600, 4872600,
                5060400, 5060400, 5253200, 5253200, 5444400, 5444400, 5656600, 5656600, 5856600, 5856600, 6052700,
                6052700, 6256800 }
        }
    };

    String formattedGaji = String.format("%.2f", gajiPokok[golonganIndex - 1][tipeGolonganIndex - 1][masaKerjaIndex]);
    return formattedGaji;
  }

  // menampilkan semua output
  public static void displayOutput(String nama, int masaKerja, String tipeGolongan, int golonganPangkat) {
    System.out.println("===================================");
    System.out.println(getName(nama));
    System.out.println("Masa Kerja: " + getMasaKerja(masaKerja,
        golonganPangkat));
    System.out.println("Tipe Golongan: " + getTipeGolongan(tipeGolongan,
        golonganPangkat));
    System.out.println("Golongan Pangkat: " +
        getGolonganPangkat(golonganPangkat));
    System.out.println("Gaji Pokok: " + kalkulasiGajiPokok(masaKerja,
        tipeGolongan, golonganPangkat));
    System.out.println("===================================");
  }
}
