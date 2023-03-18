import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Anna", 1);
    Player player2 = new Player(11, "Roman", 2);
    Player player3 = new Player(12, "Olga", 3);
    Player player4 = new Player(13, "Slava", 5);
    Player player5 = new Player(14, "Fedya", 0);
    Player player6 = new Player(15, "Nadya", 3);
    Player player7 = new Player(16, "Sveta", 7);

    @BeforeEach
    public void addPlayers() throws NotRegisteredException {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
    }

    @Test
    public void shouldGetID(){

        Assertions.assertEquals(13, player4.getId());
    }

    @Test
    public void shouldSetId(){
        Assertions.assertEquals(11, player2.getId());
    }
    @Test
    public void addPlayerWhoseNameAlreadyExists() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.register(player6);
        });
    }

    @Test
    public void roundPlayersOfEqualStrength() throws NotRegisteredException {

        int expected = 0;
        int actual = game.round("Olga", "Nadya");
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void roundPlayersWhenFirstIsWeakerThanSecond() throws NotRegisteredException {

        int expected = 2;
        int actual = game.round("Anna", "Slava");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundPlayersWhenFirstIsStrongerThanSecond() throws NotRegisteredException {

        int expected = 1;
        int actual = game.round("Sveta", "Fedya");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundFirstPlayerAreUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sofia", "Olga");
        });
    }
    @Test
    public void roundSecondPlayerAreUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nadya", "Sofia");
        });
    }
    @Test
    public void roundTwoPlayerAreUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sofia", "Leo");
        });
    }
    @Test
    public void roundTwoPlayersNotEliminated() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(null, null);
        });
    }
}
