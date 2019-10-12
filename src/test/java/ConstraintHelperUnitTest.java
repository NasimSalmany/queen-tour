import com.demo.ChessBoard;
import com.demo.ConstraintHelper;
import com.demo.Tile;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Nasim Salmany
 */
public class ConstraintHelperUnitTest {
    private static ChessBoard chessBoard;

    @Before
    public void init() {
        chessBoard = new ChessBoard(10, 10);
    }

    @Test
    public void success_check_if_coordinate_is_in_bound() {
        boolean inBounds = ConstraintHelper.isInBounds(2, 9, 10, 10);

        assertThat(inBounds, equalTo(true));
    }

    @Test
    public void success_check_if_coordinate_is_not_in_bound() {
        Tile tile = new Tile(-2, 3);
        boolean inBounds = ConstraintHelper.isInBounds(10, 1, 10, 10);

        assertThat(inBounds, equalTo(false));
    }

    @Test
    public void success_check_if_tile_is_empty() {
        Tile tile = chessBoard.getTiles()[2][3];
        tile.setStep(-1);

        boolean isEmpty = ConstraintHelper.isEmpty(chessBoard, tile.getRow(), tile.getCol());
        assertThat(isEmpty, equalTo(true));
    }

    @Test
    public void success_check_if_tile_is_not_empty() {
        Tile tile = chessBoard.getTiles()[2][3];
        tile.setStep(21);

        boolean isEmpty = ConstraintHelper.isEmpty(chessBoard, tile.getRow(), tile.getCol());
        assertThat(isEmpty, equalTo(false));
    }


}
