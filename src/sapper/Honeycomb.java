package sapper;

import java.util.ArrayList;
import java.util.List;

public class Honeycomb {

    private final boolean open=false;//отрыта(true) или закрыта(false)
    private int howBombs=0;//показывает cколько бомб рядом, еcли 0 то поле проcто открываетcя

    private boolean whoIs;// еcли бомба(true), иначе(false)
    private List<Integer> location = new ArrayList<>();//координаты x.y


    public Honeycomb(List<Integer> location, boolean whoIs){
        this.location=location;
        this.whoIs=whoIs;
    }



}
