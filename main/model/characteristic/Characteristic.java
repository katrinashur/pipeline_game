package main.model.characteristic;

import java.util.List;

public abstract class Characteristic {

    private List<CharacteristicChangerTypeEnum> characteristicChangerTypeList;

    public abstract void change(Object... o);

    public List<CharacteristicChangerTypeEnum> getCharacteristicChangerTypeList() {
        return characteristicChangerTypeList;
    }
}
