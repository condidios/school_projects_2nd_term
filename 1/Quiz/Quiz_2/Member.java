public class Member extends Person{
    private double weight;
    private double height;


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Member(int id, String name, String surname, double weight, double height){
        super(id,name,surname);
        setHeight(height);
        setWeight(weight);
    }

    private double bmi(){
        double bmi = weight / (Math.pow(height,2));
        return bmi;
    }
    public String weightStatus(){
        if (bmi() < 18.5){
            return "Thin";
        }
        else if(18.5 < bmi() && bmi() < 24.9){
            return "Normal";
        }
        else if(25 < bmi() && bmi() < 29.9){
            return "Fat";
        }
        else return "Obese";
    }
}
