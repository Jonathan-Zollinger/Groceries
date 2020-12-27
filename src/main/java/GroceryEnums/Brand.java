package GroceryEnums;

public enum Brand {
    //store brands
    Kroger("Kroger"),
    WesternFamily("Western Family")

    //name brands

    ;
    private final String text;

    Brand(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
