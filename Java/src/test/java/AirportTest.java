import airports.Airport;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import java.util.Arrays;
import java.util.List;

public class AirportTest {

    private static final PassengerPlane PLANE_WITH_MAX_PASSENGER_CAPACITY = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    private static final List<MilitaryPlane> EXPECTED_TRANSPORT_PLANES = Arrays.asList(
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
    );

    private static final List<Plane> EXPECTED_SORTED_PLANES_BY_LOAD_CAPACITY = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
    );


    private static final List<MilitaryPlane> EXPECTED_BOMBER_PLANES = Arrays.asList(
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER)
    );

    private static final List<ExperimentalPlane> EXPECTED_CLASSIFIED_EXPERIMENTAL_PLANES = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private List<Plane> planes;
    private Airport airport;

    @BeforeClass
    public void setUp() {
        planes = Arrays.asList(
        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                PLANE_WITH_MAX_PASSENGER_CAPACITY,
        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),

        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                EXPECTED_TRANSPORT_PLANES.get(0),

        new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
        );

        airport = new Airport(planes);
    }

    @Test(description = "Validate getTransportMilitaryPlanes returns only TRANSPORT planes")
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();

        Assert.assertEquals(transportMilitaryPlanes, EXPECTED_TRANSPORT_PLANES,
                "The Transport Military Plane lists are not equal");
    }

    @Test(description = "Validate getPassengerPlaneWithMaxPassengersCapacity returns the Passenger Plane with max capacity")
    public void testGetPassengerPlaneWithMaxCapacity() {
        PassengerPlane actualPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();

        Assert.assertEquals(actualPlaneWithMaxPassengersCapacity, PLANE_WITH_MAX_PASSENGER_CAPACITY,
                "The plane with the maximum passenger capacity is incorrect");
    }

    @Test(description = "Validate that planes are sorted by max load capacity in ascending order")
    public void testPlanesSortedByMaxLoadCapacity() {
        airport.sortByMaxLoadCapacity();

        List<? extends Plane> sortedPlanesByLoadCapacity = airport.getPlanes();

        Assert.assertEquals(sortedPlanesByLoadCapacity, EXPECTED_SORTED_PLANES_BY_LOAD_CAPACITY,
                "The planes are not sorted by max load capacity as expected");
    }

    @Test(description = "Validate that the list of military planes includes at least one bomber plane")
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        List<MilitaryPlane> actualBomberMilitaryPlanes = airport.getBomberMilitaryPlanes();

        Assert.assertTrue(actualBomberMilitaryPlanes.containsAll(EXPECTED_BOMBER_PLANES) &&
                        EXPECTED_BOMBER_PLANES.containsAll(actualBomberMilitaryPlanes),
                "The bomber planes list does not match the expected bomber planes");
    }

    @Test(description = "Validate that all experimental planes have a classification level higher than UNCLASSIFIED")
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        List<ExperimentalPlane> actualExperimentalPlanes = airport.getExperimentalPlanes();

        Assert.assertEquals(actualExperimentalPlanes, EXPECTED_CLASSIFIED_EXPERIMENTAL_PLANES,
                "The experimental planes list includes unclassified planes");
    }

    @AfterClass
    public void tearDown() {
        airport = null;
    }
}
