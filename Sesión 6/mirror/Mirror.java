package tudelft.mirror;

public class Mirror {

    public String mirrorEnds(String string) {
        StringBuilder mirror = new StringBuilder();

        int len = string.length();
        for (int i = 0; i < len; i++) {
            if (string.charAt(i) == string.charAt(len - 1 - i)) {
                mirror.append(string.charAt(i));
            } else {
                break;
            }
        }

        return mirror.toString();
    }
}
