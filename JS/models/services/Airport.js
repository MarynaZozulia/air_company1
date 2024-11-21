const MilitaryPlane = require('../../planes/MilitaryPlane');
const PassengerPlane = require('../../planes/PassengerPlane');
const ExperimentalPlane = require('../../planes/ExperimentalPlane');
const MilitaryType = require('../MilitaryType');

class Airport {
    constructor(planes) {
        this.planes = planes;
    }

    getPlanesByType(type) {
        return this.planes.filter(plane => plane instanceof type);
    }

    getMilitaryPlanes() {
        return this.getPlanesByType(MilitaryPlane);
    }

    getPassengerPlanes() {
        return this.getPlanesByType(PassengerPlane);
    }

    getExperimentalPlanes() {
        return this.getPlanesByType(ExperimentalPlane);
    }

    getPassengerPlaneWithMaxCapacity() {
        return this.getPassengerPlanes().reduce((max, plane) =>
            plane.getPassengersCapacity() > max.getPassengersCapacity() ? plane : max);
    }

    getTransportMilitaryPlanes() {
        return this.getMilitaryPlanes().filter(plane => plane.militaryType === MilitaryType.TRANSPORT);
    }

    getBomberMilitaryPlanes() {
        return this.getMilitaryPlanes().filter(plane => plane.militaryType === MilitaryType.BOMBER);
    }

    sortPlanesByProperty(property) {
        return this.planes.sort((a, b) => a[property] > b[property] ? 1 : -1);
    }

    sortByMaxDistance() {
        return this.sortPlanesByProperty('maxFlightDistance');
    }

    sortByMaxSpeed() {
        return this.sortPlanesByProperty('maxSpeed');
    }

    sortByMaxLoadCapacity() {
        return this.sortPlanesByProperty('maxLoadCapacity');
    }

    static print(planes) {
        return JSON.stringify(planes);
    }

    getPassengerPlaneWithMaxPassengersCapacity() {
        return this.getPassengerPlanes()
            .reduce((maxPlane, currentPlane) =>
                currentPlane.getPassengersCapacity() > maxPlane.getPassengersCapacity() ? currentPlane : maxPlane
            );
    }
}

module.exports = Airport;