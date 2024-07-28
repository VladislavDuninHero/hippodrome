import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GettersTest {

    @Mock
    private Horse horse;

    @Spy
    private Horse horseWithConstructor = new Horse("name", 1, 1);

    @Spy
    private Horse horseConstructorWithTwoArguments = new Horse("name", 1);

    @Test
    public void getNameTest() {
        Mockito.doReturn("name").when(horse).getName();

        Assertions.assertEquals("name", horse.getName());
    }

    @Test
    public void getSpeedTest() {
        Mockito.doReturn(1.0).when(horse).getSpeed();

        Assertions.assertEquals(1.0, horse.getSpeed());
    }

    @Test
    public void getDistanceTest() {
        Assertions.assertEquals(1, horseWithConstructor.getDistance());
        Assertions.assertEquals(0, horseConstructorWithTwoArguments.getDistance());
    }

    @Test
    public void moveTest() {
        try(MockedStatic<Horse> horseManipulateObject = Mockito.mockStatic(Horse.class)) {
            new Horse("name", 31, 291).move();

            horseManipulateObject.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

}
