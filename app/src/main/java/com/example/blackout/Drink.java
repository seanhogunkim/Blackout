package com.example.blackout;

public class Drink {


    private final String _name;
    private final int _alcPercent;
    private final int _alcVolume;
    private int _imageResource;

    public Drink(String name, int alcPercent, int volume, int imageResource) {
        _name = name;
        _alcPercent = alcPercent;
        _imageResource = imageResource;
        _alcVolume = volume;

    }


    public Drink(String name, int alcPercent, int volume) {
        _name = name;
        _alcPercent = alcPercent;
        _imageResource = R.drawable.ic_baseline_local_bar_24;
        _alcVolume = volume;
    }

    public int get_alcVolume() {
        return _alcVolume;
    }

    public String get_name() {
        return _name;
    }

    public int get_alcPercent() {
        return _alcPercent;
    }

    public int get_imageResource() {
        return _imageResource;
    }
}
