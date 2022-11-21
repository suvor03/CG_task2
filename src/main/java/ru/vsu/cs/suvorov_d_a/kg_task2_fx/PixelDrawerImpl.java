package ru.vsu.cs.suvorov_d_a.kg_task2_fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PixelDrawerImpl implements PixelDrawer {
    private final GraphicsContext g;

    public PixelDrawerImpl(GraphicsContext g) {
        this.g = g;
    }

    @Override
    public void putPixel(double x, double y, Color c) {
        g.setFill(c);
        g.fillRect(x, y, 1, 1);
    }
}
