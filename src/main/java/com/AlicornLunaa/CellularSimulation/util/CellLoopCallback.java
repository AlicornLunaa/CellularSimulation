package com.AlicornLunaa.CellularSimulation.util;

import com.AlicornLunaa.CellularSimulation.gameplay.Cell;

public interface CellLoopCallback {

    void invoke(int x, int y, Cell c);

}
