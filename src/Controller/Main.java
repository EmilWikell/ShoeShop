package Controller;

import Model.*;
import Repositories.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    RepositorySelector repositorySelector = new RepositorySelector();
    RepCustomer customerHandlder = new RepCustomer();
    ProcedureCaller procedureCaller = new ProcedureCaller();

    public Main() {
        List<Brand> brandList = new RepBrand().getBrandList();
        List<ShoeType> shoeTypeList = new RepShoeType().getShoeTypeList();
        List<Shoe> shoeList = new RepShoe().getShoesList(brandList);
        new RepTypeOfShoe().connectShoeToType(shoeList,shoeTypeList);


        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Enter your firstname lastname and password");
            int id = customerHandlder.VerifyLogin(sc.next(), sc.next(), sc.next());
            if (id > 0){
                Customer user = customerHandlder.loginCustomer(id);
                int choice = 1;
                while (choice >= 0){
                    System.out.println("1. Browse shop \n2.View Orders \n-1.Logout");
                    choice = sc.nextInt();
                    if (choice==1){
                        System.out.println("Choose model:");
                        for (int i = 0; i < shoeList.size(); i++) {
                            System.out.println(i+1 +" "+shoeList.get(i).toString());
                        }
                        System.out.println(-1 + ". Go Back");

                        choice = sc.nextInt()-1;
                        if (choice < 0 || choice > shoeList.size()){
                            choice = 0;
                        }else {
                            List<PairOfShoes> pairOfShoesList = repositorySelector.getlistPairOfShoes(shoeList.get(choice));
                            System.out.println("Add to cart");
                            int n;
                            for (n = 0; n < pairOfShoesList.size(); n++) {
                                System.out.println(n+1 +" "+pairOfShoesList.get(n).toString());
                            }
                            System.out.println(++n + " Show reviews");
                            System.out.println(++n + " Leave a review");
                            System.out.println(-1 + ". Go Back");

                            choice = sc.nextInt()-1;
                            if (choice < 0 || choice > pairOfShoesList.size()){
                                choice = 0;
                            }else {
                                PairOfShoes chosenShoe = pairOfShoesList.get(choice);
                                System.out.println("Add to order nr?, 0 for new order");
                                for (int i = 0; i < user.getOrderList().size(); i++) {
                                    System.out.println(i+1);
                                }
                                choice = sc.nextInt()-1;

                                int idOrder;
                                if (choice < 0  || choice >= user.getOrderList().size()){
                                    idOrder = Integer.MAX_VALUE;
                                }else
                                    idOrder = user.getOrderList().get(choice).getId();
                                System.out.println(procedureCaller.addToCart(user,idOrder,chosenShoe));
                                user.setOrderList(new RepCustomerOrder().getOrderList(user.getId()));
                            }
                        }
                    }else if(choice==2){
                        System.out.println("Choose Order nr");
                        for (int i = 0; i < user.getOrderList().size(); i++) {
                            System.out.println(i+1 + " " + user.getOrderList().get(i).getDate());
                        }
                        System.out.println(-1 +". Go back");
                        choice = sc.nextInt()-1;
                        if (choice< 0 || choice >= user.getOrderList().size()){
                            System.out.println("Invalid input");
                        }else{
                            user.getOrderList().get(choice).setListPairOfShoes(repositorySelector.getOrderedItemsList(user.getOrderList().get(choice),shoeList));
                            for (int i = 0; i < user.getOrderList().get(choice).getListPairOfShoes().size(); i++) {
                                System.out.println(user.getOrderList().get(choice).getListPairOfShoes().get(i).getShoe().toString());
                            }
                            System.out.println("Press any key to continue");
                            choice = 0;
                            sc.next();
                        }
                    }
                    else if(choice==3){

                    }
                }
            }
            else{
                System.out.println("Invalid login");
            }
        }


    }

    public static void main(String[] args) {
        new Main();
    }
}
// Use me when user has chosen shoe model  List<PairOfShoes> sizesFromShoe = sizeSelector.getSizesFromShoe(pairOfShoesList, chosenShoe);