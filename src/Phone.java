package src;

import java.util.Random;

public class Phone
{
    String CountryCode;
    int PhoneNumber;

    public Phone(String countryCode,int phoneNumber)
    {
        CountryCode = countryCode;
        PhoneNumber = phoneNumber;
    }
    public int CreateNewPhoneNumber()
    {
        Random r = new Random();
        int phoneNum = r.nextInt(1000000,10000000);
        return  phoneNum;
    }
}
