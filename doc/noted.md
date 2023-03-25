# Judul: Sistem Manajemen Quotation (QMS) PT. SKI

## Fitur Aplikasi

1. Form Login
2. Menu
3. Form:  
A. Master-Company (Nama Perusahaan, PIC, No. Telp)  
B. Master-Item (Nama Item, Harga Per Unit)  
C. Form Input Transaksi (Harga per unit + PPN (11% PPN Indonesia))  
D. Master Login Karyawan  
E. Form Report  
F. Form Profile Karyawan  
4. Report Master Company
5. Report Transaksi per Status (Remarks/Quotation)
6. Report Prospek per Tahun
7. Report Quotation Grafik Tahun 2022-2023 (Simpan)
8. Report Segmentasi Market (Simpan)

## Pembagian Tugas Pemrograman Visual:

1. Buat DFD program terlebih dahulu dan pembagian tugas
2. Pemrograman visual minimal setengah jalan, baru ansys akan dirancang
3. Buat DFD analisis sistem (Fauziah, Dede)> minimal P4 (hari Minggu sudah disusun)
4. User Interface (Jimmy, Ilham)
5. Back-end (Atha, Yusuf)
6. Database (Pandu, Diaz)
7. P3-P5 (pengajuan judul)
8. Tim mulai cicil/rancang sesuai jobdesk masing-masing

## Analisis Sistem: Sistem Manajemen Quotation (QMS) PT. SKI

### Data:

1. Data Karyawan (Nama, Jenis Kelamin, TTL, Alamat, Agama, Status, No. Telp, Mulai Join SKI)
2. Data Jabatan (Nama, Jabatan, Periode Jabatan)
3. Data Customer (Nama Perusahaan, PIC, No. Telp, Bergerak di Bidang Apa)
4. Data Transaksi Item (No. Quotation, Nama Item, Qty, Harga per Unit)

### Informasi:

1. Quotation Customer (Nomor, Tanggal, Nomor Quotation, Nama Perusahaan, Bergerak di Bidang Apa, PIC, No. Telp, Nama Item, Qty, Harga/EA, Subtotal, PPN, Total Amount)
2. Report Quotation per Status (Quotation Close, Quotation Sudah PO, Quotation Masih di FU, Remarks)
    > NB: Pengambilan Data/Isi sama dengan di No. 1

3. Report Quotation per Tahun (2022-2023 Perbandingan dari Tahun Sebelumnya dengan Sekarang)
    > NB: Pengambilan Data/Isi sama dengan di No. 1

4. Report Quotation Grafik Tahun 2022-2023 (Buat grafik perbandingan setiap bulan antara tahun 2022 & 2023)
    > NB: Hasil dalam bentuk grafik dari Report sebelumnya

5. Report Segmentasi Market (Pharmaceutical, Foods & Beverages, Automotive Parts Industry, Pulp & Paper, Palm Oil Refinery, Steel Manufacturer, Water Process Company, Marine/Diesel, Power Plants, Water Cooling, Chemical, Oil & Gas)
    >  NB: Hasil grafik dalam % (persentasi) per segmen market

### Entitas:

1. Karyawan (Sales Support, Accounting, Administrasi)
2. Customer
3. Pemilik
4. Product Specialist (Admin yang input data quotation)