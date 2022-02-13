import interfaces.CombinatoricsInterface;

import java.util.*;

public class Combinatorics<E> implements CombinatoricsInterface<E> {
    @Override
    public List<Object[]> combinationsWithoutRepetitions(Collection<E> collection, int n) {
        List<E> elements = collection.stream().toList();
        List<Object[]> result = new ArrayList<>();
        Object[] arr = new Object[n];
        combinationsWithoutRepetitions(0, 0, elements, arr, result);

        return result;
    }

    @Override
    public List<Object[]> combinationsWithRepetitions(Collection<E> collection, int n) {
        List<E> elements = collection.stream().toList();
        List<Object[]> result = new ArrayList<>();
        Object[] arr = new Object[n];
        combinationsWithRepetitions(0, 0, elements, arr, result);

        return result;
    }

    @Override
    public List<Object[]> permutationsWithoutRepetitions(Collection<E> collection) {
        List<E> elements = collection.stream().toList();
        List<Object[]> result = new ArrayList<>();
        Object[] arr = new Object[elements.size()];
        boolean[] used = new boolean[elements.size()];

        permutationsWithoutRepetitions(0, arr, used, elements, result);

        return result;
    }


    @Override
    public List<Object[]> permutationsWithRepetitions(Collection<E> collection) {
        List<E> elements = collection.stream().toList();
        List<Object[]> result = new ArrayList<>();
        Object[] arr = new Object[elements.size()];

        permutationsWithRepetitions(0, elements.size() - 1, arr, elements, result);

        return result;
    }


    @Override
    public List<Object[]> variationsWithoutRepetitions(Collection<E> collection, int n) {
        List<E> elements = collection.stream().toList();
        List<Object[]> result = new ArrayList<>();
        Object[] arr = new Object[n];
        boolean[] used = new boolean[elements.size()];
        variationsWithoutRepetitions(0, arr, used, elements, result);

        return result;
    }

    @Override
    public List<Object[]> variationsWithRepetitions(Collection<E> collection, int n) {
        List<E> elements = collection.stream().toList();
        List<Object[]> result = new ArrayList<>();
        Object[] arr = new Object[n];
        int index, lastIndex = index = n - 1;


        for (int i = 0; i < elements.size(); i++) {
            if (index > 0) {
                index--;
            }
            arr[index] = elements.get(i);
            for (E element : elements) {
                arr[lastIndex] = element;
                result.add(arr.clone());
            }
        }

        return result;
    }
    //HELPERS


    private void combinationsWithoutRepetitions(int index, int start, List<E> elements, Object[] arr, List<Object[]> result) {
        if (index >= arr.length) {
            result.add(arr.clone());
            return;
        }
        for (int i = start; i < elements.size(); i++) {
            arr[index] = elements.get(i);
            combinationsWithoutRepetitions(index + 1, i + 1, elements, arr, result);
        }
    }


    private void combinationsWithRepetitions(int index, int start, List<E> elements, Object[] arr, List<Object[]> result) {
        if (index >= arr.length) {
            result.add(arr.clone());
            return;
        }
        for (int i = start; i < elements.size(); i++) {
            arr[index] = elements.get(i);
            combinationsWithRepetitions(index + 1, i, elements, arr, result);
        }
    }

    private void permutationsWithoutRepetitions(int index, Object[] arr, boolean[] used, List<E> elements, List<Object[]> result) {
        if (index >= elements.size()) {
            result.add(arr.clone());
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                arr[index] = elements.get(i);
                permutationsWithoutRepetitions(index + 1, arr, used, elements, result);
                used[i] = false;
            }
        }
    }

    private void permutationsWithRepetitions(int startIndex, int endIndex, Object[] arr, List<E> elements, List<Object[]> result) {
        result.add(arr.clone());
        for (int left = endIndex - 1; left >= startIndex; left--) {
            for (int right = left + 1; right <= endIndex; right++) {
                if (!elements.get(left).equals(elements.get(right))) {
                    swap(left, right, elements);
                    permutationsWithRepetitions(left + 1, endIndex, arr, elements, result);
                }
            }
            E element = elements.get(left);
            for (int i = left; i <= endIndex - 1; i++) {
                elements.set(i, elements.get(i + 1));
            }
            elements.set(endIndex, element);
        }
    }

    private void swap(int left, int right, List<E> elements) {
        E tmp = elements.get(left);
        elements.set(left, elements.get(right));
        elements.set(right, tmp);
    }

    private void variationsWithoutRepetitions(int index, Object[] arr, boolean[] used, List<E> elements, List<Object[]> result) {
        if (index >= arr.length) {
            result.add(arr.clone());
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                arr[index] = elements.get(i);
                variationsWithoutRepetitions(index + 1, arr, used, elements, result);
                used[i] = false;
            }
        }
    }

}
