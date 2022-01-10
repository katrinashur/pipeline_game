package main.model.pipeelement.factory;

import main.model.exception.ConfigurationNotCorrectException;
import main.model.pipeelement.Tap;
import main.model.pipeelement.WaterCreator;
import org.json.JSONObject;

public class WaterCreatorFactory {

    private TapFactory tapFactory;



    public WaterCreator createWaterCreator(JSONObject jsonWaterCreator) throws ConfigurationNotCorrectException {
        return (Tap)tapFactory.createPipeElement(jsonWaterCreator);
    }

}
