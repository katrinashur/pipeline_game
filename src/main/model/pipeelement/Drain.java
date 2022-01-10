package main.model.pipeelement;


import main.model.DirectionTypeEnum;
import main.model.characteristic.Characteristic;

import java.util.ArrayList;
import java.util.List;

public class Drain extends PipeElement implements WaterChecker {

    protected List<Characteristic> characteristicList;

    public Drain(DirectionTypeEnum directionType) {
        this.directionList = new ArrayList<>();
        this.directionList.add(directionType);
    }

    @Override
    public Boolean checkWater() {
        if (this.characteristicList != null && !characteristicList.isEmpty()) {
            return this.compareCharacteristic(this.characteristicList, this.waterPiece.getCharacteristicList());
        }

        if (this.waterPiece == null) {
            return false;
        }
        //Если не заполнен, значит все равно какая вода придет
        return true;
    }

    @Override
    public void setExpectedCharacteristic(List<Characteristic> characteristicList) {
            this.characteristicList = characteristicList;
    }

    protected Boolean compareCharacteristic(List<Characteristic> expected, List<Characteristic> real){
        //не будем учитывать если количество ожидаемых и реальных характеристик отличается
        for (Characteristic realCharacteristic : real) {
            for (Characteristic expectedCharacteristic : expected) {
                if ((expectedCharacteristic.getClass().equals(realCharacteristic.getClass()) &&
                        !expectedCharacteristic.equals(realCharacteristic))) {
                    //Если характеристики принадлежат к одному виду и при этом имееют разные значения
                    return false;
                }
            }
        }
        return true;
    }
}
