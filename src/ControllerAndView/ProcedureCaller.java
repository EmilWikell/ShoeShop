package ControllerAndView;

import Model.Customer;
import Model.PairOfShoes;
import Repositories.RepProcedureAddToCart;
import Repositories.RepProcedureRate;

public class ProcedureCaller {

    RepProcedureAddToCart procedureAddToCart = new RepProcedureAddToCart();
    RepProcedureRate procedureRate = new RepProcedureRate();

    public String addToCart(Customer customer, int idOrder, PairOfShoes pair){
        return procedureAddToCart.callProcedure(customer.getId(),idOrder,pair.getId());
    }

    public String procedureRate(int customerId, int shoeId, int gradeId, String comment) {
        return procedureRate.callProcedureRate(customerId,shoeId,gradeId,comment);
    }
}
