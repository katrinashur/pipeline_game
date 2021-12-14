package main.model.pipeelement;

import main.model.WaterPiece;

public class TemperatureChangerSegment extends SegmentChanger {

    private Integer degrees;

    public TemperatureChangerSegment(Class... characteristics) {
        super(characteristics);

        characteristics[0].getSuperclass();
    }

    @Override
    protected void transform(WaterPiece waterPiece) {

    }
}
