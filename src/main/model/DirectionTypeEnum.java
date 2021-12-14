package main.model;

public enum DirectionTypeEnum {

    UP,
    DOWN,
    RIGHT,
    LEFT;

    DirectionTypeEnum() {

    }

    public static DirectionTypeEnum getOpposite(DirectionTypeEnum directionType) {
        switch (directionType) {
            case UP:
                return DirectionTypeEnum.DOWN;

            case DOWN:
                return DirectionTypeEnum.UP;

            case RIGHT:
                return DirectionTypeEnum.LEFT;

            case LEFT:
                return DirectionTypeEnum.RIGHT;
        }
        return null;
    }
}
