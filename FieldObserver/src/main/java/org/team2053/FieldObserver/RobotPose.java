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
		Map<String, Object> map = new HashMap<>();
		map.put("xPos", this.xPos);
		map.put("yPos", this.yPos);
		map.put("heading", this.heading);
		return map;
	}
	
	@Override
	public boolean equals(Object obj) {
		double thresh = 0.000001;
		if(!(obj instanceof RobotPose)) {
			return false;
		}
		RobotPose pose = (RobotPose) obj;
		double xComp = this.getXPos() - pose.getXPos();
		double yComp = this.getXPos() - pose.getYPos();
		double headingComp = this.getHeading() - pose.getHeading();
		if((Math.abs(xComp - 1) <= thresh) && (Math.abs(yComp - 1) <= thresh) && (Math.abs(headingComp - 1) <= thresh)) {
			return true;
		}
		else {
			return false;
		}
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
