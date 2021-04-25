package hu.nive.ujratervezes.kepesitovizsga.ladybird;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LadybirdTest {

    private Ladybird ladybird;

    @BeforeEach
    public void setUp() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        ladybird = new Ladybird(dataSource);
    }

    @Test
    void testGetLadybirdsWithExactNumberOfPoints() {
        List<String> ladybirds = ladybird.getLadybirdsWithExactNumberOfPoints(11);

        assertEquals(5, ladybirds.size());
        assertEquals("sziki tizenegypettyes katica", ladybirds.get(2));
    }

    @Test
    void testGetLadybirdsWithNotExistingNumberOfPoints() {
        List<String> ladybirds = ladybird.getLadybirdsWithExactNumberOfPoints(100);

        assertEquals(0, ladybirds.size());
    }

    @Test
    void testGetLadybirdsByNumberOfPoints() {
        Map<Integer, Long> numberOfLadybirdsByPoints = ladybird.getLadybirdsByNumberOfPoints();

        assertEquals(1, numberOfLadybirdsByPoints.get(24));
        assertEquals(5, numberOfLadybirdsByPoints.get(11));
        assertEquals(2, numberOfLadybirdsByPoints.get(7));
    }

    @Test
    void testGetLadybirdByPartOfLatinNameAndNumberOfPoints() {
        Set<Ladybug> ladybirds = ladybird.getLadybirdByPartOfLatinNameAndNumberOfPoints("Scymnus", 2);

        assertEquals(4, ladybirds.size());
        assertTrue(ladybirds.contains(new Ladybug("ostoros bödice", "(Scymnus flagellisiphonatus)", "bödiceformák (Scymninae)", 2)));
        assertFalse(ladybirds.contains(new Ladybug("sárgafejű bödice", "(Scymnus auritus)", "bödiceformák (Scymninae)", 0)));
    }

    @Test
    void testGetLadybirdStatistics() {
        Map<String, Integer> ladybirdStatistics = ladybird.getLadybirdStatistics();

        assertEquals(36, ladybirdStatistics.get("katicaformák (Coccinellinae)"));
        assertEquals(5, ladybirdStatistics.get("szerecsenkata-formák (Chilocorinae)"));
    }

}