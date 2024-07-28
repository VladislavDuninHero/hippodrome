import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HorseTest {

    private final String CONSTRUCTOR_WITH_NULL_MESSAGE = "Name cannot be null.";
    private final String CONSTRUCTOR_WITH_EMPTY_PARAMETER_MESSAGE = "Name cannot be blank.";

    private final String CONSTRUCTOR_SECOND_PARAMETER_NEGATIVE_MESSAGE_EXCEPTION =  "Speed cannot be negative.";

    private final String CONSTRUCTOR_THIRD_PARAMETER_NEGATIVE_MESSAGE_EXCEPTION = "Distance cannot be negative.";

    @Test
    public void horseNullFirstParameterConstructorTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 2));
    }

    @Test
    public void horseConstructorNullParameterConstructorTest() {

        try {
            Horse horse = new Horse(null, 1, 2);
        } catch (IllegalArgumentException err) {
            Assertions.assertEquals(err.getMessage(), CONSTRUCTOR_WITH_NULL_MESSAGE);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "\n", "\t"})
    public void horseConstructorEmptyFirstParameterTest(String arg) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(arg, 1, 2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    public void horseConstructorFirstParameterEmptyTest(String arg) {
        try {
            Horse horse = new Horse(arg, 1, 2);
        } catch (IllegalArgumentException err) {
            Assertions.assertEquals(err.getMessage(), CONSTRUCTOR_WITH_EMPTY_PARAMETER_MESSAGE);
        }
    }

    @Test
    public void horseConstructorSecondParameterIsNegativeExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("name", -1, 1));
    }

    @Test
    public void horseConstructorSecondParameterIsNegativeExceptionMessageTest() {
        try {
            Horse horse = new Horse("name", -1, 1);
        } catch (IllegalArgumentException err) {
            Assertions.assertEquals(err.getMessage(), CONSTRUCTOR_SECOND_PARAMETER_NEGATIVE_MESSAGE_EXCEPTION);
        }
    }

    @Test
    public void horseConstructorThirdParameterIsNegativeExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("name", 1, -1));
    }

    @Test
    public void horseConstructorThirdParameterIsNegativeExceptionMessageTest() {
        try {
            Horse horse = new Horse("name", 1, -1);
        } catch (IllegalArgumentException err) {
            Assertions.assertEquals(err.getMessage(), CONSTRUCTOR_THIRD_PARAMETER_NEGATIVE_MESSAGE_EXCEPTION);
        }
    }
}
