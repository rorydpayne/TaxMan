package models;

import com.taxman.calculator.NICalculator;
import com.taxman.calculator.StudentLoanCalculator;
import com.taxman.calculator.TaxCalculator;
import com.taxman.model.FiscalYear;
import com.taxman.model.Rates;
import com.taxman.model.Rounder;
import java.math.BigDecimal;

/**
 * Created by rory.payne on 31/03/14.
 */
public class ReturnData {

    public UserFormData userData;

    public ReturnData() {

    }

    public ReturnData(UserFormData userData) {
        this.userData = userData;
    }

    Rounder r = new Rounder(2);
    FiscalYear FY = new FiscalYear();
    Rates rates = FY.getFYByName(userData.getFiscalYear());
    //User user = new User(getSalary(), isStudentLoan());
    TaxCalculator tx = new TaxCalculator(userData, rates, r);
    NICalculator ni = new NICalculator(userData, rates, r);
    StudentLoanCalculator sl = new StudentLoanCalculator(userData, rates, r);

    public String getFiscalYear() {
        return userData.getFiscalYear();
    }

    public BigDecimal getSalary() {
        return userData.getSalary();
    }

    public BigDecimal getMonthlySalary() {
        return r.monthly(userData.getSalary());
    }

    public BigDecimal getWeeklySalary() {
        return r.weekly(userData.getSalary());
    }

    public boolean isStudentLoan() {
        return userData.isStudentLoan();
    }

    public BigDecimal getIncomeTax() {
        return tx.getTax();
    }

    public BigDecimal getMonthlyIncomeTax() {
        return r.monthly(tx.getTax());
    }

    public BigDecimal getWeeklyIncomeTax() {
        return r.weekly(tx.getTax());
    }

    public BigDecimal getNI() {
        return ni.getNI();
    }

    public BigDecimal getMonthlyNI() {
        return r.monthly(ni.getNI());
    }

    public BigDecimal getWeeklyNI() {
        return r.weekly(ni.getNI());
    }

    public BigDecimal getStudentLoan() {
        return sl.getStudentLoan();
    }

    public BigDecimal getMonthlyStudentLoan() {
        return r.monthly(sl.getStudentLoan());
    }

    public BigDecimal getWeeklyStudentLoan() {
        return r.weekly(sl.getStudentLoan());
    }

    public BigDecimal getTakeHomePay() {
        return getSalary().add(getIncomeTax().negate()).add(getNI().negate()).add(getStudentLoan().negate());
    }

    public BigDecimal getMonthlyTakeHomePay() {
        return r.monthly(getSalary().add(getIncomeTax().negate()).add(getNI().negate()).add(getStudentLoan().negate()));
    }

    public BigDecimal getWeeklyTakeHomePay() {
        return r.weekly(getSalary().add(getIncomeTax().negate()).add(getNI().negate()).add(getStudentLoan().negate()));
    }
}
