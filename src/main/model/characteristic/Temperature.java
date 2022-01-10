package main.model.characteristic;

import main.model.WaterPiece;

import java.util.List;

public abstract class Temperature extends Characteristic {

    protected Integer degrees;

    public Temperature() {
        this.degrees = 0;
    }

    @Override
    public void change(List<Characteristic> initialState, List<CharacteristicChanger> characteristicChangerList) {
        for (CharacteristicChanger changer: characteristicChangerList) {
            if (changer instanceof EnergyQuantity) {
                increase(initialState, (EnergyQuantity) changer);
            }
        }
    }

    protected abstract void increase(List<Characteristic> initialState, EnergyQuantity energyQuantity);

    public Integer getDegrees() {
        return this.degrees;
    }
}
