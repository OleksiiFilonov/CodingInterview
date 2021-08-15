package oleksii.filonov.interview.systemdesign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

interface ServerNode {
    String getNodeIdentity();
}
/**
 * Consistent Hashing Ring make use of a TreeMap (ability to get a tale Map, after certain key)
 * @param <T> - Server Node Type
 */
public class Ring<T extends ServerNode> {
    private SortedMap<Long, T> ring = new TreeMap<>();
    private MD5Hash hash = new MD5Hash();
    private int virtualNodeCount;

    /**
     * Create Consistent hashing ring
     * @param virtualNodeCount - number of times every real server (machine) will be present on the consistent hashing ring
     * @param nodes - {@link Collection<T> collection} of servers (machines)
     */
    public Ring(int virtualNodeCount, Collection<T> nodes) {
        this.virtualNodeCount = virtualNodeCount;
        for (T node : nodes) {
            addNode(node);
        }
    }

    private void addNode(T node) {
        for (int i = 0; i < this.virtualNodeCount; i++) {
            ring.put(hash.hash(node.getNodeIdentity() + i), node);
        }
    }

    public void removeNode(T node) {
        for (int i = 0; i < this.virtualNodeCount; i++) {
            ring.remove(hash.hash(node.getNodeIdentity() + i));
        }
    }

    private T getNodeByObjectId(String objectId) {

        long hashValue = hash.hash(objectId);

        if (!ring.containsKey(hashValue)) {
            SortedMap<Long, T> tailMap = ring.tailMap(hashValue);
            hashValue = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
        }

        return ring.get(hashValue);
    }

    private static class MD5Hash {
        MessageDigest instance;

        public MD5Hash() {
            try {
                instance = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("MD5 hash algorithm is not supported by the platform");
            }
        }

        long hash(String key) {
            instance.reset();
            instance.update(key.getBytes());
            byte[] digest = instance.digest();

            long h = 0;
            for (int i = 0; i < 4; i++) {
                h <<= 8;
                h |= ((int) digest[i]) & 0xFF;
            }
            return h;
        }
    }

}
