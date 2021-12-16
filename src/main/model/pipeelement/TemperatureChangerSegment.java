package main.model.pipeelement;

import main.model.WaterPiece;
import main.model.characteristic.EnergyQuantity;

import java.util.Collections;

public class TemperatureChangerSegment extends ChangerSegment {

    private EnergyQuantity energyQuantity;

    public TemperatureChangerSegment() {
        this.energyQuantity = new EnergyQuantity();
    }

    @Override
    protected void transform(WaterPiece waterPiece) {
        waterPiece.transform(Collections.singletonList(this.energyQuantity));
    }
}
