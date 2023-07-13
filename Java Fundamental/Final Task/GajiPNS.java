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
  public static String getName(boolean isAllLetters, String nama) {
    nama = isAllLetters(nama) ? nama : "Nama harus huruf Alphabet!!!";
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
    return masaKerja >= Integer.MIN_VALUE && masaKerja <= indexDataMasaKerja.length;
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
  public static int convertTipeGolonganToInt(String tipeGolongan) {
    int result = 0;
    String[] tipeGolonganArray = { "A", "B", "C", "D", "E" };

    for (int i = 0; i < tipeGolonganArray.length; i++) {
      if (tipeGolongan.equalsIgnoreCase(tipeGolonganArray[i])) {
        result = (i + 1);
      }
    }

    return result;
  }

  // kalkulasi gaji pokok
  public static String kalkulasiGajiPokok(int masaKerja, String tipeGolongan, int golonganPangkat) {

    int masaKerjaIndex = getMasaKerja(masaKerja, golonganPangkat) - 1;
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
        }
    };

    String formattedGaji = String.format("%.2f",
        gajiPokok[golonganIndex - 1][tipeGolonganIndex - 1][0][masaKerjaIndex + 1]);
    return formattedGaji;
  }

  // menampilkan semua output
  public static void displayOutput(String nama, int masaKerja, String tipeGolongan, int golonganPangkat) {
    System.out.println("===================================");
    System.out.println(getName(isAllLetters(nama), nama));
    // System.out.println("Masa Kerja: " + getMasaKerja(masaKerja,
    // golonganPangkat));
    // System.out.println("Tipe Golongan: " + getTipeGolongan(tipeGolongan,
    // golonganPangkat));
    // System.out.println("Golongan Pangkat: " +
    // getGolonganPangkat(golonganPangkat));
    System.out.println("Gaji Pokok: " + kalkulasiGajiPokok(masaKerja,
        tipeGolongan, golonganPangkat));
    System.out.println("===================================");
  }
}
