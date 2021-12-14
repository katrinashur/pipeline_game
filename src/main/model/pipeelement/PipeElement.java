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

    public  List<DirectionTypeEnum> getDirectionList() {
        //найдем через соседей элементы куда можно протечь
        List<DirectionTypeEnum> directionList = new ArrayList<>();
        return directionList;
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
        if (directionList.size() == 1) {
            //если дыра одна
            DirectionTypeEnum directionWay = directionList.get(0);
            PipeElement neighbor = neighbors.get(directionWay);
            if (neighbor.getDirectionList().contains(DirectionTypeEnum.getOpposite(directionWay))) {
                reachable.add(neighbor);
            }
        } else {

        }
    }
}
