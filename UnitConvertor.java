package unitconvertor;
import javax.swing.*;
import java.awt.event.*;

public class UnitConvertor{
    private JFrame frame;
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JTextField input;
    private JTextField output;
    private JComboBox<String> fromUnit;
    private JComboBox<String> toUnit;
    private JButton convertButton;

    //------------------------make initComponents--------------------------------
    protected void initComponents(){
        frame=new JFrame("Unit Convertor");
        frame.setSize(450,190);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        inputLabel=new JLabel("Input: ");
        input=new JTextField(10);
        outputLabel=new JLabel("Output");
        output=new JTextField(10);
        output.setEditable(false);

        fromUnit=new JComboBox<String>(new String[]{"Meters","Feet","Inches","Centimeters"});
        toUnit=new JComboBox<String>(new String[]{"Meters","Feet","Inches","Centimeters"});
        convertButton=new JButton("Convert");

        inputLabel.setBounds(20,30,80,20);
        input.setBounds(130,30,100,20);
        fromUnit.setBounds(300,30,100,20);
        outputLabel.setBounds(20,70,80,20);
        output.setBounds(130,70,130,20);
        toUnit.setBounds(300,70,100,20);
        convertButton.setBounds(140,110,100,30);

        //------object of convertButtonListener--------------
        convertButton.addActionListener(new ConvertButtonListener());

        frame.add(inputLabel);
        frame.add(input);
        frame.add(outputLabel);
        frame.add(output);
        frame.add(fromUnit);
        frame.add(toUnit);
        frame.add(convertButton);

        frame.setVisible(true);
    }

    //-----------------event handling--------------------------
    private class ConvertButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String fromUnitType=fromUnit.getSelectedItem().toString();
            String toUnitType=toUnit.getSelectedItem().toString();
            double inputValue=Double.parseDouble(input.getText());
            double outputValue=0.0;

            //----------select unit Meter--------------------
            if(fromUnitType.equals("Meters")){

                //from meters to meters
                if(toUnitType.equals("Meters")){
                    outputValue=UnitConvertor.metersToMeters(inputValue);
                }
                //from meters to feet
                else if(toUnitType.equals("Feet")){
                    outputValue=UnitConvertor.metersToFeet(inputValue);
                }
                //from meters to Inches
                else if(toUnitType.equals("Inches")){
                    outputValue=UnitConvertor.metersToInches(inputValue);
                }
                //from meters to Centimeters
                else if(toUnitType.equals("Centimeters")){
                    outputValue=UnitConvertor.metersToCentimeters(inputValue);
                }
            }

            //---------Select Unit Feet-------------------
            else if(fromUnitType.equals("Feet")){

                //from Feet to meters
                if(toUnitType.equals("Meters")){
                    outputValue=UnitConvertor.feetTOMeters(inputValue);
                }
                //from Feet to Feet
                else if(toUnitType.equals("Feet")) {
                    outputValue=UnitConvertor.feetToFeet(inputValue);
                }
                //from Feet to Inches
                else if(toUnitType.equals("Inches")) {
                    outputValue=UnitConvertor.feetToInches(inputValue);
                }
                //from Feet to Centimeters
                else if(toUnitType.equals("Centimeters")) {
                    outputValue=UnitConvertor.feetToCentimeters(inputValue);
                }
            }

            //---------select Unit Inches----------------------
            else if(fromUnitType.equals("Inches")){

                //from Inches to meters
                if(toUnitType.equals("Meters")){
                    outputValue=UnitConvertor.inchesTOMeters(inputValue);
                }
                //from Inches to Feet
                else if(toUnitType.equals("Feet")) {
                    outputValue=UnitConvertor.inchesToFeet(inputValue);
                }
                //from Inches to Inches
                else if(toUnitType.equals("Inches")) {
                    outputValue=UnitConvertor.inchesToInches(inputValue);
                }
                //from Inches to Centimeters
                else if(toUnitType.equals("Centimeters")) {
                    outputValue=UnitConvertor.inchesToCentimeters(inputValue);
                }

            }

            //---------select unit Centimeters----------------
            else if(fromUnitType.equals("Centimeters")){

                //from Centimeters to meters
                if(toUnitType.equals("Meters")){
                    outputValue=UnitConvertor.centimetersTOMeters(inputValue);
                }
                //from Centimeters to Feet
                else if(toUnitType.equals("Feet")) {
                    outputValue=UnitConvertor.centimetersToFeet(inputValue);
                }
                //from Centimeters to Inches
                else if(toUnitType.equals("Inches")) {
                    outputValue=UnitConvertor.centimetersToInches(inputValue);
                }
                //from Feet to Centimeters
                else if(toUnitType.equals("Centimeters")) {
                    outputValue=UnitConvertor.centimetersToCentimeters(inputValue);
                }
            }
            output.setText(""+outputValue);
        }
    }
    //-----meters to other unit convert----------------
    public static double metersToMeters(double inputValue){
        double outputValue;
        outputValue=inputValue;
        return outputValue;
    }
    public static double metersToCentimeters(double inputValue){
        double outputValue;
        outputValue=inputValue*100;
        return outputValue;
    }
    public static double metersToFeet(double inputValue){
        double outputValue;
        outputValue=inputValue*3.28084;
        return outputValue;
    }
    public static double metersToInches(double inputValue){
        double outputValue;
        outputValue=inputValue*3.28084*12;
        return outputValue;
    }

    //-----------Feet to other unit convert---------------------
    public static double feetTOMeters(double inputValue){
        double outputValue;
        outputValue=inputValue/3.28084;
        return outputValue;
    }
    public static double feetToCentimeters(double inputValue){
        double outputValue;
        outputValue=inputValue/3.28084*100;
        return outputValue;
    }
    public static double feetToFeet(double inputValue){
        double outputValue;
        outputValue=inputValue;
        return outputValue;
    }
    public static double feetToInches(double inputValue){
        double outputValue;
        outputValue=inputValue*12;
        return outputValue;
    }

    //-------------Inches to other unit convert------------------
    public static double inchesTOMeters(double inputValue){
        double outputValue;
        outputValue=inputValue/12*3.28084;
        return outputValue;
    }
    public static double inchesToCentimeters(double inputValue){
        double outputValue;
        outputValue=inputValue/12*3.28084*100;
        return outputValue;
    }
    public static double inchesToFeet(double inputValue){
        double outputValue;
        outputValue=inputValue/12;
        return outputValue;
    }
    public static double inchesToInches(double inputValue){
        double outputValue;
        outputValue=inputValue;
        return outputValue;
    }

    //--------------Centimeters to other unit convert----------------
    public static double centimetersTOMeters(double inputValue){
        double outputValue;
        outputValue=inputValue/100;
        return outputValue;
    }
    public static double centimetersToCentimeters(double inputValue){
        double outputValue;
        outputValue=inputValue;
        return outputValue;
    }
    public static double centimetersToFeet(double inputValue){
        double outputValue;
        outputValue=(inputValue/100)*3.28084;
        return outputValue;
    }
    public static double centimetersToInches(double inputValue){
        double outputValue;
        outputValue=(inputValue/100)*3.28084*12;
        return outputValue;
    }




    //constructor
    public UnitConvertor(){
        initComponents();
    }

//call main method
    public static void main(String[] args){
        new UnitConvertor();
    }
}
