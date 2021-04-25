package hu.nive.ujratervezes.kepesitovizsga.trees;

public class AppleTree extends Tree {

    public AppleTree(int leaves) {
        super(leaves);
        setFruit(Fruit.APPLE);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        setLeaves(getLeaves() + numberOfSunnyDays * 10);
        return getLeaves();
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        growLeaves(numberOfSunnyDays);
        setWeightOfFruit(getLeaves() / 50);
    }

    @Override
    public int hostBirdNest() {
        return getLeaves() / 200;
    }

}
