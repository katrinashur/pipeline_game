package main.model.pipeelement.factory;

import main.model.pipeelement.ChangerSegment;
import main.model.pipeelement.TemperatureChangerSegment;

public class TemperatureChangerSegmentFactory extends AbstractChangerSegmentFactory {

    @Override
    public ChangerSegment createChangerSegment() {
        return new TemperatureChangerSegment();
    }
}
