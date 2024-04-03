import java.util.Scanner;

class Kendaraan {
    String platno;
    String merk;
    int jumlahPenumpang;
    int maxPenumpang;

    public Kendaraan(String platno, String merk, int maxPenumpang) {
        this.platno = platno;
        this.merk = merk;
        this.maxPenumpang = maxPenumpang;
        this.jumlahPenumpang = 0;
    }

    void cekPenumpang() {
        System.out.println("Jumlah Penumpang saat ini adalah : " + this.jumlahPenumpang);
    }

    void penumpangNaik(int naik) {
        if (this.jumlahPenumpang + naik > this.maxPenumpang) {
            System.out.println("Penumpang tidak bisa masuk dikarenakan melebihi kapasitas");
        } else {
            this.jumlahPenumpang += naik;
            System.out.println("Penumpang berhasil naik");
        }
        cekPenumpang();
    }

    void penumpangTurun(int turun) {
        if (this.jumlahPenumpang - turun < 0) {
            System.out.println("Penumpang tidak boleh kurang dari 0");
        } else {
            this.jumlahPenumpang -= turun;
            System.out.println("Penumpang berhasil turun");
        }
        cekPenumpang();
    }

    void getInfoDriverBus() {
        Driver driverBus = new Driver("Samsul", 1234123);
        System.out.println("Bus ini dikendarai oleh " + driverBus.namaDriver + " dengan no sim : " + driverBus.noSim);
    }

    void getInfoDriverTruk() {
        Driver driverTruk = new Driver("Blackie", 5431231);
        System.out.println("Truk ini dikendarai oleh " + driverTruk.namaDriver + " dengan no sim : " + driverTruk.noSim);
    }
}

class Bus extends Kendaraan {
    boolean isThereToilet;

    public Bus(String platno, String merk, int maxPenumpang, boolean isThereToilet) {
        super(platno, merk, maxPenumpang);
        this.isThereToilet = isThereToilet;
    }

    void belUnik() {
        System.out.println("Bus dengan plat nomor " + this.platno + " sedang membunyikan bel telolet telolet");
    }

    void penumpangNaik(int naik) {
        Scanner munggah = new Scanner(System.in);
        int bayar;

        if (this.jumlahPenumpang + naik > this.maxPenumpang) {
            System.out.println("Penumpang tidak bisa masuk dikarenakan melebihi kapasitas");
        } else {
            int nominalBayar = 5000 * naik;
            System.out.println("Silahkan melakukan pembayaran sebesar " + nominalBayar);
            System.out.print("Masukkan nominal : ");
            bayar = munggah.nextInt();
            if (bayar > nominalBayar) {
                this.jumlahPenumpang += naik;
                System.out.println("Penumpang berhasil naik,Terimakasih telah melakukan pembayaran");
                System.out.println("Silahkan menerima kembalian sebesar " + (bayar - nominalBayar));
            } else if (bayar == nominalBayar) {
                this.jumlahPenumpang += naik;
                System.out.println("Penumpang berhasil naik,Terimakasih telah melakukan pembayaran");
            } else {
                System.out.println("Mohon maaf penumpang gagal naik dikarenakan nominal tidak cukup/sesuai");
            }
        }
        cekPenumpang();
    }
}

class Truk extends Kendaraan {
    int bakTruk;
    int maxBakTruk;

    public Truk(String platno, String merk, int maxPenumpang, int maxBakTruk) {
        super(platno, merk, maxPenumpang);
        this.bakTruk = 0;
        this.maxBakTruk = maxBakTruk;
    }

    void cekMuatan() {
        System.out.println("Bak Truk ini telah terisi oleh pasir sebesar " + this.bakTruk + " kg");
    }

    void cekMuatanBakTrukTersisa() {
        System.out.println("Truk ini memiliki sisa bak muatan sebesar " + (this.maxBakTruk - this.bakTruk) + " kg");
    }

    void menaikkanPasir(int pasirUp) {
        if (this.bakTruk + pasirUp > this.maxBakTruk) {
            System.out.println("Tidak bisa menaikkan pasir karena melebihi muatan");
        } else {
            this.bakTruk += pasirUp;
            System.out.println("Pasir berhasil dinaikkan kedalam Bak Truk");
        }
        cekMuatan();
        cekMuatanBakTrukTersisa();
    }

    void menurunkanPasir(int pasirDown) {
        if (this.bakTruk - pasirDown < 0) {
            System.out.println("Tidak bisa menurunkan pasir karena pasir tidak sesuai dengan muatan yang ada");
        } else {
            this.bakTruk -= pasirDown;
            System.out.println("Pasir berhasil diturunkan");
        }
        cekMuatan();
        cekMuatanBakTrukTersisa();
    }

