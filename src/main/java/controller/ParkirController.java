/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Kendaraan;
import model.Motor;
import model.Mobil;
import model.Petugas;
import model.SlotParkir;
import model.Parkir;
import service.ParkirService;
import view.ParkirView;

/**
 *
 * @author ASUS
 */
public class ParkirController {
    private ParkirService service;
    private ParkirView view;

    public ParkirController(ParkirService service, ParkirView view) {
        this.service = service;
        this.view = view;
    }

    public void jalankan() {

        boolean berjalan = true;

        while (berjalan) {

            view.tampilkanMenu();

            int pilihan = view.inputIntPositif("Pilih menu: ");

            switch (pilihan) {
                
                case 1:
                    tambahKendaraan();
                    break;

                case 2:
                    tambahPetugas();
                    break;

                case 3:
                    tambahSlot();
                    break;

                case 4:
                    tambahParkir();
                    break;

                case 5:
                    lihatParkir();
                    break;

                case 6:
                    updateParkir();
                    break;

                case 7:
                    hapusParkir();
                    break;

                case 8:
                    cariParkir();
                    break;

                case 9:
                    berjalan = false;
                    view.pesan("Terima kasih!");
                    break;

                default:
                    view.pesan("Menu hanya 1 sampai 9!");
            }
        }
    }
    // Tambah Kendaraan
    private void tambahKendaraan() {
        System.out.println("\n=== TAMBAH KENDARAAN ===");
        int id = service.generateIdKendaraan();
        System.out.println("ID Kendaraan: " + id);
        String plat = view.inputTidakKosong(
                "Nomor Plat: "
        );
        
        String jenis = view.inputJenisKendaraan();
        String merk = view.inputMerk();
        String warna = view.inputTidakKosong(
                "Warna: "
        );
        
        Kendaraan kendaraan;

        if (jenis.equalsIgnoreCase("Motor")) {
            kendaraan = new Motor(
                    id,
                    plat,
                    merk,
                    warna
            );
        } else {
            kendaraan = new Mobil(
                    id,
                    plat,
                    merk,
                    warna
            );
        }
        
        service.tambahKendaraan(kendaraan);

        view.pesan("Data kendaraan berhasil ditambahkan.");
    }

    // Tambah Petugas
    private void tambahPetugas() {
        System.out.println("\n=== TAMBAH PETUGAS ===");
        int id = service.generateIdPetugas();
        System.out.println("ID Petugas: " + id);
        String nama = view.inputTidakKosong(
                "Nama Petugas: "
        );

        String username = view.inputTidakKosong(
                "Username: "
        );
        
        String password = view.inputTidakKosong(
                "Password: "
        );

        String shift = view.inputTidakKosong(
                "Shift: "
        );

        Petugas petugas = new Petugas(
                id,
                nama,
                username,
                password,
                shift
        );

        service.tambahPetugas(petugas);

        view.pesan("Data petugas berhasil ditambahkan.");
    }
    
    // Tambah Slot
    private void tambahSlot() {
        System.out.println("\n=== TAMBAH SLOT PARKIR ===");
        int id = service.generateIdSlot();
        System.out.println("ID Slot: " + id);
        String nomor = view.inputTidakKosong(
                "Nomor Slot: "
        );

        String jenis = view.inputJenisSlot();
        SlotParkir slot = new SlotParkir(
                id,
                nomor,
                jenis,
                "Kosong"
        );
        
        service.tambahSlot(slot);
        view.pesan("Data slot berhasil ditambahkan.");
    }

