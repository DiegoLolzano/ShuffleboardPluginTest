package org.team2053.FieldObserver;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

@Description(group = "org.team2053", name = "FieldObserver", summary = "A plugin to take in a robotpose and display it on a virtual field", version = "0.0.1")
public class App extends Plugin {
	@Override
	public List<ComponentType> getComponents() {
		// TODO Auto-generated method stub
		return ImmutableList.of(WidgetType.forAnnotatedWidget(FieldObserver.class));
	}

	@Override
	public List<DataType> getDataTypes() {
		return ImmutableList.of(new RobotPoseData());
	}

	@Override
	public Map<DataType, ComponentType> getDefaultComponents() {
		return Map.of(RobotPoseData.Instance, WidgetType.forAnnotatedWidget(FieldObserver.class));
	}
}
