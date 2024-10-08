/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemReservasiHotel;

/**
 *
 * @author afifa
 */

import Hotel.Kamar; // Mengimpor kelas Kamar dari package Hotel untuk digunakan di dalam kelas Customer
import Hotel.Pesanan; // Mengimpor kelas Pesanan dari package Hotel untuk menangani pesanan kamar
import java.util.Scanner; // Mengimpor kelas Scanner untuk memungkinkan input dari pengguna

public class Customer {
    private Kamar[] kamarArray; // Array untuk menyimpan daftar kamar yang tersedia
    private Pesanan pesanan = null; // Menyimpan detail pesanan yang dibuat oleh customer

    // Konstruktor untuk inisialisasi objek Customer dengan daftar kamar yang diberikan
    public Customer(Kamar[] kamarArray) {
        this.kamarArray = kamarArray;
    }

    // Menampilkan menu pilihan untuk customer
    public void menuCustomer(Scanner input) {
        int pilihan; // Variabel untuk menyimpan pilihan menu customer

        do {
            // Menampilkan menu customer
            System.out.println("===================================");
            System.out.println("|          Menu Customer          |");
            System.out.println("===================================");
            System.out.println("1. Lihat Kamar"); // Opsi untuk melihat daftar kamar
            System.out.println("2. Pesan Kamar"); // Opsi untuk memesan kamar
            System.out.println("3. Bayar Pesanan"); // Opsi untuk membayar pesanan
            System.out.println("4. Lihat Pesanan"); // Opsi untuk melihat detail pesanan
            System.out.println("5. Keluar"); // Opsi untuk keluar dari menu
            System.out.println("===================================");
            System.out.print("Pilih menu (1-5): "); // Meminta pengguna memilih menu
            pilihan = input.nextInt(); // Membaca pilihan pengguna

            // Menangani pilihan menu
            switch (pilihan) {
                case 1:
                    lihatKamar(); // Memanggil metode untuk melihat kamar
                    break;
                case 2:
                    pesanKamar(input); // Memanggil metode untuk memesan kamar
                    break;
                case 3:
                    bayarPesanan(input); // Memanggil metode untuk membayar pesanan
                    break;
                case 4:
                    lihatPesanan(); // Memanggil metode untuk melihat pesanan
                    break;
                case 5:
                    System.out.println("Keluar dari menu customer."); // Menampilkan pesan keluar
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi."); // Menampilkan pesan jika pilihan tidak valid
            }
        } while (pilihan != 5); // Ulangi menu sampai pengguna memilih untuk keluar
    }

    // Menampilkan daftar kamar yang tersedia
    private void lihatKamar() {
        System.out.println("===================================");
        System.out.println("|          Daftar Kamar           |");
        System.out.println("===================================");

        // Iterasi melalui array kamar dan menampilkan informasi tentang kamar yang tidak null
        for (int i = 0; i < kamarArray.length; i++) {
            if (kamarArray[i] != null) {
                kamarArray[i].tampilkanInfo(); // Memanggil metode untuk menampilkan info kamar
            }
        }
    }

    // Metode untuk memesan kamar
    private void pesanKamar(Scanner input) {
        System.out.println("===================================");
        System.out.println("|           Pesan Kamar           |");
        System.out.println("===================================");

        // Meminta data pemesan
        System.out.print("Masukkan nama pemesan: ");
        input.nextLine(); // Membersihkan buffer
        String namaPemesan = input.nextLine();

        System.out.print("Masukkan nomor KTP: ");
        String nomorKTP = input.nextLine();

        System.out.print("Masukkan alamat: ");
        String alamatPemesan = input.nextLine();

        System.out.print("Masukkan tanggal check-in (dd-mm-yyyy): ");
        String tanggalCheckIn = input.nextLine();

        System.out.print("Masukkan jam check-in (hh:mm): ");
        String jamCheckIn = input.nextLine();
        
        // Menampilkan pilihan kamar yang tersedia untuk dipesan
        System.out.println("===================================");
        System.out.println("Pilih kamar yang ingin dipesan");
        System.out.println("===================================");

        // Menampilkan daftar kamar yang tersedia
        for (int i = 0; i < kamarArray.length; i++) {
            if (kamarArray[i] != null && kamarArray[i].tersedia) {
                // Menampilkan nama dan harga kamar
                System.out.println((i + 1) + ". " + kamarArray[i].namaKamar + " - Harga: Rp" + kamarArray[i].hargaKamar);
            }
        }

        // Meminta pengguna memilih kamar untuk dipesan
        System.out.println("===================================");
        System.out.print("Masukkan nomor kamar yang ingin dipesan (1-" + kamarArray.length + "): ");
        int nomorKamar = input.nextInt();

        // Validasi nomor kamar dan ketersediaan
        if (nomorKamar < 1 || nomorKamar > kamarArray.length || kamarArray[nomorKamar - 1] == null || !kamarArray[nomorKamar - 1].tersedia) {
            System.out.println("Kamar tidak tersedia."); // Pesan jika kamar tidak tersedia
            return; // Kembali dari metode jika kamar tidak valid
        }

        Kamar kamarDipilih = kamarArray[nomorKamar - 1]; // Menyimpan kamar yang dipilih
        System.out.print("Masukkan durasi (hari): ");
        int durasiHari = input.nextInt(); // Meminta durasi pemesanan

        double totalHarga = kamarDipilih.hargaKamar * durasiHari; // Menghitung total harga
        pesanan = new Pesanan(namaPemesan, nomorKTP, kamarDipilih, durasiHari, totalHarga, alamatPemesan, tanggalCheckIn, jamCheckIn); // Membuat objek Pesanan
        System.out.println("===================================");
        System.out.println("Pesanan berhasil dibuat! \nTotal harga: Rp" + totalHarga); // Menampilkan pesan berhasil
        System.out.println("===================================");

        // Meminta konfirmasi pembayaran
        System.out.print("Lakukan pembayaran? (yes/no): ");
        String pembayaran = input.next();
        if (pembayaran.equalsIgnoreCase("yes")) {
            pesanan.setPaid(true); // Menandai pesanan sebagai dibayar
            kamarDipilih.setTersedia(false); // Mengubah status kamar menjadi tidak tersedia setelah pembayaran
            System.out.println("Pembayaran berhasil. Kamar telah dipesan.");
        } else {
            System.out.println("Pembayaran dibatalkan."); // Pesan jika pembayaran dibatalkan
        }
    }

