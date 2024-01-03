package Hosptial;

import java.sql.Date;

public class Payment {
	    private int paymentId;
	    private int invoiceId;
	    private double amount;
	    private Date paymentDate;
		public int getPaymentId() {
			return paymentId;
		}
		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}
		public int getInvoiceId() {
			return invoiceId;
		}
		public void setInvoiceId(int invoiceId) {
			this.invoiceId = invoiceId;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public Date getPaymentDate() {
			return paymentDate;
		}
		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}


}
