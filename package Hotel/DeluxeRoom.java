/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel;

/**
 *
 * @author afifa
 */

// Membuat class DeluxeRoom yang merupakan turunan dari kelas Kamar
public class DeluxeRoom extends Kamar {
    
    // Constructor kelas DeluxeRoom dengan parameter jumlahKamar
    public DeluxeRoom(int jumlahKamar) {
        // Memanggil constructor superclass (Kamar) dengan mengisi tipe kamar, harga, deskripsi, dan jumlahKamar
        super("Deluxe Room", 700000, "Full fasilitas, view pegunungan", jumlahKamar);
    }

    // Override method tampilkanInfo dari kelas Kamar untuk menampilkan informasi yang lebih spesifik
    @Override
    public void tampilkanInfo() {
        // Menampilkan pesan khusus untuk kamar nomor 3 (bisa diganti sesuai logika program)
        System.out.println("======= Kamar 3 =======");
        // Memanggil method tampilkanInfo dari superclass (Kamar) untuk menampilkan detail kamar lainnya
        super.tampilkanInfo();
    }
}
