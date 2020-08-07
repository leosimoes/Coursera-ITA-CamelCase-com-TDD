package programa;

//@author Leonardo Simões
import java.util.ArrayList;
import java.util.List;

public class CamelCase {

    public static List<String> converterCamelCase(String original) {
        List<String> p = new ArrayList<>();
        if (original != null && !original.isEmpty()) {
            List<Integer> indices = localizarPalavras(original);
            for (int i = 0; i < indices.size() - 1; ++i) {
                p.add(formatarPalavra(original.substring(indices.get(i), indices.get(i + 1))));
            }
        }
        return p;
    }

    public static List<Integer> localizarPalavras(String original) {
        List<Integer> indices = new ArrayList<>();
        indices.add(0);
        for (int i = 1; i < original.length() - 1; ++i) {
            if (incluirIndice(original, i))
                indices.add(i);
        }
        indices.add(original.length());
        return indices;
    }

    public static String formatarPalavra(String palavra) {
        if (palavra.equals(palavra.toUpperCase())) {
            return palavra;
        }
        return palavra.toLowerCase();
    }

    public static boolean incluirIndice(String original, int i) {
        return (!Character.isDigit(original.charAt(i)) && (original.charAt(i) == Character.toUpperCase(original.charAt(i))
                && (original.charAt(i + 1) == Character.toLowerCase(original.charAt(i + 1))
                || original.charAt(i - 1) == Character.toLowerCase(original.charAt(i - 1)))))
                || (Character.isDigit(original.charAt(i)) && !Character.isDigit(original.charAt(i - 1)));
    }
}
