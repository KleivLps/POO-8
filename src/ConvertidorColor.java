public class ConvertidorColor {
    public static Color convertitHexadecimal(String valorHexadecimal) {
        for (Color color: Color.values()) {
            if (color.getValorHexadecimal().equalsIgnoreCase(valorHexadecimal)) {
                return color;
            }
        }
        return null;
    }
}
