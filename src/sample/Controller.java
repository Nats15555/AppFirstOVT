package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button calc;

    @FXML
    private TextField first;

    @FXML
    private TextField second;

    @FXML
    private Text bitS;

    @FXML
    void initialize() {
        calc.setOnAction(actionEvent -> {
            CharSequence f = first.getCharacters();
            CharSequence s = second.getCharacters();
            List<String> tab = FXCollections.observableArrayList();
            tab.add("Чиcло   |Sing2|Sing1|   Разряды     ");
            tab.addAll(binTest(Integer.parseInt(f.toString()), Integer.parseInt(s.toString())));
            bitS.setText(tab.get(0) + "\n" + tab.get(1) + "\n" + tab.get(2) + "\n" + tab.get(3) + "\n" + tab.get(4)
                    + "\n" + tab.get(5) + "\n" + tab.get(6) + "\n" + tab.get(7));
        });
    }

    private static List<String> inDop(List<String> list, CharSequence f, CharSequence s) {
        char[] charA = f.toString().toCharArray();
        char[] charB = s.toString().toCharArray();
        List<String> listPrint = new ArrayList<String>();
        String A = "A(прям)|         |       ";
        String B = "B(прям)|         |       ";
        for (int i = 0; i <= 8; i++) {//вывод двоичного чила
            A += charA[i] + "|";
            B += charB[i] + "|";
        }
        listPrint.add(A);
        listPrint.add(B);
        for (int i = 0; i <= 8; i++) {//перевод в доп код

        }
        return listPrint;
    }

    private static List<String> inObr(char[] a, char[] b) {
        char[] A = new char[8];
        char[] B = new char[8];
        String strA = "A(доп) |        ";
        String strB = "B(доп) |        ";
        byte test = 0b1000;

        System.out.println(~(test));
        List<String> listPrint = new ArrayList<String>();
        if (a[0] == '0') {
            strA += "0|       0|";
            for (int i = 1; i <= 8; i++) {//вывод двоичного чила
                strA += a[i] + "|";
            }
        } else {
            strA += "1|       1|";
        }
        if (b[0] == '0') {
            strB += "0|       0|";
            for (int i = 1; i <= 8; i++) {//вывод двоичного чила
                strB += b[i] + "|";
            }
        } else {
            strB += "1|       1|";

            if (a[8] == '0') {
                strB += '1';
            }
        }
        listPrint.add(strA);
        listPrint.add(strB);
        return listPrint;
    }


    public static List<String> binTest(int a, int b) {
        List<String> binF = new ArrayList<>();
        int aLeng = Integer.toBinaryString(a * -1).length();;
        int bLeng = Integer.toBinaryString(b * -1).length();;
        String strA = "A(доп)  |       ";
        String strB = "B(доп)  |       ";
        String Sdop = "S(доп)  |       ";
        String Sprzm = "S(прям)|       ";
        if (a < 0) {
            System.out.println(Integer.toBinaryString(a * -1));
            binF.add("A(прям)|         |       1|" + Integer.toBinaryString(a * -1));
            strA += "1|       1|" + Integer.toBinaryString(a).substring(Integer.toBinaryString(a).length() - aLeng);
        } else {
            binF.add("A(прям)|         |       0|" + Integer.toBinaryString(a));
            strA += "0|       0|" + Integer.toBinaryString(a);
        }
        if (b < 0) {
            System.out.println(Integer.toBinaryString(b * -1));
            binF.add("B(прям)|         |       1|" + Integer.toBinaryString(b * -1));
            strB += "1|       1|" + Integer.toBinaryString(b).substring(Integer.toBinaryString(b).length() - bLeng);
        } else {
            binF.add("A(прям)|         |       0|" + Integer.toBinaryString(b));
            strB += "0|       0|" + Integer.toBinaryString(b);
        }
        binF.add(strA);
        binF.add(strB);
        binF.add(Sdop + Integer.toBinaryString(a + b).substring(22).charAt(0) + "|       "
                + Integer.toBinaryString(a + b).substring(23).charAt(0) + "|"
                + Integer.toBinaryString(a + b).substring(24));
        if (Integer.toBinaryString(a + b).substring(21).charAt(0) == '1') {
            binF.add(Sprzm + "1|       " + Integer.toBinaryString(a + b).substring(23).charAt(0) + "|"
                    + Integer.toBinaryString((a + b) * -1).substring(1));
            binF.add("Отрицательное переполнение");
        } else {
            binF.add("Переполнения нет");
        }
        //System.out.println(A|(~B|0b1));

        return binF;
    }
}
