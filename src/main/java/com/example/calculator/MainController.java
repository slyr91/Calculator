package com.example.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import com.example.calculator.logic.EquationHandler;
import com.example.calculator.logic.Operand;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainController implements Initializer {

    @FXML
    private Hyperlink flaticonLink;

    @FXML
    private Button button4;

    @FXML
    private Button backspaceButton;

    @FXML
    private Button button5;

    @FXML
    private Button button2;

    @FXML
    private Button clearAllButton;

    @FXML
    private Button button3;

    @FXML
    private Button divideButton;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Hyperlink googleLink;

    @FXML
    private Hyperlink creativeCommonsLink;

    @FXML
    private Button addButton;

    @FXML
    private TextField resultArea;

    @FXML
    private Button equalsButton;

    @FXML
    private Button subtractButton;

    @FXML
    private Button factoriaButton;

    @FXML
    private Button decimalButton;

    @FXML
    private Button piButton;

    @FXML
    private Button clearEntryButton;

    @FXML
    private Button negateButton;

    @FXML
    private Button button0;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button button1;

    private EquationHandler equation = new EquationHandler();
    private boolean inEqualsState = false;

    @FXML
    public void initialize() {
        googleLink.setOnAction(event -> {
            if(Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.flaticon.com/authors/google"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        flaticonLink.setOnAction(event -> {
            if(Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.flaticon.com/"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        creativeCommonsLink.setOnAction(event -> {
            if(Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("http://creativecommons.org/licenses/by/3.0/"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void init(Scene scene) {
//        ImageView icon = new ImageView();
//        backspaceButton.setGraphic();

        scene.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch (event.getCharacter()) {
                        case "0":
                            button0.fire();
                            break;
                        case "1":
                            button1.fire();
                            break;
                        case "2":
                            button2.fire();
                            break;
                        case "3":
                            button3.fire();
                            break;
                        case "4":
                            button4.fire();
                            break;
                        case "5":
                            button5.fire();
                            break;
                        case "6":
                            button6.fire();
                            break;
                        case "7":
                            button7.fire();
                            break;
                        case "8":
                            button8.fire();
                            break;
                        case "9":
                            button9.fire();
                            break;
                        case "+":
                            addButton.fire();
                            break;
                        case "-":
                            subtractButton.fire();
                            break;
                        case "*":
                            multiplyButton.fire();
                            break;
                        case "/":
                            divideButton.fire();
                            break;
                        case "=":
                            equalsButton.fire();
                            break;
                    case ".":
                        decimalButton.fire();
                        break;
                }

            }
        });
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.ENTER) {
                equalsButton.fire();
                event.consume();
            } else if(event.getCode() == KeyCode.BACK_SPACE) {
                backspaceButton.fire();
                event.consume();
            }
        });
    }

    @FXML
    void clearEntry(ActionEvent event) {
        resultArea.clear();
    }

    @FXML
    void clearAll(ActionEvent event) {
        equation.clear();
        resultArea.clear();
    }

    @FXML
    void backspace(ActionEvent event) {
        if(inEqualsState) {
            return;
        }
        String currentEntry = resultArea.getText();
        if(currentEntry.length() > 0) {
            resultArea.setText(currentEntry.substring(0, currentEntry.length() - 1));
        }
    }

    @FXML
    void divide(ActionEvent event) {
        String currentTotal = resultArea.getText();
        if(currentTotal.isEmpty()) {
            return;
        }

        Double newTotal = equation.performPreviousOperand(Double.parseDouble(currentTotal));
        if(newTotal == null) {
            resultArea.setText("ERROR");
            equation.clear();
        } else {
            resultArea.setText(formatText(newTotal.toString()));
            equation.setOperand(Operand.DIVIDE);
        }
        inEqualsState = true;
    }

    @FXML
    void enterPI(ActionEvent event) {
        checkState();
        resultArea.clear();
        resultArea.setText(Double.toString(EquationHandler.pi));
    }

    @FXML
    void seven(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "7";
        resultArea.setText(display);
    }

    @FXML
    void eight(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "8";
        resultArea.setText(display);
    }

    @FXML
    void nine(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "9";
        resultArea.setText(display);
    }

    @FXML
    void multiply(ActionEvent event) {
        String currentTotal = resultArea.getText();
        if(currentTotal.isEmpty()) {
            return;
        }

        Double newTotal = equation.performPreviousOperand(Double.parseDouble(currentTotal));
        if(newTotal == null) {
            resultArea.setText("ERROR");
            equation.clear();
        } else {
            resultArea.setText(formatText(newTotal.toString()));
            equation.setOperand(Operand.MULTIPLY);
        }
        inEqualsState = true;

    }

//    @FXML
//    void factorial(ActionEvent event) {
//        String currentNumString = resultArea.getText();
//
//        Double currentNumD = Double.parseDouble(currentNumString);
//        Double newNumD = equation.factorial(currentNumD);
//
//        resultArea.setText(newNumD.toString());
//
//    }

    @FXML
    void four(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "4";
        resultArea.setText(display);
    }

    @FXML
    void five(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "5";
        resultArea.setText(display);
    }

    @FXML
    void six(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "6";
        resultArea.setText(display);
    }

    @FXML
    void subtract(ActionEvent event) {
        String currentTotal = resultArea.getText();
        if(currentTotal.isEmpty()) {
            return;
        }

        Double newTotal = equation.performPreviousOperand(Double.parseDouble(currentTotal));
        if(newTotal == null) {
            resultArea.setText("ERROR");
            equation.clear();
        } else {
            resultArea.setText(formatText(newTotal.toString()));
            equation.setOperand(Operand.SUBTRACT);
        }
        inEqualsState = true;
    }

    @FXML
    void negate(ActionEvent event) {
        Double currentValue = Double.parseDouble(resultArea.getText());
        Double newValue = -currentValue;
        resultArea.setText(newValue.toString());
    }

    @FXML
    void one(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "1";
        resultArea.setText(display);
    }

    @FXML
    void two(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "2";
        resultArea.setText(display);
    }

    @FXML
    void three(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "3";
        resultArea.setText(display);
    }

    @FXML
    void add(ActionEvent event) {
        String currentTotal = resultArea.getText();
        if(currentTotal.isEmpty()) {
            return;
        }

        Double newTotal = equation.performPreviousOperand(Double.parseDouble(currentTotal));
        if(newTotal == null) {
            resultArea.setText("ERROR");
            equation.clear();
        } else {
            resultArea.setText(formatText(newTotal.toString()));
            equation.setOperand(Operand.ADD);
        }
        inEqualsState = true;
    }

    @FXML
    void zero(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        display += "0";
        resultArea.setText(display);
    }

    @FXML
    void decimal(ActionEvent event) {
        checkState();
        String display = resultArea.getText();
        if(display.isEmpty()) {
            display += "0.";
        } else if(!display.contains(".")) {
            display += ".";
        }
        resultArea.setText(display);

    }

    @FXML
    void equals(ActionEvent event) {
        String currentTotal = resultArea.getText();
        if(currentTotal.isEmpty()) {
            return;
        }

        Double newTotal = equation.performPreviousOperand(Double.parseDouble(currentTotal));
        if(newTotal == null) {
            resultArea.setText("ERROR");
            equation.clear();
        } else {
            resultArea.setText(formatText(newTotal.toString()));
            equation.setOperand(Operand.EQUALS);
        }
        inEqualsState = true;
    }

    private void checkState() {
        if(inEqualsState) {
            inEqualsState = false;
            resultArea.clear();
        }
    }

    private String formatText(String text) {
        Double num = Double.parseDouble(text);
        num = num - num.intValue();
        num = Math.abs(num);
        if(num > 0.0) {
            return text;
        } else {
            return text.substring(0, text.indexOf("."));
        }
    }

}
