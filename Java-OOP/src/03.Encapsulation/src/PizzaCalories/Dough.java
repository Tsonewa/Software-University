package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 200){
            throw  new IllegalArgumentException(DataValidations.INVALID_DOUGH_WEIGHT);
        }
this.weight = weight;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!bakingTechnique.toUpperCase().equals(DoughModifiers.CHEWY.name())
                && !bakingTechnique.toUpperCase().equals(DoughModifiers.CRISPY.name())
                && !bakingTechnique.toUpperCase().equals(DoughModifiers.HOMEMADE.name())){
            throw  new IllegalArgumentException(DataValidations.INVALID_FLOUR_TYPE);
        } else {
            this.bakingTechnique = bakingTechnique;
            }
        }
    private void setFlourType(String flourType) {
        if(!flourType.toUpperCase().equals(DoughModifiers.WHITE.name()) && !flourType.toUpperCase().equals(DoughModifiers.WHOLEGRAIN.name())){
            throw new IllegalArgumentException(DataValidations.INVALID_FLOUR_TYPE);
        } else {
            this.flourType = flourType;
        }
        }
public double calculateCalories() {
    return (2 * this.weight) * DoughModifiers.valueOf(this.flourType.toUpperCase()).getValue() * DoughModifiers.valueOf(this.bakingTechnique.toUpperCase()).getValue();
}
}
