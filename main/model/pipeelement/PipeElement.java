package main.model.pipeelement;

import main.model.HoleDirection;
import main.model.WaterPiece;

import java.util.ArrayList;
import java.util.List;

public abstract class PipeElement {

    protected List<HoleDirection> holeDirectionList;
    protected List<PipeElement> neighbors;

    protected WaterPiece waterPiece;

    public  List<HoleDirection> getDirectionList() {
        //найдем через соседей элементы куда можно протечь
        List<HoleDirection> holeDirectionList = new ArrayList<>();
        return holeDirectionList;
    }

    public void fillWithWaterPiece(WaterPiece waterPiece) {
        this.waterPiece = waterPiece;
    }
}
