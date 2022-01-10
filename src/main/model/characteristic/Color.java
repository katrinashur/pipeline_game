package main.model.characteristic;

import java.util.List;

public class Color extends Characteristic{

    public ColorType colorType;

    @Override
    public void change(List<Characteristic> initialState, List<CharacteristicChanger> characteristicChangerList) {
        if (initialState)
    }

    public enum ColorType {
        BLUE,
        RED,
        GREEN;
    }
}


