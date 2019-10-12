import com.demo.ChessBoard;
import com.demo.Tile;
import com.demo.TileHelper;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Nasim Salmany
 */
public class TileHelperUnitTest {
    private static ChessBoard chessBoard;

    @Before
    public void init() {
        chessBoard = new ChessBoard(10, 10);
    }

    @Test
    public void success_get_empty_adjacent_tiles_count() {
        int adjacentTilesCount = TileHelper.emptyAdjacentTilesCount(chessBoard, 3, 2);
        assertThat(adjacentTilesCount, equalTo(9));
    }

    @Test
    public void success_check_if_new_tile_is_neighbour() {
        Tile[][] tiles = chessBoard.getTiles();
        Tile startTile = tiles[3][2];
        startTile.setStep(1);
        boolean neighbour = TileHelper.neighbour(tiles[6][2], startTile);
        assertThat(neighbour, equalTo(true));
    }

}
