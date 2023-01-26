import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import models.MilitaryType;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream().filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane) plane).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream().filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane) plane).collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream().filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane).collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return Collections.max(getPassengerPlanes(), Comparator.comparingInt(PassengerPlane::getPassengersCapacity));
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanes().stream().filter(plane -> plane.getType().equals(MilitaryType.TRANSPORT)).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().stream().filter(plane -> plane.getType().equals(MilitaryType.BOMBER)).collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, (o1, o2) -> o1.getMaxFlightDistance() - o2.getMaxFlightDistance());
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, (o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, (o1, o2) -> o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity());
        return this;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes +
                '}';
    }

}
