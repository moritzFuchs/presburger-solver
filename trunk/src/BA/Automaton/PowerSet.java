/**
 * 
 */
package BA.Automaton;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Gets the items of a powerset in descending order of size.
 * 
 * @author moritzfuchs, idea by st0le (see http://stackoverflow.com/questions/1670862/obtaining-powerset-of-a-set-in-java)
 *
 */
public class PowerSet<E> implements Iterator<Set<E>>,Iterable<Set<E>>{
    private E[] arr = null;
    private BitSet bset = null;

    @SuppressWarnings("unchecked")
    public PowerSet(Set<E> set)
    {
        arr = (E[])set.toArray();
        bset = new BitSet(arr.length + 1);
        for(int i = 0; i < bset.size(); i++)  {
            bset.set(i);
        }
    }

    @Override
    public boolean hasNext() {
        return bset.get(arr.length);
    }

    @Override
    public Set<E> next() {
        Set<E> returnSet = new TreeSet<E>();
        for(int i = 0; i < arr.length; i++)
        {
            if(bset.get(i))
                returnSet.add(arr[i]);
        }
        //decrement bset
        for(int i = 0; i < bset.size(); i++) 
        {
            if(bset.get(i))
            {
                bset.clear(i);
                break;
            }else
                bset.set(i);
        }

        return returnSet;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not Supported!");
    }

    @Override
    public Iterator<Set<E>> iterator() {
        return this;
    }

}