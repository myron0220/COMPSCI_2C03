public class LinearProbingHashST<Key, Value> 
{
    private int N;           // number of key-value pairs in the symbol table
    private int M = 11;      // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values

    public LinearProbingHashST() 
    {
        keys = (Key[])   new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int mapAlphabet(String letter) 
    {
        return (letter.charAt(0) - 'A' + 1);
    }

    private int hash1(Key key) 
    {
        return mapAlphabet((String) key) % M;
    }

    private int hash2(Key key) 
    {
        double A = 0.6180339887;
        return (int) Math.floor(M * ((mapAlphabet((String) key) * A) % 1));
    }

    private int hash(Key key, int i) {
        return (hash1(key) + i * hash2(key)) % m;
    }

    public void put(Key key, Value val) {
        int i;
        for (i = 0; keys[hash(key, i)] != null; i++) {
            if (keys[hash(key, i)].equals(key)) {
                vals[hash(key, i)] = val;
                return;
            }
        }
        keys[hash(key, i)] = key;
        vals[hash(key, i)] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = 0; keys[hash(key, i)] != null; i++) {
            if (keys[hash(key, i)].equals(key))
                return vals[hash(key, i)];
        }
        return null;
    }
}
