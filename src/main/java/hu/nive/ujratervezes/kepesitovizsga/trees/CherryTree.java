package hu.nive.ujratervezes.kepesitovizsga.trees;

public class CherryTree extends Tree {

    public CherryTree(int leaves) {
        super(leaves);
        setFruit(Fruit.CHERRY);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        setLeaves(getLeaves() + numberOfSunnyDays * 20);
        return getLeaves();
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        growLeaves(numberOfSunnyDays);
        setWeightOfFruit(getLeaves() / 30);
    }

    @Override
    public int hostBirdNest() {
        return getLeaves() / 200;
    }
}
