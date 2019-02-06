package org.team2053.FieldObserver;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

@Description(dataTypes = { RobotPoseType.class }, name = "Field Observer Widget" )
@ParametrizedController(value = "FieldObserver.fxml")
public class FieldObserver extends SimpleAnnotatedWidget<RobotPose> {

	@FXML
	protected Pane _thePane;
	@FXML
	protected Canvas _theCanvas;
	
	private ObjectProperty<Image> imageToBeDrawn = new SimpleObjectProperty<Image>(new Image(getClass().getResource("2019-field.jpg").toExternalForm()));
	
	public Pane getView() {
		
		int imageFieldLength = 579;
		int imageFieldWidth = 287;
		
		int robotPosXPixels = (int) ((this.getData().getXPos() * imageFieldLength) / (12 * 54));
		int robotPosYPixels = (int) ((this.getData().getYPos() * imageFieldWidth) / (12 * 27));
		
		double angle = this.getData().getHeading() * Math.PI / 180;
				
		GraphicsContext gc = _theCanvas.getGraphicsContext2D();
		gc.drawImage(imageToBeDrawn.get(), 0, 0);
		gc.setFill(Color.DEEPPINK);
		gc.fillOval(robotPosXPixels, robotPosYPixels, 10, 10);
		gc.setFill(Color.LIMEGREEN);
		gc.setLineWidth(2);
		gc.strokeLine(robotPosXPixels + 5, robotPosYPixels + 5, robotPosXPixels + 14 * Math.sin(angle), robotPosYPixels + 14 * Math.cos(angle));
		return _thePane;
	}

	@FXML
	public void initialize() {
		GraphicsContext gc = _theCanvas.getGraphicsContext2D();
		gc.drawImage(imageToBeDrawn.get(), 0, 0);
	}
}
