package Hosptial;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	public class InvoiceDAO {
	    private Connection connection;

	    public InvoiceDAO(Connection connection) {
	        this.connection = connection;
	    }

	    public int createInvoice(int patientId, double totalAmount) {
	        try {
	            String insertQuery = "INSERT INTO invoices (patient_id, total_amount, paid) VALUES (?, ?, false)";
	            
	            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
	                preparedStatement.setInt(1, patientId);
	                preparedStatement.setDouble(2, totalAmount);

	                int rowsAffected = preparedStatement.executeUpdate();

	                if (rowsAffected > 0) {
	                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	                    if (generatedKeys.next()) {
	                        return generatedKeys.getInt(1); // Return the generated invoice ID
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return -1; // Return -1 if invoice creation fails
	    }

	    public List<Invoice> getUnpaidInvoices(int patientId) {
	        List<Invoice> unpaidInvoices = new ArrayList<>();

	        try {
	            String selectQuery = "SELECT * FROM invoices WHERE patient_id = ? AND paid = false";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	                preparedStatement.setInt(1, patientId);

	                ResultSet resultSet = preparedStatement.executeQuery();

	                while (resultSet.next()) {
	                    Invoice invoice = new Invoice();
	                    invoice.setInvoiceId(resultSet.getInt("invoice_id"));
	                    invoice.setPatientId(resultSet.getInt("patient_id"));
	                    invoice.setTotalAmount(resultSet.getDouble("total_amount"));
	                    invoice.setPaid(resultSet.getBoolean("paid"));
	                    unpaidInvoices.add(invoice);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return unpaidInvoices;
	    }
	}



