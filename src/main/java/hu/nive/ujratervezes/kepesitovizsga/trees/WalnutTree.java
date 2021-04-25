package hu.nive.ujratervezes.kepesitovizsga.trees;

public class WalnutTree extends Tree {
    public WalnutTree(int leaves) {
        super(leaves);
        setFruit(Fruit.WALNUT);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        setLeaves(getLeaves() + numberOfSunnyDays * 30);
        return getLeaves();
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        growLeaves(numberOfSunnyDays);
        setWeightOfFruit(getLeaves() / 10);
    }

    @Override
    public int hostBirdNest() {
        return getLeaves() / 200;
    }
}
