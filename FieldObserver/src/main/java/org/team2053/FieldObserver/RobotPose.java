package org.team2053.FieldObserver;

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
		return Map.of("xPos", this.xPos, "yPos", this.yPos, "heading", this.heading);
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
	
	public RobotPose withXPos(double newXPos) {
		return new RobotPose(newXPos, this.yPos, this.heading);
	}
	
	public RobotPose withYPos(double newYPos) {
		return new RobotPose(this.xPos, newYPos, this.heading);
	}
	
	public RobotPose withHeading(double newHeading) {
		return new RobotPose(this.xPos, this.yPos, newHeading);
	}
}
