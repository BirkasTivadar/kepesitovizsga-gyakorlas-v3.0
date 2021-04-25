package hu.nive.ujratervezes.kepesitovizsga.trees;

public abstract class Tree {

    public static final int BIRD_NEST_PER_LEAVES = 200;

    private int leaves;

    private int weightOfFruit;

    private Fruit fruit;

    public Tree(int leaves) {
        this.leaves = leaves;
    }

    public abstract int growLeaves(int numberOfSunnyDays);

    public abstract void ripenFruit(int numberOfSunnyDays);

    public abstract int hostBirdNest();

    public int getLeaves() {
        return leaves;
    }

    public void setLeaves(int leaves) {
        this.leaves = leaves;
    }

    public int getWeightOfFruit() {
        return weightOfFruit;
    }

    public void setWeightOfFruit(int weightOfFruit) {
        this.weightOfFruit = weightOfFruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
}
