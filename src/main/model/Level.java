package main.model;

import main.model.characteristic.Characteristic;
import main.model.exception.GameNotMeetRequirementsException;
import main.model.pipeelement.PipeElement;
import main.model.pipeelement.WaterChecker;
import main.model.pipeelement.WaterCreator;

import java.util.List;
import java.util.Map;

public class Level {

    private Map<Point, PipeElement> elementsMap;
    private List<Characteristic> characteristicList;


    private Point waterCreatorPoint;
    private Point waterCheckerPoint;
    private Water water;



    protected Level(Level.LevelBuilder builder) {
        this.elementsMap = builder.elementsMap;
        this.waterCreatorPoint = builder.waterCreatorPoint;
    }

    public Map<Point, PipeElement> getElementsMap() {
        return elementsMap;
    }

    public WaterCreator getWaterCreator() {
        return (WaterCreator)this.elementsMap.get(this.waterCreatorPoint); //?
    }

    public void findNeighbours() {
        Map<Point, PipeElement> copyElementsMap = elementsMap;
        elementsMap.forEach((point, pipeElement) -> {
            //сосед сверху
            pipeElement.addNeighbor(DirectionTypeEnum.UP, copyElementsMap.get(new Point(point.getX(), point.getY()+1)));
            //сосед справа
            pipeElement.addNeighbor(DirectionTypeEnum.RIGHT, copyElementsMap.get(new Point(point.getX()+1, point.getY())));
            //сосед снизу
            pipeElement.addNeighbor(DirectionTypeEnum.DOWN, copyElementsMap.get(new Point(point.getX(), point.getY()-1)));
            //сосед слева
            pipeElement.addNeighbor(DirectionTypeEnum.LEFT, copyElementsMap.get(new Point(point.getX()-1, point.getY())));
        });
    }

    public WaterChecker getWaterChecker() {
        return (WaterChecker)this.elementsMap.get(this.waterCheckerPoint); //?
    }


    public static class LevelBuilder {
        Point waterCreatorPoint;
        List<Characteristic> characteristicList;
        Map<Point, PipeElement> elementsMap;

        public LevelBuilder setWaterCreatorPoint(Point waterCreatorPoint) {
            this.waterCreatorPoint = waterCreatorPoint;
            return this;
        }

        public LevelBuilder setCharacteristicList(List<Characteristic> characteristicList) {
            this.characteristicList = characteristicList;
            return this;
        }

        public Level build() throws GameNotMeetRequirementsException {
            if (this.waterCreatorPoint == null || this.elementsMap.isEmpty()) {
                throw new GameNotMeetRequirementsException("Конструкция уровня не соответствует базовым требования уровня");
            }

            if (!(this.elementsMap.get(this.waterCreatorPoint) instanceof WaterCreator)) {
                throw new GameNotMeetRequirementsException("На месте крана должен быть кран");
            }

            //всевозможные проверки

            return new Level(this);
        }

    }
}
