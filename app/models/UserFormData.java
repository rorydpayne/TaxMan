package models;

import com.taxman.model.Rounder;
import play.data.validation.Constraints;
import java.math.BigDecimal;

/**
 * Created by rory.payne on 25/03/14.
 */
public class UserFormData {

    @Constraints.Required
    public String fiscalYear;

    @Constraints.Required
    public BigDecimal salary;

    public boolean studentLoan;

    public UserFormData() {

    }

    public UserFormData(String fiscalYear, String salary, String studentLoan) {
        Rounder r = new Rounder(2);
        this.fiscalYear = fiscalYear;
        this.salary = r.round(Double.parseDouble(salary));
        if (studentLoan == "checked") {
            this.studentLoan=true;
        } else {
            this.studentLoan=false;
        }
    }

    public void setStudentLoan(boolean studentLoan) {
        this.studentLoan = studentLoan;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean isStudentLoan() {
        return studentLoan;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}

//    FiscalYear FY = new FiscalYear();
//    Rates rates = FY.getFYByName(fiscalYear);
//    User user = new User(getSalary(), isStudentLoan());
//
//
//    public String getFiscalYear() {
//        return fiscalYear;
//    }
//
//    public BigDecimal getSalary() {
//        return salary;
//    }
//
//    public boolean isStudentLoan() {
//        return studentLoan;
//    }
//
//    public BigDecimal getIncomeTax() {
//        return tx.getTax();
//    }
//
//    public BigDecimal getMonthlyIncomeTax() {
//        return r.monthly(tx.getTax());
//    }
//
//    public BigDecimal getWeeklyIncomeTax() {
//        return r.weekly(tx.getTax());
//    }
//
//    public BigDecimal getNI() {
//        return ni.getNI();
//    }
//
//    public BigDecimal getMonthlyNI() {
//        return r.monthly(ni.getNI());
//    }
//
//    public BigDecimal getWeeklyNI() {
//        return r.weekly(ni.getNI());
//    }
//
//    public BigDecimal getStudentLoan() {
//        return sl.getStudentLoan();
//    }
//
//    public BigDecimal getMonthlyStudentLoan() {
//        return r.monthly(sl.getStudentLoan());
//    }
//
//    public BigDecimal getWeeklyStudentLoan() {
//        return r.weekly(sl.getStudentLoan());
//    }
//
//    public BigDecimal getTakeHomePay() {
//        return getSalary().add(getIncomeTax().negate()).add(getNI().negate()).add(getStudentLoan().negate());
//    }
//
//    public BigDecimal getMonthlyTakeHomePay() {
//        return r.monthly(getSalary().add(getIncomeTax().negate()).add(getNI().negate()).add(getStudentLoan().negate()));
//    }
//
//    public BigDecimal getWeeklyTakeHomePay() {
//        return r.weekly(getSalary().add(getIncomeTax().negate()).add(getNI().negate()).add(getStudentLoan().negate()));
//    }
