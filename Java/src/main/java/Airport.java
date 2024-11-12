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

    public List<PassengerPlane> getPassengerPlane() {
        List<? extends Plane> planesList = this.planes;
        List<PassengerPlane> passangerPlaneList = new ArrayList<>();

        for (Plane plane : planesList) {
            if (plane instanceof PassengerPlane) {
                passangerPlaneList.add((PassengerPlane) plane);
            }
        }

        return passangerPlaneList;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();

        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }

        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);

        for (int i = 0; i < passengerPlanes.size() ; i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }

        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();

        for (int i = 0; i < militaryPlanes.size() ; i++) {
            MilitaryPlane plane = militaryPlanes.get(i);

                if (plane.getType() == MilitaryType.TRANSPORT) {
                    transportMilitaryPlanes.add(plane);
                }
        }

        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();

        for (int i = 0; i < militaryPlanes.size() ; i++) {
            MilitaryPlane plane = militaryPlanes.get(i);

            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }

        return bomberMilitaryPlanes;

    }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();

        for (Plane plane : planes) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane);
            }
        }

        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firsPlane, Plane secondPlane) {
                return firstPlane.getMaxFlightDistance() - secondPlane.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMS() - secondPlane.getMS();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane first, Plane secondPlane) {
                return first.getMinLoadCapacity() - secondPlane.getMinLoadCapacity();
            }
        });
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
