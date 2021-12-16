package main.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sun.tools.javac.Main;
import main.model.characteristic.Characteristic;
import main.model.exception.ConfigurationNotCorrectException;
import main.model.exception.GameCommonException;
import main.model.exception.GameNotMeetRequirementsException;
import main.model.pipeelement.*;
import main.model.pipeelement.factory.SegmentFactory;
import main.model.pipeelement.factory.WaterCheckerFactory;
import main.model.pipeelement.factory.WaterCreatorFactory;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelConfigurator {

    private String configName;
    private JSONObject config;
    private ObjectMapper mapper;

    //фабрики?
    private WaterCreatorFactory waterCreatorFactory;
    private WaterCheckerFactory waterCheckerFactory;
    private SegmentFactory segmentFactory;

    public LevelConfigurator(String configName) {
        this.configName = configName;
        this.mapper = new JsonMapper();
        this.waterCreatorFactory = new WaterCreatorFactory();
        this.waterCheckerFactory = new WaterCheckerFactory();
        this.segmentFactory = new SegmentFactory();
    }

    public Level createLevel() throws GameCommonException, GameNotMeetRequirementsException, ConfigurationNotCorrectException {
        this.readConfig();
        this.checkBasicConfigNames();

        //заполним из конфига
        List<Characteristic> characteristicList = new ArrayList<>();


        Point waterCreatorPoint;
        Point waterCheckerPoint;
        Point segment;
        Map<Point, PipeElement>  elementsMap = new HashMap<>();
        for ( : jsonArrayElements) {
            if () {
                //Если кран
                WaterCreator waterCreator = this.waterCreatorFactory.createWaterCreator(this.config.getJSONObject("waterCreator"));
                waterCreatorPoint = this.parseElementPoint(this.config.getJSONObject("waterCreator"));
                elementsMap.put(waterCreatorPoint, (Tap)waterCreator); //?
            } else if () {
                //Если слив
                WaterChecker waterChecker = this.waterCheckerFactory.createWaterChecker(characteristicList, this.config.getJSONObject("waterChecker"));
                waterCheckerPoint = this.parseElementPoint(this.config.getJSONObject("waterChecker"));
                elementsMap.put(waterCheckerPoint, (Drain)waterChecker); //?
            } else if () {
                PipeElement pipeElement = this.segmentFactory.createPipeElement(this.config.getJSONObject("segment"));
                segment = this.parseElementPoint(this.config.getJSONObject("segment"));
                elementsMap.put(segment, pipeElement);
            }
            //...
        }

        //установка всех на поле
        Point pointTap = new Point(0,0);

        Level level = new Level.LevelBuilder()
                .setWaterCreatorPoint(pointTap)
                .setWaterCheckerPoint(waterCheckerPoint)
                .setElementsMap(elementsMap)
                .build();

        return level;
    }

    public void readConfig() throws GameCommonException {
        InputStream stream = Main.class.getResourceAsStream(configName);
        String configString = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                configString.concat(line);
                reader.close();
            }
        } catch (IOException e) {
            throw new GameCommonException("Ошибка при чтении конфигурации!");
        }

        this.config = new JSONObject(configString);
    }

    public void checkBasicConfigNames() throws GameNotMeetRequirementsException{

    }

    public Point parseElementPoint(JSONObject jsonObject) throws ConfigurationNotCorrectException {
        try {
            return mapper.readValue(jsonObject.getJSONObject("point").toString(), Point.class);
        } catch (JsonProcessingException e) {
            throw new ConfigurationNotCorrectException("Координаты записаны неверно");
        }
    }

}
