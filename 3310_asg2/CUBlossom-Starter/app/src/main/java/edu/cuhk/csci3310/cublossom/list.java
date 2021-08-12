package edu.cuhk.csci3310.cublossom;

import java.util.ArrayList;
import java.util.List;

public class list {
    private List<Flowers> flowers=new ArrayList<>();
    public void genlist(List<Flowers> flr){
        flowers = flr;
    }

    public void renewlist(int pos, String filename, String Fname, String genus, String richness){
        Flowers flower = new Flowers();
        flower.setFilename(filename);
        flower.setFlower_name(Fname);
        flower.setGenus(genus);
        flower.setRichness(richness);
        flowers.set(pos,flower);
    }

    public List<Flowers> newlist(){
        return flowers;
    }
}
