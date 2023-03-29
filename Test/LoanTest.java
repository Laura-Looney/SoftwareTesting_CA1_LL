import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest
{
    @Test
    public void TestSetRate() throws
            NoSuchMethodException, InvocationTargetException, IllegalAccessException
                {
                    Loan loan = new Loan(500, 2);

                    Class[] arg = new Class[1];
                    arg[0] = Integer.class;
                    Method methodCall = loan.getClass().getDeclaredMethod("setRate", arg);

                    methodCall.setAccessible(true);

                    Object[] methodArgument = new Object[1];
                    methodArgument[0] = 2;

                    double actualRate = (double)
                    methodCall.invoke(loan, methodArgument);
                    double expectedRate = 10/100.0/12;

                    assertEquals(expectedRate, actualRate);
                }
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

