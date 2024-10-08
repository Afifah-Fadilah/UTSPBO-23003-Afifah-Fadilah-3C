/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemReservasiHotel;

/**
 *
 * @author afifa
 */

import Hotel.SilverRoom; // Mengimpor kelas SilverRoom dari package Hotel
import Hotel.GoldenRoom; // Mengimpor kelas GoldenRoom dari package Hotel
import Hotel.DeluxeRoom; // Mengimpor kelas DeluxeRoom dari package Hotel
import Hotel.Kamar; // Mengimpor kelas Kamar dari package Hotel
import java.util.ArrayList; // Mengimpor kelas ArrayList untuk membuat daftar dinamis
import java.util.Scanner; // Mengimpor kelas Scanner untuk menangani input pengguna

public class SistemReservasi {
    public static void main(String[] args) {
        ArrayList<Kamar> kamarList = new ArrayList<>(); // Membuat daftar kamar yang dapat tumbuh

        // Inisialisasi berbagai jenis kamar dan menambahkannya ke dalam daftar
        kamarList.add(new SilverRoom(10)); // Menambahkan SilverRoom dengan 10 kamar
        kamarList.add(new GoldenRoom(5)); // Menambahkan GoldenRoom dengan 5 kamar
        kamarList.add(new DeluxeRoom(3)); // Menambahkan DeluxeRoom dengan 3 kamar

        // Mengkonversi ArrayList ke array Kamar
        Kamar[] kamarArray = kamarList.toArray(new Kamar[0]);
        Admin admin1 = new Admin(kamarArray); // Membuat objek Admin dengan daftar kamar
        Customer customer = new Customer(kamarArray); // Membuat objek Customer dengan daftar kamar

        Scanner input = new Scanner(System.in); // Membuat objek Scanner untuk input dari pengguna
        int login; // Variabel untuk menyimpan pilihan login

        do {
            // Menampilkan menu utama
            System.out.println("===================================");
            System.out.println("|           Hotel Apipah          |");
            System.out.println("===================================");
            System.out.println("Login sebagai:\n1. Admin\n2. Customer\n3. Keluar"); // Pilihan login
            System.out.println("===================================");

            login = input.nextInt(); // Membaca pilihan login dari pengguna

            // Menangani pilihan login
            switch (login) {
                case 1:
                    admin1.login(input); // Memanggil metode login untuk admin
                    break;
                case 2:
                    customer.menuCustomer(input); // Memanggil metode menu untuk customer
                    break;
                case 3:
                    System.out.println("===================================");
                    System.out.println("Terimakasih telah menggunakan program..."); // Pesan keluar
                    break;
                default:
                    System.out.println("===================================");
                    System.out.println("Pilihan tidak valid."); // Pesan jika pilihan tidak valid
            }
        } while (login != 3); // Ulangi menu sampai pengguna memilih untuk keluar

        input.close(); // Menutup objek Scanner untuk mencegah kebocoran memori
    }
}