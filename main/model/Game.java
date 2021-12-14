package main.model;

import main.model.exception.GameCommonException;
import main.model.exception.GameNotMeetRequirementsException;

public class Game implements Subscriber {

    private Level level;
    private LevelConfigurator levelConfigurator;

    public void prepare(String configName) throws GameCommonException, GameNotMeetRequirementsException {
        levelConfigurator = new LevelConfigurator(configName);
        level = levelConfigurator.createLevel();

        /////////

        Player player = level.getWaterCreator().createWater(levelConfigurator.getCharacteristicList());
        //Буду следить за игроком
        player.subscribe(this);
    }

    public void start() {

        level.getWaterCreator().pushWater();
    }

    @Override
    public void update() {
        //реакция на событие

    }
}
