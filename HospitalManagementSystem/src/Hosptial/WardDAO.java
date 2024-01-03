package Hosptial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Hosptial.Ward;

@SuppressWarnings("unused")
public class WardDAO {
    private final Connection connection;

    public WardDAO(Connection connection) {
        this.connection = connection;
    }

    public void addWard(Ward ward) {
        String query = "INSERT INTO ward(ward_id, ward_name) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ward.getWardId());
            preparedStatement.setString(2, ward.getWardName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewWard() {
        String query = "SELECT * FROM ward";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Ward: ");
            System.out.println("+------------+------------------+");
            System.out.println("| Ward_Id    | Ward_Name        |");
            System.out.println("+------------+------------------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("ward_id");
                String name = resultSet.getString("ward_name");

                System.out.printf("| %-10s | %-16s |\n", id, name);
                System.out.println("+------------+------------------+");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
