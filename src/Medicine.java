package src;

public class Medicine
{
    String name;
    int amount;
    int dailyUsageRate;
    int dosage;

    public Medicine(String name,int amount,int dailyUsageRate,int dosage)
    {
        this.name = name;
        this.amount = amount;
        this.dailyUsageRate = dailyUsageRate;
        this.dosage = dosage;
    }
}
