import com.game.tennis.Tennis;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author Ernestas
 */
public class TennisTestCase {

    @Test
    public void shouldBothBeLOVE() {
        Assert.assertEquals("LOVE-LOVE", Tennis.start(0, 0).getResult());
    }

    @Test
    public void shouldBothBeFIFTEEN() {
        Assert.assertEquals("FIFTEEN-FIFTEEN", Tennis.start(1, 1).getResult());
    }

    @Test
    public void shouldBothBeTHIRTY() {
        Assert.assertEquals("THIRTY-THIRTY", Tennis.start(2, 2).getResult());
    }

    @Test
    public void shouldBothBeFORTY() {
        Assert.assertEquals("FORTY-FORTY", Tennis.start(3, 3).getResult());
    }

    @Test
    public void shouldBeDEUCE() {
        Assert.assertEquals("DEUCE", Tennis.start(4, 4).getResult());
    }

    @Test
    public void shouldPlayer1HasAdvantage() {
        Assert.assertEquals("Advantage Player1", Tennis.start(4, 3).getResult());
    }

    @Test
    public void shouldPlayer1Won() {
        Assert.assertEquals("Won Player1", Tennis.start(5, 3).getResult());
    }

    @Test
    public void shouldPlayer2Won() {
        Assert.assertEquals("Won Player2", Tennis.start(1, 10).getResult());
    }

    @Test
    public void shouldBeLoveForty() {
        Assert.assertEquals("LOVE-FORTY", Tennis.start(0, 3).getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValues() {
        Tennis.start(-2, -2);
    }
}
