# 🚗 Sistem Manajemen Parkir Kendaraan 🚗

**Nama** : Nabila Fitriani 

**NIM**  : 2509116063  

**Kelas** : B  

---

## 📌 Deskripsi Singkat Program

Program ini merupakan aplikasi berbasis **Java** yang digunakan untuk mengelola sistem parkir kendaraan pada berbagai tempat yang menyediakan area parkir, seperti **coffee shop, mall, kampus, perkantoran, maupun tempat usaha lainnya.**

Program membantu petugas dalam mengelola data kendaraan, petugas, slot parkir, dan transaksi parkir. Sistem menyediakan fitur **CRUD (Create, Read, Update, Delete)** pada data parkir, mulai dari menambahkan, melihat, memperbarui, menghapus, hingga mencari data berdasarkan ID.

Program juga dapat menghitung tarif parkir berdasarkan **jenis kendaraan dan lama parkir**, **mengelola status slot**, serta **menampilkan receipt pembayaran** setelah transaksi selesai.

🔹 Fitur Program
- Mengelola data kendaraan, petugas, slot parkir, dan transaksi parkir.
- Melihat, mencari, memperbarui, dan menghapus data parkir.
- Menghitung tarif parkir dan pembayaran berdasarkan lama parkir.
- Menampilkan _receipt_ pembayaran dan kembalian.
- Menyediakan _dummy_ data awal dan generate ID otomatis.
- Menerapkan validasi input dan konfirmasi penghapusan.
- Menerapkan MVC, Access Modifier, Encapsulation, Inheritance, dan Polymorphism.

  ---
  ## 📂 Struktur Program

  Program menggunakan struktur MVC (Model-View-Controller) dengan beberapa package yang memiliki fungsi berbeda.

  <img width="347" height="324" alt="image" src="https://github.com/user-attachments/assets/9bea8063-b020-4840-acda-c5203ce68571" />

  **Penjelasan Package**
  
  **1. model**

  Berisi class yang merepresentasikan objek dalam sistem, yaitu Kendaraan, Motor, Mobil, Petugas, SlotParkir, dan Parkir.

   **2. view**

  Berisi ParkirView yang menangani tampilan menu, input user, validasi input, dan pesan yang ditampilkan kepada user.
  
  **3. controller**

  Berisi ParkirController yang mengatur alur program dan menghubungkan bagian View dengan Service.

  **4. service**

  Berisi ParkirService yang menangani pengelolaan data menggunakan ArrayList, seperti tambah, cari, update, hapus, dan generate ID.

  **5. main**

  Berisi Main sebagai titik awal program. Class ini membuat object Service, View, dan Controller, kemudian menjalankan program.

---
## ⚙️ Penjelasan Alur Program

### 1. Menu Utama

<img width="383" height="376" alt="image" src="https://github.com/user-attachments/assets/b195205a-9bf5-4ca6-9824-e32f3d05a672" />

Program menampilkan menu utama yang berisi pilihan untuk menambah, melihat, memperbarui, menghapus, dan mencari data parkir. User dapat memilih menu dengan memasukkan nomor sesuai fitur yang ingin digunakan.

---
### 2. Tambah Kendaraan

<img width="295" height="159" alt="image" src="https://github.com/user-attachments/assets/10abc1d8-3af4-47c1-8c46-6b75af025812" />

User memilih jenis kendaraan Motor atau Mobil, kemudian memasukkan nomor plat, merk, dan warna. ID kendaraan dibuat secara otomatis oleh sistem. Setelah data valid, kendaraan disimpan ke dalam sistem.

---
### 3. Tambah Petugas

<img width="254" height="161" alt="image" src="https://github.com/user-attachments/assets/00a5b4aa-18d1-403a-8a33-1d0ad76e9ba1" />

User memasukkan data petugas berupa nama, username, password, dan shift. ID petugas dibuat secara otomatis oleh sistem. Setelah data valid, petugas disimpan dan dapat digunakan dalam transaksi parkir.

---
### 4. Tambah Slot Parkir

<img width="228" height="125" alt="image" src="https://github.com/user-attachments/assets/aeb0afff-d866-4f5c-be0b-484f22bf76ba" />

User memasukkan nomor slot dan memilih jenis slot yaitu Motor atau Mobil. ID slot dibuat secara otomatis dan setiap slot baru memiliki status Kosong, sehingga dapat digunakan untuk kendaraan yang sesuai dengan jenis slot.

---
### 5. Tambah Data Parkir

