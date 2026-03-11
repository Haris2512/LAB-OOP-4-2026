LAB-OOP-4-2026

Repositori Tugas Praktikum Pemrograman Berorientasi Objek 2026.

Requirements

Memiliki akun GitHub (github.com).

Telah mengunduh dan menginstal Git (git-scm.com).

Alur Pengumpulan Tugas

Fork Repositori
Lakukan fork pada repositori utama ini ke akun GitHub Anda sendiri.

Clone Repositori
Lakukan clone repositori hasil fork tersebut ke perangkat lokal Anda:

git clone [https://github.com/USERNAME_ANDA/LAB-OOP-4-2026.git](https://github.com/USERNAME_ANDA/LAB-OOP-4-2026.git)


Buat Branch Baru
Masuk ke folder hasil clone dan buat branch dengan nama 3 digit terakhir NIM Anda:

cd LAB-OOP-4-2026
git branch XXX
git checkout XXX


(Ganti XXX dengan 3 digit NIM Anda. Gunakan perintah git branch untuk memastikan tanda asterisk * berada di branch tersebut).

Konfigurasi Git (Opsional)
Jika ini pertama kali Anda menggunakan Git, atur identitas Anda:

git config user.name "USERNAME_GITHUB"
git config user.email "EMAIL_GITHUB"


Struktur Folder Tugas
Tugas dikerjakan pada package masing-masing di dalam path berikut:
app/src/main/java/pbo26/week_x

Contoh: week_1, week_2, dsb.

Jika disediakan placeholder atau template file dari lab, wajib menggunakannya.

Stage dan Commit
Setelah selesai mengerjakan, tambahkan perubahan dan lakukan commit dengan pesan yang deskriptif:

git add .
git commit -m "'feat': tugas praktikum 1"


(Gunakan git status untuk memastikan file yang ingin di-add sudah berwarna hijau).

Push ke GitHub
Kirim perubahan ke repositori fork Anda:

git push origin XXX


Pull Request (PR)
Buka repositori hasil fork di GitHub, pilih menu Pull Request, dan buat PR baru. Pastikan base branch dan compare branch sesuai dengan NIM Anda masing-masing.
