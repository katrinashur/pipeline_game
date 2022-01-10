package main.model;

import main.model.exception.GameNotMeetRequirementsException;
import main.model.pipeelement.PipeElement;
import main.model.pipeelement.WaterChecker;
import main.model.pipeelement.WaterCreator;

import java.util.Map;

public class Level {

    private Map<Point, PipeElement> elementsMap;

    private Point waterCreatorPoint;
    private Point waterCheckerPoint;


    protected Level(Level.LevelBuilder builder) {
        this.elementsMap = builder.elementsMap;
        this.waterCreatorPoint = builder.waterCreatorPoint;
        this.waterCheckerPoint = builder.waterCheckerPoint;
    }

    public Map<Point, PipeElement> getElementsMap() {
        return elementsMap;
    }

    public WaterCreator getWaterCreator() {
        return (WaterCreator)this.elementsMap.get(this.waterCreatorPoint); //?
    }

    public WaterChecker getWaterChecker() {
        return (WaterChecker)this.elementsMap.get(this.waterCheckerPoint); //?
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


    public static class LevelBuilder {
        Point waterCreatorPoint;
        Point waterCheckerPoint;
        Map<Point, PipeElement> elementsMap;

        public LevelBuilder setWaterCreatorPoint(Point waterCreatorPoint) {
            this.waterCreatorPoint = waterCreatorPoint;
            return this;
        }

        public LevelBuilder setWaterCheckerPoint(Point waterCheckerPoint) {
            this.waterCheckerPoint = waterCheckerPoint;
            return this;
        }

        public LevelBuilder setElementsMap(Map<Point, PipeElement> elementsMap) {
            this.elementsMap = elementsMap;
            return this;
        }

        public Level build() throws GameNotMeetRequirementsException {
            if (this.elementsMap.isEmpty()         ||
                    this.waterCreatorPoint == null ||
                    this.waterCheckerPoint == null) {
                throw new GameNotMeetRequirementsException("Конструкция уровня не соответствует базовым требования уровня");
            }

            if (!(this.elementsMap.get(this.waterCreatorPoint) instanceof WaterCreator)) {
                throw new GameNotMeetRequirementsException("На месте крана должен быть кран");
            }

            if (!(this.elementsMap.get(this.waterCheckerPoint) instanceof WaterChecker)) {
                throw new GameNotMeetRequirementsException("На месте слива должен быть слив");
            }

            //всевозможные проверки

            Level level = new Level(this);
            //Расставим соседей
            level.findNeighbours();
            return level;
        }

    }
}
