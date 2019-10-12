import com.demo.PieceTour;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Nasim Salmany
 */

public class PieceTourIntegTest {

    @Test
    public void success_find_tour() {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                System.out.println("(" + i + "," + j + ")");

                while (!PieceTour.performPieceTour(j, j)){
                    ;
                }
                ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
                String result = outSpy.toString();
                long count = result.chars()
                        .mapToObj(item -> (char) item)
                        .filter(b -> Integer.valueOf(b) == 0)
                        .count();

                assertThat(count, equalTo(0l));

                System.out.println();
            }
        }
    }
}
