package hu.nive.ujratervezes.kepesitovizsga.ladybird;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Ladybird {

    private DataSource datasource;

    public Ladybird(DataSource datasource) {
        this.datasource = datasource;
    }

    public List<String> getLadybirdsWithExactNumberOfPoints(int number) {

        List<String> result;

        try (
                Connection conn = datasource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT hungarian_name FROM ladybirds WHERE number_of_points = ?;")
        ) {
            ps.setInt(1, number);

            result = getStrings(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }

    private List<String> getStrings(PreparedStatement ps) {

        List<String> result = new ArrayList<>();

        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String hungarian_name = rs.getString("hungarian_name");
                result.add(hungarian_name);
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
        return result;
    }

    public Map<Integer, Long> getLadybirdsByNumberOfPoints() {

        List<Integer> pointsOfLadyBirds = loadList();

        return pointsOfLadyBirds.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    private List<Integer> loadList() {

        List<Integer> result = new ArrayList<>();

        try (
                Connection conn = datasource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT number_of_points FROM ladybirds WHERE number_of_points > 0 ORDER BY number_of_points;")
        ) {

            while (rs.next()) {
                Integer points = rs.getInt("number_of_points");
                result.add(points);
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }

    public Set<Ladybug> getLadybirdByPartOfLatinNameAndNumberOfPoints(String partOfName, int numberOfPoints) {

        String sqlOrder = "SELECT * FROM ladybirds WHERE latin_name LIKE '%" + partOfName + "%' AND number_of_points = ?;";

        Set<Ladybug> result;

        try (
                Connection conn = datasource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlOrder)
        ) {

            ps.setInt(1, numberOfPoints);

            result = getLadyBugs(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }

    private Set<Ladybug> getLadyBugs(PreparedStatement ps) {

        Set<Ladybug> result = new HashSet<>();

        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String hungarian_name = rs.getString("hungarian_name");
                String latin_name = rs.getString("latin_name");
                String genus = rs.getString("genus");
                int points = rs.getInt("number_of_points");

                result.add(new Ladybug(hungarian_name, latin_name, genus, points));
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
        return result;
    }

    public Map<String, Integer> getLadybirdStatistics() {

        Map<String, Integer> result = new HashMap<>();

        try (
                Connection conn = datasource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT genus, COUNT(genus) AS amount FROM ladybirds GROUP BY genus;")
        ) {

            while (rs.next()) {
                String genus = rs.getString("genus");
                int amount = rs.getInt("amount");

                result.put(genus, amount);
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }
}


