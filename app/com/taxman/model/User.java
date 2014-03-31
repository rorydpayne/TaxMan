package com.taxman.model;

import play.db.ebean.Model;
import models.UserFormData;
import java.math.BigDecimal;

public class User extends Model {

    private BigDecimal annualSalary;
    private boolean studentLoan;

    Rounder r = new Rounder(2);
    public User() {
        annualSalary = r.round(0);
        studentLoan = false;
    }

    public User(BigDecimal annualSalary, boolean studentLoan) {
        this.annualSalary = annualSalary;
        this.studentLoan = studentLoan;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(BigDecimal annualSalary) {

        this.annualSalary = annualSalary;
    }

    public boolean isStudentLoan() {
        return studentLoan;
    }

    public void setStudentLoan(boolean studentLoan) {
        this.studentLoan = studentLoan;
    }

    public static User makeInstance(UserFormData userForm) {
        User user = new User();
        user.annualSalary = userForm.salary;
        user.studentLoan = userForm.studentLoan;
        return user;
    }
}
