package main.model.pipeelement;

import main.model.DirectionTypeEnum;
import main.model.WaterPiece;
import main.model.characteristic.EnergyQuantity;

import java.util.Collections;
import java.util.List;

public class TemperatureChangerSegment extends ChangerSegment {

    private Integer energyQuantityCount;

    public TemperatureChangerSegment(List<DirectionTypeEnum> directionTypeList) {
        super(directionTypeList);
        this.energyQuantityCount = ;
    }

    @Override
    protected void transform(WaterPiece waterPiece) {
        waterPiece.transform(Collections.singletonList(new EnergyQuantity(this.energyQuantityCount)));
    }
}
