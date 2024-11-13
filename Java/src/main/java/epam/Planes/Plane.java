package epam.Planes;

import java.util.Objects;


abstract public class Plane {
	private String model;
	private int maxSpeed;
	private int maxFlightDistance;
	private int maxLoadCapacity;

	public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
		if (model == null || model.isEmpty()) {
			throw new IllegalArgumentException("Model cannot be null or empty");
		}
		if (maxSpeed <= 0) {
			throw new IllegalArgumentException("Max speed should be greater than zero");
		}
		if (maxFlightDistance <= 0) {
			throw new IllegalArgumentException("Max flight distance should be greater than zero");
		}
		if (maxLoadCapacity <= 0) {
			throw new IllegalArgumentException("Max load capacity should be greater than zero");
		}
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.maxFlightDistance = maxFlightDistance;
		this.maxLoadCapacity = maxLoadCapacity;
	}

	public String getModel() {
		return model;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getMaxFlightDistance() {
		return maxFlightDistance;
	}

	public int getMaxLoadCapacity() {
		return maxLoadCapacity;
	}

	@Override
	public String toString() {
		return "Plane{" + "model='" + model + '\'' + ", maxSpeed=" + maxSpeed + ", maxFlightDistance=" + maxFlightDistance
				+ ", maxLoadCapacity=" + maxLoadCapacity + '}';
	}

	@Override
	public boolean equals(Object otherObject) {
       if (this == otherObject) {
           return true;
       }
       if (!(otherObject instanceof Plane)) {
           return false;
       }
		Plane plane = (Plane) otherObject;
		return maxSpeed == plane.maxSpeed && maxFlightDistance == plane.maxFlightDistance
				&& maxLoadCapacity == plane.maxLoadCapacity && Objects.equals(model, plane.model);
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
	}
}
