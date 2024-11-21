const Airport = require('./models/services/Airport');
const MilitaryPlane = require('./planes/MilitaryPlane');
const PassengerPlane = require('./planes/PassengerPlane');
const ExperimentalPlane = require('./planes/ExperimentalPlane');
const MyPlane = require('./planes/MyPlane');
const ExperimentalTypes = require('./models/ExperimentalTypes');
const ClassificationLevel = require('./models/ClassificationLevel');
const MilitaryType = require('./models/MilitaryType');

(function run() {
    let planes = [
        new PassengerPlane('Boeing-737', 900, 12000, 60500, 164),
        new PassengerPlane('Boeing-737-800', 940, 12300, 63870, 192),
        new PassengerPlane('Boeing-747', 980, 16100, 70500, 242),
        new MilitaryPlane('B-1B Lancer', 1050, 21000, 80000, MilitaryType.BOMBER),
        new MilitaryPlane('F-15', 1500, 12000, 10000, MilitaryType.FIGHTER),
        new ExperimentalPlane('Bell X-14', 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
        new MyPlane('Gulfstream G650', 950, 13000, 18000, 'Gulfstream Airlines', true)
    ];

    let airport = new Airport(planes);
    let militaryAirport = new Airport(airport.getMilitaryPlanes());
    let passengerAirport = new Airport(airport.getPassengerPlanes());

    console.log(`Military airport sorted by max distance: ${Airport.print(militaryAirport.sortByMaxDistance())}`);
    console.log(`Passenger airport sorted by max speed: ${Airport.print(passengerAirport.sortByMaxSpeed())}`);
    console.log(`Plane with max passenger capacity: ${Airport.print(passengerAirport.getPassengerPlaneWithMaxCapacity())}`);
})();