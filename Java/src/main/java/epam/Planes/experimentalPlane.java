package epam.Planes;

import epam.models.ClassificationLevel;


public class experimentalPlane extends Plane {
	private ClassificationLevel classificationLevel;

	public experimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
			ClassificationLevel classificationLevel) {
		super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
		this.classificationLevel = classificationLevel;
	}

	public ClassificationLevel getClassificationLevel() {
		return classificationLevel;
	}

	@Override
	public boolean equals(Object otherObject) {
		return super.equals(otherObject);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "experimentalPlane{" + "model='" + getModel() + '\'' + '}';
	}
}
