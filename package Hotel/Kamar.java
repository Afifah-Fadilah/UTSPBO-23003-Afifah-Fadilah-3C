/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel;

/**
 *
 * @author afifa
 */

// Class Kamar dibuat public agar dapat dipanggil di package lain
public class Kamar implements KamarInterface {
    
    // Deklarasi atribut public agar dapat diakses di luar class ini
    public String namaKamar; // Nama kamar, misalnya "Deluxe Room"
    public double hargaKamar; // Harga kamar, misalnya 700000
    public String deskripsiKamar; // Deskripsi singkat mengenai kamar
    public boolean tersedia; // Status ketersediaan kamar, apakah bisa dipesan atau tidak
    public int jumlahKamar; // Jumlah kamar yang tersedia dari tipe tertentu

    // Constructor untuk menginisialisasi atribut ketika objek Kamar dibuat
    public Kamar(String namaKamar, double hargaKamar, String deskripsiKamar, int jumlahKamar) {
        this.namaKamar = namaKamar; // Menginisialisasi nama kamar
        this.hargaKamar = hargaKamar; // Menginisialisasi harga kamar
        this.deskripsiKamar = deskripsiKamar; // Menginisialisasi deskripsi kamar
        this.jumlahKamar = jumlahKamar; // Menginisialisasi jumlah kamar
        this.tersedia = true; // Kamar dianggap tersedia secara default ketika baru dibuat
    }

    // Override method tampilkanInfo untuk menampilkan informasi kamar
    @Override
    public void tampilkanInfo() {
        // Menampilkan detail nama, harga, deskripsi, jumlah kamar, dan status ketersediaan
        System.out.println("Nama Kamar: " + namaKamar);
        System.out.println("Harga Kamar: " + hargaKamar);
        System.out.println("Deskripsi: " + deskripsiKamar);
        System.out.println("Jumlah Kamar Tersedia: " + jumlahKamar);
        System.out.println("Status Tersedia: " + (tersedia ? "Tersedia" : "Tidak Tersedia"));
        System.out.println("-----------------------------------");
    }

    // Override method getNamaKamar untuk mengembalikan nama kamar
    @Override
    public String getNamaKamar() {
        return namaKamar;
    }

    // Override method setNamaKamar untuk mengubah nama kamar
    @Override
    public void setNamaKamar(String namaKamarBaru) {
        this.namaKamar = namaKamarBaru;
    }

    // Override method setHargaKamar untuk mengubah harga kamar
    @Override
    public void setHargaKamar(double hargaKamarBaru) {
        this.hargaKamar = hargaKamarBaru;
    }

    // Override method setDeskripsiKamar untuk mengubah deskripsi kamar
    @Override
    public void setDeskripsiKamar(String deskripsiKamarBaru) {
        this.deskripsiKamar = deskripsiKamarBaru;
    }

    // Override method setJumlahKamar untuk mengubah jumlah kamar yang tersedia
    @Override
    public void setJumlahKamar(int jumlahKamarBaru) {
        this.jumlahKamar = jumlahKamarBaru;
    }

    // Override method setTersedia untuk mengubah status ketersediaan kamar (tersedia atau tidak)
    @Override
    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}