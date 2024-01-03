package Hosptial;

public class Invoice {
	
	    private int invoiceId;
	    private int patientId;
	    private double totalAmount;
	    private boolean paid;
		public int getInvoiceId() {
			return invoiceId;
		}
		public void setInvoiceId(int invoiceId) {
			this.invoiceId = invoiceId;
		}
		public int getPatientId() {
			return patientId;
		}
		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public boolean isPaid() {
			return paid;
		}
		public void setPaid(boolean paid) {
			this.paid = paid;
		}
	    
	    

	

}
