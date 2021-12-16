package main.model.pipeelement;

import main.model.DirectionTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class Segment extends PipeElement {

    public Segment(List<DirectionTypeEnum> directionTypeList) {
        this.directionList = directionTypeList;
    }

    public void turn() {
        List<DirectionTypeEnum> newDirections = new ArrayList<>();
        for (DirectionTypeEnum directionType: this.directionList) {
            newDirections.add(DirectionTypeEnum.getNextOnTurn(directionType));
        }
        this.directionList = newDirections;
    }
}
