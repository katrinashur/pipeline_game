package main.model.pipeelement;

import main.model.DirectionTypeEnum;
import main.model.Water;
import main.model.WaterPiece;
import main.model.characteristic.Characteristic;

import java.util.ArrayList;
import java.util.List;

public class Tap extends PipeElement implements WaterCreator {

    private Water water;

    public Tap(DirectionTypeEnum directionType) {
        this.directionList = new ArrayList<>();
        this.directionList.add(directionType);
    }

    public Water createWater(List<Characteristic> characteristicList) {
        water = Water.getInstance(this, characteristicList);
        this.waterPiece = water.getHead();
        return water;
    }

    @Override
    public Boolean pushWater() {
       return this.water.doStep();
    }

    @Override
    public void fillWithWaterPiece(WaterPiece waterPiece) {

    }

}
