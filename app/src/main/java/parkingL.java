public class parkingL {

    private int image;
    private String information;

    @Override
    public String toString() {
        return "parkingL{" +
                "image=" + image +
                ", information='" + information + '\'' +
                '}';
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getImage() {

        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public parkingL(int image, String information) {

        this.image = image;
        this.information = information;
    }
}
