package main.model.pipeelement;

import main.model.DirectionTypeEnum;
import main.model.WaterPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class PipeElement {

    protected List<DirectionTypeEnum> directionList;
    protected Map<DirectionTypeEnum, PipeElement> neighbors; //по 4 сторонам

    protected DirectionTypeEnum enter; // ?

    protected WaterPiece waterPiece;

    public PipeElement() {
    }

    public List<DirectionTypeEnum> getDirectionList() {
        return this.directionList;
    }

    public void setDirectionList(List<DirectionTypeEnum> directionList) {
        this.directionList = directionList;
    }

    public void addNeighbor(DirectionTypeEnum direction, PipeElement pipeElement) {
        //проверить что лист не null и не пуст
        neighbors.put(direction, pipeElement);
    }

    public void fillWithWaterPiece(WaterPiece waterPiece) {
        this.waterPiece = waterPiece;
        //нужно как-то помечать вход
    }

    public List<PipeElement> getReachablePipeElementList() {
        List<PipeElement> reachable = new ArrayList<>();
        //проверить что лист не null и не пуст
        for (DirectionTypeEnum directionType : directionList) {
            //Получаем соседа по этому направлению
            PipeElement neighbor = neighbors.get(directionType);

            //ПРОВЕРИТЬ!
            if (neighbor.getDirectionList().contains(DirectionTypeEnum.getOpposite(directionType))) {
                //Если у соседа есть отверствие в противоположную сторону (текуший элемент - верх, сосед - вниз)
                reachable.add(neighbor);
            }
        }
        return reachable;
    }
}
