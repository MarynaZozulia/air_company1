const Plane = require('./Plane');

class MyPlane extends Plane {
    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, airline, isPrivate) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.airline = airline || "Unknown Airline";
        this.isPrivate = isPrivate || false;
    }

    isPrivateJet() {
        return this.isPrivate;
    }

    getAirline() {
        return this.airline;
    }

    calculateFuelRequired() {
        const fuelEfficiency = 0.05; // Simplified fuel efficiency constant
        return (this.maxFlightDistance * this.maxSpeed) * fuelEfficiency;
    }

    toString() {
        return `${this.model} - Airline: ${this.airline}, Private: ${this.isPrivate ? 'Yes' : 'No'}`;
    }
}

module.exports = MyPlane;