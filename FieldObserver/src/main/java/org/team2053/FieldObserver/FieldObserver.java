package org.team2053.FieldObserver;

import edu.wpi.first.shuffleboard.api.data.MapData;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

@Description(dataTypes = { MapData.class }, name = "Field Observer Widget" )
@ParametrizedController(value = "FieldObserver.fxml")
public class FieldObserver extends SimpleAnnotatedWidget<MapData> {

	@FXML
	protected Pane _thePane;
	@FXML
	protected Canvas _theCanvas;
	
	private ObjectProperty<Image> imageToBeDrawn = new SimpleObjectProperty<Image>(new Image(getClass().getResource("2019-field.jpg").toExternalForm()));
	
	private SimpleStringProperty _xPositionKey = new SimpleStringProperty(this, "xImageKey", "");
	private SimpleStringProperty _yPositionKey = new SimpleStringProperty(this, "yImageKey", "");
	private SimpleStringProperty _headingAngleKey = new SimpleStringProperty(this, "headingImageKey", "");
	
	public String getXImageKey() {
		return _xPositionKey.getValue();
	}
	
	public void setXImageKey(String x) {
		_xPositionKey.setValue(x);
	}
	
	public String getYImageKey() {
		return _yPositionKey.getValue();
	}
	
	public void setYImageKey(String y) {
		_yPositionKey.setValue(y);
	}
	
	public String getHeadingImageKey() {
		return _headingAngleKey.getValue();
	}
	
	public void setHeadingImageKey(String h) {
		_headingAngleKey.setValue(h);
	}
	
	public Pane getView() {
		
		GraphicsContext gc = _theCanvas.getGraphicsContext2D();
		gc.drawImage(imageToBeDrawn.get(), 0, 0);		
		return _thePane;
	}

	@FXML
	public void initialize() {
		//this.exportProperties(_xPositionKey, _yPositionKey, _headingAngleKey);
		GraphicsContext gc = _theCanvas.getGraphicsContext2D();
		gc.drawImage(imageToBeDrawn.get(), 0, 0);
	}
}
