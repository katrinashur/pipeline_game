package main.model.pipeelement;

import main.model.WaterPiece;
import main.model.characteristic.EnergyQuantity;

public class TemperatureChangerSegment extends ChangerSegment {

    private EnergyQuantity energyQuantity;

    public TemperatureChangerSegment() {
        this.energyQuantity = new EnergyQuantity();
    }

    //
//    public TemperatureChangerSegment(List<Class> characteristicList) {
//        super(characteristicList);
//
//        characteristicList.get(0).getSuperclass().asSubclass(Temperature.class);
//    }

    @Override
    protected void transform(WaterPiece waterPiece) {
        waterPiece.transform(this.energyQuantity);
    }
}
