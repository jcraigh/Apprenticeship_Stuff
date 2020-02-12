package training.BloomFilter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class BloomFilter {

    List<String> contents;
    private MyBloomFilter bloomFilter = new MyBloomFilter();

    private static final String PATH = "src/training/BloomFiller";
    private static final String FILE = "wordList.txt";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Path file = Paths.get(PATH+FILE);

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashResult = md.digest("Hello".getBytes());

        boolean[] bitmap = new boolean[256];

        bitmap[hashResult[0] + 128] = true;

       System.out.println(hashResult[0]);
        for (boolean b: bitmap){
            System.out.print(b ? 1 : 0);
        }
    }

    public boolean add(String value){
        contents.add(value);
        bloomFilter.add(value);
        return true;
    }

    public boolean contains(String value){
        return bloomFilter.contains(value);

    }
}
