package Controller;

import Model.CustomerOrder;
import Model.PairOfShoes;
import Model.Shoe;
import Repositories.RepOrderedItems;
import Repositories.RepPairOfShoes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorySelector {
    private RepPairOfShoes pairOfShoesRepository = new RepPairOfShoes();
    private RepOrderedItems orderedItemsRepository = new RepOrderedItems();

    public List<PairOfShoes> getlistPairOfShoes(Shoe shoe){
        return pairOfShoesRepository.getListPairOfShoes(shoe);
    }

    public List<PairOfShoes> getOrderedItemsList(CustomerOrder customerOrder,List<Shoe> shoeList) {
        return orderedItemsRepository.getOrderedItems(customerOrder,shoeList);
    }

}
