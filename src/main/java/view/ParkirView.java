/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Kendaraan;
import model.Petugas;
import model.SlotParkir;
import model.Parkir;

/**
 *
 * @author ASUS
 */
public class ParkirView {
    private Scanner input;

    public ParkirView(Scanner input) {
        this.input = input;
    }
    // Validasi
    public int inputIntPositif(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                int angka = Integer.parseInt(input.nextLine().trim());

                if (angka > 0) {
                    return angka;
                }

                System.out.println("Input harus lebih dari 0!");

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }
    
    public String inputTidakKosong(String pesan) {
        while (true) {
            System.out.print(pesan);
            String data = input.nextLine().trim();

            if (!data.isEmpty()) {
                return data;
            }

            System.out.println("Input tidak boleh kosong!");
        }
    }
    
    public String inputMerk() {
    while (true) {
        System.out.print("Merk: ");
        String merk = input.nextLine().trim();

        if (merk.isEmpty()) {
            System.out.println("Merk tidak boleh kosong!");
        } else if (!merk.matches(".*[a-zA-Z].*")) {
            System.out.println("Merk harus mengandung huruf!");
        } else {
            return merk;
        }
    }
}
    
    public String inputJenisKendaraan() {
        while (true) {
            String jenis = inputTidakKosong(
                    "Jenis Kendaraan (Motor/Mobil): "
            );

            if (jenis.equalsIgnoreCase("Motor")
                    || jenis.equalsIgnoreCase("Mobil")) {
                return jenis;
            }

            System.out.println(
                    "Jenis kendaraan hanya Motor atau Mobil!"
            );
        }
    }
    
    public String inputJenisSlot() {
        while (true) {
            String jenis = inputTidakKosong(
                    "Jenis Slot (Motor/Mobil): "
            );

            if (jenis.equalsIgnoreCase("Motor")
                    || jenis.equalsIgnoreCase("Mobil")) {
                return jenis;
            }

            System.out.println(
                    "Jenis slot hanya Motor atau Mobil!"
            );
        }
    }
    
    public String inputMetodePembayaran() {
        while (true) {
            String metode = inputTidakKosong(
                    "Metode Pembayaran (Cash/QRIS): "
            );

            if (metode.equalsIgnoreCase("Cash")
                    || metode.equalsIgnoreCase("QRIS")) {
                return metode;
            }

            System.out.println(
                    "Metode pembayaran hanya Cash atau QRIS!"
            );
        }
    }
    
    public boolean konfirmasiHapus() {
        while (true) {
            String pilihan = inputTidakKosong(
                    "Yakin ingin menghapus data? (Y/T): "
            );

            if (pilihan.equalsIgnoreCase("Y")) {
                return true;
            }

            if (pilihan.equalsIgnoreCase("T")) {
                return false;
            }

            System.out.println("Masukkan Y atau T!");
        }
    }
    
     // Menu
    public void tampilkanMenu() {
        System.out.println();
            System.out.println("|===================================================|");
            System.out.println("|                                                   |");
            System.out.println("|                🚗  MY PARKIR GW 🚗                  |");
            System.out.println("|         SISTEM MANAJEMEN PARKIR KENDARAAN         |");
            System.out.println("|                                                   |");
            System.out.println("|           ------- Smart Parking  -------          |");
            System.out.println("|                                                   |");
            System.out.println("|===================================================|");
            System.out.println("------------------- MENU UTAMA ----------------------");
            System.out.println("|                                                   |");
            System.out.println("|   [1]  Tambah Kendaraan                           |");
            System.out.println("|   [2]  Tambah Petugas                             |");
            System.out.println("|   [3]  Tambah Slot Parkir                         |");
            System.out.println("|   [4]  Tambah Data Parkir                         |");
            System.out.println("|   [5]  Lihat Data Parkir                          |");
            System.out.println("|   [6]  Update Data Parkir                         |");
            System.out.println("|   [7]  Hapus Data Parkir                          |");
            System.out.println("|   [8]  Cari Data Parkir                           |");
            System.out.println("|   [9]  Keluar                                     |");
            System.out.println("|                                                   |");
            System.out.println("-----------------------------------------------------");    
    }
    
    // Tampil Data
    public void tampilkanKendaraan(ArrayList<Kendaraan> daftar) {
        System.out.println("\n========== DATA KENDARAAN ==========");

        for (Kendaraan kendaraan : daftar) {
            kendaraan.tampilkanInfo();
            System.out.println("------------------------------------");
        }
    }

    public void tampilkanPetugas(ArrayList<Petugas> daftar) {
        System.out.println("\n========== DATA PETUGAS ==========");

        for (Petugas petugas : daftar) {
            petugas.tampilkanInfo();
            System.out.println("----------------------------------");
        }
    }
    
    public void tampilkanSlot(ArrayList<SlotParkir> daftar) {
        System.out.println("\n========== DATA SLOT ==========");

        for (SlotParkir slot : daftar) {
            slot.tampilkanInfo();
            System.out.println("--------------------------------");
        }
    }

    public void tampilkanParkir(ArrayList<Parkir> daftar) {
        System.out.println();

        if (daftar.isEmpty()) {
            System.out.println("Belum ada data parkir.");
            return;
        }

        for (Parkir parkir : daftar) {
            parkir.tampilkanInfo();
        }
    }

    public void pesan(String pesan) {
        System.out.println(pesan);
    }
}
