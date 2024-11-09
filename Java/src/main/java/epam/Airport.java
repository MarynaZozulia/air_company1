package epam;

import epam.Planes.experimentalPlane;
import epam.models.MilitaryType;
import epam.Planes.*;

import java.util.*;
import java.util.stream.Collectors;


public class Airport {
	private List<? extends Plane> planes;

	public List<PassengerPlane> getPassengerPlane() {
		return planes.stream().filter(plane -> plane instanceof PassengerPlane).map(
				plane -> (PassengerPlane) plane).collect(Collectors.toList());
	}

	public List<MilitaryPlane> getMilitaryPlanes() {
		return planes.stream().filter(plane -> plane instanceof MilitaryPlane).map(
				plane -> (MilitaryPlane) plane).collect(Collectors.toList());
	}

	public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
		return getPassengerPlane().stream().max(Comparator.comparing(PassengerPlane::getPassengersCapacity)).orElseThrow(
				NoSuchElementException::new);
	}

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
		planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
		return this;
	}

	public Airport sortByMaxSpeed() {
		planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
		return this;
	}

	public Airport sortByMaxLoadCapacity() {
		planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
		return this;
	}

	public List<? extends Plane> getPlanes() {
		return planes;
	}

	@Override
	public String toString() {
		return "epam.Airport{" + "Planes=" + planes.toString() + '}';
	}

	//Constructor
	public Airport(List<? extends Plane> planes) {
		this.planes = planes;
	}

}
