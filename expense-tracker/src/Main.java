
public class Main {
    public static void main(String[] args) {
        Management m = new Management();
        m.addExpense(new Expense(1, "gym", 20, "12.12.2025"));
        m.addExpense(new Expense(2, "groceries", 50, "15.12.2025"));
        m.addExpense(new Expense(3, "birthday gift", 100, "1.1.2026"));
        m.listExpenses();
        m.sumExpenses();
        m.sumExpensesMonthly("December");
        m.sumExpensesMonthly("January");
        m.deleteExpense(2);
        m.listExpenses();
        m.exportToCSV("expenses.csv");
        m.saveToJson("expenses.json");

    }
}