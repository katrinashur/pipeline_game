package main.model.pipeelement.factory;

import main.model.DirectionTypeEnum;
import main.model.exception.ConfigurationNotCorrectException;
import main.model.pipeelement.PipeElement;
import main.model.pipeelement.Tap;
import org.json.JSONObject;

import java.util.List;

public class TapFactory extends AbstractPipeElementFactory {

    @Override
    protected PipeElement createWithDirections(List<DirectionTypeEnum> directionTypeList) throws ConfigurationNotCorrectException {
        if (directionTypeList == null || directionTypeList.size() != 1) {
            throw new ConfigurationNotCorrectException("Неправильная инициализация крана");
        }
        return new Tap(directionTypeList.get(0));
    }
}
