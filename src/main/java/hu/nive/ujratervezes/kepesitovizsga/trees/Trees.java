package hu.nive.ujratervezes.kepesitovizsga.trees;

public abstract class Trees {

    private int leaves;

    public abstract int growLeaves(int numberOfSunnyDays);

    public abstract void ripenFruit(int numberOfSunnyDays);

    public abstract int hostBirdNest();

}
