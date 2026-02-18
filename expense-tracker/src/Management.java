import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;

public class Management {
    private ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense e) {
        expenses.add(e);
    }

    public void deleteExpense(int id) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getId() == id) {
                expenses.remove(i);
            }
        }
    }

    public void listExpenses() {
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void sumExpenses() {
        double sum = 0;
        for (Expense e : expenses) {
            sum += e.getAmount();
        }
        System.out.println("Total expenses:'€" + sum + "'");
    }

    public void sumExpensesMonthly(String monthName) {
        double sum = 0;

        Month month = Month.valueOf(monthName.toUpperCase());
        int monthNumber = month.getValue();

        for (Expense e : expenses) {
            String[] parts = e.getDate().split("\\.");
            int expenseMonth = Integer.parseInt(parts[1]);

            if (expenseMonth == monthNumber) {
                sum += e.getAmount();
            }
        }
        System.out.println("For " + monthName + " you have spend totally:'€" + sum + "'");
    }

    public void exportToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {

            writer.write("id, description, amount, date\n");

            for (Expense e : expenses) {
                writer.write(e.getId() + "," + e.getDescription()+ "," + e.getAmount() + "," + e.getDate() + "\n");
            }

            System.out.println("CSV export successful!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToJson(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {

            writer.write("[\n");

            for (int i = 0; i < expenses.size(); i++) {
                writer.write(expenses.get(i).toJson());

                if (i < expenses.size() - 1) {
                    writer.write(",\n");
                }
            }

            writer.write("\n]");
            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
