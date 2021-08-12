package edu.cuhk.csci3310.cublossom;

public class Flowers {
    public String filename;
    public  String flower_name;
    public  String genus;
    public  String richness;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFlower_name() {
        return flower_name;
    }

    public void setFlower_name(String flower_name) {
        this.flower_name = flower_name;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getRichness() {
        return richness;
    }

    public void setRichness(String richness) {
        this.richness = richness;
    }

    @Override
    public String toString() {
        return "Flowers{" +
                "filename='" + filename + '\'' +
                ", flower_name='" + flower_name + '\'' +
                ", genus='" + genus + '\'' +
                ", richness='" + richness + '\'' +
                '}';
    }
}
