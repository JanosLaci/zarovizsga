package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private final MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT name FROM dog_types WHERE country = ? ORDER BY name");
        ) {

            List<String> dogNamesList = new ArrayList<>();

            //kis- és nagybetű ne számítson a paraméterben, igazodjon az adatbázis nagybetűihez
            String countryUpperCase = country.toUpperCase();
            preparedStatement.setString(1, countryUpperCase);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String dogName = resultSet.getString("name");
                    dogNamesList.add(dogName.toLowerCase());

                    //Ellenőrzés:
                    // System.out.println(dogNamesList);
                }
                //while sikeres lefutása után visszatérünk a listával
                return dogNamesList;
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot execute the query", sqlException);
        }
    }

    /* kipróbálás: main metódus Flyway nélkül
    public static void main(String[] args) throws SQLException {
        MariaDbDataSource dataSource;
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");


        DogTypes dogTypes = new DogTypes(dataSource);
        List<String> types = dogTypes.getDogsByCountry("Hungary");
        System.out.println(types);

    }*/


}
