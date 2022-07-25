package LikeDataStream;

/**
 * define the operation of stream
 * the five basis operators: Source, Sink, Map, KeyBy, Reduce
 */

public enum Op
{
    NONE("NONE"),
    Source("Source"),
    Sink("Sink"),
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
