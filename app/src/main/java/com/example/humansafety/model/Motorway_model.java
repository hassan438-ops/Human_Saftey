package com.example.humansafety.model;

public class Motorway_model {
  String Location,Name,Number;

    public Motorway_model(String name, String location, String number) {
        Name = name;
        Location = location;
        Number = number;
    }

    public Motorway_model() {
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public String getNumber() {
        return Number;
    }
}

