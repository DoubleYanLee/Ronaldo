package client;

/**
 * define the operation of stream
 * the three basis operators:  Map, KeyBy, Reduce
 */

public enum Op
{
    NONE("NONE"),
    Map("Map"),
    KeyBy("KeyBy"),
    Reduce("Reduce");

    private String name;

    private Op(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
