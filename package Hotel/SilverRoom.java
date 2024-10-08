/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel;

/**
 *
 * @author afifa
 */
// Membuat class SilverRoom yang merupakan turunan dari kelas Kamar
public class SilverRoom extends Kamar {
    
    // Constructor kelas SilverRoom dengan parameter jumlahKamar
    public SilverRoom(int jumlahKamar) {
        // Memanggil constructor superclass (Kamar) dengan tipe kamar, harga, deskripsi, dan jumlahKamar
        super("Silver Room", 500000, "Full fasilitas, view pekampungan", jumlahKamar);
    }

    // Override method tampilkanInfo dari kelas Kamar untuk menampilkan informasi spesifik
    @Override
    public void tampilkanInfo() {
        // Menampilkan pesan khusus untuk kamar nomor 1 (bisa disesuaikan dengan logika program)
        System.out.println("===== Kamar 1 =====");
        // Memanggil method tampilkanInfo dari superclass (Kamar) untuk menampilkan detail kamar lainnya
        super.tampilkanInfo();
    }
}