package Hosptial;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class LabImagingIntegration {
	    private final Connection connection;

	    public LabImagingIntegration(Connection connection) {
	        this.connection = connection;
	    }

	    public void orderTest(int patientId, String testName) {
	        String query = "INSERT INTO lab_tests (patient_id, test_name, status) VALUES (?, ?, 'Pending')";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, patientId);
	            preparedStatement.setString(2, testName);
	            preparedStatement.executeUpdate();
	            System.out.println("Test ordered successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void viewDiagnosticReports(int patientId) {
	        String query = "SELECT * FROM lab_tests WHERE patient_id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, patientId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            System.out.println("Diagnostic Reports:");
	            System.out.println("+------------+--------------------+-------------+");
	            System.out.println("| Test       |   Status           | Result      |");
	            System.out.println("+------------+--------------------+-------------+");

	            while (resultSet.next()) {
	                String testName = resultSet.getString("test_name");
	                String status = resultSet.getString("status");
	                String result = resultSet.getString("result");

	                System.out.printf("| %-10s | %-18s | %-11s |\n", testName, status, result);
	                System.out.println("+------------+--------------------+-------------+");
	            }
	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void enterTestResult(int patientId, String testName, String result) {
	        String query = "UPDATE lab_tests SET status = 'Completed', result = ? WHERE patient_id = ? AND test_name = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, result);
	            preparedStatement.setInt(2, patientId);
	            preparedStatement.setString(3, testName);
	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Test result entered successfully!");
	            } else {
	                System.out.println("Failed to enter test result. Please check patient ID and test name.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



