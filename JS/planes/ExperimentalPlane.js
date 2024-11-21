const Plane = require("./Plane");

class ExperimentalPlane extends Plane {
    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, experimentalType, classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
        this._experimentalType = experimentalType;
    }

    get experimentalType() {
        return this._experimentalType;
    }

    getClassificationLevel() {
        return this.classificationLevel;
    }
}

module.exports = ExperimentalPlane;