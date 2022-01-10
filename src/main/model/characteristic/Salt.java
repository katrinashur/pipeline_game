package main.model.characteristic;


import java.util.List;

public class Salt extends Characteristic {

    protected Integer saltQuantity;

    public Integer getSaltQuantity() {
        return saltQuantity;
    }

    @Override
    public void change(List<Characteristic> initialState, List<CharacteristicChanger> characteristicChangerList) {

    }
}
