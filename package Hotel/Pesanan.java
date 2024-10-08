/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel;

/**
 *
 * @author afifa
 */

// Membuat class Pesanan yang merepresentasikan detail pemesanan kamar oleh customer
public class Pesanan {
    
    // Atribut private untuk menyimpan informasi pemesan dan detail pemesanan
    private String namaPemesan;        // Nama dari orang yang memesan kamar
    private String nomorKTP;           // Nomor KTP pemesan untuk identifikasi
    private Kamar kamar;               // Objek Kamar yang dipesan
    private int durasiHari;            // Durasi menginap dalam hitungan hari
    private double totalHarga;         // Total harga pemesanan
    private String alamatPemesan;      // Alamat dari pemesan
    private String tanggalCheckIn;     // Tanggal check-in yang dijadwalkan
    private String jamCheckIn;         // Jam check-in yang dijadwalkan
    private boolean paid;              // Status pembayaran, apakah sudah dibayar atau belum

    // Constructor untuk menginisialisasi objek Pesanan dengan data yang diberikan
    public Pesanan(String namaPemesan, String nomorKTP, Kamar kamar, int durasiHari, double totalHarga, String alamatPemesan, String tanggalCheckIn, String jamCheckIn) {
        this.namaPemesan = namaPemesan;              // Inisialisasi nama pemesan
        this.nomorKTP = nomorKTP;                   // Inisialisasi nomor KTP pemesan
        this.kamar = kamar;                         // Inisialisasi kamar yang dipesan
        this.durasiHari = durasiHari;               // Inisialisasi durasi menginap
        this.totalHarga = totalHarga;               // Inisialisasi total harga pemesanan
        this.alamatPemesan = alamatPemesan;         // Inisialisasi alamat pemesan
        this.tanggalCheckIn = tanggalCheckIn;       // Inisialisasi tanggal check-in
        this.jamCheckIn = jamCheckIn;               // Inisialisasi jam check-in
        this.paid = false;                          // Default, pesanan dianggap belum dibayar
    }

    // Method getter untuk mendapatkan nama pemesan
    public String getNamaPemesan() {
        return namaPemesan;
    }

    // Method getter untuk mendapatkan nomor KTP pemesan
    public String getNomorKTP() {
        return nomorKTP;
    }

    // Method getter untuk mendapatkan alamat pemesan
    public String getAlamatPemesan() {
        return alamatPemesan;
    }

    // Method getter untuk mendapatkan objek Kamar yang dipesan
    public Kamar getKamar() {
        return kamar;
    }

    // Method getter untuk mendapatkan durasi menginap dalam hari
    public int getDurasiHari() {
        return durasiHari;
    }

    // Method getter untuk mendapatkan total harga pemesanan
    public double getTotalHarga() {
        return totalHarga;
    }

    // Method getter untuk mendapatkan tanggal check-in yang dijadwalkan
    public String getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    // Method getter untuk mendapatkan jam check-in yang dijadwalkan
    public String getJamCheckIn() {
        return jamCheckIn;
    }

    // Method getter untuk mengecek apakah pesanan sudah dibayar atau belum
    public boolean isPaid() {
        return paid;
    }

    // Method setter untuk mengubah status pembayaran pesanan
    public void setPaid(boolean paid) {
        this.paid = paid; // Mengatur apakah pesanan sudah dibayar (true) atau belum (false)
    }
}