import Planes.experimentalPlane;
import Planes.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.Collections;
import java.util.logging.Logger;
import java.util.List;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    public List<PassengersPlane> getPassengersPlane() {
        return planes.stream().filter(plane -> plane instanceof PassengerPlane).map(
            plane -> (PassengerPlane) plane).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        Lreturn planes.stream().filter(plane -> plane instanceof MilitaryPlane).map(
                plane -> (MilitaryPlane) plane).collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        getPassengerPlanes().stream().max(Comparator.comparing(PassengerPlane::getPassengersCapacity)).orElseThrow(
                NoSuchElementException::new);
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        eturn getMilitaryPlanes().stream().filter(
                militaryPlane -> militaryPlane.getType() == MilitaryType.TRANSPORT).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().stream().filter(
                militaryPlane -> militaryPlane.getType() == MilitaryType.BOMBER).collect(Collectors.toList());

    }

    public List<experimentalPlane> getExperimentalPlanes() {
        return planes.stream().filter(plane -> plane instanceof experimentalPlane).map(
                plane -> (experimentalPlane) plane).collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
       planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity))
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            LOGGER.info("This is the plane: " + plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
