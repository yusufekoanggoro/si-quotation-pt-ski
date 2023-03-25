# Langkah-langkah Persiapan untuk Menggunakan Git
1. Buat Akun Git
Untuk menggunakan Git, pertama-tama kita perlu membuat akun Git. Buka situs https://github.com dan klik tombol "Sign up" di pojok kanan atas. Isi formulir yang disediakan dengan informasi yang diperlukan untuk membuat akun baru.

2.  Install Git
Setelah membuat akun Git, kita perlu menginstal Git pada komputer kita. Git dapat diunduh dari situs resmi Git https://git-scm.com/downloads. Pilih versi Git yang sesuai dengan sistem operasi yang digunakan, kemudian unduh dan instal Git.

3. Clone Remote Repository ke Lokal
Setelah Git terinstal, kita dapat melakukan clone remote repository ke lokal. Caranya adalah dengan membuka terminal/command prompt pada komputer kita dan mengetikkan perintah berikut:
    ```
    git clone https://github.com/yusufekoanggoro/si-quotation-pt-ski.git
    ```
    Perintah di atas akan mengunduh repository dari server Git dan menyimpannya pada komputer kita.

4. Buat Branch Develop
Selanjutnya, kita perlu membuat branch develop untuk mengembangkan kode kita. Caranya adalah dengan mengetikkan perintah berikut pada terminal:
    ```
    git branch nama_anda-dev master
    ```
    Perintah di atas akan membuat branch baru bernama nama_anda-dev dan mengambil commit terakhir dari branch master.

5. Push Branch Develop
Setelah membuat branch develop, kita perlu mem-push branch tersebut ke server Git. Caranya adalah dengan mengetikkan perintah berikut pada terminal:
    ```
    git push origin nama_anda-dev
    ```

    Perintah di atas akan mem-push branch develop kita ke server Git sehingga orang lain dapat melihat dan berkontribusi pada kode kita.

