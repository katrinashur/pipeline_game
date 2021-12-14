package main.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sun.tools.javac.Main;
import main.model.characteristic.Characteristic;
import main.model.exception.GameCommonException;
import main.model.exception.GameNotMeetRequirementsException;
import main.model.pipeelement.Tap;
import main.model.pipeelement.TemperatureChangerSegment;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LevelConfigurator {

    private String configName;
    private JSONObject config; //todo: json ?
    private List<Characteristic> characteristicList;
    private ObjectMapper mapper;

    //фабрики?

    public LevelConfigurator(String configName) {
        this.configName = configName;
        this.mapper = new JsonMapper();
    }

    public Level createLevel() throws GameCommonException, GameNotMeetRequirementsException {
        this.readConfig();

        //todo: подумать куда вынести создание элементов труб

        //Создаем кран
        Tap tap;
        //todo: Доделать
        if (this.config.has("tap")) {
            try {
                tap = mapper.readValue(this.config.get("tap").toString(), Tap.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            tap = new Tap();
        } else {
            tap = new Tap();
        }

        //Создаем слив

        //Создаем сегменты
        TemperatureChangerSegment temperatureChangerSegment = new TemperatureChangerSegment();


        //заполним из конфига
        List<Characteristic> characteristicList = new ArrayList<>();

        //установка всех на поле
        Point pointTap = new Point(0,0);

        Level level = new Level.LevelBuilder()
                .setWaterCreatorPoint(pointTap)
                .setCharacteristicList(characteristicList)
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


    public List<Characteristic> getCharacteristicList() {
        return characteristicList;
    }
}
