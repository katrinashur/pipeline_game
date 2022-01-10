package main.model.characteristic;


import java.util.List;

public class IndependentTemperature extends Temperature {

    @Override
    protected void increase(List<Characteristic> initialState, EnergyQuantity energyQuantity) {
        //Считаем что нужно 10 единиц энергии для повышения температуры на 1 градус
        degrees = energyQuantity.getEnergyQuantity()/10;
    }
}
