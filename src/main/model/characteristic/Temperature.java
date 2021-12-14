package main.model.characteristic;

public class Temperature extends Characteristic {

    @Override
    public void change(CharacteristicChanger... changers) {
        for (int i = 0; i < changers.length; i++) {
            if (changers[i] instanceof EnergyQuantity) {
                increase((EnergyQuantity)changers[i]);
            }
        }
    }

    protected void increase(EnergyQuantity energyQuantity) {
        ((EnergyQuantity)this.changer).addEnergyQuantity(energyQuantity);
    }
}
