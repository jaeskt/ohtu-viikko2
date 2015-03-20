package ohtuesimerkki;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author timojaas
 */
public class StaticsticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    public StaticsticsTest() {
    }

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

     @Test
    public void testSearch() {
        Player player = stats.search("Semenko");
        assertEquals(player.getName(), "Semenko");
    }
    
    @Test
    public void testTeam() {
        ArrayList<Player> team = (ArrayList<Player>) stats.team("PIT");
        assertEquals(stats.search("Lemieux"), team.get(0));
        assertEquals(team.size(), 1);
    }
    
    @Test
    public void testTopScorers() {
        ArrayList<Player> pisteet = (ArrayList<Player>) stats.topScorers(4);
        assertEquals(pisteet.get(0).getName(), "Gretzky");
        assertEquals(pisteet.get(1).getName(), "Lemieux");
        assertEquals(pisteet.get(2).getName(), "Yzerman");
        assertEquals(pisteet.get(3).getName(), "Kurri");
        assertEquals(pisteet.get(4).getName(), "Semenko");
    }
}
