package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int monthWorkingInYear, int annualDeductible, boolean isMarried, int childCount) {
		int annualIncome = (monthlySalary + otherMonthlyIncome) * monthWorkingInYear - annualDeductible;
		int nonTaxableIncome = 54000000; 
		
		if (isMarried) {
			nonTaxableIncome += 4500000; 
		}
		
		if (childCount > 0) {
			nonTaxableIncome += Math.min(childCount, 3) * 4500000; 
		}
		
		int taxableIncome = Math.max(0, annualIncome - nonTaxableIncome); 
		int tax = (int) (taxableIncome * 0.05); 
		
		return tax;
	
	}
}
