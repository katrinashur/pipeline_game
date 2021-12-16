package main.model.characteristic;

import java.util.Objects;

public class EnergyQuantity extends CharacteristicChanger{

    private Integer degrees;

    public EnergyQuantity() {
        this.degrees = 0;
    }

    public void addEnergyQuantity(EnergyQuantity other) {
        this.degrees += other.degrees;
    }

    public Integer getDegrees() {
        return degrees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnergyQuantity that = (EnergyQuantity) o;
        return Objects.equals(degrees, that.degrees);
    }
}
