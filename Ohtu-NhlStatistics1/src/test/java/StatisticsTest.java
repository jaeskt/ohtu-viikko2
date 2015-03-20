
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Scanner;
import java.util.List;
import ohtuesimerkki.*;
import java.util.*;

public class StatisticsTest{

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

class Readerstub implements Reader {

  ArrayList<Player> players;

  public Readerstub(ArrayList<Player> players) {
    this.players = players;

}
  public List<Player> getPlayers() {

  return players;

}

}
  Statistics stats = new Statistics(readerStub);

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
  public void tiiminListaaminen() {
    assertEquals("Lemieux", stats.team("PIT").get(0).getName());

}
  @Test
  public void pistetesti() {
    assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
}

}