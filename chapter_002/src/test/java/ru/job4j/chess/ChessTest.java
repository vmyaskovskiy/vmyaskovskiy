package ru.job4j.chess;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.OccupiedWeyException;
import ru.job4j.chess.firuges.black.*;

/**
 * Class ChessTest тестирование задачи части 002 - Контрольные вопросы.  Тестирование задачи - Каркас шахматной доски.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ChessTest {
    // Pawn
    @Test
    public void testPawnTru() {
        Cell[] steps = new Cell[1];
        Cell source = Cell.A7;
        Cell dest = Cell.A6;
        steps[0] = dest;
        PawnBlack pawnBlackSource = new PawnBlack(source);
        assertThat(pawnBlackSource.way(source, dest), is(steps));
    }
    @Test
    public void testMovePawnTru() {
        Cell source = Cell.A7;
        Cell dest = Cell.A6;
        boolean steps1 = false;
        Logic logic = new Logic();
        PawnBlack pawnBlackSource = new PawnBlack(source);
        logic.add(pawnBlackSource);
        steps1 = logic.move(source, dest);
        assertThat(steps1, is(true));
    }
    @Test
    public void testMovePawnFalseWrongWay() {
        Cell source = Cell.A8;
        Cell dest = Cell.A6;
        boolean steps1 = false;
        Logic logic = new Logic();
        PawnBlack pawnBlackSource = new PawnBlack(source);
        logic.add(pawnBlackSource);
        steps1 = logic.move(source, dest);
        assertThat(steps1, is(false));
    }
    @Test
    public void testMovePawnFalseOccupiedDest() {
        Cell source = Cell.A7;
        Cell dest = Cell.A6;
        boolean steps1 = false;
        Logic logic = new Logic();
        PawnBlack pawnBlackSource = new PawnBlack(source);
        PawnBlack pawnBlackDest = new PawnBlack(dest);
        logic.add(pawnBlackSource);
        logic.add(pawnBlackDest);
        steps1 = logic.move(source, dest);
        assertThat(steps1, is(false));
    }
    // Rook
    @Test
    public void testMoveRookTruUp() {
        Cell source = Cell.A8;
        Cell dest = Cell.A6;
        Logic logic = new Logic();
        RookBlack rookBlackSource = new RookBlack(source);
        logic.add(rookBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveRookTruRight() {
        Cell source = Cell.A5;
        Cell dest = Cell.C5;
        Logic logic = new Logic();
        RookBlack rookBlackSource = new RookBlack(source);
        logic.add(rookBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveRookFalse() {
        Cell source = Cell.A5;
        Cell dest = Cell.C6;
        Logic logic = new Logic();
        RookBlack rookBlackSource = new RookBlack(source);
        logic.add(rookBlackSource);
        assertThat(logic.move(source, dest), is(false));
    }
    @Test
    public void testMoveRookDestOccupied() {
        Cell source = Cell.A5;
        Cell dest = Cell.A7;
        Logic logic = new Logic();
        RookBlack rookBlackSource = new RookBlack(source);
        PawnBlack pawnBlack = new PawnBlack(dest);
        logic.add(rookBlackSource);
        logic.add(pawnBlack);
        assertThat(logic.move(source, dest), is(false));
    }
    @Test
    public void testMoveRookFalseOccupiedWay() {
        Cell source = Cell.A5;
        Cell dest = Cell.A8;
        Cell pawn = Cell.A7;
        Logic logic = new Logic();
        RookBlack rookBlackSource = new RookBlack(source);
        PawnBlack pawnBlackDest = new PawnBlack(pawn);
        logic.add(rookBlackSource);
        logic.add(pawnBlackDest);
        assertThat(logic.move(source, dest), is(false));
    }

    // Bishop bishop
    @Test
    public void testMoveBishopTruRight() {
        Cell source = Cell.C8;
        Cell dest = Cell.E6;
        Logic logic = new Logic();
        BishopBlack bishopBlackSource = new BishopBlack(source);
        logic.add(bishopBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveBishopTruLeft() {
        Cell source = Cell.C8;
        Cell dest = Cell.A6;
        Logic logic = new Logic();
        BishopBlack bishopBlackSource = new BishopBlack(source);
        logic.add(bishopBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveBishopFalse() {
        Cell source = Cell.C8;
        Cell dest = Cell.A4;
        Logic logic = new Logic();
        BishopBlack bishopBlackSource = new BishopBlack(source);
        logic.add(bishopBlackSource);
        assertThat(logic.move(source, dest), is(false));
    }
    @Test
    public void testMoveBishopDestOccupied() {
        Cell source = Cell.C8;
        Cell dest = Cell.A4;
        Logic logic = new Logic();
        BishopBlack bishopBlackSource = new BishopBlack(source);
        PawnBlack pawnBlack = new PawnBlack(dest);
        logic.add(bishopBlackSource);
        logic.add(pawnBlack);
        assertThat(logic.move(source, dest), is(false));
    }
    @Test
    public void testMoveBishopFalseOccupiedWay() {
        Cell source = Cell.C8;
        Cell dest = Cell.A4;
        Cell pawn = Cell.B7;
        Logic logic = new Logic();
        BishopBlack bishopBlackSource = new BishopBlack(source);
        PawnBlack pawnBlackDest = new PawnBlack(pawn);
        logic.add(bishopBlackSource);
        logic.add(pawnBlackDest);
        assertThat(logic.move(source, dest), is(false));
    }

    // King king
    @Test
    public void testMoveKingTruUp() {
        Cell source = Cell.A8;
        Cell dest = Cell.A7;
        Logic logic = new Logic();
        KingBlack kingBlackSource = new KingBlack(source);
        logic.add(kingBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveKingTruLeft() {
        Cell source = Cell.C8;
        Cell dest = Cell.B8;
        Logic logic = new Logic();
        KingBlack kingBlackSource = new KingBlack(source);
        logic.add(kingBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveKingFalse() {
        Cell source = Cell.C8;
        Cell dest = Cell.A4;
        Logic logic = new Logic();
        KingBlack kingBlackSource = new KingBlack(source);
        logic.add(kingBlackSource);
        assertThat(logic.move(source, dest), is(false));
    }
    @Test
    public void testMoveKingDestOccupied() {
        Cell source = Cell.C8;
        Cell dest = Cell.B8;
        Logic logic = new Logic();
        KingBlack kingBlackSource = new KingBlack(source);
        PawnBlack pawnBlack = new PawnBlack(dest);
        logic.add(kingBlackSource);
        logic.add(pawnBlack);
        assertThat(logic.move(source, dest), is(false));
    }

    // Knight knight
    @Test
    public void testMoveKnightTruRight() {
        Cell source = Cell.B8;
        Cell dest = Cell.C6;
        Logic logic = new Logic();
        KnightBlack knightBlackSource = new KnightBlack(source);
        logic.add(knightBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveKnightTruLeft() {
        Cell source = Cell.B8;
        Cell dest = Cell.A6;
        Logic logic = new Logic();
        KnightBlack knightBlackSource = new KnightBlack(source);
        logic.add(knightBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveKnightFalse() {
        Cell source = Cell.C8;
        Cell dest = Cell.A4;
        Logic logic = new Logic();
        KnightBlack knightBlackSource = new KnightBlack(source);
        logic.add(knightBlackSource);
        assertThat(logic.move(source, dest), is(false));
    }
    @Test
    public void testMoveKnightDestOccupied() {
        Cell source = Cell.B8;
        Cell dest = Cell.A6;
        Logic logic = new Logic();
        KnightBlack knightBlackSource = new KnightBlack(source);
        PawnBlack pawnBlack = new PawnBlack(dest);
        logic.add(knightBlackSource);
        logic.add(pawnBlack);
        assertThat(logic.move(source, dest), is(false));
    }
    @Test
    public void testMoveKnightTrueOccupiedWay() {
        Cell source = Cell.B8;
        Cell dest = Cell.A6;
        Cell pawn = Cell.B7;
        Logic logic = new Logic();
        KnightBlack knightBlackSource = new KnightBlack(source);
        PawnBlack pawnBlackDest = new PawnBlack(pawn);
        logic.add(knightBlackSource);
        logic.add(pawnBlackDest);
        assertThat(logic.move(source, dest), is(true));
    }
    // Qeen qeen
    @Test
    public void testMoveQeenTruUp() {
        Cell source = Cell.D8;
        Cell dest = Cell.D6;
        Logic logic = new Logic();
        QeenBlack qeenBlackSource = new QeenBlack(source);
        logic.add(qeenBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveQeenTruRightUp() {
        Cell source = Cell.D8;
        Cell dest = Cell.F6;
        Logic logic = new Logic();
        QeenBlack qeenBlackSource = new QeenBlack(source);
        logic.add(qeenBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveQeenTruRight() {
        Cell source = Cell.D8;
        Cell dest = Cell.F8;
        Logic logic = new Logic();
        QeenBlack qeenBlackSource = new QeenBlack(source);
        logic.add(qeenBlackSource);
        assertThat(logic.move(source, dest), is(true));
    }
    @Test
    public void testMoveQeenFalse() {
        Cell source = Cell.C8;
        Cell dest = Cell.A4;
        Logic logic = new Logic();
        QeenBlack qeenBlackSource = new QeenBlack(source);
        logic.add(qeenBlackSource);
        assertThat(logic.move(source, dest), is(false));
    }
    @Test
    public void testMoveQeentDestOccupied() {
        Cell source = Cell.D8;
        Cell dest = Cell.D6;
        Logic logic = new Logic();
        QeenBlack qeenBlackSource = new QeenBlack(source);
        PawnBlack pawnBlack = new PawnBlack(dest);
        logic.add(qeenBlackSource);
        logic.add(pawnBlack);
        assertThat(logic.move(source, dest), is(false));
    }
    @Test
    public void testMoveQeenFalseOccupiedWay() {
        Cell source = Cell.D8;
        Cell dest = Cell.D6;
        Cell pawn = Cell.D7;
        Logic logic = new Logic();
        QeenBlack qeenBlackSource = new QeenBlack(source);
        PawnBlack pawnBlackDest = new PawnBlack(pawn);
        logic.add(qeenBlackSource);
        logic.add(pawnBlackDest);
        assertThat(logic.move(source, dest), is(false));
    }
}
