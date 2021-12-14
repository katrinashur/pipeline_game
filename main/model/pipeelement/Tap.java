package main.model.pipeelement;

import main.model.Water;
import main.model.WaterPiece;
import main.model.characteristic.Characteristic;

import java.util.List;

public class Tap extends PipeElement implements WaterCreator {

    private Water water;

    public Water createWater(List<Characteristic> characteristicList) {
        Water water = Water.getInstance(this, characteristicList);
        this.waterPiece = water.getFirst();
        return water;
    }

    @Override
    public void pushWater() {
        this.water.doStep();
    }

    @Override
    public void fillWithWaterPiece(WaterPiece waterPiece) {

    }

}
