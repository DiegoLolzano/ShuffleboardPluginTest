package org.team2053.FieldObserver;

import java.util.Map;
import java.util.function.Function;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;

public class RobotPoseData extends ComplexDataType<RobotPose>{
	public static final RobotPoseData Instance = new RobotPoseData();
	
	public RobotPoseData() {
		super("RobotPose", RobotPose.class);
	}
	
	@Override
	public Function<Map<String, Object>, RobotPose> fromMap() {
		return map-> {
			return new RobotPose((double) map.getOrDefault("xPos", 0.0), (double) map.getOrDefault("yPos", 0.0), (double) map.getOrDefault("heading", 0.0));
		};
	}
	
	@Override
	public RobotPose getDefaultValue() {
		return new RobotPose(0,0,0);
	}
}