    void penumpangNaik(int naik) {
        Scanner up = new Scanner(System.in);
        String gender;

        if (this.jumlahPenumpang + naik > this.maxPenumpang) {
            System.out.println("Penumpang tidak bisa masuk dikarenakan melebihi kapasitas");
        } else {
            System.out.print("Apakah ada penumpang perempuan? y/n : ");
            gender = up.nextLine();

            if (gender.equalsIgnoreCase("y")) {
                System.out.println("Mohon maaf tidak bisa menambahkan penumpang perempuan");
            } else if (gender.equalsIgnoreCase("n")) {
                this.jumlahPenumpang += naik;
                System.out.println("Penumpang berhasil naik");
            } else {
                System.out.println("Pilihan tidak valid,gagal menambahkan penumpang");
            }
        }
        cekPenumpang();
    }
}

class Driver {
    String namaDriver;
    int noSim;

    public Driver(String namaDriver, int noSim) {
        this.namaDriver = namaDriver;
        this.noSim = noSim;
    }
}

public class Lkdua {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pilihan = 0;
        int milih = 0;

        Bus bus1 = new Bus("n123", "Mercedes", 40, true);
        Truk truk1 = new Truk("n321", "Mazda", 2, 500);

        System.out.println("Selamat datang di program kendaraan");

        while (true) {
            System.out.println("\nSilahkan pilih jenis kendaraan");
            System.out.println("1.Bus\n2.Truk\n3.Keluar Program");
            System.out.print("Pilihan : ");
            pilihan = in.nextInt();
            if (pilihan == 1) {
                System.out.println("\nSilahkan memilih menu yang sesuai");
                System.out.println("1.Penumpang Naik\n2.Penumpang Turun\n3.Cek Penumpang\n4.Cek Driver\n5.Membunyikan Bel");
                System.out.print("Pilihan : ");
                milih = in.nextInt();

                switch (milih) {
                    case 1:
                        int mlebu;
                        System.out.print("Masukkan jumlah penumpang naik : ");
                        mlebu = in.nextInt();
                        bus1.penumpangNaik(mlebu);
                        break;

                    case 2:
                        int mudun;
                        System.out.print("Masukkan jumlah penumpang turun : ");
                        mudun = in.nextInt();
                        bus1.penumpangTurun(mudun);
                        break;

                    case 3:
                        bus1.cekPenumpang();
                        break;

                    case 4:
                        bus1.getInfoDriverBus();
                        break;

                    case 5:
                        bus1.belUnik();

                    default:
                        System.out.println("Silahkan memilih sesuai angka menu");
                        break;
                }
            } else if (pilihan == 2) {
                System.out.println("\nSilahkan memilih menu yang sesuai");
                System.out.println(
                        "1.Penumpang Naik\n2.Penumpang Turun\n3.Cek Penumpang\n4.Cek Driver\n5.Menaikkan Pasir\n6.Menurunkan Pasir");
                System.out.print("Pilihan : ");
                milih = in.nextInt();

                switch (milih) {
                    case 1:
                        int mlebu;
                        System.out.print("Masukkan jumlah penumpang naik : ");
                        mlebu = in.nextInt();
                        truk1.penumpangNaik(mlebu);
                        break;

                    case 2:
                        int mudun;
                        System.out.print("Masukkan jumlah penumpang turun : ");
                        mudun = in.nextInt();
                        truk1.penumpangTurun(mudun);
                        break;

                    case 3:
                        truk1.cekPenumpang();
                        break;

                    case 4:
                        truk1.getInfoDriverTruk();
                        break;

                    case 5:
                        int pasirmunggah;
                        System.out.print("Silahkan masukkan pasir yang ingin dinaikkan : ");
                        pasirmunggah = in.nextInt();
                        truk1.menaikkanPasir(pasirmunggah);
                        break;

                    case 6:
                        int pasirmudun;
                        System.out.print("Silahkan masukkan pasir yang ingin diturunkan : ");
                        pasirmudun = in.nextInt();
                        truk1.menurunkanPasir(pasirmudun);
                        break;

                    default:
                        System.out.println("Silahkan memilih sesuai angka menu");
                        break;
                }
            } else if (pilihan == 3) {
                System.out.println("\nTerimakasih,Program berhenti");
                return;
            } else {
                System.out.println("Silahkan pilih menu yang sesuai");
                continue;
            }
        }
    }
}