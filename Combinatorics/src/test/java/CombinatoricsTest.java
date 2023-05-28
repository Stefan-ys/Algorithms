import interfaces.CombinatoricsInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class CombinatoricsTest {
    CombinatoricsInterface<String> combinatorics = new Combinatorics<>();


    @Test
    public void combinationsWithoutRepetitions() {
        List<String> testList = Arrays.asList("A", "B", "C", "D");
        int n = 2;

        List<Object[]> expected = new ArrayList<>();
        expected.add(new Object[]{"A", "B"});
        expected.add(new Object[]{"A", "C"});
        expected.add(new Object[]{"A", "D"});
        expected.add(new Object[]{"B", "C"});
        expected.add(new Object[]{"B", "D"});
        expected.add(new Object[]{"C", "D"});

        List<Object[]> actual = combinatorics.combinationsWithoutRepetitions(testList, n);

        Assert.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), actual.get(i));
        }

    }

    @Test
    public void combinationsWithRepetitions() {
        List<String> testList = Arrays.asList("A", "B", "C");


        List<Object[]> expected = new ArrayList<>();
        expected.add(new Object[]{"A", "A"});
        expected.add(new Object[]{"A", "B"});
        expected.add(new Object[]{"A", "C"});
        expected.add(new Object[]{"B", "B"});
        expected.add(new Object[]{"B", "C"});
        expected.add(new Object[]{"C", "C"});

        List<Object[]> actual = combinatorics.combinationsWithRepetitions(testList, 2);

        Assert.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), actual.get(i));
        }

    }

    @Test
    public void testPermutationsWithoutRepetitions() {
        List<String> testList = Arrays.asList("A", "B", "C");

        List<Object[]> expected = new ArrayList<>();
        expected.add(new Object[]{"A", "B", "C"});
        expected.add(new Object[]{"A", "C", "B"});
        expected.add(new Object[]{"B", "A", "C"});
        expected.add(new Object[]{"B", "C", "A"});
        expected.add(new Object[]{"C", "A", "B"});
        expected.add(new Object[]{"C", "B", "A"});

        List<Object[]> actual = combinatorics.permutationsWithoutRepetitions(testList);

        Assert.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testPermutationsWithRepetitions() {
        List<String> testList = Arrays.asList("A", "B", "C");

        List<Object[]> expected = new ArrayList<>();
        expected.add(new Object[]{"A", "A", "A"});
        expected.add(new Object[]{"A", "A", "B"});
        expected.add(new Object[]{"A", "A", "C"});
        expected.add(new Object[]{"A", "B", "A"});
        expected.add(new Object[]{"A", "B", "B"});
        expected.add(new Object[]{"A", "B", "C"});
        expected.add(new Object[]{"A", "C", "A"});
        expected.add(new Object[]{"A", "C", "B"});
        expected.add(new Object[]{"A", "C", "C"});
        expected.add(new Object[]{"B", "A", "A"});
        expected.add(new Object[]{"B", "A", "B"});
        expected.add(new Object[]{"B", "A", "C"});
        expected.add(new Object[]{"B", "B", "A"});
        expected.add(new Object[]{"B", "B", "B"});
        expected.add(new Object[]{"B", "B", "C"});
        expected.add(new Object[]{"B", "C", "A"});
        expected.add(new Object[]{"B", "C", "B"});
        expected.add(new Object[]{"B", "C", "C"});
        expected.add(new Object[]{"C", "A", "A"});
        expected.add(new Object[]{"C", "A", "B"});
        expected.add(new Object[]{"C", "A", "C"});
        expected.add(new Object[]{"C", "B", "A"});
        expected.add(new Object[]{"C", "B", "B"});
        expected.add(new Object[]{"C", "B", "C"});
        expected.add(new Object[]{"C", "C", "A"});
        expected.add(new Object[]{"C", "C", "B"});
        expected.add(new Object[]{"C", "C", "C"});

        List<Object[]> actual = combinatorics.permutationsWithRepetitions(testList);

        Assert.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testVariationsWithoutRepetitions() {

        List<String> testList = Arrays.asList("A", "B", "C", "D");

        List<Object[]> expected = new ArrayList<>();
        expected.add(new Object[]{"A", "B"});
        expected.add(new Object[]{"A", "C"});
        expected.add(new Object[]{"A", "D"});
        expected.add(new Object[]{"B", "A"});
        expected.add(new Object[]{"B", "C"});
        expected.add(new Object[]{"B", "D"});
        expected.add(new Object[]{"C", "A"});
        expected.add(new Object[]{"C", "B"});
        expected.add(new Object[]{"C", "D"});
        expected.add(new Object[]{"D", "A"});
        expected.add(new Object[]{"D", "B"});
        expected.add(new Object[]{"D", "C"});

        List<Object[]> actual = combinatorics.variationsWithoutRepetitions(testList, 2);

        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), actual.get(i));
        }

    }

    @Test
    public void testVariationsWithRepetitions() {

        List<String> testList = Arrays.asList("A", "B", "C");

        List<Object[]> expected = new ArrayList<>();
        expected.add(new Object[]{"A", "A"});
        expected.add(new Object[]{"A", "B"});
        expected.add(new Object[]{"A", "C"});
        expected.add(new Object[]{"B", "A"});
        expected.add(new Object[]{"B", "B"});
        expected.add(new Object[]{"B", "C"});
        expected.add(new Object[]{"C", "A"});
        expected.add(new Object[]{"C", "B"});
        expected.add(new Object[]{"C", "C"});

        List<Object[]> actual = combinatorics.variationsWithRepetitions(testList, 2);

        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), actual.get(i));
        }

    }
}