package pemlan4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenyimpan KHS :");
            System.out.println("==============================");
            Mahasiswa mahasiswa = new Mahasiswa();
            System.out.println("- Data Mahasiswa");
            System.out.print("Masukkan NIM Mahasiswa : ");
            mahasiswa.setNim(scanner.nextLine());
            System.out.print("Masukkan Nama Mahasiswa : ");
            mahasiswa.setNama(scanner.nextLine());

            System.out.println("\n- Data Mata Kuliah");
            List<MataKuliah> mataKuliahs = new ArrayList<>();
            while (true) {
                MataKuliah mataKuliah = new MataKuliah();
                System.out.print("\nMasukkan Kode MataKuliah : ");
                mataKuliah.setKode(scanner.nextLine());
                System.out.print("Masukkan Nama MataKuliah : ");
                mataKuliah.setNama(scanner.nextLine());
                mataKuliahs.add(mataKuliah);

                System.out.print("\nApakah Anda ingin menambahkan Mata Kuliah lagi? (yes/no) ");
                String input = scanner.nextLine();
                if (!input.equalsIgnoreCase("yes")) {
                    break;
                }
            }

            for (MataKuliah mataKuliah : mataKuliahs) {
                System.out.print("\nMasukkan Nilai Angka Mata Kuliah " + mataKuliah.getNama() + ": ");
                mahasiswa.tambahNilai(mataKuliah.getKode(), Integer.parseInt(scanner.nextLine()));
            }

            System.out.println("\nMencetak KHS Mahasiswa :");
            System.out.println("==============================");
            System.out.println("- Hasil Mahasiswa");
            System.out.println("   NIM  : " + mahasiswa.getNim());
            System.out.println("   Nama : " + mahasiswa.getNama());
            System.out.println("\n- Mata Kuliah");
            for (MataKuliah mataKuliah : mataKuliahs) {
                System.out.println("   Kode : " + mataKuliah.getKode());
                System.out.println("   Nama : " + mataKuliah.getNama());
                int nilaiAngka = mahasiswa.getNilaiAngkaMap().get(mataKuliah.getKode());
                String nilaiHuruf = konversiNilaiAngkaKeHuruf(nilaiAngka);
                System.out.println("   Nilai Huruf : " + nilaiHuruf);
                System.out.println();
            }

            System.out.print("\nApakah Anda ingin menambahkan data mahasiswa lagi? (yes/no) ");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }

    public static String konversiNilaiAngkaKeHuruf(int nilaiAngka) {
        if (nilaiAngka >= 80) {
            return "A";
        } else if (nilaiAngka >= 75) {
            return "B+";
        } else if (nilaiAngka >= 69) {
            return "B";
        } else if (nilaiAngka >= 60) {
            return "C+";
        } else if (nilaiAngka >= 55) {
            return "C";
        } else if (nilaiAngka >= 50) {
            return "D+";
        } else if (nilaiAngka >= 44) {
            return "D";
        } else {
            return "E";
        }
    }
}
