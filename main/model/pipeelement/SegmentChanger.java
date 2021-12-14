package main.model.pipeelement;

import main.model.WaterPiece;

import java.util.ArrayList;
import java.util.List;

public abstract class SegmentChanger extends Segment{

    List<Class> characteristicList = new ArrayList<>();

    public SegmentChanger(Class... characteristics) {
        for (Class characteristicClass : characteristics) {
            characteristicList.add(characteristicClass);
        }
    }

    public void fillWithWaterPiece(WaterPiece waterPiece) {
        this.waterPiece = waterPiece;
        this.transform(this.waterPiece);
    }

    protected abstract void transform(WaterPiece waterPiece);
}
