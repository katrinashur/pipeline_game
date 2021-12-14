package main.model;

import jdk.jfr.Event;
import main.model.characteristic.Characteristic;
import main.model.pipeelement.PipeElement;

import java.util.ArrayList;
import java.util.List;

public class Water implements Player {
    private static Water instance;
    private List<WaterPiece> waterPieceList;
    private List<Subscriber> subscriberList;

    private Water(PipeElement pipeElement, List<Characteristic> characteristicList) {
        waterPieceList = new ArrayList<>();
        subscriberList = new ArrayList<>();
        WaterPiece waterPiece = new WaterPiece(pipeElement, characteristicList);
        waterPieceList.add(waterPiece);
    }

    public static Water getInstance(PipeElement pipeElement, List<Characteristic> characteristicList) {
        if (instance == null) {
            instance = new Water(pipeElement, characteristicList);
        }
        return instance;
    }

    public WaterPiece getFirst() {
        if (waterPieceList != null && !waterPieceList.isEmpty()) {
            return waterPieceList.get(0);
        } else {
            return null;
        }
    }

    public void doStep() {
        PipeElement current = this.getFirst().go();
        PipeElement next = choose(current.getDirectionList());

        waterPieceList.add(getFirst().clone());
        getFirst().setPipeElement(next);

    }

    private PipeElement choose(List<HoleDirection> directionList) {
    }

    @Override
    public void fireEvent(Event event) {
        this.subscriberList.stream().forEach(subscriber -> subscriber.update());
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscriberList.add(subscriber);
    }

}
