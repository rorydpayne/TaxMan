package controllers;



import com.taxman.model.Rates;

import models.FiscalYear_;
import models.ReturnData;
import models.UserFormData;
import views.html.index;
import java.lang.*;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

/**
 * Created by rory.payne on 27/03/14.
 */
public class Taxes extends Controller {
    /**
     * Defines a form wrapping the User class.
     */
    final static Form<UserFormData> userForm = form(UserFormData.class);

    final static FiscalYear_ FY = new FiscalYear_();

    // add some rates
    final static Rates r1 = new Rates("13/14", 9440, 100000, 32011, 150000, 0.2, 0.4, 0.45, 149, 797, 0.12, 0.02, 0.09, 21000);
    final static Rates r2 = new Rates("14/15", 10000, 100000, 31866, 150000, 0.2, 0.4, 0.45, 153, 805, 0.12, 0.02, 0.09, 21000);

    final static UserFormData zero = new UserFormData("0", "0", "");
    final static ReturnData nil = new ReturnData(zero);

    /**
     * Display a blank form.
     */
    public static Result blank() {

        FY.addFY(r1);
        FY.addFY(r2);
        return ok(index.render(userForm, nil));
    }

    /**
     * Handle the form submission.
     */
    public static Result submit() {
        Form<UserFormData> filledForm = userForm.bindFromRequest();

        if(filledForm.hasErrors()) {
            return badRequest(index.render(filledForm, nil));
        } else {
          //  UserFormData created = filledForm.get();
            // do calculation and populate in the form
            UserFormData userForm = filledForm.get();
            ReturnData returnData = new ReturnData(userForm);

//            System.out.println("Salary " + userForm.getSalary());
//            System.out.println("Fiscal Year " + rates.fiscalToString());
//            System.out.println("Student Loan " + userForm.isStudentLoan());
//            System.out.println("Annual income tax is: £" + tx.getTax());
//            System.out.println("Annual national insurance is: £" + ni.getNI());
//            if (userForm.isStudentLoan()) {
//                BigDecimal studentLoanAmount = sl.getStudentLoan();
//
//            }
//            System.out.println("Take home pay: £" + rounder.round(userForm.getSalary() - tx.getTax() - ni.getNI() - sl.getStudentLoan()));
            return ok(index.render(filledForm, returnData));
        }
    }
}
