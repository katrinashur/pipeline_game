package main.model.characteristic;

import java.util.List;

public abstract class Characteristic {

    CharacteristicChanger changer;

    private List<CharacteristicChangerTypeEnum> characteristicChangerTypeList;

    public abstract void change(CharacteristicChanger... changers);

    public List<CharacteristicChangerTypeEnum> getCharacteristicChangerTypeList() {
        return characteristicChangerTypeList;
    }
}
