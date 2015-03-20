
import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;

public class StatisticsTest{

   Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }


    };
    
   @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
  @Test
  public void loytyvaHaku() {
    Player player = stats.search("Semenko");

    assertEquals("Semenko", player.getName());
}

  @Test
  public void eiLoytyvaHaku() {
    
    assertEquals(null, stats.search("trolli"));
}
  @Test
  public void joukkoeenListaaminen() {
    assertEquals("Lemieux", stats.team("PIT").get(0).getName());

}
  @Test
  public void pistetesti() {
    assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
}

}