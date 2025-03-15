import java.util.Scanner;
public class Currency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exchange rates
        double usdToEur = 0.92;
        double usdToInr = 82.75;
        double usdToGbp = 0.78;

        System.out.println("========= Currency Converter =========");
        System.out.println("Available currencies: USD, EUR, INR, GBP");
        
        System.out.print("Enter source currency (USD/EUR/INR/GBP): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (USD/EUR/INR/GBP): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount, usdToEur, usdToInr, usdToGbp);

        if (convertedAmount != -1) {
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
        } else {
            System.out.println("Invalid currency entered.");
        }

        System.out.println("Thank you for using Currency Converter!");
        scanner.close();
    }

    public static double convertCurrency(String from, String to, double amount, double usdToEur, double usdToInr, double usdToGbp) {
        // First, convert any currency to USD
        double amountInUsd;

        switch (from) {
            case "USD":
                amountInUsd = amount;
                break;
            case "EUR":
                amountInUsd = amount / usdToEur;
                break;
            case "INR":
                amountInUsd = amount / usdToInr;
                break;
            case "GBP":
                amountInUsd = amount / usdToGbp;
                break;
            default:
                return -1; // Invalid currency
        }

        // Convert USD to target currency
        switch (to) {
            case "USD":
                return amountInUsd;
            case "EUR":
                return amountInUsd * usdToEur;
            case "INR":
                return amountInUsd * usdToInr;
            case "GBP":
                return amountInUsd * usdToGbp;
            default:
                return -1; // Invalid currency
        }
    }
}
