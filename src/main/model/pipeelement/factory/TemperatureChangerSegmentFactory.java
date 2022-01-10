package main.model.pipeelement.factory;

import main.model.DirectionTypeEnum;
import main.model.pipeelement.ChangerSegment;
import main.model.pipeelement.TemperatureChangerSegment;

import java.util.List;

public class TemperatureChangerSegmentFactory extends ChangerSegmentFactory {

    @Override
    public ChangerSegment createPipeE(List<DirectionTypeEnum> directionTypeEnumList) {
        return new TemperatureChangerSegment(directionTypeEnumList);
    }
}
