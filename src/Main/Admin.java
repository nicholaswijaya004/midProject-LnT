package Main;

public class Admin extends Karyawan {
	
	private double bonus;
	private int jml_admin;
	
	public Admin(String kode, String nama, String jenis_kelamin, String jabatan, double gaji) {
		super(kode, nama, jenis_kelamin, jabatan, gaji);
		this.bonus = gaji * 0.05;
	}
	
	public double getBonus() {
		return bonus;
	}


	public void setBonus(double bonus) {
		this.bonus = bonus;
	}


	@Override
	public double totalGaji() {
		// TODO Auto-generated method stub
		int totalGaji = 0;
		totalGaji += this.getGaji() + bonus;
		return totalGaji;
	}
	
}
