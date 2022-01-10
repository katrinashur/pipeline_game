package main.model.pipeelement;

import main.model.DirectionTypeEnum;
import main.model.WaterPiece;

import java.util.List;

public abstract class ChangerSegment extends Segment{

    public ChangerSegment(List<DirectionTypeEnum> directionTypeList) {
        super(directionTypeList);
    }

    @Override
    public void fillWithWaterPiece(PipeElement pipeElement, WaterPiece waterPiece) {
        this.waterPiece = waterPiece;
        this.transform(this.waterPiece);
    }

    protected abstract void transform(WaterPiece waterPiece);
}
