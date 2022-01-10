package main.model;

import main.model.exception.ConfigurationNotCorrectException;
import main.model.exception.GameCommonException;
import main.model.exception.GameNotMeetRequirementsException;

import java.util.ArrayList;
import java.util.List;

public class Game  {

    private Level level;
    private LevelConfigurator levelConfigurator;

    public void prepare(String configName) throws GameCommonException, GameNotMeetRequirementsException, ConfigurationNotCorrectException {
        levelConfigurator = new LevelConfigurator(configName);
        levelConfigurator.readConfig();
        level = levelConfigurator.createLevel();
    }

    public GameResult startGameProcess() {
        Boolean isOk = true;
        while (isOk) {
            isOk = level.getWaterCreator().pushWater();
        }

        //обработать конец игры
        return this.endGame();
    }

    public List<String> loadLevelList() {
        return new ArrayList<>();
    }

    private GameResult endGame() {
        if (level.getWaterChecker().checkWater()) {
            return GameResult.VICTORY;
        } else {
            return GameResult.LOSING;
        }
    }

}
