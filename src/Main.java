import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        // 1- Formatting value
        // Create a currency instance
        Currency euro = Currency.getInstance("EUR");

        // Location information
        Locale eurLocale = new Locale("fr", "FR");

        // Create number format
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(eurLocale);

        // Examples
        double amount = 1_234.564;
        double amount1 = 1_234.565;
        double amount2 = 1_234.566;

        System.out.println("formatttedCurrency of 1_234.564= "+ numberFormat.format(amount));
        System.out.println("formatttedCurrency of 1_234.565= "+numberFormat.format(amount1));
        System.out.println("formatttedCurrency of 1_234.566= "+numberFormat.format(amount2));

        // 2- Parsing Currency

        String currencyString = "$1,234.57";

        try {
            NumberFormat localizedCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
            Number parsedNumber = localizedCurrencyFormat.parse(currencyString);
            double parsedAmount = parsedNumber.doubleValue();
            System.out.println("parsedAmount= "+parsedAmount);  // Output: 1234.57
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 3- handling currency round off
        NumberFormat roundedCurrencyFormat = NumberFormat.getCurrencyInstance();
        roundedCurrencyFormat.setRoundingMode(RoundingMode.UP);
        String formattedValue = roundedCurrencyFormat.format(123456.784d);
        String formattedValue1 = roundedCurrencyFormat.format(123456.785d);
        String formattedValue2 = roundedCurrencyFormat.format(123456.786d);
        System.out.println("formattedValue rounded.UP of 123456.784d = " + formattedValue);  // Output: $123456.79
        System.out.println("formattedValue rounded.UP of 123456.785d = " + formattedValue1);  // Output: $123456.79
        System.out.println("formattedValue rounded.UP of 123456.786d = " + formattedValue2);  // Output: $123456.79

    }
}