package epam;

import epam.Planes.experimentalPlane;
import epam.models.MilitaryType;
import epam.Planes.*;

import java.util.*;
import java.util.stream.Collectors;


public class Airport {
	private List<? extends Plane> planes;

	public List<PassengerPlane> getPassengerPlanes() {
		return planes.stream().filter(plane -> plane instanceof PassengerPlane).map(
				plane -> (PassengerPlane) plane).collect(Collectors.toList());
	}

	public List<MilitaryPlane> getMilitaryPlanes() {
		return planes.stream().filter(plane -> plane instanceof MilitaryPlane).map(
				plane -> (MilitaryPlane) plane).collect(Collectors.toList());
	}

	public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
		return getPassengerPlanes().stream().max(Comparator.comparing(PassengerPlane::getPassengersCapacity)).orElseThrow(
				NoSuchElementException::new);
	}

	public List<MilitaryPlane> getTransportMilitaryPlanes() {
		return getMilitaryPlanes().stream().filter(
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
