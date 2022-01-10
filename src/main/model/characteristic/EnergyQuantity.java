package main.model.characteristic;

import java.util.Objects;

public class EnergyQuantity extends CharacteristicChanger{

    private Integer energyQuantity;

    public EnergyQuantity(Integer energyQuantity) {
        this.energyQuantity = 0;
    }

    public Integer getEnergyQuantity() {
        return energyQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnergyQuantity that = (EnergyQuantity) o;
        return Objects.equals(energyQuantity, that.energyQuantity);
    }
}
