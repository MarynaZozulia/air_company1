package airports;

import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }
    public <T extends Plane> List<T> getPlanesByType(Class<T> planeType) {
        return planes.stream()
                .filter(planeType::isInstance)
                .map(planeType::cast)
                .collect(Collectors.toList());
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return getPlanesByType(PassengerPlane.class);
    }


    public List<MilitaryPlane> getMilitaryPlanes() {
        return getPlanesByType(MilitaryPlane.class);
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return getPlanesByType(ExperimentalPlane.class);
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getPassengerPlanes().stream()
                .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity))
                .orElseThrow(() -> new NoSuchElementException("There are not passenger planes"));
    }

    public List<MilitaryPlane> getMilitaryPlanesByType(MilitaryType type) {
        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType() == type)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanesByType(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanesByType(MilitaryType.BOMBER);
    }

    public Airport sortBy(Comparator<Plane> comparator) {
        planes.sort(comparator);
        return this;
    }

    public Airport sortByMaxDistance() {
        return sortBy(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public Airport sortByMaxSpeed() {
        return sortBy(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public Airport sortByMaxLoadCapacity() {
        return sortBy(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    @Override
    public String toString() {
        return "airports.Airport{" +
                "planes=" + planes.toString() +
                '}';
    }

}
