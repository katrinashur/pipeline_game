package main.model.pipeelement.factory;

import main.model.DirectionTypeEnum;
import main.model.exception.ConfigurationNotCorrectException;
import main.model.pipeelement.PipeElement;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPipeElementFactory {

    protected abstract PipeElement createWithDirections(List<DirectionTypeEnum> directionTypeList) throws ConfigurationNotCorrectException;

    public PipeElement createPipeElement(JSONObject jsonPipeElement) throws ConfigurationNotCorrectException {
        if (!jsonPipeElement.has("directionTypeList") || !(jsonPipeElement.get("directionTypeList") instanceof JSONArray)) {
            throw new ConfigurationNotCorrectException("У элемента трубопровода должно быть хотя бы 1 отверстие");
        }

        List<DirectionTypeEnum> directionTypeList = new ArrayList<>();
        JSONArray directionTypeListJson = (JSONArray)jsonPipeElement.get("directionTypeList");
        for (int i = 0; i < directionTypeListJson.length(); i++) {
            DirectionTypeEnum directionType = DirectionTypeEnum.valueOf(directionTypeListJson.getString(i)); //сделать проверку
            directionTypeList.add(directionType);
        }
        return createWithDirections(directionTypeList);
    }
}
