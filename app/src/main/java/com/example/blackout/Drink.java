package com.example.blackout;

public class Drink {


    private String _name;
    private String _alcPercent;
    private String _alcVolume;
    private int _imageResource;

    public Drink(String name, String alcPercent, String volume, int imageResource) {
        _name = name;
        _alcPercent = alcPercent;
        _imageResource = imageResource;
        _alcVolume = volume;

    }


    public Drink(String name, String alcPercent, String volume) {
        _name = name;
        _alcPercent = alcPercent;
        _imageResource = R.drawable.ic_baseline_local_bar_24;
        _alcVolume = volume;
    }

    public String get_alcVolume() {
        return _alcVolume;
    }

    public String get_name() {
        return _name;
    }

    public String get_alcPercent() {
        return _alcPercent;
    }

    public int get_imageResource() {
        return _imageResource;
    }
}
