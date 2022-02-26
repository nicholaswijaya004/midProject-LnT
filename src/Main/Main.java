package Main;

import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Vector<Karyawan> karyawanVector = new Vector<>();
	static Karyawan karyawan1 = null;
	static int jml_manager=0, jml_supervisor=0, jml_admin=0;
	
	public Main() {
		menu();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public void menu() {
		int choice;
		System.out.println("Pilih Menu");
		System.out.println("1. Insert Data");
		System.out.println("2. View Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		System.out.println("5. Keluar");
		System.out.print(">> ");
		choice = scan.nextInt();scan.nextLine();
		
		switch (choice) {
		case 1:
			insert();
			break;
		case 2:
			view();
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;
		case 5:
			System.out.println("Terima kasih telah menggunakan program ini!!");
			break;
		}
	}
	
	public boolean cekKode(String kode) {
		int flag = 0;
		for (int i=0; i<karyawanVector.size(); i++) {
			if (karyawanVector.get(i).getKode().equals(kode)) {
				flag = 1;
				break;
			} else {
				flag = 0;
			}
		}
		if (flag == 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public void insert() {
		String kode, nama, jenis_kelamin, jabatan;
		double gaji;
		boolean cek;
		do {
			System.out.println("Input Kode Karyawan [Kode Karyawan tidak boleh ada yang sama]: ");
			kode = scan.nextLine();
			cek = cekKode(kode);
			if (cek == false) {
				System.out.println("Alert! Kode sudah ada di dalam data, masukkan kode lain!");
			}
		} while (kode.length() < 3 || cek == false);
			
		do {
			System.out.println("Input Nama Karyawan [nama harus lebih dari 3 huruf alfabet]: ");
			nama = scan.nextLine();
		} while (nama.length() < 3);
		
		do {
			System.out.println("Input Jenis Kelamin [Laki-Laki|Perempuan]");
			jenis_kelamin = scan.nextLine();
		} while (!(jenis_kelamin.equals("Laki-Laki")) && !(jenis_kelamin.equals("Perempuan")));
		
		do {
			System.out.println(("Input Jabatan [Manager|Supervisor|Admin]"));
			jabatan = scan.nextLine();
		} while (!(jabatan.equals("Manager")) && !(jabatan.equals("Supervisor")) && !jabatan.equals("Admin"));
		
		if (jabatan.equals("Manager")) {
			jml_manager += 1;
			gaji = 8000000;
			karyawan1 = new Manager(kode, nama, jenis_kelamin, jabatan, gaji);
			System.out.println("Manager sudah ditambahkan!!");
		} else if (jabatan.equals("Supervisor")) {
			jml_supervisor += 1;
			gaji = 6000000;
			karyawan1 = new Supervisor(kode, nama, jenis_kelamin, jabatan, gaji);
			System.out.println("Supervisor sudah ditambahkan!!");
		} else if (jabatan.equals("Admin")) {
			jml_admin += 1;
			gaji = 4000000;
			karyawan1 = new Admin(kode, nama, jenis_kelamin, jabatan, gaji);
			System.out.println("Admin sudah ditambahkan!!");
		}
		
		karyawanVector.add(karyawan1);
		menu();
	}
	
	public void printData() {
		for (int i=0; i<karyawanVector.size(); i++) {
			for (int j=0; j<karyawanVector.size()-i-1; j++) {
				if (karyawanVector.get(j).getNama().compareTo(karyawanVector.get(j+1).getNama()) > 0) {
					Karyawan temp = karyawanVector.get(j);
					karyawanVector.set(j, karyawanVector.get(j+1));
					karyawanVector.set(j+1, temp);
				}
			}
		}
		
		int counter_admin = jml_admin;
		int counter_supervisor = jml_supervisor;
		int counter_manager = jml_manager;
		
		System.out.println("===================================================================================================================");
		System.out.println("|No |Kode Karyawan      |Nama Karyawan                     |Jenis Kelamin      |Jabatan         |Gaji Karyawan    |");
		System.out.println("===================================================================================================================");
		
		for (int i=0; i<karyawanVector.size(); i++) {
			if ((jml_admin-1)%3 == 0 && karyawanVector.get(i).getJabatan().equals("Admin")) {
				counter_admin = counter_admin-1;
				if (counter_admin == 0 && counter_admin != counter_admin-1) {
					System.out.printf("|%3d|%19s|%34s|%19s|%16s|%17s|\n", (i+1), karyawanVector.get(i).getKode(), karyawanVector.get(i).getNama(),
							karyawanVector.get(i).getJenis_kelamin(), karyawanVector.get(i).getJabatan(), karyawanVector.get(i).getGaji());
				} else {
					System.out.printf("|%3d|%19s|%34s|%19s|%16s|%17s|\n", (i+1), karyawanVector.get(i).getKode(), karyawanVector.get(i).getNama(),
							karyawanVector.get(i).getJenis_kelamin(), karyawanVector.get(i).getJabatan(), karyawanVector.get(i).totalGaji());
				}
			} else if ((jml_supervisor-1)%3 == 0 && karyawanVector.get(i).getJabatan().equals("Supervisor")) {
				counter_supervisor = counter_supervisor-1;
				if (counter_supervisor == 0 && counter_supervisor != counter_supervisor-1) {
					System.out.printf("|%3d|%19s|%34s|%19s|%16s|%17s|\n", (i+1), karyawanVector.get(i).getKode(), karyawanVector.get(i).getNama(),
							karyawanVector.get(i).getJenis_kelamin(), karyawanVector.get(i).getJabatan(), karyawanVector.get(i).getGaji());
				} else {
					System.out.printf("|%3d|%19s|%34s|%19s|%16s|%17s|\n", (i+1), karyawanVector.get(i).getKode(), karyawanVector.get(i).getNama(),
							karyawanVector.get(i).getJenis_kelamin(), karyawanVector.get(i).getJabatan(), karyawanVector.get(i).totalGaji());
				}
			} else if ((jml_manager-1)%3 == 0 && karyawanVector.get(i).getJabatan().equals("Manager")) {
				counter_manager = counter_manager-1;
				if (counter_manager == 0 && counter_manager != counter_manager-1) {
					System.out.printf("|%3d|%19s|%34s|%19s|%16s|%17s|\n", (i+1), karyawanVector.get(i).getKode(), karyawanVector.get(i).getNama(),
							karyawanVector.get(i).getJenis_kelamin(), karyawanVector.get(i).getJabatan(), karyawanVector.get(i).getGaji());
				} else {
					System.out.printf("|%3d|%19s|%34s|%19s|%16s|%17s|\n", (i+1), karyawanVector.get(i).getKode(), karyawanVector.get(i).getNama(),
							karyawanVector.get(i).getJenis_kelamin(), karyawanVector.get(i).getJabatan(), karyawanVector.get(i).totalGaji());
				}
			} else {
				System.out.printf("|%3d|%19s|%34s|%19s|%16s|%17s|\n", (i+1), karyawanVector.get(i).getKode(), karyawanVector.get(i).getNama(),
						karyawanVector.get(i).getJenis_kelamin(), karyawanVector.get(i).getJabatan(), karyawanVector.get(i).getGaji());
			}
		}
		
		System.out.println("===================================================================================================================");
	}
	
	public void view() {
		printData();
		System.out.println();
		menu();
	}
	
	public void update() {
		for (int i=0; i<karyawanVector.size(); i++) {
			for (int j=0; j<karyawanVector.size()-i-1; j++) {
				if (karyawanVector.get(j).getNama().compareTo(karyawanVector.get(j+1).getNama()) > 0) {
					Karyawan temp = karyawanVector.get(j);
					karyawanVector.set(j, karyawanVector.get(j+1));
					karyawanVector.set(j+1, temp);
				}
			}
		}
		for (int i=0; i<karyawanVector.size(); i++) {
			System.out.println("Nama karyawan ke-" + (i+1) + " adalah " + karyawanVector.get(i).getNama());
		}
		int choice;
		String newKode, newNama, newJenis_kelamin, newJabatan;
		double newGaji;
		boolean cek;
		
		do {
			System.out.println("Input nomor karyawan yang akan diupdate[1 - " + karyawanVector.size() + "]");
			choice = scan.nextInt();scan.nextLine();
		} while (choice < 1 || choice > karyawanVector.size());
		
		do {
			System.out.println("Input Kode Karyawan Baru [Kode Karyawan tidak boleh ada yang sama]: ");
			newKode = scan.nextLine();
			cek = cekKode(newKode);
			if (cek == false) {
				System.out.println("Alert! Kode sudah ada di dalam data, masukkan kode lain!");
			}
		} while (newKode.length() < 3 || cek == false);
		
		do {
			System.out.println("Input Nama Karyawan Baru [nama harus lebih dari 3 huruf alfabet]: ");
			newNama = scan.nextLine();
		} while (newNama.length() < 3);
		
		do {
			System.out.println("Input Jenis Kelamin Baru [Laki-Laki|Perempuan]");
			newJenis_kelamin = scan.nextLine();
		} while (!(newJenis_kelamin.equals("Laki-Laki")) && !(newJenis_kelamin.equals("Perempuan")));
		
		do {
			System.out.println(("Input Jabatan [Manager|Supervisor|Admin]"));
			newJabatan = scan.nextLine();
		} while (!(newJabatan.equals("Manager")) && !(newJabatan.equals("Supervisor")) && !newJabatan.equals("Admin"));
		
		if (newJabatan.equals("Manager")) {
			jml_manager += 1;
			newGaji = 8000000;
			karyawan1 = new Manager(newKode, newNama, newJenis_kelamin, newJabatan, newGaji);
			System.out.println("Manager sudah ditambahkan!!");
		} else if (newJabatan.equals("Supervisor")) {
			jml_supervisor += 1;
			newGaji = 6000000;
			karyawan1 = new Supervisor(newKode, newNama, newJenis_kelamin, newJabatan, newGaji);
			System.out.println("Supervisor sudah ditambahkan!!");
		} else if (newJabatan.equals("Admin")) {
			jml_admin += 1;
			newGaji = 4000000;
			karyawan1 = new Admin(newKode, newNama, newJenis_kelamin, newJabatan, newGaji);
			System.out.println("Admin sudah ditambahkan!!");
		}
		
		karyawanVector.set(choice-1, karyawan1);
		menu();
	}
	
	public void delete() {
		int choice;
		for (int i=0; i<karyawanVector.size(); i++) {
			for (int j=0; j<karyawanVector.size()-i-1; j++) {
				if (karyawanVector.get(j).getNama().compareTo(karyawanVector.get(j+1).getNama()) > 0) {
					Karyawan temp = karyawanVector.get(j);
					karyawanVector.set(j, karyawanVector.get(j+1));
					karyawanVector.set(j+1, temp);
				}
			}
		}
		for (int i=0; i<karyawanVector.size(); i++) {
			System.out.println("Nama karyawan ke-" + (i+1) + " adalah " + karyawanVector.get(i).getGaji());
		}
		do {
			System.out.println("Input nomor karyawan yang akan dihapus [1 - " + karyawanVector.size() + "]");
			choice = scan.nextInt();scan.nextLine();
		} while (choice < 1 || choice > karyawanVector.size());
		karyawanVector.remove(choice);
		menu();
	}

}
