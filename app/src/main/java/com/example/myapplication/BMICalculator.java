package com.example.myapplication;

class BMICalculator {

    BMICalculator() {
    }

    static String[] bmiRatings = {
            "very severly underweight",
            "severly underweight",
            "moderately underweight",
            "normal (healthy weight)",
            "overweight",
            "moderately obese (class I)",
            "severly obese (class II)",
            "very severly obese (class III)"
    };

     static String[] details = {
            "BMI kleiner als 15",
            "BMI zwischen 15 und 16",
            "BMI zwischen 18.5 und 25",
            "BMI zwischen 25 und 30",
            "BMI zwischen 30 und 35",
            "BMI zwischen 35 und 40",
            "BMI über 40"
    };



    String BMI(long gewicht, long groesse){

        long bmi = (100*100*gewicht)/(groesse*groesse);

        String value;
        if (bmi < 15) {
            value = "\n" + bmiRatings[0];
        }
        else if (bmi <= 16){
            value = "\n" + bmiRatings[1];
        }
        else if (bmi <= 18.5){
            value = "\n" + bmiRatings[2];
        }
        else if (bmi <= 25){
            value = "\n" + bmiRatings[3];
        }
        else if (bmi <= 30){
            value = "\n" + bmiRatings[4];
        }
        else if (bmi <= 35){
            value = "\n" + bmiRatings[5];
        }
        else if (bmi <= 40){
            value = "\n" + bmiRatings[6];
        }
        else {
            value = "\n" + bmiRatings[7];
        }
        return bmi + value;
    }


}
