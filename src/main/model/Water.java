package main.model;

import main.model.characteristic.Characteristic;
import main.model.pipeelement.PipeElement;

import java.util.ArrayList;
import java.util.List;

public class Water {
    private static Water instance;
    private List<WaterPiece> waterPieceList;

    private Water(PipeElement pipeElement, List<Characteristic> characteristicList) {
        waterPieceList = new ArrayList<>();
        WaterPiece waterPiece = new WaterPiece(pipeElement, characteristicList);
        waterPieceList.add(waterPiece);
    }

    public static Water getInstance(PipeElement pipeElement, List<Characteristic> characteristicList) {
        if (instance == null) {
            instance = new Water(pipeElement, characteristicList);
        }
        return instance;
    }

    public WaterPiece getHead() {
        if (waterPieceList != null && !waterPieceList.isEmpty()) {
            return waterPieceList.get(waterPieceList.size()-1);
        } else {
            return null;
        }
    }

    public Boolean doStep() {
        //Берем у головы потока его элемент трубы
        PipeElement current = this.getHead().getPipeElement();

        //У трубы спрашиваем достижимых соседей и выбираем среди них
        PipeElement next = choose(current.getReachablePipeElementList());

        if (next == null) {
            return false;
        }

        //Создаем копию головы
        waterPieceList.add((WaterPiece) getHead().clone());

        //Копией головы двигаемся в следующий элемент трубы
        getHead().fillPipeElement(current, next);
        return true;

    }

    protected PipeElement choose(List<PipeElement> pipeElementList) {
        //возможно переопределяемое поведение - стратегия выбора отверстия
        if (pipeElementList != null && !pipeElementList.isEmpty()) {
            return pipeElementList.get(0);
        }
        return null;
    }
}
