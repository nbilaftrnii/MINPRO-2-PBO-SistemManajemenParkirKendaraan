/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ParkirService {
        private ArrayList<Kendaraan> daftarKendaraan;
    private ArrayList<Petugas> daftarPetugas;
    private ArrayList<SlotParkir> daftarSlot;
    private ArrayList<Parkir> daftarParkir;

    private int idKendaraanBerikutnya = 2;
    private int idPetugasBerikutnya = 2;
    private int idSlotBerikutnya = 2;
    private int idParkirBerikutnya = 2;

    public ParkirService() {
        daftarKendaraan = new ArrayList<>();
        daftarPetugas = new ArrayList<>();
        daftarSlot = new ArrayList<>();
        daftarParkir = new ArrayList<>();

        // Dummy data kendaraan
        Kendaraan kendaraan = new Motor(
                1,
                "KT 1234 AB",
                "Honda Vario",
                "Hitam"
        );
        daftarKendaraan.add(kendaraan);

        // Dummy data petugas
        Petugas petugas = new Petugas(
                1,
                "Andi",
                "andi",
                "12345",
                "Pagi"
        );
        daftarPetugas.add(petugas);

        // Dummy data slot
        SlotParkir slot = new SlotParkir(
                1,
                "A01",
                "Motor",
                "Terisi"
        );
        daftarSlot.add(slot);

        // Dummy data parkir
        Parkir parkir = new Parkir(
                1,
                kendaraan,
                petugas,
                slot,
                "24-09-2026 08:00"
        );
        daftarParkir.add(parkir);
    }

    // Generate Id
    public int generateIdKendaraan() {
        return idKendaraanBerikutnya++;
    }

    public int generateIdPetugas() {
        return idPetugasBerikutnya++;
    }

    public int generateIdSlot() {
        return idSlotBerikutnya++;
    }

    public int generateIdParkir() {
        return idParkirBerikutnya++;
    }

    // Kendaraan
    public void tambahKendaraan(Kendaraan kendaraan) {
        daftarKendaraan.add(kendaraan);
    }

    public Kendaraan cariKendaraan(int id) {
        for (Kendaraan kendaraan : daftarKendaraan) {
            if (kendaraan.getIdKendaraan() == id) {
                return kendaraan;
            }
        }
        return null;
    }

    public ArrayList<Kendaraan> getAllKendaraan() {
        return daftarKendaraan;
    }

    // Petugas
    public void tambahPetugas(Petugas petugas) {
        daftarPetugas.add(petugas);
    }

    public Petugas cariPetugas(int id) {
        for (Petugas petugas : daftarPetugas) {
            if (petugas.getIdPetugas() == id) {
                return petugas;
            }
        }
        return null;
    }

    public ArrayList<Petugas> getAllPetugas() {
        return daftarPetugas;
    }

    // Slot Parkir
    public void tambahSlot(SlotParkir slot) {
        daftarSlot.add(slot);
    }

    public SlotParkir cariSlot(int id) {
        for (SlotParkir slot : daftarSlot) {
            if (slot.getIdSlot() == id) {
                return slot;
            }
        }
        return null;
    }

    public ArrayList<SlotParkir> getAllSlot() {
        return daftarSlot;
    }

    // Parkir
    public void tambahParkir(Parkir parkir) {
        daftarParkir.add(parkir);

        // Mengubah status slot menjadi terisi
        parkir.getSlot().setStatusSlot("Terisi");
    }

    public ArrayList<Parkir> getAllParkir() {
        return daftarParkir;
    }

    public Parkir cariById(int id) {
        for (Parkir parkir : daftarParkir) {
            if (parkir.getIdParkir() == id) {
                return parkir;
            }
        }
        return null;
    }

    // Update Parkir
    public void updateParkir(
            Parkir parkir,
            String waktuKeluar,
            int lamaParkir,
            String metodePembayaran,
            int jumlahBayar) {

        int tarif = (int) parkir.hitungTarif(lamaParkir);

        parkir.setWaktuKeluar(waktuKeluar);
        parkir.setMetodePembayaran(metodePembayaran);
        parkir.setJumlahBayar(jumlahBayar);
        parkir.setStatusParkir("Selesai");

        if (jumlahBayar >= tarif) {
            parkir.setStatusPembayaran("Lunas");
        } else {
            parkir.setStatusPembayaran("Belum Lunas");
        }

        // Slot kembali kosong setelah kendaraan keluar
        parkir.getSlot().setStatusSlot("Kosong");
    }

    // =========================
    // HAPUS PARKIR
    // =========================

    public void hapusParkir(Parkir parkir) {

        // Slot dikosongkan sebelum data parkir dihapus
        parkir.getSlot().setStatusSlot("Kosong");

        daftarParkir.remove(parkir);
    }
}