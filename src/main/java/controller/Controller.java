package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Calculator;
import model.Number;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML
    private TextField resultDisplay;

    @FXML
    private TextArea history;

    @FXML
    private Button clearButton;

    @FXML
    private Button squarerootButton;

    @FXML
    private Button squareButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button subtractButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button addButton;

    @FXML
    private Button zeroButton;

    @FXML
    private Button dotButton;

    @FXML
    private Button equalButton;

    private Calculator calculator;

    double result = 0;
    int iD = 0;
    String operator;
    double firstNumber, secondNumber, count;
    boolean point = false;
    List<Number> result_list;

    @FXML
    public void initialize() {
        calculator = new Calculator();
    }

    public void calculate(ActionEvent event) {

        Button button = (Button) event.getSource();

        if(button.getId().equals("addButton")){
            firstNumber = Double.parseDouble(resultDisplay.getText());
            resultDisplay.setText("");
            count = 1;
            point = false;
            operator = "+";
        } else if(button.getId().equals("subtractButton")) {
            firstNumber = Double.parseDouble(resultDisplay.getText());
            resultDisplay.setText("");
            count = 2;
            point = false;
            operator = "-";
        } else if(button.getId().equals("multiplyButton")) {
            firstNumber = Double.parseDouble(resultDisplay.getText());
            resultDisplay.setText("");
            count = 3;
            point = false;
            operator = "*";
        } else if(button.getId().equals("divideButton")) {
            firstNumber = Double.parseDouble(resultDisplay.getText());
            resultDisplay.setText("");
            count = 4;
            point = false;
            operator = "/";
        } else if(button.getId().equals("squareButton")) {
            firstNumber = Double.parseDouble(resultDisplay.getText());
            resultDisplay.setText(String.valueOf(calculator.square(firstNumber)));
            result = Double.parseDouble(resultDisplay.getText());
            System.out.println(result);
            iD++;
            count = 0;
            operator = "square";

            result = Double.parseDouble(resultDisplay.getText());
            System.out.println(result);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculator");
            EntityManager em = emf.createEntityManager();

            Number user = Number.builder().id(iD).first_number(firstNumber).operator(operator).calculated_result(result).build();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

            result_list =  em.createQuery("SELECT n FROM Number n", Number.class).getResultList();

            em.close();
            emf.close();

            history.setText(Arrays.toString(result_list.toArray()));

        } else if(button.getId().equals("squarerootButton")) {
            firstNumber = Double.parseDouble(resultDisplay.getText());
            resultDisplay.setText(String.valueOf(calculator.squareRoot(firstNumber)));
            result = Double.parseDouble(resultDisplay.getText());
            System.out.println(result);
            iD++;
            count = 0;
            operator = "sqrt";

            result = Double.parseDouble(resultDisplay.getText());
            System.out.println(result);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculator");
            EntityManager em = emf.createEntityManager();

            Number user = Number.builder().id(iD).first_number(firstNumber).operator(operator).calculated_result(result).build();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

            result_list =  em.createQuery("SELECT n FROM Number n", Number.class).getResultList();

            em.close();
            emf.close();

            history.setText(Arrays.toString(result_list.toArray()));

        } else if(button.getId().equals("equalButton") && count > 0 ) {
            secondNumber = Double.parseDouble(resultDisplay.getText());

            if(count == 1){
                resultDisplay.setText(String.valueOf(calculator.add(firstNumber, secondNumber)));
            } else if( count == 2){
                resultDisplay.setText(String.valueOf(calculator.subtract(firstNumber, secondNumber)));
            } else if( count == 3){
                resultDisplay.setText(String.valueOf(calculator.multiply(firstNumber, secondNumber)));
            } else if( count == 4){
                resultDisplay.setText(String.valueOf(calculator.divide(firstNumber, secondNumber)));
            }
            result = Double.parseDouble(resultDisplay.getText());
            System.out.println(result);
            count = 0;
            iD++;

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculator");
            EntityManager em = emf.createEntityManager();

            Number user = Number.builder().id(iD).first_number(firstNumber).operator(operator).
                    second_number(secondNumber).calculated_result(result).build();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

            result_list =  em.createQuery("SELECT n FROM Number n", Number.class).getResultList();

            em.close();
            emf.close();

            history.setText(Arrays.toString(result_list.toArray()));
        }
    }

    public void processNumpad(ActionEvent event) {

        Button button = (Button) event.getSource();

        if(button.getId().equals("oneButton")){
            resultDisplay.appendText("1");
        } else if(button.getId().equals("twoButton")){
            resultDisplay.appendText("2");
        } else if(button.getId().equals("threeButton")){
            resultDisplay.appendText("3");
        } else if(button.getId().equals("fourButton")){
            resultDisplay.appendText("4");
        } else if(button.getId().equals("fiveButton")){
            resultDisplay.appendText("5");
        } else if(button.getId().equals("sixButton")){
            resultDisplay.appendText("6");
        } else if(button.getId().equals("sevenButton")){
            resultDisplay.appendText("7");
        } else if(button.getId().equals("eightButton")){
            resultDisplay.appendText("8");
        } else if(button.getId().equals("nineButton")){
            resultDisplay.appendText("9");
        } else if(button.getId().equals("zeroButton")){
            resultDisplay.appendText("0");
        } else if(button.getId().equals("dotButton") && !point){
            resultDisplay.appendText(".");
            point = true;
        } else if(button.getId().equals("clearButton")){
            resultDisplay.setText("");
            firstNumber = 0;
            secondNumber = 0;
            count = 0;
            point = false;
            result = 0;
        }

    }

}
