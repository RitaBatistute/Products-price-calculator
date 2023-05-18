package entities;

public class ImportedProduct extends Product{

    private Double customsFree;

    public ImportedProduct(String name, Double price, Double customsFree) {
        super(name, price);
        this.customsFree = customsFree;
    }

    public Double getCustomsFree() {
        return customsFree;
    }

    public void setCustomsFree(Double customsFree) {
        this.customsFree = customsFree;
    }

    @Override
    public String priceTag(){

        String name = getName();
        String price = " " + "$ " + totalPrice().toString();
        String customsFree = " " + "Customs fee: " + "$ " + getCustomsFree().toString() + ")";

        return name + price + customsFree;
    }

    public Double totalPrice(){
        return getPrice() + getCustomsFree();
    }
}