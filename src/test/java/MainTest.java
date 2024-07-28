import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class MainTest {

    @Test
    @Disabled
    @Timeout(21)
    public void mainTimeoutTest() throws Exception {
        Main.main(null);
    }
}