    // Metode untuk membayar pesanan
    private void bayarPesanan(Scanner input) {
        if (pesanan == null) { // Memeriksa apakah ada pesanan
            System.out.println("Anda belum melakukan pemesanan."); // Pesan jika tidak ada pesanan
            return; // Kembali dari metode jika tidak ada pesanan
        }

        // Menampilkan detail pesanan untuk pembayaran
        System.out.println("===================================");
        System.out.println("|          Bayar Pesanan          |");
        System.out.println("===================================");
        System.out.println("Nama Pemesan: " + pesanan.getNamaPemesan());
        System.out.println("Nomor KTP: " + pesanan.getNomorKTP());
        System.out.println("Alamat: " + pesanan.getAlamatPemesan());
        System.out.println("Kamar: " + pesanan.getKamar().namaKamar);
        System.out.println("Durasi: " + pesanan.getDurasiHari() + " hari");
        System.out.println("Total Harga: " + pesanan.getTotalHarga());
        System.out.println("Tanggal Check-in: " + pesanan.getTanggalCheckIn());
        System.out.println("Jam Check-in: " + pesanan.getJamCheckIn());
        System.out.println("Status Pembayaran: " + (pesanan.isPaid() ? "Sudah dibayar" : "Belum dibayar"));

        // Meminta konfirmasi pembayaran
        System.out.print("Konfirmasi pembayaran? (yes/no): ");
        String konfirmasi = input.next();
        if (konfirmasi.equalsIgnoreCase("yes")) {
            pesanan.setPaid(true); // Menandai pesanan sebagai dibayar
            pesanan.getKamar().setTersedia(false); // Mengubah status kamar menjadi tidak tersedia setelah pembayaran
            System.out.println("Pembayaran berhasil. Kamar telah dipesan.");
        } else {
            System.out.println("Pembayaran dibatalkan."); // Pesan jika pembayaran dibatalkan
        }
    }

    // Metode untuk melihat detail pesanan yang telah dibuat
    private void lihatPesanan() {
        if (pesanan != null) { // Memeriksa apakah ada pesanan
            System.out.println("===================================");
            System.out.println("|         Detail Pesanan          |");
            System.out.println("===================================");
            System.out.println("Nama Pemesan: " + pesanan.getNamaPemesan());
            System.out.println("Nomor KTP: " + pesanan.getNomorKTP());
            System.out.println("Alamat: " + pesanan.getAlamatPemesan());
            System.out.println("Kamar: " + pesanan.getKamar().namaKamar);
            System.out.println("Durasi: " + pesanan.getDurasiHari() + " hari");
            System.out.println("Total Harga: " + pesanan.getTotalHarga());
            System.out.println("Tanggal Check-in: " + pesanan.getTanggalCheckIn());
            System.out.println("Jam Check-in: " + pesanan.getJamCheckIn());
            System.out.println("Status Pembayaran: " + (pesanan.isPaid() ? "Sudah dibayar" : "Belum dibayar"));
        } else {
            System.out.println("Anda belum melakukan pemesanan."); // Pesan jika tidak ada pesanan
        }
    }
}