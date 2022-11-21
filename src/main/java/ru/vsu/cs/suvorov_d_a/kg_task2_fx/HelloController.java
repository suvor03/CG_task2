package ru.vsu.cs.suvorov_d_a.kg_task2_fx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
public class HelloController implements Initializable  {
    private final int WIDTH = 1500;
    private final int HEIGHT = 800;

    @FXML
    private Canvas drawingCanvas = new Canvas(WIDTH, HEIGHT);
    private GraphicsContext graphicsContext;
    public PixelInfo firstPoint = new PixelInfo(30, 60, Color.RED);
    public PixelInfo secondPoint = new PixelInfo(750, 600, Color.BLUE);

    private int selectedVertex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        graphicsContext = drawingCanvas.getGraphicsContext2D();
        repaint();
    }
    private void repaint() {
        paint(graphicsContext);
    }
    @FXML
    private void onMousePressed(MouseEvent mouseEvent) {
        int currentX = (int) mouseEvent.getX();
        int currentY = (int) mouseEvent.getY();

        int errorRate = 2;

        if (Math.abs(currentX - firstPoint.getX()) < errorRate && Math.abs(currentY - firstPoint.getY()) < errorRate) {
            selectedVertex = 1;
        } else {
            if (Math.abs(currentX - secondPoint.getX()) < errorRate && Math.abs(currentY - secondPoint.getY()) < errorRate) {
                selectedVertex = 2;
            } else {
                    selectedVertex = 0;
                }
            }
        }


    @FXML
    private void onMouseDragged(MouseEvent mouseEvent) {
        int currentX = (int) mouseEvent.getX();
        int currentY = (int) mouseEvent.getY();

        switch (selectedVertex) {
            case (1) -> firstPoint = new PixelInfo(currentX, currentY, firstPoint.getColor());
            case (2) -> secondPoint = new PixelInfo(currentX, currentY, secondPoint.getColor());
        }

        repaint();
    }

    protected void paint(GraphicsContext graphicsContext) {
        graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);
        Line line = new Line(firstPoint, secondPoint);
        PixelDrawer pd = new PixelDrawerImpl(graphicsContext);
        line.drawLine(pd);
    }
}