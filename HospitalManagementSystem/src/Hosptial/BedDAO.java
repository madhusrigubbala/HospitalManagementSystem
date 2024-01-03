package Hosptial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

	public class BedDAO {
	    private Connection connection;

	    public BedDAO(Connection connection) {
	        this.connection = connection;
	    }

	    public List<Bed> getBedsByWard(int wardId) {
	        List<Bed> beds = new ArrayList<>();

	        try {
	            String selectQuery = "SELECT * FROM beds WHERE ward_id = ?";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	                preparedStatement.setInt(1, wardId);

	                ResultSet resultSet = preparedStatement.executeQuery();

	                while (resultSet.next()) {
	                    Bed bed = new Bed();
	                    bed.setBedId(resultSet.getInt("bed_id"));
	                    bed.setWardId(resultSet.getInt("ward_id"));
	                    bed.setOccupied(resultSet.getBoolean("occupied"));
	                    beds.add(bed);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return beds;
	    }

	    public boolean allocateBed(int bedId, int patientId) {
	        try {
	            String updateQuery = "UPDATE beds SET occupied = true, patient_id = ? WHERE bed_id = ? AND occupied = false";

	            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
	                updateStatement.setInt(1, patientId);
	                updateStatement.setInt(2, bedId);

	                int rowsAffected = updateStatement.executeUpdate();

	                return rowsAffected > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }
	}


