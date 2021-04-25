package hu.nive.ujratervezes.kepesitovizsga.ladybird;

import java.util.Objects;

public class Ladybug {

    private String hungarian_name;

    private String latin_name;

    private String genus;

    private int points;

    public Ladybug(String hungarian_name, String latin_name, String genus, int points) {
        this.hungarian_name = hungarian_name;
        this.latin_name = latin_name;
        this.genus = genus;
        this.points = points;
    }

    public String getHungarian_name() {
        return hungarian_name;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public String getGenus() {
        return genus;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladybug ladybug = (Ladybug) o;
        return points == ladybug.points && Objects.equals(hungarian_name, ladybug.hungarian_name) && Objects.equals(latin_name, ladybug.latin_name) && Objects.equals(genus, ladybug.genus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hungarian_name, latin_name, genus, points);
    }
}
