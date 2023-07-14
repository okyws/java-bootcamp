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

    double[][][][] gajiPokok = {
        // Dimension: golonganPangkat
        {
            // Dimension: tipeGolongan
            {
                // Dimension: masaKerja
                // data golongan 1 tipe A berdasarkan masa kerja
                {
                    1560800,
                    1560800,
                    1610000,
                    1610000,
                    1660700,
                    1660700,
                    1713000,
                    1713000,
                    1766900,
                    1766900,
                    1822600,
                    1822600,
                    1880000,
                    1880000,
                    1939200,
                    1939200,
                    2000300,
                    2000300,
                    2063300,
                    2063300,
                    2128300,
                    2128300,
                    2195300,
                    2195300,
                    2264400,
                    2264400,
                    2335800,
                    2335800
                }
            },
            {
                // data golongan 1 tipe B berdasarkan masa kerja
                {
                    1560800,
                    1560800,
                    1610000,
                    1704500,
                    1704500,
                    1758200,
                    1758200,
                    1813600,
                    1813600,
                    1870700,
                    1870700,
                    1929600,
                    1929600,
                    1990400,
                    1990400,
                    2053100,
                    2053100,
                    2117700,
                    2117700,
                    2184400,
                    2184400,
                    2253200,
                    2253200,
                    2324200,
                    2324200,
                    2397400,
                    2397400,
                    2472900
                }
            },
            {
                // data golongan 1 tipe C berdasarkan jam kerja
                {
                    1560800,
                    1560800,
                    1610000,
                    1776600,
                    1776600,
                    1832600,
                    1832600,
                    1890300,
                    1890300,
                    1949800,
                    1949800,
                    2011200,
                    2011200,
                    2074600,
                    2074600,
                    2139900,
                    2139900,
                    2207300,
                    2207300,
                    2276800,
                    2276800,
                    2348500,
                    2348500,
                    2422500,
                    2422500,
                    2498800,
                    2498800,
                    2557500
                }
            },
            {
                // golongan 1 tipe D berdasrkan jam kerja
                {
                    1560800,
                    1560800,
                    1610000,
                    1851800,
                    1851800,
                    1910100,
                    1910100,
                    1970200,
                    1970200,
                    2032300,
                    2032300,
                    2096300,
                    2096300,
                    2162300,
                    2162300,
                    2230400,
                    2230400,
                    2300700,
                    2300700,
                    2373100,
                    2373100,
                    2447900,
                    2447900,
                    2525000,
                    2525000,
                    2604500,
                    2604500,
                    2686500
                }
            }
        },
        // Dimension: golonganPangkat2
        {
            // Dimension: tipeGolongan A
            {
                // Dimension: masaKerja
                // data golongan 2 tipe A berdasarkan masa kerja
                {
                    2022200,
                    2054100,
                    2054100,
                    2118800,
                    2118800,
                    2185500,
                    2185500,
                    2254300,
                    2254300,
                    2325300,
                    2325300,
                    2398600,
                    2398600,
                    2474100,
                    2474100,
                    2552000,
                    2552000,
                    2632400,
                    2632400,
                    2715300,
                    2715300,
                    2800800,
                    2800800,
                    2889100,
                    2889100,
                    2980000,
                    2980000,
                    3073900,
                    3073900,
                    3170700,
                    3170700,
                    3270600,
                    3270600,
                    3373600
                }
            },
            {
                // Dimension: masaKerja
                // data golongan 2 tipe B berdasarkan masa kerja
                {
                    2022200,
                    2054100,
                    2054100,
                    2118800,
                    2118800,
                    2185500,
                    2185500,
                    2254300,
                    2254300,
                    2325300,
                    2325300,
                    2398600,
                    2398600,
                    2474100,
                    2474100,
                    2552000,
                    2552000,
                    2632400,
                    2632400,
                    2715300,
                    2715300,
                    2800800,
                    2800800,
                    2889100,
                    2889100,
                    2980000,
                    2980000,
                    3073900,
                    3073900,
                    3170700,
                    3170700,
                    3270600,
                    3270600,
                    3373600
                }
            },
            // Dimension: tipe golongan B
            {
                {
                    2022200,
                    2054100,
                    2054100,
                    2208400,
                    2208400,
                    2277900,
                    2277900,
                    2349700,
                    2349700,
                    2423700,
                    2423700,
                    2500000,
                    2500000,
                    2578800,
                    2578800,
                    2660000,
                    2660000,
                    2743800,
                    2743800,
                    2830200,
                    2830200,
                    2919300,
                    2919300,
                    3011200,
                    3011200,
                    3106100,
                    3106100,
                    3203900,
                    3203900,
                    3304800,
                    3304800,
                    3408900,
                    3408900,
                    3516300
                }
            },
            // Dimension: tipe golongan C
            {
                {
                    2022200,
                    2054100,
                    2054100,
                    2301800,
                    2301800,
                    2374300,
                    2374300,
                    2449100,
                    2449100,
                    2526200,
                    2526200,
                    2605800,
                    2605800,
                    2687800,
                    2687800,
                    2772500,
                    2772500,
                    2859800,
                    2859800,
                    2949900,
                    2949900,
                    3042800,
                    3042800,
                    3138600,
                    3138600,
                    3237500,
                    3237500,
                    3339400,
                    3339400,
                    3444600,
                    3444600,
                    3553100,
                    3553100,
                    3665000
                }
            },
            // Dimension: tipe golongan D
            {
                {
                    2022200,
                    2054100,
                    2054100,
                    2399200,
                    2399200,
                    2474700,
                    2474700,
                    2552700,
                    2552700,
                    2633100,
                    2633100,
                    2716000,
                    2716000,
                    2801500,
                    2801500,
                    2889800,
                    2889800,
                    2980800,
                    2980800,
                    3074700,
                    3074700,
                    3171500,
                    3171500,
                    3271400,
                    3271400,
                    3374400,
                    3374400,
                    3480700,
                    3480700,
                    3590300,
                    3590300,
                    3703400,
                    3703400,
                    3820000
                }
            }
        },
        // Dimension: golongan pangkat 3
        {
            // Dimension: tipe golongan A
            {
                // Dimension: masa kerja
                {
                    2579400,
                    2579400,
                    2660700,
                    2660700,
                    2744500,
                    2744500,
                    2830900,
                    2830900,
                    2920100,
                    2920100,
                    3012000,
                    3012000,
                    3106900,
                    3106900,
                    3204700,
                    3204700,
                    3305700,
                    3305700,
                    3409800,
                    3409800,
                    3517200,
                    3517200,
                    3627900,
                    3627900,
                    3742200,
                    3742200,
                    3860100,
                    3860100,
                    3981600,
                    3981600,
                    4107000,
                    4107000,
                    4236400
                }
            },
            // Dimension: tipe golongan B
            {
                // Dimension: masa kerja
                {
                    2688500,
                    2688500,
                    2773200,
                    2773200,
                    2860500,
                    2860500,
                    2950600,
                    2950600,
                    3043600,
                    3043600,
                    3139400,
                    3139400,
                    3238300,
                    3238300,
                    3340300,
                    3340300,
                    3445500,
                    3445500,
                    3554000,
                    3554000,
                    3665900,
                    3665900,
                    3781400,
                    3781400,
                    3900500,
                    3900500,
                    4023300,
                    4023300,
                    4150100,
                    4150100,
                    4280800,
                    4280800,
                    4415600
                }
            },
            // Dimension: tipe golongan C
            {
                // Dimension: masa kerja
                {
                    2802300,
                    2802300,
                    2890500,
                    2890500,
                    2981500,
                    2981500,
                    3075500,
                    3075500,
                    3172300,
                    3172300,
                    3272200,
                    3272200,
                    3375300,
                    3375300,
                    3481600,
                    3481600,
                    3591200,
                    3591200,
                    3704300,
                    3704300,
                    3821000,
                    3821000,
                    3941400,
                    3941400,
                    4065500,
                    4065500,
                    4193500,
                    4193500,
                    4325600,
                    4325600,
                    4461800,
                    4461800,
                    4602400
                }
            },
            // Dimension: tipe golongan D
            {
                // Dimension: masa kerja
                {
                    2920800,
                    2920800,
                    3012800,
                    3012800,
                    3107700,
                    3107700,
                    3205500,
                    3205500,
                    3306500,
                    3306500,
                    3410600,
                    3410600,
                    3518100,
                    3518100,
                    3628900,
                    3628900,
                    3743100,
                    3743100,
                    3861000,
                    3861000,
                    3982600,
                    3982600,
                    4108100,
                    4108100,
                    4237500,
                    4237500,
                    4370900,
                    4370900,
                    4508600,
                    4508600,
                    4650600,
                    4650600,
                    4797000
                }
            }
        },
        // Dimension: golongan Pangkat 4
        {
            // Dimension: tipe golongan A
            {
                // Dimension: masa kerja
                {
                    3044300,
                    3044300,
                    3140200,
                    3140200,
                    3239100,
                    3239100,
                    3341100,
                    3341100,
                    3446400,
                    3446400,
                    3554900,
                    3554900,
                    3666900,
                    3666900,
                    3782400,
                    3782400,
                    3901500,
                    3901500,
                    4024400,
                    4024400,
                    4151100,
                    4151100,
                    4281800,
                    4281800,
                    4416700,
                    4416700,
                    4555800,
                    4555800,
                    4699300,
                    4699300,
                    4847300,
                    4847300,
                    5000000
                }
            },
            // Dimension: tipe golongan B
            {
                // Dimension: masa kerja
                {
                    3173100,
                    3173100,
                    3272100,
                    3272100,
                    3376100,
                    3376100,
                    3482500,
                    3482500,
                    3592100,
                    3592100,
                    3705300,
                    3705300,
                    3822000,
                    3822000,
                    3942400,
                    3942400,
                    4066500,
                    4066500,
                    4194600,
                    4194600,
                    4326700,
                    4326700,
                    4463000,
                    4463000,
                    4603500,
                    4603500,
                    4748500,
                    4748500,
                    4898100,
                    4898100,
                    5052300,
                    5052300,
                    5211500
                }
            },
            // Dimension: tipe golongan C
            {
                // Dimension: masa kerja
                {
                    3307300,
                    3307300,
                    3411500,
                    3411500,
                    3518900,
                    3518900,
                    3629800,
                    3629800,
                    3744100,
                    3744100,
                    3862000,
                    3862000,
                    3983600,
                    3983600,
                    4109100,
                    4109100,
                    4238500,
                    4238500,
                    4372000,
                    4372000,
                    4509700,
                    4509700,
                    4651800,
                    4651800,
                    4798300,
                    4798300,
                    4949400,
                    4949400,
                    5105300,
                    5105300,
                    5266100,
                    5266100,
                    5431900
                }
            },
            // Dimension: tipe golongan D
            {
                // Dimension: masa kerja
                {
                    3447200,
                    3447200,
                    3555800,
                    3555800,
                    3667800,
                    3667800,
                    3783300,
                    3783300,
                    3902500,
                    3902500,
                    4025400,
                    4025400,
                    4152200,
                    4152200,
                    4282900,
                    4282900,
                    4417800,
                    4417800,
                    4557000,
                    4557000,
                    4700500,
                    4700500,
                    4848500,
                    4848500,
                    5001200,
                    5001200,
                    5158700,
                    5158700,
                    5321200,
                    5321200,
                    5488800,
                    5488800,
                    5661700
                }
            },
            // Dimension: tipe golongan E
            {
                // Dimension: masa kerja
                {
                    3593100,
                    3593100,
                    3706200,
                    3706200,
                    3822900,
                    3822900,
                    3943300,
                    3943300,
                    4067500,
                    4067500,
                    4195700,
                    4195700,
                    4327800,
                    4327800,
                    4462100,
                    4462100,
                    4604700,
                    4604700,
                    4749700,
                    4749700,
                    4899300,
                    4899300,
                    5053600,
                    5053600,
                    5212800,
                    5212800,
                    5377000,
                    5377000,
                    5546300,
                    5546300,
                    5721000,
                    5721000,
                    5901200
                }
            }
        }
    };

    String formattedGaji = String.format("%.2f",
        gajiPokok[golonganIndex - 1][tipeGolonganIndex - 1][0][masaKerjaIndex]);
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
