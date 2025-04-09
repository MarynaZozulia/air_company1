package Planes;

import java.util.Objects;

public abstract class Plane {
    private final String model;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        if (maxSpeed <= 0) {
            throw new IllegalArgumentException("Max speed must be greater than zero.");
        }
        if (maxFlightDistance <= 0) {
            throw new IllegalArgumentException("Max flight distance must be greater than zero.");
        }
        if (maxLoadCapacity <= 0) {
            throw new IllegalArgumentException("Max load capacity must be greater than zero.");
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
        return """
               Plane{
                   model='%s',
                   maxSpeed=%d,
                   maxFlightDistance=%d,
                   maxLoadCapacity=%d
               }
               """.formatted(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return maxSpeed == plane.maxSpeed &&
                maxFlightDistance == plane.maxFlightDistance &&
                maxLoadCapacity == plane.maxLoadCapacity &&
                Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }

    // Abstract methods to be implemented by subclasses
    public abstract void fly();
    public abstract void land();
