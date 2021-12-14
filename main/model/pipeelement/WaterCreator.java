package main.model.pipeelement;

import main.model.Water;
import main.model.characteristic.Characteristic;

import java.util.List;

public interface WaterCreator {

    Water createWater(List<Characteristic> characteristicList);

    void pushWater();
}
