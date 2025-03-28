package tudelft.caesarshift;

public class CaesarShiftCipher {

    public String caesarShiftCipher(String message, int shift) {
        if (message == null) return "invalid";

        StringBuilder sb = new StringBuilder();
        shift = shift % 26; // Normaliza el desplazamiento

        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(c); // Espacios no se cifran
                continue;
            }

            if (c < 'a' || c > 'z') {
                return "invalid"; // Solo letras minúsculas y espacios
            }

            // Cálculo del nuevo carácter con desplazamiento circular
            char newChar = (char) ('a' + (c - 'a' + shift + 26) % 26);
            sb.append(newChar);
        }
        return sb.toString();
    }
}
