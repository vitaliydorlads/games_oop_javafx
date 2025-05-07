package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;

class BishopBlackTest {

    @Test
    void whenCreatedWithA3ThenPositionIsA3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        Cell exp = bishopBlack.position();
        assertThat(Cell.A3).isEqualTo(exp);
    }

    @Test
    void whenCopiedThenPositionIsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        Figure exp = bishopBlack.copy(Cell.C1);
        assertThat(exp.position()).isEqualTo(Cell.C1);
    }

    @Test
    void whenMoveFromC1ThenReturnTheMoveD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] des = bishopBlack.way(Cell.G5);
        Cell[] exp = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(des).isEqualTo(exp);
    }

    @Test
    void whenMoveFromC1ThenImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exp = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.D1);
                });
        assertThat(exp.getMessage()).isEqualTo("Could not move by diagonal from C1 to D1");
    }
}
