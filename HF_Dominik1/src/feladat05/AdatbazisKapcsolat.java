package feladat05;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdatbazisKapcsolat {
    private static final String ADATBAZIS_URL = "jdbc:mysql://localhost:3306/szinhaz_eloadasok_db";
    private static final String FELHASZNALONEV = "root";
    private static final String JELSZO = "Deved1997";

    public List<Eloadas> eloadasokLekerdezese() {
        List<Eloadas> eloadasok = new ArrayList<>();

        try (Connection kapcsolat = DriverManager.getConnection(ADATBAZIS_URL, FELHASZNALONEV, JELSZO)) {
            String lekerdezes = "SELECT * FROM eloadasok";
            try (Statement statement = kapcsolat.createStatement();
                    ResultSet resultSet = statement.executeQuery(lekerdezes)) {

                while (resultSet.next()) {
                    String cim = resultSet.getString("cim");
                    String rendezo = resultSet.getString("rendezo");
                    LocalDateTime bemutato = resultSet.getTimestamp("bemutato").toLocalDateTime();                 
                    int eloadasSzam = resultSet.getInt("eloadas_szam");

                    Eloadas eloadas = new Eloadas(cim, rendezo, bemutato.toLocalDate(), eloadasSzam);
                    eloadasok.add(eloadas);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eloadasok;
    }

}
