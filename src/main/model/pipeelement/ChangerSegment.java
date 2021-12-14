package main.model.pipeelement;

import main.model.WaterPiece;
import main.model.characteristic.Characteristic;
import main.model.exception.GameCommonException;

import java.util.ArrayList;
import java.util.List;

public abstract class ChangerSegment extends Segment{

   // List<Class> characteristicList = new ArrayList<>();

    public ChangerSegment() {
    }

//    public SegmentChanger(List<Class> characteristicList) {
//        for (Class characteristicClass : characteristicList) {
//            try {
//                characteristicClass.asSubclass(Characteristic.class)
//            } catch (ClassCastException e) {
//                throw new GameCommonException("Для создания изменятеля характеристики нужно ");
//            }
//            this.characteristicList.add(characteristicClass);
//        }
//    }

    public void fillWithWaterPiece(WaterPiece waterPiece) {
        this.waterPiece = waterPiece;
        this.transform(this.waterPiece);
    }

    protected abstract void transform(WaterPiece waterPiece);
}