    // Tambah Parkir
    private void tambahParkir() {
        System.out.println("\n=== TAMBAH DATA PARKIR ===");

        // Menampilkan data agar user tidak perlu mengingat ID
        view.tampilkanKendaraan(
                service.getAllKendaraan()
        );

        view.tampilkanPetugas(
                service.getAllPetugas()
        );

        view.tampilkanSlot(
                service.getAllSlot()
        );
        
        int idParkir = service.generateIdParkir();

        System.out.println("ID Parkir: " + idParkir);

        int idKendaraan = view.inputIntPositif(
                "ID Kendaraan: "
        );

        Kendaraan kendaraan =
                service.cariKendaraan(idKendaraan);

        if (kendaraan == null) {
            view.pesan("Kendaraan tidak ditemukan!");
            return;
        }

        int idPetugas = view.inputIntPositif(
                "ID Petugas: "
        );

        Petugas petugas =
                service.cariPetugas(idPetugas);

        if (petugas == null) {
            view.pesan("Petugas tidak ditemukan!");
            return;
        }
        
        int idSlot = view.inputIntPositif(
                "ID Slot: "
        );

        SlotParkir slot =
                service.cariSlot(idSlot);

        if (slot == null) {
            view.pesan("Slot tidak ditemukan!");
            return;
        }

        if (slot.getStatusSlot().equalsIgnoreCase("Terisi")) {
            view.pesan("Slot sedang terisi!");
            return;
        }

        if (!slot.getJenisSlot().equalsIgnoreCase(
                kendaraan.getJenisKendaraan())) {

            view.pesan(
                    "Jenis slot tidak sesuai dengan jenis kendaraan!"
            );
            return;
        }
        
       String waktuMasuk = view.inputTidakKosong(
                "Waktu Masuk: "
        );

        Parkir parkir = new Parkir(
                idParkir,
                kendaraan,
                petugas,
                slot,
                waktuMasuk
        );

        service.tambahParkir(parkir);

        view.pesan("Data parkir berhasil ditambahkan.");
    }
    
    // Lihat
    private void lihatParkir() {
        view.tampilkanParkir(
                service.getAllParkir()
        );
    }

    // Update
    private void updateParkir() {
        System.out.println("\n=== UPDATE DATA PARKIR ===");
        view.tampilkanParkir(
                service.getAllParkir()
        );

        int id = view.inputIntPositif(
                "ID Parkir yang diupdate: "
        );
        
        Parkir parkir =
                service.cariById(id);

        if (parkir == null) {
            view.pesan("Data parkir tidak ditemukan!");
            return;
        }

        String waktuKeluar = view.inputTidakKosong(
                "Waktu Keluar: "
        );

        int lamaParkir = view.inputIntPositif(
                "Lama Parkir (jam): "
        );

        String metode =
                view.inputMetodePembayaran();

        int tarif =
                (int) parkir.hitungTarif(lamaParkir);

        System.out.println(
                "Total Tarif: Rp" + tarif
        );
        
        int jumlahBayar =
                view.inputIntPositif(
                        "Jumlah Bayar: Rp"
                );

        if (jumlahBayar < tarif) {
            view.pesan(
                    "Pembayaran kurang! Data belum dapat diselesaikan."
            );
            return;
        }

        int kembalian =
                jumlahBayar - tarif;

        service.updateParkir(
                parkir,
                waktuKeluar,
                lamaParkir,
                metode,
                jumlahBayar
        );
        
        view.pesan("Data parkir berhasil diupdate.");
        view.pesan("Kembalian: Rp" + kembalian);
    }

    // Hapus
    private void hapusParkir() {
        System.out.println("\n=== HAPUS DATA PARKIR ===");
        view.tampilkanParkir(
                service.getAllParkir()
        );

        int id = view.inputIntPositif(
                "ID Parkir yang dihapus: "
        );

        Parkir parkir =
                service.cariById(id);

        if (parkir == null) {
            view.pesan("Data parkir tidak ditemukan!");
            return;
        }
        
        System.out.println("\nData yang akan dihapus:");
        parkir.tampilkanInfo();

        boolean konfirmasi =
                view.konfirmasiHapus();

        if (konfirmasi) {
            service.hapusParkir(parkir);
            view.pesan(
                    "Data parkir berhasil dihapus."
            );
        } else {
            view.pesan(
                    "Penghapusan dibatalkan."
            );
        }
    }
    
    // Cari
    private void cariParkir() {
        System.out.println("\n=== CARI DATA PARKIR ===");
        int id = view.inputIntPositif(
                "ID Parkir: "
        );

        Parkir parkir =
                service.cariById(id);

        if (parkir == null) {
            view.pesan(
                    "Data parkir tidak ditemukan!"
            );
            return;
        }

        parkir.tampilkanInfo();
    }
}
