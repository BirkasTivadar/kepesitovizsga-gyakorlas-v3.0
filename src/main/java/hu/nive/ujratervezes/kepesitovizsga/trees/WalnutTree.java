package hu.nive.ujratervezes.kepesitovizsga.trees;

public class WalnutTree extends Tree {

    private static final int GROW_LEAVES_BY_SUNNY_DAY = 30;

    private static final int WEIGHT_OF_FRUIT_PER_LEAVES = 10;

    public WalnutTree(int leaves) {
        super(leaves);
        setFruit(Fruit.WALNUT);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        setLeaves(getLeaves() + numberOfSunnyDays * GROW_LEAVES_BY_SUNNY_DAY);
        return getLeaves();
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        growLeaves(numberOfSunnyDays);
        setWeightOfFruit(getLeaves() / WEIGHT_OF_FRUIT_PER_LEAVES);
    }

    @Override
    public int hostBirdNest() {
        return getLeaves() / BIRD_NEST_PER_LEAVES;
    }
}
