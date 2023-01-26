package planes;

import models.ClassificationLevel;
import models.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane{

    private ExperimentalType experimentalType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalType getType() {
        return experimentalType;
    }

    public void setType(ExperimentalType type) {
        this.experimentalType = experimentalType;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", experimentalType=" + experimentalType +
                        ", classificationLevel=" + classificationLevel +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null | !(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return experimentalType == that.experimentalType &&
                classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model);
    }
}
