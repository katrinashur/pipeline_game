package main.model.characteristic;

import java.util.List;

public class Temperature extends Characteristic {

    public Temperature() {
        this.changer = new EnergyQuantity();
    }

    @Override
    public void change(List<CharacteristicChanger> characteristicChangerList) {
        for (CharacteristicChanger changer: characteristicChangerList) {
            if (changer instanceof EnergyQuantity) {
                increase((EnergyQuantity) changer);
            }
        }
    }

    protected void increase(EnergyQuantity energyQuantity) {
        ((EnergyQuantity)this.changer).addEnergyQuantity(energyQuantity);
    }

    public Integer getDegrees() {
        return ((EnergyQuantity)this.changer).getDegrees();
    }
}