<img width="260" height="324" alt="image" src="https://github.com/user-attachments/assets/2d47fcf2-787d-41ca-897e-102165687602" /><br>

<img width="248" height="307" alt="image" src="https://github.com/user-attachments/assets/d6f6d84f-f6c9-4b5f-8241-fc091febaa34" /><br>

<img width="238" height="194" alt="image" src="https://github.com/user-attachments/assets/fb124b16-c272-4b37-b1ca-ecb6fb461d35" />

Sebelum menambahkan data parkir, sistem menampilkan data kendaraan, petugas, dan slot yang tersedia sehingga user tidak perlu mengingat ID yang telah dibuat.
User kemudian memilih ID kendaraan, ID petugas, ID slot, dan memasukkan waktu masuk. ID parkir dibuat secara otomatis oleh sistem.
Sistem melakukan pengecekan untuk memastikan data tersedia, slot masih kosong, dan jenis kendaraan sesuai dengan jenis slot. Jika semua sesuai, data parkir berhasil ditambahkan dan status slot berubah menjadi Terisi.

---
### 6. Lihat Data Parkir

<img width="297" height="375" alt="image" src="https://github.com/user-attachments/assets/3bec8217-b8e6-421f-ace1-e9a0a4c66bbd" /><br>

<img width="297" height="340" alt="image" src="https://github.com/user-attachments/assets/8a71ea7b-2d54-4f32-91ff-f24b4a1c9961" />

Sistem menampilkan seluruh data parkir yang telah tersimpan. Informasi yang ditampilkan meliputi kendaraan, petugas, slot, waktu masuk, waktu keluar, jumlah pembayaran, metode pembayaran, status parkir, dan status pembayaran.

---
### 7. Update Data Parkir

<img width="295" height="414" alt="image" src="https://github.com/user-attachments/assets/dc82e197-5909-41d3-b149-2c99ee7ef6f5" /><br>

<img width="323" height="464" alt="image" src="https://github.com/user-attachments/assets/840bdc6c-7c99-4e43-a054-c78382fb1650" />

User memasukkan ID parkir yang ingin diperbarui, kemudian mengisi waktu keluar, lama parkir, metode pembayaran, dan jumlah pembayaran.
Sistem menghitung biaya parkir berdasarkan jenis kendaraan dan lama parkir. Jika pembayaran mencukupi, sistem menghitung kembalian dan status pembayaran menjadi Lunas. Setelah transaksi selesai, status parkir menjadi Selesai dan status slot berubah menjadi Kosong.

---
### 8. Hapus Data Parkir

<img width="291" height="415" alt="image" src="https://github.com/user-attachments/assets/aa5dd57f-b879-417d-82e9-c75b24be04fc" /><br>

<img width="360" height="350" alt="image" src="https://github.com/user-attachments/assets/e9cbe1ec-d611-41f6-ad3f-9ecad4a5ed5d" /><br>

<img width="355" height="395" alt="image" src="https://github.com/user-attachments/assets/0b7c2363-09e8-4322-bfd9-cab8d55952e0" />

User memasukkan ID parkir yang ingin dihapus. Jika data ditemukan, sistem menampilkan data parkir dan meminta konfirmasi penghapusan.
User dapat memilih Y untuk menghapus atau T untuk membatalkan. Jika penghapusan dikonfirmasi, data dihapus dan status slot berubah menjadi Kosong sehingga dapat digunakan kembali.

---
### 9. Cari Data Parkir

<img width="308" height="415" alt="image" src="https://github.com/user-attachments/assets/d1bcd6ad-c8b4-472e-98bd-f6cd8d0b6613" />

User memasukkan ID parkir yang ingin dicari. Program akan mencari data berdasarkan ID tersebut.

Jika data ditemukan, program menampilkan informasi data parkir seperti kendaraan, petugas, slot, waktu masuk, waktu keluar, status parkir, dan informasi pembayaran.

<img width="211" height="91" alt="image" src="https://github.com/user-attachments/assets/b177bd0f-177d-4b36-b5a5-3a84bde62c5e" />

Jika data tidak ditemukan, program menampilkan pesan bahwa data parkir dengan ID tersebut tidak ditemukan.

---
### 10. Keluar

<img width="516" height="140" alt="image" src="https://github.com/user-attachments/assets/ef119411-517c-4589-9572-79e95e1f01d9" />

User memilih menu Keluar untuk menghentikan program. Setelah itu sistem menampilkan pesan "Terima kasih!" dan program selesai.

