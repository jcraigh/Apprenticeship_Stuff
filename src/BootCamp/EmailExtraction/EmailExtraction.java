package BootCamp.EmailExtraction;

public class EmailExtraction {
    /**public static void main(String[] args) throws IOException {
        String sample = Files.readString(Paths.get("src/BootCamp/EmailExtraction/sample.txt"), Charset.forName("windows-1252"));

        int counter = 0;
        int length = sample.length();

        Pattern pattern = Pattern.compile("@softwire.com");
        Matcher matcher = pattern.matcher(sample);

        for (int i = 0; i < length - 13; i++)
            if (sample.substring(i, i + 13).equals("@softwire.com")) {
                counter++;
            }
        System.out.println(counter);
    }
     **/
}
