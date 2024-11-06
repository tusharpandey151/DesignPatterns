package designpatterns.creational.builder;

public class TestDriver {
    public static void main(String[] args) {
        NutritionalFacts nutritionalFacts = new NutritionalFacts
                                                .Builder(30,1)
                .protien(10).carbohydrates(30)
                .cholestrol(3).fats(4).fibre(7).sugar(10)
                .build();

        System.out.println(nutritionalFacts.getServingSize());
        System.out.println(nutritionalFacts.getServings());
        System.out.println(nutritionalFacts.getProtien());
        System.out.println(nutritionalFacts.getSugar());
        System.out.println(nutritionalFacts.getCholestrol());
        System.out.println(nutritionalFacts.getFats());
        
    }
}
