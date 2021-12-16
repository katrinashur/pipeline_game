package main.model.pipeelement;

import main.model.characteristic.Characteristic;

import java.util.List;

public interface WaterChecker {

    Boolean checkWater();

    void setExpectedCharacteristic(List<Characteristic> characteristicList);
}
