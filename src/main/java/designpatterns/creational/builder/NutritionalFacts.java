package designpatterns.creational.builder;

public class NutritionalFacts {
    private int servingSize;
    private int servings;
    private int protien;
    private int cholestrol;
    private int sugar;
    private int carbohydrates;
    private int fibre;
    private int fats;

    private NutritionalFacts(Builder builder) {

        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.protien = builder.protien;
        this.cholestrol = builder.cholestrol;
        this.sugar = builder.sugar;
        this.carbohydrates = builder.carbohydrates;
        this.fibre = builder.fibre;
        this.fats = builder.fats;
    }

    public int getServingSize() {
        return this.servingSize;
    }

    public int getServings() {
        return this.servings;
    }

    public int getProtien() {
        return this.protien;
    }

    public int getCholestrol() {
        return this.cholestrol;
    }

    public int getSugar() {
        return this.sugar;
    }

    public int getCarbohydrates() {
        return this.carbohydrates;
    }

    public int getFibre() {
        return this.fibre;
    }

    public int getFats() {
        return this.fats;
    }    

    public static class Builder {

        private int servingSize;
        private int servings;
        private int protien;
        private int cholestrol;
        private int sugar;
        private int carbohydrates;
        private int fibre;
        private int fats;

        public Builder (int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder protien(int protien) {
            this.protien = protien;
            return this;
        }

        public Builder cholestrol(int cholestrol) {
            this.cholestrol = cholestrol;
            return this;
        }
        public Builder sugar(int sugar) {
            this.sugar = sugar;
            return this;
        }
        public Builder carbohydrates(int carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public Builder fibre(int fibre) {
            this.fibre = fibre;
            return this;
        }

        public Builder fats(int fats) {
            this.fats = fats;
            return this;
        }

        public NutritionalFacts build() {
            return new NutritionalFacts(this);
        }
    }


}