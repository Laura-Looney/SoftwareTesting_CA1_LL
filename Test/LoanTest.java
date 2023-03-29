import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest
{
    @ParameterizedTest
    @CsvFileSource(resources = "MonthlyPayments.csv",numLinesToSkip = 1)
    void TestAllMonthly(double Amount, int Period, double Answer)
        {
            Loan loan = new Loan(Amount, Period);
            assertEquals(Answer, loan.getMonthlyPayment());
        }

    @ParameterizedTest
    @CsvFileSource(resources = "NegativeTests.csv",numLinesToSkip = 1)
    void TestAllMonthlyNegative(String Amount, String Period)
    {
        assertThrows(IllegalArgumentException.class, () -> {
            Loan loan = new Loan(Double.parseDouble(Amount), Integer.parseInt(Period));
        });

    }

    @ParameterizedTest
    @CsvFileSource(resources = "TotalPayments.csv",numLinesToSkip = 1)
    void TestAll(double Amount, int Period, double Answer)
    {
        Loan loan = new Loan(Amount, Period);
        assertEquals(Answer, loan.getTotalPayment());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "GetAmount.csv",numLinesToSkip = 1)
    void TestGetAmount(double Amount, int Period, double Answer)
    {
        Loan loan = new Loan(Amount, Period);
        assertEquals(Answer, loan.getAmount());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "GetRate.csv",numLinesToSkip = 1)
    void TestGetRate(double Amount, int Period, double Answer)
    {
        Loan loan = new Loan(Amount, Period);
        assertEquals(Answer, loan.getRate());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "GetPeriod.csv",numLinesToSkip = 1)
    void TestGetPeriod(double Amount, int Period, double Answer)
    {
        Loan loan = new Loan(Amount, Period);
        assertEquals(Answer, loan.getPeriod());
    }
}

