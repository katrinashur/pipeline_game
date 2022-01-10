package main.model.pipeelement.factory;

import main.model.characteristic.Characteristic;
import main.model.exception.ConfigurationNotCorrectException;
import main.model.pipeelement.WaterChecker;
import org.json.JSONObject;

import java.util.List;

public class WaterCheckerFactory {

    private DrainFactory drainFactory;

    public WaterCheckerFactory() {
        this.drainFactory = new DrainFactory();
    }

    public WaterChecker createWaterChecker(List<Characteristic> expectedCharacteristicList, JSONObject jsonWaterChecker) throws ConfigurationNotCorrectException {
        WaterChecker checker = (WaterChecker)drainFactory.createPipeElement(jsonWaterChecker);
        checker.setExpectedCharacteristic(expectedCharacteristicList);
        return checker;
    }
}
