package Hosptial;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class PaymentDAO {
	    private Connection connection;

	    public PaymentDAO(Connection connection) {
	        this.connection = connection;
	    }

	    public boolean makePayment(int invoiceId, double amount) {
	        try {
	            String updateQuery = "UPDATE invoices SET paid = true WHERE invoice_id = ?";
	            
	            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
	                updateStatement.setInt(1, invoiceId);

	                int rowsAffected = updateStatement.executeUpdate();

	                if (rowsAffected > 0) {
	                    // Payment successful, record the payment details
	                    String insertQuery = "INSERT INTO payments (invoice_id, amount, payment_date) VALUES (?, ?, CURRENT_DATE)";
	                    try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
	                        insertStatement.setInt(1, invoiceId);
	                        insertStatement.setDouble(2, amount);

	                        insertStatement.executeUpdate();
	                        return true; // Return true if payment and update are successful
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false; // Return false if payment fails
	    }
	}

	


