package GroceryEnums;

public enum Measure {
    //TODO IF CHANGED: update switch statement in calculatePricePerMeasure()
    OZ("ounce"),
    FLOZ("fluid ounce"),
    LBS("pound"),
    MILLILITER("milliliter"),
    LITER("liter"),
    GRAM("gram"),
    KILOGRAM("kilogram");

    private final String text;

    Measure(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
