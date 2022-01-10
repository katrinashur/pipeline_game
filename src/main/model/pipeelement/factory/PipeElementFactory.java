package main.model.pipeelement.factory;

import main.model.DirectionTypeEnum;
import main.model.exception.ConfigurationNotCorrectException;
import main.model.pipeelement.Drain;
import main.model.pipeelement.PipeElement;
import main.model.pipeelement.Segment;
import main.model.pipeelement.Tap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PipeElementFactory {

    List<DirectionTypeEnum> directionTypeList = new ArrayList<>();

    public Drain createDrain(JSONObject jsonPipeElement) throws ConfigurationNotCorrectException {
        this.parseDirectionList(jsonPipeElement);
        if (directionTypeList == null || directionTypeList.size() != 1) {
            throw new ConfigurationNotCorrectException("Неправильная инициализация слива");
        }
        return new Drain(directionTypeList.get(0));
    }

    public Tap createTap(JSONObject jsonPipeElement) throws ConfigurationNotCorrectException {
        this.parseDirectionList(jsonPipeElement);
        if (directionTypeList == null || directionTypeList.size() != 1) {
            throw new ConfigurationNotCorrectException("Неправильная инициализация крана");
        }
        return new Tap(directionTypeList.get(0));
    }

    public Segment createSegment(JSONObject jsonPipeElement) throws ConfigurationNotCorrectException {
        this.parseDirectionList(jsonPipeElement);
        if (directionTypeList == null || directionTypeList.size() < 2) {
            throw new ConfigurationNotCorrectException("Неправильная инициализация сегмента");
        }
        Segment segment = new Segment(directionTypeList);
        return segment;
    }

    private void parseDirectionList(JSONObject jsonPipeElement) throws ConfigurationNotCorrectException {
        directionTypeList.clear();
        if (!jsonPipeElement.has("directionTypeList") || !(jsonPipeElement.get("directionTypeList") instanceof JSONArray)) {
            throw new ConfigurationNotCorrectException("У элемента трубопровода должно быть хотя бы 1 отверстие");
        }
        JSONArray directionTypeListJson = (JSONArray)jsonPipeElement.get("directionTypeList");
        for (int i = 0; i < directionTypeListJson.length(); i++) {
            DirectionTypeEnum directionType = DirectionTypeEnum.valueOf(directionTypeListJson.getString(i)); //сделать проверку
            directionTypeList.add(directionType);
        }
    }

}
