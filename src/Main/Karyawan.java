package Main;

public abstract class Karyawan {
	
	private String kode;
	private String nama;
	private String jenis_kelamin;
	private String jabatan;
	private double gaji;
	
	public Karyawan(String kode, String nama, String jenis_kelamin, String jabatan, double gaji) {
		super();
		this.kode = kode;
		this.nama = nama;
		this.jenis_kelamin = jenis_kelamin;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
	
	
	
	public String getKode() {
		return kode;
	}



	public void setKode(String kode) {
		this.kode = kode;
	}



	public String getNama() {
		return nama;
	}



	public void setNama(String nama) {
		this.nama = nama;
	}



	public String getJenis_kelamin() {
		return jenis_kelamin;
	}



	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}



	public String getJabatan() {
		return jabatan;
	}



	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}



	public double getGaji() {
		return gaji;
	}



	public void setGaji(int gaji) {
		this.gaji = gaji;
	}



	public abstract double totalGaji();
	
}