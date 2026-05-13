package tuprak6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library perpus = new Library();
        Scanner input = new Scanner(System.in);

        int pilih;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN PERPUSTAKAAN ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");

            while (true) {
                System.out.print("Pilih menu: ");
                try {
                    pilih = Integer.parseInt(input.nextLine());
                    if (pilih >= 1 && pilih <= 8) break;
                    else System.out.println("Harus pilih 1 - 8");
                } catch (Exception e) {
                    System.out.println("Input harus angka antara 1 - 8");
                }
            }

            try {

                if (pilih == 1) {

                    int tipe;
                    while (true) {
                        System.out.print("Tipe (1. Buku / 2. DVD): ");
                        try {
                            tipe = Integer.parseInt(input.nextLine());
                            if (tipe == 1 || tipe == 2) break;
                            else System.out.println("Harus pilih 1 atau 2");
                        } catch (Exception e) {
                            System.out.println("Input harus angka antara 1 - 2");
                        }
                    }

                    System.out.print("Judul: ");
                    String judul = input.nextLine();

                    int idItem;
                    while (true) {
                        System.out.print("ID: ");
                        try {
                            idItem = Integer.parseInt(input.nextLine());

                            // cek duplikat id
                            boolean ada = false;
                            for (LibraryItem item : perpus.items) {
                                if (item.itemId == idItem) {
                                    ada = true;
                                    break;
                                }
                            }

                            if (ada) {
                                System.out.println("ID sudah digunakan! Masukkan ID lain");
                            } else {
                                break;
                            }

                        } catch (Exception e) {
                            System.out.println("ID harus angka");
                        }
                    }

                    if (tipe == 1) {
                        System.out.print("Penulis: ");
                        String penulis = input.nextLine();
                        System.out.println(perpus.addItem(new Book(judul, idItem, penulis)));
                    } else {
                        int durasi;
                        while (true) {
                            System.out.print("Durasi DVD (menit): ");
                            try {
                                durasi = Integer.parseInt(input.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println("Durasi harus berupa angka");
                            }
                        }
                        System.out.println(perpus.addItem(new DVD(judul, idItem, durasi)));
                    }
                }

                else if (pilih == 2) {
                    System.out.print("Nama Anggota: ");
                    String nama = input.nextLine();

                    String idMember;
                    while (true) {
                        System.out.print("ID Anggota: ");
                        idMember = input.nextLine();

                        if (idMember.isEmpty()) {
                            System.out.println("ID tidak boleh kosong");
                            continue;
                        }

                        boolean ada = false;
                        for (Member member : perpus.members) {
                            if (member.memberId.equals(idMember)) {
                                ada = true;
                                break;
                            }
                        }

                        if (ada) {
                            System.out.println("ID sudah digunakan! Masukkan ID lain");
                        } else {
                            break;
                        }
                    }

                    perpus.addMember(new Member(nama, idMember));
                    System.out.println("Anggota " + nama + " berhasil didaftarkan dengan ID " + idMember);
                }

                else if (pilih == 3) {

                    System.out.print("ID Anggota: ");
                    String idMember = input.nextLine();

                    int idItem;
                    while (true) {
                        System.out.print("ID Item: ");
                        try {
                            idItem = Integer.parseInt(input.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("ID harus angka");
                        }
                    }

                    int hari;
                    while (true) {
                        System.out.print("Durasi Peminjaman (hari): ");
                        try {
                            hari = Integer.parseInt(input.nextLine());
                            if (hari > 0) break;
                            else System.out.println("Hari harus > 0");
                        } catch (Exception e) {
                            System.out.println("Input harus angka");
                        }
                    }

                    Member member = perpus.findMemberById(idMember);
                    LibraryItem item = perpus.findItemById(idItem);

                    String message = member.borrow(item, hari);
                    perpus.logger.logActivity("Item " + item.title + " dipinjam oleh " + member.name);

                    System.out.println(message);
                }

                else if (pilih == 4) {

                    System.out.print("ID Anggota: ");
                    String idMember = input.nextLine();

                    int idItem;
                    while (true) {
                        System.out.print("ID Item: ");
                        try {
                            idItem = Integer.parseInt(input.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("ID harus angka");
                        }
                    }

                    int keterlambatan;
                    while (true) {
                        System.out.print("Keterlambatan (hari): ");
                        try {
                            keterlambatan = Integer.parseInt(input.nextLine());
                            if (keterlambatan >= 0) break;
                            else System.out.println("Keterlambatan tidak boleh negatif");
                        } catch (Exception e) {
                            System.out.println("Input harus angka");
                        }
                    }

                    Member member = perpus.findMemberById(idMember);
                    LibraryItem item = perpus.findItemById(idItem);

                    String message = member.returnItem(item, keterlambatan);
                    perpus.logger.logActivity("Item " + item.title + " dikembalikan oleh " + member.name);

                    System.out.println(message);
                }

                else if (pilih == 5) {
                    System.out.println(perpus.getLibraryStatus());
                }

                else if (pilih == 6) {
                    System.out.println("\n--- Riwayat Log ---");
                    System.out.println(perpus.getAllLogs());
                }

                else if (pilih == 7) {
                    System.out.print("Masukkan ID Anggota: ");
                    String idMemberr = input.nextLine();

                    Member memberr = perpus.findMemberById(idMemberr);
                    memberr.getBorrowedItems();
                }

                else if (pilih == 8) {
                    System.out.println("Keluar dari sistem.");
                }

            } catch (Exception e) {
                System.out.println("Gagal: " + e.getMessage());
            }

        } while (pilih != 8);

        input.close();
    }
}