/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Mobil extends Kendaraan{
    public Mobil(int idKendaraan, String nomorPlat, String merk, String warna) {
        super(idKendaraan, nomorPlat, "Mobil", merk, warna);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Mobil ===");
        super.tampilkanInfo();
    }
}
