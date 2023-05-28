package interfaces;

import java.util.Collection;
import java.util.List;

public interface CombinatoricsInterface<E> {

    public List<Object[]> combinationsWithoutRepetitions(List<E> collection, int n);

    public List<Object[]> combinationsWithRepetitions(Collection<E> collection, int n);

    public List<Object[]> permutationsWithoutRepetitions(Collection<E> collection);

    public List<Object[]> permutationsWithRepetitions(Collection<E> collection);

    public List<Object[]> variationsWithoutRepetitions(Collection<E> collection, int n);

    public List<Object[]> variationsWithRepetitions(Collection<E> collection, int n);
}