---
## 🔹 Access Modifier

Penerapan Access Modifier pada program ini terdapat pada atribut-atribut di dalam class model seperti Kendaraan, Petugas, SlotParkir, dan Parkir.

Atribut dibuat menggunakan access modifier private, sehingga tidak dapat diakses secara langsung dari luar class.

Contohnya pada class **Parkir** terdapat atribut:

<img width="305" height="200" alt="image" src="https://github.com/user-attachments/assets/9a9590fe-61d4-4fae-af8c-d270b5d1d7d2" />

Dengan penggunaan private, akses terhadap atribut dapat dibatasi sehingga data di dalam object menjadi lebih terkontrol.

---
## 🔹 Encapsulation

Penerapan Encapsulation dilakukan dengan membungkus data atau atribut di dalam class dan menyediakan getter dan setter untuk mengakses atau mengubah data tersebut.

Pada class **SlotParkir**, getter digunakan untuk mengambil nilai atribut, sedangkan setter digunakan untuk mengubah nilai tertentu.

Contohnya:

<img width="382" height="375" alt="image" src="https://github.com/user-attachments/assets/f73b95db-300e-4a95-9c5b-a656aa68ec7c" />

Dengan adanya encapsulation, atribut yang bersifat private tidak diakses secara langsung dari luar class, tetapi melalui method yang telah disediakan.

---
## 🔹 Validasi Input

Penerapan Validasi Input terdapat pada class ParkirView.java.

Program memiliki beberapa method khusus untuk memastikan input yang diberikan user sesuai dengan ketentuan, yaitu:

<img width="285" height="338" alt="image" src="https://github.com/user-attachments/assets/0aa5b3d9-78e9-4a02-bff1-438cf9796b77" />

Validasi input angka juga menggunakan try-catch, sehingga program tidak langsung crash ketika user memasukkan input dengan tipe data yang salah.

---
## 🔹 Inheritance

Penerapan Inheritance terdapat pada class Motor dan Mobil yang mewarisi class Kendaraan sebagai superclass.

Struktur inheritance pada program:

```
Kendaraan
  /      \
Motor  Mobil
```

### </> Kode SubClass

**1. Subclass Motor**

<img width="648" height="71" alt="image" src="https://github.com/user-attachments/assets/c4926767-72f8-49f1-83d9-195c0800384c" />

**2. Subclass Mobil**

<img width="648" height="75" alt="image" src="https://github.com/user-attachments/assets/728deb41-1d9c-471b-9d1d-b67bc5b56a2f" />

Dengan inheritance, class **Motor** dan **Mobil** dapat menggunakan atribut dan method yang terdapat pada class **Kendaraan** tanpa harus membuatnya kembali.

---
## 🔹 Polymorphism

Penerapan Polymorphism pada program ini menggunakan method **overriding**. Method **tampilkanInfo()** yang terdapat pada class Kendaraan dioverride pada class Motor dan Mobil.

**1. Pada class Motor:**

<img width="395" height="112" alt="image" src="https://github.com/user-attachments/assets/112d0d15-e0e4-4c21-9044-329f1d17adba" />

**2. Pada class Mobil:**

<img width="397" height="113" alt="image" src="https://github.com/user-attachments/assets/44fac3ff-6f23-4ac8-90b4-0898a5511d46" />

Dengan overriding tersebut, method **tampilkanInfo()** dapat menghasilkan tampilan yang berbeda sesuai dengan object yang digunakan.

---
## 🔹 Struktur MVC

Penerapan struktur MVC pada program dilakukan dengan memisahkan class berdasarkan fungsinya ke dalam beberapa package.

<img width="347" height="396" alt="image" src="https://github.com/user-attachments/assets/d4aad913-93f0-460c-bb92-8fb22f927709" />

Struktur package tersebut membuat setiap bagian program memiliki tugas yang berbeda sehingga kode lebih terorganisir dan mudah dikembangkan.

---
## 🔹 Dummy Data

Program menyediakan dummy data awal pada ParkirService, berupa data kendaraan, petugas, slot parkir, dan data parkir. Dummy data digunakan agar saat program dijalankan, data sudah tersedia dan dapat langsung ditampilkan.

<img width="283" height="332" alt="image" src="https://github.com/user-attachments/assets/7a7e35f7-73f5-4e1f-ad84-7a545cc26dab" /><br>

<img width="279" height="307" alt="image" src="https://github.com/user-attachments/assets/3e43e854-dee2-4bd9-b630-31b66a7d5abe" />
