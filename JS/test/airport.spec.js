const assert = require('chai').assert;

const Airport = require('../models/services/Airport');
const MilitaryPlane = require('../planes/MilitaryPlane');
const PassengerPlane = require('../planes/PassengerPlane');
const ExperimentalPlane = require('../planes/ExperimentalPlane');
const MilitaryType = require('../models/MilitaryType');
const ExperimentalTypes = require('../models/ExperimentalTypes');
const ClassificationLevel = require('../models/ClassificationLevel');

describe('Airport Test', () => {

    let planes = [
        new PassengerPlane('Boeing-737', 900, 12000, 60500, 164),
        new PassengerPlane('Boeing-737-800', 940, 12300, 63870, 192),
        new PassengerPlane('Boeing-747', 980, 16100, 70500, 242),
        new PassengerPlane('Airbus A320', 930, 11800, 65500, 188),
        new PassengerPlane('Airbus A330', 990, 14800, 80500, 222),
        new PassengerPlane('Embraer 190', 870, 8100, 30800, 64),
        new PassengerPlane('Sukhoi Superjet 100', 870, 11500, 50500, 140),
        new PassengerPlane('Bombardier CS300', 920, 11000, 60700, 196),
        new MilitaryPlane('B-1B Lancer', 1050, 21000, 80000, MilitaryType.BOMBER),
        new MilitaryPlane('B-2 Spirit', 1030, 22000, 70000, MilitaryType.BOMBER),
        new MilitaryPlane('B-52 Stratofortress', 1000, 20000, 80000, MilitaryType.BOMBER),
        new MilitaryPlane('F-15', 1500, 12000, 10000, MilitaryType.FIGHTER),
        new MilitaryPlane('F-22', 1550, 13000, 11000, MilitaryType.FIGHTER),
        new MilitaryPlane('C-130 Hercules', 650, 5000, 110000, MilitaryType.TRANSPORT),
        new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    ];
    let planeWithMaxPassengerCapacity = new PassengerPlane('Boeing-747', 980, 16100, 70500, 242);

    it('should have military planes with transport type', () => {
        let airport = new Airport(planes);
        let transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        const hasTransportMilitaryPlane = transportMilitaryPlanes.some(militaryPlane =>
            militaryPlane.getMilitaryType() === MilitaryType.TRANSPORT
        );
        assert.isTrue(hasTransportMilitaryPlane, "There should be at least one transport military plane.");
    });

    it('should check passenger plane with max capacity', () => {
        let airport = new Airport(planes);
        let expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        assert.equal(expectedPlaneWithMaxPassengersCapacity.getPassengersCapacity(),
            planeWithMaxPassengerCapacity.getPassengersCapacity(),
            'The plane with max capacity should be correct');
    });


    it('should sort planes by MaxLoadCapacity', () => {
        let airport = new Airport(planes);
        let planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity();
        let isSorted = true;
        for (let i = 0; i < planesSortedByMaxLoadCapacity.length - 1; i++) {
            let currentPlane = planesSortedByMaxLoadCapacity[i];
            let nextPlane = planesSortedByMaxLoadCapacity[i + 1];
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                isSorted = false;
                break;
            }
        }
        assert.isTrue(isSorted, "planes should be sorted by max load capacity.");
    });

    it('should have at least one bomber in military planes', () => {
        let airport = new Airport(planes);
        let bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        let hasBomber = bomberMilitaryPlanes.some(militaryPlane => militaryPlane.getMilitaryType() === MilitaryType.BOMBER);
        assert.isTrue(hasBomber, "There should be at least one bomber military plane in the list.");
    });

    it('should check that experimental planes have classification level higher than unclassified', () => {
        let airport = new Airport(planes);
        let experimentalPlanes = airport.getExperimentalPlanes();
        let hasUnclassifiedPlanes = false;

        for (let experimentalPlane of experimentalPlanes) {
            if (experimentalPlane.classificationLevel === ClassificationLevel.UNCLASSIFIED) {
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        assert.isFalse(hasUnclassifiedPlanes, "There should be no unclassified experimental planes.");
    });
});