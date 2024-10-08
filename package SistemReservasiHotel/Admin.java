/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemReservasiHotel;

/**
 *
 * @author afifa
*/
import Hotel.Kamar; // Mengimpor kelas Kamar dari package Hotel
import java.util.Scanner; // Mengimpor kelas Scanner untuk input pengguna
import Hotel.KamarInterface; // Mengimpor interface KamarInterface dari package Hotel

// Kelas Admin yang menangani fungsi terkait admin dalam sistem reservasi hotel
public class Admin {
    private Kamar[] kamarArray; // Array untuk menyimpan daftar kamar

    // Constructor untuk menginisialisasi objek Admin dengan array kamar
    public Admin(Kamar[] kamarArray) {
        this.kamarArray = kamarArray; // Menyimpan daftar kamar ke atribut kamarArray
    }

    // Method untuk melakukan login admin
    public void login(Scanner input) {
        System.out.println("===================================");
        System.out.println("|           Login Admin           |");
        System.out.println("===================================");
        System.out.print("Masukkan password admin: ");
        String password = input.next(); // Mengambil input password dari pengguna

        // Cek password (hardcoded untuk kesederhanaan)
        if (password.equals("admin123")) {
            System.out.println("Login berhasil!");
            menuAdmin(input); // Panggil menu admin setelah login berhasil
        } else {
            System.out.println("Password salah. Akses ditolak."); // Pesan jika password salah
        }
    }

    // Method untuk menampilkan menu admin setelah login berhasil
    private void menuAdmin(Scanner input) {
        int pilihan; // Variabel untuk menyimpan pilihan menu admin

        do {
            System.out.println("==================================="); 
            System.out.println("|           Menu Admin            |");
            System.out.println("==================================="); 
            System.out.println("1. Lihat Kamar");
            System.out.println("2. Edit Kamar");
            System.out.println("3. Edit Status Kamar Tersedia");
            System.out.println("4. Keluar");
            System.out.println("==================================="); 
            System.out.print("Pilih menu (1-4): ");
            pilihan = input.nextInt(); // Mengambil pilihan menu dari pengguna

            switch (pilihan) {
                case 1:
                    lihatKamar(); // Panggil method untuk melihat daftar kamar
                    break;
                case 2:
                    editKamar(input); // Panggil method untuk mengedit kamar
                    break;
                case 3:
                    editStatusKamarTersedia(input); // Panggil method untuk mengedit status kamar
                    break;
                case 4:
                    System.out.println("Keluar dari menu admin."); // Pesan saat keluar dari menu
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi."); // Pesan jika pilihan tidak valid
            }
        } while (pilihan != 4); // Ulangi sampai pilihan 4 (keluar) dipilih
    }

    // Method untuk menampilkan daftar kamar yang tersedia
    private void lihatKamar() {
        System.out.println("==================================="); 
        System.out.println("|          Daftar Kamar           |");
        System.out.println("==================================="); 
        for (Kamar kamar : kamarArray) { // Iterasi melalui semua kamar dalam kamarArray
            if (kamar != null) {
                kamar.tampilkanInfo(); // Panggil method untuk menampilkan informasi kamar
            }
        }
    }

    // Method untuk mengedit informasi kamar
    private void editKamar(Scanner input) {
        System.out.println("===================================");
        System.out.println("|           Edit Kamar            |");
        System.out.println("==================================="); 
        System.out.print("Masukkan nomor kamar yang ingin diedit (1-" + kamarArray.length + "): ");
        int nomorKamar = input.nextInt(); // Mengambil input nomor kamar yang ingin diedit

        // Validasi nomor kamar
        if (nomorKamar < 1 || nomorKamar > kamarArray.length || kamarArray[nomorKamar - 1] == null) {
            System.out.println("Kamar tidak ditemukan."); // Pesan jika kamar tidak valid
            return; // Keluar dari method
        }

        KamarInterface kamarDipilih = kamarArray[nomorKamar - 1]; // Ambil kamar yang dipilih

        // Tampilkan nama kamar yang sedang diedit
        System.out.println("Editing Kamar: " + kamarDipilih.getNamaKamar());
        System.out.print("Masukkan nama kamar baru (tekan Enter untuk tetap): ");
        input.nextLine(); // Membersihkan buffer
        String namaKamarBaru = input.nextLine(); // Mengambil input nama kamar baru
        if (!namaKamarBaru.isEmpty()) {
            kamarDipilih.setNamaKamar(namaKamarBaru); // Set nama kamar baru jika diisi
        }

        System.out.print("Masukkan harga kamar baru (tekan Enter untuk tetap): ");
        String hargaKamarBaruInput = input.nextLine(); // Mengambil input harga kamar baru
        if (!hargaKamarBaruInput.isEmpty()) {
            double hargaKamarBaru = Double.parseDouble(hargaKamarBaruInput); // Parsing input menjadi double
            kamarDipilih.setHargaKamar(hargaKamarBaru); // Set harga kamar baru
        }

        System.out.print("Masukkan deskripsi kamar baru (tekan Enter untuk tetap): ");
        String deskripsiKamarBaru = input.nextLine(); // Mengambil input deskripsi kamar baru
        if (!deskripsiKamarBaru.isEmpty()) {
            kamarDipilih.setDeskripsiKamar(deskripsiKamarBaru); // Set deskripsi kamar baru
        }

        System.out.print("Masukkan jumlah kamar baru (tekan Enter untuk tetap): ");
        String jumlahKamarBaruInput = input.nextLine(); // Mengambil input jumlah kamar baru
        if (!jumlahKamarBaruInput.isEmpty()) {
            int jumlahKamarBaru = Integer.parseInt(jumlahKamarBaruInput); // Parsing input menjadi integer
            kamarDipilih.setJumlahKamar(jumlahKamarBaru); // Set jumlah kamar baru
        }

        System.out.println("Kamar berhasil diedit."); // Konfirmasi setelah berhasil mengedit
    }

    // Method untuk mengedit status ketersediaan kamar
    private void editStatusKamarTersedia(Scanner input) {
        System.out.println("===================================");
        System.out.println("|        Edit Status Kamar        |");
        System.out.println("==================================="); 
        System.out.print("Masukkan nomor kamar yang ingin diedit statusnya (1-" + kamarArray.length + "): ");
        int nomorKamar = input.nextInt(); // Mengambil input nomor kamar yang ingin diedit statusnya

        // Validasi nomor kamar
        if (nomorKamar < 1 || nomorKamar > kamarArray.length || kamarArray[nomorKamar - 1] == null) {
            System.out.println("Kamar tidak valid."); // Pesan jika kamar tidak valid
            return; // Keluar dari method
        }

        KamarInterface kamarDipilih = kamarArray[nomorKamar - 1]; // Ambil kamar yang dipilih

        System.out.print("Apakah kamar ini tersedia? (true/false): ");
        boolean tersedia = input.nextBoolean(); // Mengambil input status ketersediaan kamar
        kamarDipilih.setTersedia(tersedia); // Set status ketersediaan kamar

        System.out.println("Status kamar telah diperbarui."); // Konfirmasi setelah status diperbarui
    }
}