package main.model.characteristic;

public class EnergyQuantity extends CharacteristicChanger{

    private Integer degrees;

    public EnergyQuantity() {
        this.degrees = 0;
    }

    public void addEnergyQuantity(EnergyQuantity other) {
        this.degrees += other.degrees;
    }



}
