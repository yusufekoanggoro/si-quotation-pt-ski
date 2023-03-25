# Studi Kasus Gitflow

Berikut adalah contoh penggunaan Gitflow pada saat seorang developer akan mengembangkan fitur baru "UI login" pada proyek:

1. Checkout ke branch <nama_anda>-dev
    ```
    git checkout pandu-dev
    ```
    Langkah ini akan membuat developer beralih ke branch develop yang telah dibuat sebelumnya.

2. Lakukan aktivitas development (coding)
Setelah berpindah ke branch develop, developer dapat mulai mengembangkan fitur baru "UI login".

3. Pull terlebih dahulu dari origin master
Sebelum melakukan commit, developer harus melakukan pull terlebih dahulu dari branch master untuk memastikan bahwa kode yang dikembangkan selaras dengan kode di branch master.
    ```
    git pull origin master
    ```
4. Jika terjadi konflik, resolve terlebih dahulu
    Jika terjadi konflik saat melakukan pull, developer harus menyelesaikan konflik tersebut terlebih dahulu sebelum melakukan commit. Hal ini bisa dilakukan dengan menggunakan perintah berikut:

    ```
    git add .
    git commit -m "resolve conflict"

    ```

5. Lakukan commit hasil development fitur tersebut dengan cara:
    ```
    git add .
    git commit -m “add UI login”
    ```
    Setelah selesai mengembangkan fitur baru, developer harus melakukan commit untuk menyimpan perubahan yang telah dibuat.

6. Push ke branch develop masing-masing

    Setelah melakukan commit, developer harus mem-push kode yang telah di-commit ke branch develop yang telah dibuat sebelumnya.

    ```
    git push origin <nama_anda>-dev
    ```
7. Lakukan Pull Request dari <nama_anda>-dev ke Master

    Setelah mem-push kode ke branch develop, developer harus membuat Pull Request untuk menggabungkan branch develop dengan branch master. Hal ini dapat dilakukan melalui fitur Pull Request pada platform Git yang digunakan.

8. Pull Request akan di review oleh reviewer

    Pull Request yang telah dibuat akan direview oleh reviewer sebelum akhirnya di-merge ke branch master. Reviewer akan mengevaluasi kode yang telah dikembangkan dan memberikan feedback untuk perbaikan jika diperlukan.