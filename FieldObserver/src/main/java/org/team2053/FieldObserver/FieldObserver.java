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

@Description(dataTypes = { RobotPoseData.class }, name = "Field Observer Widget" )
@ParametrizedController(value = "FieldObserver.fxml")
public class FieldObserver extends SimpleAnnotatedWidget<RobotPose> {

	@FXML
	protected Pane _thePane;
	@FXML
	protected Canvas _theCanvas;
	
	private ObjectProperty<Image> imageToBeDrawn = new SimpleObjectProperty<Image>(new Image(getClass().getResource("2019-field.jpg").toExternalForm()));
	
	public Pane getView() {
		
		GraphicsContext gc = _theCanvas.getGraphicsContext2D();
		gc.drawImage(imageToBeDrawn.get(), 0, 0);
		gc.fillOval(this.getData().getXPos(), this.getData().getYPos(), 10, 10);
		
		return _thePane;
	}

	@FXML
	public void initialize() {
		GraphicsContext gc = _theCanvas.getGraphicsContext2D();
		gc.drawImage(imageToBeDrawn.get(), 0, 0);
	}
}
