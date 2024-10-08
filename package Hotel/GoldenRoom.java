/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel;

/**
 *
 * @author afifa
 */
// Membuat class GoldenRoom yang merupakan turunan dari kelas Kamar
public class GoldenRoom extends Kamar {
    
    // Constructor kelas GoldenRoom dengan parameter jumlahKamar
    public GoldenRoom(int jumlahKamar) {
        // Memanggil constructor superclass (Kamar) dengan tipe kamar, harga, deskripsi, dan jumlahKamar
        super("Golden Room", 600000, "Full fasilitas, view city light", jumlahKamar);
    }

    // Override method tampilkanInfo dari kelas Kamar untuk menampilkan informasi spesifik
    @Override
    public void tampilkanInfo() {
        // Menampilkan pesan khusus untuk kamar nomor 2 (bisa diubah sesuai logika program)
        System.out.println("======= Kamar 2 =======");
        // Memanggil method tampilkanInfo dari superclass (Kamar) untuk menampilkan detail kamar lainnya
        super.tampilkanInfo();
    }
}