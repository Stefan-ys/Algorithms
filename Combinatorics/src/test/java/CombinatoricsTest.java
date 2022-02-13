import interfaces.CombinatoricsInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class CombinatoricsTest {
    CombinatoricsInterface<Character> combinatorics = new Combinatorics<>();


    private List<Character> createTestCharList() {
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            characterList.add((char) ('A' + i));
        }
        return characterList;

    }


    @Test
    public void combinationsWithoutRepetitions() {
        List<Character> testList = createTestCharList();

        List<Object[]> result = combinatorics.combinationsWithoutRepetitions(testList, 2);

        HashSet<String> testSet = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            char a = (char) ('A' + i);
            for (int j = i + 1; j < 4; j++) {
                char b = (char) ('A' + j);
                testSet.add(a + "" + b);
            }
        }

        Assert.assertEquals(testSet.size(), result.size());
        for (Object[] arr : result) {
            StringBuilder str = new StringBuilder();
            for (Object c : arr) {
                str.append(c);
                ;
            }
            Assert.assertTrue(testSet.contains(str.toString()));
        }

    }

    @Test
    public void combinationsWithRepetitions() {
        List<Character> testList = createTestCharList();

        List<Object[]> result = combinatorics.combinationsWithRepetitions(testList, 2);

        HashSet<String> testSet = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            char a = (char) ('A' + i);
            for (int j = i; j < 4; j++) {
                char b = (char) ('A' + j);
                testSet.add(a + "" + b);

            }
        }

        Assert.assertEquals(testSet.size(), result.size());
        for (Object[] arr : result) {
            StringBuilder str = new StringBuilder();
            for (Object c : arr) {
                str.append(c);
                ;
            }
            Assert.assertTrue(testSet.contains(str.toString()));
        }
    }

    @Test
    public void testPermutationsWithoutRepetitions() {
        List<Character> testList = createTestCharList();

        List<Object[]> result = combinatorics.permutationsWithoutRepetitions(testList);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).length; j++) {
                System.out.print(result.get(i)[j] + "");
            }
            System.out.println();
        }
    }

    @Test
    public void testPermutationsWithRepetitions() {
        List<Character> testList = createTestCharList();

        List<Object[]> result = combinatorics.permutationsWithoutRepetitions(testList);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).length; j++) {
                System.out.print(result.get(i)[j] + "");
            }
            System.out.print(" - ");
        }
    }

    @Test
    public void testVariationsWithoutRepetitions() {
        List<Character> testList = createTestCharList();

        List<Object[]> result = combinatorics.variationsWithoutRepetitions(testList, 2);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).length; j++) {
                System.out.print(result.get(i)[j] + "");
            }
            System.out.print(" - ");
        }
    }

    @Test
    public void testVariationsWithRepetitions() {
        List<Character> testList = createTestCharList();

        List<Object[]> result = combinatorics.variationsWithRepetitions(testList, 2);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).length; j++) {
                System.out.print(result.get(i)[j] + "");
            }
            System.out.print(" - ");
        }
    }
}