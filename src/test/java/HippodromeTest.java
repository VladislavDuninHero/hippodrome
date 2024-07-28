import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


public class HippodromeTest {

    @Mock
    Hippodrome hippodrome;

    @Test
    public void nullableConstructorTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    public void nullableConstructorExceptionMessageTest() {
        try {
            new Hippodrome(null);
        } catch (Exception err) {
            Assertions.assertEquals("Horses cannot be null.", err.getMessage());
        }
    }

    @Test
    public void getHorseMethodTest() {
        List<Horse> list = new ArrayList<>();

        for (int i =  0; i < 30; i++) {
            list.add(new Horse("Horse " + i, i, i));
        }

        Hippodrome hippodromeWithHorses = new Hippodrome(list);

        Assertions.assertEquals(list, hippodromeWithHorses.getHorses());
    }

    @Test
    public void moveHippodromeTest() {
        List<Horse> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add(Mockito.mock(Horse.class));
        }

        Hippodrome hippodromeWithHorses = new Hippodrome(list);

        hippodromeWithHorses.move();

        for (Horse horse : hippodromeWithHorses.getHorses()) {
            Mockito.verify(horse).move();
        }
    }

    @Test
    public void getWinnerTest() {
        List<Horse> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add(new Horse("name", i, i));
        }

        Hippodrome hippodromeWithHorses = new Hippodrome(list);

        Assertions.assertEquals(
                hippodromeWithHorses.getHorses().get(hippodromeWithHorses.getHorses().size() - 1),
                hippodromeWithHorses.getWinner()
        );
    }
}
