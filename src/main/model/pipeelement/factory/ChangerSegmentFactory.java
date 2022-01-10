package main.model.pipeelement.factory;

import main.model.DirectionTypeEnum;
import main.model.exception.ConfigurationNotCorrectException;
import main.model.pipeelement.ChangerSegment;
import main.model.pipeelement.PipeElement;
import main.model.pipeelement.Segment;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChangerSegmentFactory {

    public TemperatureChangerSegmentFactory temperatureChangerSegmentFactory;

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

        if (jsonPipeElement.has("characteristic") && !jsonPipeElement.getString("characteristic").isEmpty()) {
            //Если есть уточнение насчет изменяемой характеристики
            if (jsonPipeElement.getString("characteristic").equals("temperature")) {
                Segment segment = temperatureChangerSegmentFactory.createChangerSegment();
                segment.setDirectionList(directionTypeList);    //set или в конструкторе ?
            }
        }

        //Сегмент не умеет изменять характеристики
        return createWithDirections(directionTypeList);
    }
}
