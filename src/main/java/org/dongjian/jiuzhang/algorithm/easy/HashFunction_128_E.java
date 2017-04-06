package org.dongjian.jiuzhang.algorithm.easy;

/**
 * In data structure Hash, hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero. The objective of designing a hash function is to "hash" the key as unreasonable as possible. A good hash function can avoid collision as less as possible. A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:
 * <p>
 * hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE
 * <p>
 * = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE
 * <p>
 * = 3595978 % HASH_SIZE
 * <p>
 * here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).
 * <p>
 * Given a string as a key and the size of hash table, return the hash value of this key.f
 */
public class HashFunction_128_E {
    public int hashCode(char[] key, int HASH_SIZE) {
        long res = 0;

        for (int i = 0; i < key.length; i++) {
            res = (res * 33 + (int) key[i]) % HASH_SIZE;
        }

        return (int) res;
    }
}
