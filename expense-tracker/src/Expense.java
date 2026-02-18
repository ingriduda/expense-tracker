public class Expense {
    private int id;
    private String description;
    private double amount;
    private String date;

    public Expense(int id, String description, double amount, String date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String toJson() {
        return String.format(
                "{\"id\":\"%s\",\"description\":\"%s\",\"amount\":%s,\"date\":\"%s\"}",
                id, description, amount, date
        );
    }

    @Override
    public String toString() {
        return "Expense [id='" + id + "', date='" + date + "', description='" + description + "', amount='€" + amount + "']";
    }
}

