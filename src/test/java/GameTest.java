import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void FirstWin() {
        Player Slava = new Player(1, "Слава", 100);
        Player Petya = new Player(2, "Петя", 150);
        Game game = new Game();

        game.register(Slava);
        game.register(Petya);
        int actual = game.round("Петя", "Слава");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondWin() {
        Player Slava = new Player(1, "Слава", 200);
        Player Petya = new Player(2, "Петя", 150);
        Game game = new Game();

        game.register(Slava);
        game.register(Petya);
        int actual = game.round("Петя", "Слава");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void GamwDraw() {
        Player Slava = new Player(1, "Слава", 200);
        Player Petya = new Player(2, "Петя", 200);
        Game game = new Game();

        game.register(Slava);
        game.register(Petya);
        int actual = game.round("Петя", "Слава");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstNotExist() {
        Player Slava = new Player(1, "Слава", 100);
        Player Petya = new Player(2, "Петя", 200);
        Game game = new Game();
        game.register(Slava);
        game.register(Petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Маша", "Петя")
        );
    }

    @Test
    public void SecondNotExist() {
        Player Slava = new Player(1, "Слава", 100);
        Player Petya = new Player(2, "Петя", 200);
        Game game = new Game();
        game.register(Slava);
        game.register(Petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Слава", "Вова")
        );
    }

    @Test
    public void NobodyNotExist() {
        Player Slava = new Player(1, "Слава", 100);
        Player Petya = new Player(2, "Петя", 200);
        Game game = new Game();
        game.register(Slava);
        game.register(Petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Маша", "Вова")
        );
    }
}
