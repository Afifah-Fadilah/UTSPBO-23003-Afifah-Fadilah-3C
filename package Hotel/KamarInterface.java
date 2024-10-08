/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Hotel;

/**
 *
 * @author afifa
 */

// Membuat interface KamarInterface, yang mana akan diimplementasikan di kelas Kamar
public interface KamarInterface {
    
    // Method untuk menampilkan informasi kamar, yang akan diimplementasikan di kelas yang mengimplementasikan interface ini
    void tampilkanInfo();

    // Method untuk mendapatkan nama kamar
    public String getNamaKamar();

    // Method untuk mengubah nama kamar
    public void setNamaKamar(String namaKamarBaru);

    // Method untuk mengubah harga kamar
    public void setHargaKamar(double hargaKamarBaru);

    // Method untuk mengubah deskripsi kamar
    public void setDeskripsiKamar(String deskripsiKamarBaru);

    // Method untuk mengubah jumlah kamar
    public void setJumlahKamar(int jumlahKamarBaru);
    
    // Method untuk mengubah status ketersediaan kamar (tersedia atau tidak)
    public void setTersedia(boolean tersedia);
}