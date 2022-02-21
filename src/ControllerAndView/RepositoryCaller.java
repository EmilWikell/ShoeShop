package ControllerAndView;

import Model.CustomerOrder;
import Model.PairOfShoes;
import Model.Shoe;
import Repositories.RepOrderedItems;
import Repositories.RepPairOfShoes;
import Repositories.RepRating;

import java.util.List;

public class RepositoryCaller {
    private RepPairOfShoes pairOfShoesRepository = new RepPairOfShoes();
    private RepOrderedItems orderedItemsRepository = new RepOrderedItems();
    private RepRating ratingRepository = new RepRating();

    public List<PairOfShoes> getlistPairOfShoes(Shoe shoe){
        return pairOfShoesRepository.getListPairOfShoes(shoe);
    }

    public List<PairOfShoes> getOrderedItemsList(CustomerOrder customerOrder,List<Shoe> shoeList) {
        return orderedItemsRepository.getOrderedItems(customerOrder,shoeList);
    }
    public String getRating(int shoeId){
        return ratingRepository.showRating(shoeId);
    }
}
