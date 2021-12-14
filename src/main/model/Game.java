package main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.model.exception.GameCommonException;
import main.model.exception.GameNotMeetRequirementsException;

public class Game implements Subscriber {

    private Level level;
    private LevelConfigurator levelConfigurator;

    public void prepare(String configName) throws GameCommonException, GameNotMeetRequirementsException {
        levelConfigurator = new LevelConfigurator(configName);
        levelConfigurator.readConfig();
        level = levelConfigurator.createLevel();

        /////////

        Player player = level.getWaterCreator().createWater(levelConfigurator.getCharacteristicList());
        //Буду следить за игроком
        player.subscribe(this);
    }

    public Boolean startGameProcess() {
        Boolean isOk = true;
        while (isOk) {
            isOk = level.getWaterCreator().pushWater();
        }

        //обработать конец игры
        return this.endGame();
    }

    private Boolean endGame() {
        if (level.getWaterChecker().checkWater()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void update() {
        //реакция на событие

    }
}
