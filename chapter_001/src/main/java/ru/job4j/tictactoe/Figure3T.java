package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;
/**
 * Class Figure3T решение задачи части 001 - урок Крестики-нолики на JavaFX, отвечает за клетку на поле.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    public Figure3T() {
    }
    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }
    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }
    public boolean hasMarkX() {
        return this.markX;
    }
    public boolean hasMarkO() {
        return this.markO;
    }
}
