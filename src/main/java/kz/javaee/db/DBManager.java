package kz.javaee.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/first_ee_db", "postgres", "Xv6Vv12c3c");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addUser(User user) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (login ,password) VALUES (? ,?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean addFootballer(Footballer footballer) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO footballers (id,name ,surname,salary,club,transferprice) VALUES (? ,?,?,?,?,?)");
            statement.setLong(1, footballer.getId());
            statement.setString(2, footballer.getName());
            statement.setString(3, footballer.getSurname());
            statement.setInt(4, footballer.getSalary());
            statement.setString(5, footballer.getClub());
            statement.setInt(6, footballer.getTransferPrice());

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean deleteFootballer(Footballer football){
        int rows=0;
        try{
            PreparedStatement statement=connection.prepareStatement("DELETE FROM footballers WHERE id=?");
            statement.setLong(1,football.getId());

            rows=statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Footballer> getFootballers() {
        ArrayList<Footballer> footballs = new ArrayList<>();
        try {

            PreparedStatement statement = connection.prepareStatement("SELECT id,name ,surname,salary,club,transferprice FROM footballers");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                footballs.add(new Footballer(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("salary"),
                        resultSet.getString("club"),
                        resultSet.getInt("transferprice")


                ));

            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return footballs;
    }

    public static Footballer getFootballer(Long id) {
        Footballer football = null;
        try {

            PreparedStatement statement = connection.prepareStatement(" " + "SELECT id,name ,surname,salary,club,transferprice FROM footballers WHERE id=?" + " ");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                football = new Footballer(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("salary"),
                        resultSet.getString("club"),
                        resultSet.getInt("transferprice")


                );

            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return football;
    }

    public static boolean savePlayer(Footballer football){
        int rows=0;
        try{
            PreparedStatement statement=connection.prepareStatement("UPDATE footballers SET id=?,name=?,surname=?,salary=?,club=?,transferprice=? WHERE id=?");
            statement.setLong(1,football.getId());
            statement.setString(2,football.getName());
            statement.setString(3,football.getSurname());
            statement.setInt(4,football.getSalary());
            statement.setString(5,football.getClub());
            statement.setInt(6,football.getTransferPrice());
            statement.setLong(7,football.getId());
            rows=statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }
}