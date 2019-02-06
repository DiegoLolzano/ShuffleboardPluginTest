package org.team2053.FieldObserver;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

public class RobotPose extends ComplexData<RobotPose> {
	
	private final double xPos;
	private final double yPos;
	private final double heading;
	
	public RobotPose(double x, double y, double heading) {
		this.xPos = x;
		this.yPos = y;
		this.heading = heading;
	}

	@Override
	public Map<String, Object> asMap() {
		return Map.of("x", xPos, "y", yPos, "heading", heading);
	}
	
	@Override
	public String toHumanReadableString() {
		return String.format("(%.1f, %.1f), %.3f degrees", xPos, yPos, heading);
	}
	
	public double getXPos() {
		return xPos;
	}
	
	public double getYPos() {
		return yPos;
	}
	
	public double getHeading() {
		return heading;
	}
}
