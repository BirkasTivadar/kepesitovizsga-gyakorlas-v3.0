package hu.nive.ujratervezes.kepesitovizsga.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreesTest {
    private Tree tree;

    @Test
    public void testAppleTree() {
        tree = new AppleTree(100);

        assertEquals(Fruit.APPLE, tree.getFruit());
        assertEquals(900, tree.growLeaves(80));

        tree.setLeaves(100);
        tree.ripenFruit(80);

        assertEquals(18, tree.getWeightOfFruit());
        assertEquals(4, tree.hostBirdNest());
    }

    @Test
    public void testCherryTree() {
        tree = new CherryTree(200);

        assertEquals(Fruit.CHERRY, tree.getFruit());
        assertEquals(1800, tree.growLeaves(80));

        tree.setLeaves(200);
        tree.ripenFruit(80);

        assertEquals(60, tree.getWeightOfFruit());
        assertEquals(9, tree.hostBirdNest());
    }

    @Test
    public void testWalnutTree() {
        tree = new WalnutTree(300);

        assertEquals(Fruit.WALNUT, tree.getFruit());
        assertEquals(2700, tree.growLeaves(80));

        tree.setLeaves(300);
        tree.ripenFruit(80);

        assertEquals(270, tree.getWeightOfFruit());
        assertEquals(13, tree.hostBirdNest());
    }

}