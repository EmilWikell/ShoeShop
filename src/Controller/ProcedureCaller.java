package Controller;

import Model.Customer;
import Model.PairOfShoes;
import Repositories.RepProcedureAddToCart;

public class ProcedureCaller {

    RepProcedureAddToCart procedureAddToCart = new RepProcedureAddToCart();

    public String addToCart(Customer customer, int idOrder, PairOfShoes pair){
        return procedureAddToCart.callProcedure(customer.getId(),idOrder,pair.getId());
    }
}
