import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {
    private static JButton num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    private static JButton cal1, cal2, cal3, cal4, re, point, ac;
    private static JLabel resultLabel, calLabel;

    public static double totalResult = 0, currentNumber = 0;
    public static String currentNumberString = "", currentCalRule = "";

    public Calculator() {
        defineFrame(); // 定義視窗
        defineLabel(); // 定義顯示Label
        defineButton(); // 定義顯示Button

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void defineFrame() {
        setTitle("簡易計算機");
        setSize(240, 320);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    public void defineLabel() {
        // 結果顯示區域
        resultLabel = new JLabel();
        resultLabel.setBounds(0, 0, 240, 50);
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        resultLabel.setText("0");
        add(resultLabel);

        // 運算符號顯示區域
        calLabel = new JLabel();
        calLabel.setBounds(10, 5, 100, 10);
        calLabel.setHorizontalAlignment(SwingConstants.LEFT);
        calLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        calLabel.setText("");
        add(calLabel);
    }

    public void defineButton() {
        // 清除鍵
        ac = new JButton();
        ac.setBounds(0, 230, 60, 60);
        ac.setText("AC");
        add(ac);
        ac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("0");
                totalResult = 0;
                currentNumberString = "";
                currentNumber = 0;
                calLabel.setText("");
                currentCalRule = "";
            }
        });

        // 數字鍵
        num0 = new JButton();
        num0.setBounds(60, 230, 60, 60);
        num0.setText("0");
        add(num0);
        num0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("0");
            }
        });

        num1 = new JButton();
        num1.setBounds(0, 170, 60, 60);
        num1.setText("1");
        add(num1);
        num1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("1");
            }
        });

        num2 = new JButton();
        num2.setBounds(60, 170, 60, 60);
        num2.setText("2");
        add(num2);
        num2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("2");
            }
        });

        num3 = new JButton();
        num3.setBounds(120, 170, 60, 60);
        num3.setText("3");
        add(num3);
        num3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("3");
            }
        });

        num4 = new JButton();
        num4.setBounds(0, 110, 60, 60);
        num4.setText("4");
        add(num4);
        num4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("4");
            }
        });

        num5 = new JButton();
        num5.setBounds(60, 110, 60, 60);
        num5.setText("5");
        add(num5);
        num5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("5");
            }
        });

        num6 = new JButton();
        num6.setBounds(120, 110, 60, 60);
        num6.setText("6");
        add(num6);
        num6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("6");
            }
        });

        num7 = new JButton();
        num7.setBounds(0, 50, 60, 60);
        num7.setText("7");
        add(num7);
        num7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("7");
            }
        });

        num8 = new JButton();
        num8.setBounds(60, 50, 60, 60);
        num8.setText("8");
        add(num8);
        num8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("8");
            }
        });

        num9 = new JButton();
        num9.setBounds(120, 50, 60, 60);
        num9.setText("9");
        add(num9);
        num9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl("9");
            }
        });

        // 小數點
        point = new JButton();
        point.setBounds(120, 230, 60, 60);
        point.setText(".");
        add(point);
        point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonControl(".");
            }
        });

        // 運算鍵
        cal1 = new JButton();
        cal1.setBounds(180, 50, 60, 50);
        cal1.setText("+");
        add(cal1);
        cal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateControl("+");
            }
        });

        cal2 = new JButton();
        cal2.setBounds(180, 100, 60, 50);
        cal2.setText("-");
        add(cal2);
        cal2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateControl("-");
            }
        });

        cal3 = new JButton();
        cal3.setBounds(180, 150, 60, 50);
        cal3.setText("X");
        add(cal3);
        cal3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateControl("*");
            }
        });

        cal4 = new JButton();
        cal4.setBounds(180, 200, 60, 50);
        cal4.setText("/");
        add(cal4);
        cal4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateControl("/");
            }
        });

        re = new JButton();
        re.setBounds(180, 250, 60, 40);
        re.setText("=");
        add(re);
        re.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!currentCalRule.equals("")) {
                    totalResult = calculate(currentNumber, totalResult, currentCalRule);
                }
                // resultLabel.setText(Float.toString(totalResult));
                replaceResult(totalResult);
                calLabel.setText("");
                currentNumberString = "";
                currentNumber = 0;
            }
        });
    }

    protected static void replaceResult(Double totalResult) {
        if (String.valueOf(totalResult).indexOf(".") > 0) {
            resultLabel.setText(String.valueOf(totalResult).replaceAll("0 ?$", ""));
            resultLabel.setText(resultLabel.getText().replaceAll("[.]$", ""));
        }
    }

    protected static Double calculate(Double currentNumber, Double totalResult, String currentCalRule) {
        if (currentCalRule.equals("+")) {
            totalResult += currentNumber;
        } else if (currentCalRule.equals("-")) {
            totalResult -= currentNumber;
        } else if (currentCalRule.equals("x")) {
            totalResult *= currentNumber;
        } else if (currentCalRule.equals("/")) {
            totalResult /= currentNumber;
        }
        return totalResult;
    }

    protected static void calculateControl(String buttonCal) {
        if (totalResult != 0) {
            totalResult = calculate(currentNumber, totalResult, currentCalRule);
        } else {
            totalResult = Double.parseDouble(resultLabel.getText());
        }
        switch (buttonCal) {
            case "+":
                calLabel.setText("+");
                currentCalRule = "+";
                break;
            case "-":
                calLabel.setText("-");
                currentCalRule = "-";
                break;
            case "*":
                calLabel.setText("x");
                currentCalRule = "x";
                break;
            case "/":
                calLabel.setText("/");
                currentCalRule = "/";
                break;
        }

        // resultLabel.setText(String.valueOf(totalResult));
        replaceResult(totalResult);
        currentNumber = 0;
        currentNumberString = "";
    }

    protected static void buttonControl(String buttonNum) {
        resultLabel.setText("0");

        switch (buttonNum) {
            case "0":
                if (!currentNumberString.equals("")) {
                    currentNumberString = currentNumberString + buttonNum;
                }
                break;
            default:
                currentNumberString = currentNumberString + buttonNum;
                break;
        }

        currentNumber = Double.parseDouble(currentNumberString);
        resultLabel.setText(currentNumberString);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}