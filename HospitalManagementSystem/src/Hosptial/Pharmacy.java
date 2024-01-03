package Hosptial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class Pharmacy {
	    private final Connection connection;

	    public Pharmacy(Connection connection) {
	        this.connection = connection;
	    }

	    public void dispenseMedication(int prescriptionId) {
	        // Implement medication dispensing logic here
	        // For simplicity, let's assume the medication details are in a "medications" table

	        String query = "SELECT * FROM medications WHERE prescription_id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, prescriptionId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                // Medication details found, you can implement the dispensing logic here
	                int medicationId = resultSet.getInt("medication_id");
	                String medicationName = resultSet.getString("medication_name");
	                int quantity = resultSet.getInt("quantity");
	                System.out.println("Dispensing Medication:");
	                System.out.println("Medication ID: " + medicationId);
	                System.out.println("Medication Name: " + medicationName);
	                System.out.println("Quantity: " + quantity);

	                // Update inventory or perform any other necessary actions
	                // For simplicity, let's assume updating the inventory in the database
	                updateInventory(medicationId, quantity);
	            } else {
	                System.out.println("Medication not found for prescription ID: " + prescriptionId);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private void updateInventory(int medicationId, int dispensedQuantity) {
	       

	        String updateQuery = "UPDATE inventory SET quantity = quantity - ? WHERE medication_id = ?";
	        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
	            updateStatement.setInt(1, dispensedQuantity);
	            updateStatement.setInt(2, medicationId);
	            int rowsAffected = updateStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Inventory updated successfully.");
	            } else {
	                System.out.println("Failed to update inventory.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


