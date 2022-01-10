package main.model.characteristic;

import java.util.List;
import java.util.Objects;

public abstract class Characteristic {

    public abstract void change(List<Characteristic> initialState, List<CharacteristicChanger> characteristicChangerList);

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Characteristic that = (Characteristic) o;
//        return Objects.equals(changer, that.changer);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(changer);
//    }
}
