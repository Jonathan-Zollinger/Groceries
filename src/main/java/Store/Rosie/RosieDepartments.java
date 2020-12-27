package Store.Rosie;

public enum RosieDepartments {
        Alcohol("Alcohol"), Bakery("Bakery"), Beverage("Beverage"), Bulk("Bulk"),
        CaseLotSales("Case Lot Sales"), Cater("Cater"), Dairy("Dairy"), Deli("Deli"),
        EmergencyPreparedness("Emergency Preparedness"),Exclusives("Exclusives"), Frozen("Frozen"),
        Fruit("Fruit"), GlutenFree("Gluten Free"), GourmetFoods("Gourmet Foods"), Grocery("Grocery"),
        HealthBeauty("Health & Beauty"), HomeGoods("Home Goods"), Meat("Meat"), Organic("Organic"),
        Pasta("Pasta"), Pets("Pets"), Seafood("Seafood"), Seasonal("Seasonal"), Vegan("Vegan"),
        Vegetables("Vegetables") ;
    private final String text;

        RosieDepartments (final String text){
            this.text = text;
        }

    @Override
    public String toString() {
        return text;
    }
}

