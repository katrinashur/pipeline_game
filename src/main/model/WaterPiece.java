package main.model;

import main.model.characteristic.Characteristic;
import main.model.characteristic.CharacteristicChanger;
import main.model.pipeelement.PipeElement;

import java.util.List;

public class WaterPiece implements Cloneable {

    private PipeElement pipeElement;
    private List<Characteristic> characteristicList;

    public WaterPiece(PipeElement pipeElement, List<Characteristic> characteristicList) {
        this.pipeElement = pipeElement;
        this.characteristicList = characteristicList;
    }

    private WaterPiece(WaterPiece waterPiece) {
        this.pipeElement = null;
        this.characteristicList = waterPiece.characteristicList;
    }

    public List<Characteristic> getCharacteristicList() {
        return characteristicList;
    }

    public void transform(List<CharacteristicChanger> changerList){
        for (Characteristic characteristic : characteristicList ) {
            characteristic.change(changerList);
        }
    }

    public PipeElement getPipeElement() {
        return this.pipeElement;
    }

    @Override
    public Object clone() {
        return new WaterPiece(this);
    }

    public void fillPipeElement(PipeElement previous, PipeElement next) {
        this.pipeElement = next;
        next.fillWithWaterPiece(previous, this);
    }
}
