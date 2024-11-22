using Aircompany.Models;
using Aircompany.Planes;
using System.Collections.Generic;
using System.Linq;

namespace Aircompany;

public class Airport(IEnumerable<Plane> planes)
{
    private List<Plane> Planes = planes.ToList();

    public List<PassengerPlane> GetPassengersPlanes()
    {
        return Planes.Where(t => t.GetType() == typeof(PassengerPlane)).Cast<PassengerPlane>().ToList();
    }

    public List<MilitaryPlane> GetMilitaryPlanes()
    {
        return Planes.Where(t => t.GetType() == typeof(MilitaryPlane)).Cast<MilitaryPlane>().ToList();
    }

    public PassengerPlane GetPassengerPlaneWithMaxPassengersCapacity()
    {
        var passengerPlanes = GetPassengersPlanes();
        return passengerPlanes.Aggregate((w, x) => w.PassengersCapacityIs() > x.PassengersCapacityIs() ? w : x);             
    }

    public List<MilitaryPlane> GetTransportMilitaryPlanes()
    {
        var militaryPlanes = GetMilitaryPlanes();

        return militaryPlanes.Where(plane => plane.PlaneTypeIs() == MilitaryType.TRANSPORT).ToList();
    }

    public Airport SortByMaxDistance()
    {
        return new Airport(Planes.OrderBy(w => w.MaxFlightDistance()));
    }

    public Airport SortByMaxSpeed()
    {
        return new Airport(Planes.OrderBy(w => w.GetMaxSpeed()));
    }

    public Airport SortByMaxLoadCapacity()
    {
        return new Airport(Planes.OrderBy(w => w.MaxLoadCapacity()));
    }


    public IEnumerable<Plane> GetPlanes()
    {
        return Planes;
    }

    public override string ToString()
    {
        return "Airport{" +
               "planes=" + string.Join(", ", Planes.Select(x => x.GetModel())) +
               '}';
    }
}