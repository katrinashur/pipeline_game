package main.model;

import com.sun.tools.javac.Main;
import main.model.characteristic.Characteristic;
import main.model.exception.GameCommonException;
import main.model.exception.GameNotMeetRequirementsException;
import main.model.pipeelement.Tap;
import main.model.pipeelement.TemperatureChangerSegment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LevelConfigurator {

    private String configName;
    private String config; //todo: json ?
    private List<Characteristic> characteristicList;

    //фабрики?

    public LevelConfigurator(String configName) {
        this.configName = configName;
        config = "";
    }

    public Level createLevel() throws GameCommonException, GameNotMeetRequirementsException {
        this.readConfig();

        //Создаем кран
        Tap tap;
        //todo: Доделать
        if (this.config.contains("...")) {
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

    private void readConfig() throws GameCommonException {
        InputStream stream = Main.class.getResourceAsStream(configName);

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                config.concat(line);
                reader.close();
            }
        } catch (IOException e) {
            throw new GameCommonException("Ошибка при чтении конфигурации!");
        }
    }


    public List<Characteristic> getCharacteristicList() {
        return characteristicList;
    }
}
