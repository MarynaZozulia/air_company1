import Planes.experimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

/**
 * Airport class manages a collection of planes and provides functionalities
 * to retrieve specific types of planes, such as passenger planes, military planes
 * (bomber and transport), and experimental planes. It also allows sorting planes by
 * their maximum distance, speed, and load capacity.
 *
 * @version 1.1
 * @author Vitali Shulha
 * @since 4-Jan-2019
 */

public class Airport {
    private final List<? extends Plane> planes;


    /**
     * Constructs an Airport instance with a list of planes.
     *
     * @param planes List of planes present in the airport.
     */
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    /**
     * Retrieves a list of all passenger planes in the airport.
     *
     * @return List of passenger planes.
     */
    public List<PassengerPlane> getPassengerPlane() {
        List<PassengerPlane> passengerPlaneList = new ArrayList<>();
        for (Plane p : this.planes) {if (p instanceof PassengerPlane) {passengerPlaneList.add((PassengerPlane) p);}}
        return passengerPlaneList;

    }

    /**
     * Retrieves a list of all military planes in the airport.
     *
     * @return List of military planes.
     */
    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    /**
     * Finds and returns the passenger plane with the maximum passenger capacity.
     *
     * @return Passenger plane with the highest capacity.
     */
    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    /**
     * Retrieves a list of all transport military planes in the airport.
     *
     * @return List of transport military planes.
     */
    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    /**
     * Retrieves a list of all bomber military planes in the airport.
     *
     * @return List of bomber military planes.
     */
    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    /**
     * Retrieves a list of all experimental planes in the airport.
     *
     * @return List of experimental planes.
     */
    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    /**
     * Sorts the planes by their maximum flight distance in ascending order.
     *
     * @return This Airport instance with planes sorted by max distance.
     */
    public Airport sortByMaxDistance() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance();
            }
        });
        return this;
    }


    /**
     * Sorts by max speed
     *
     * @return Airport
     */
    public Airport sortByMaxSpeed() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMS() - o2.getMS();
            }
        });
        return this;
    }

    /**
     * Sorts the planes by their maximum load capacity in ascending order.
     */
    public void sortByMaxLoadCapacity() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
    }

    /**
     * Retrieves the list of all planes in the airport.
     *
     * @return List of planes.
     */
    public List<? extends Plane> getPlanes() {
        return planes;
    }

    /**
     * Returns a string representation of the Airport object.
     *
     * @return String representation of the airport with all its planes.
     */
    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
