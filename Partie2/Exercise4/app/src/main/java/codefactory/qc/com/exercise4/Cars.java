package codefactory.qc.com.exercise4;

public class Cars {
    private int image;
    private String model;
    private String color;
    private long price;

    public Cars(int image, String model, String color, long price) {
        this.image = image;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public long getPrice() {
        return price;
    }
}
