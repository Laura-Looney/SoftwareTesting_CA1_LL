import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest
    {
        @Test
        public void test1(){
            Loan loan =  new Loan(500,1);
        assertEquals(43.96,loan.getMonthlyPayment());
        }
        //test

    }