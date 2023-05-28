package CarsInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Search extends JFrame implements ActionListener {

    JTextField model_box;
    JTextField year_box;
    JTextField speed_box;
    JTextField color_box;
    JTextField brand_box;
    JTextField gearbox;
    JLabel brand;
    JLabel gear;
    JLabel model;
    JLabel year;
    JLabel speed;
    JLabel color;
    JButton find;
    JButton clear;

    public Search(){
        setLayout(null);
        setSize(620, 180);
        setTitle("Search Fastest Car");
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon3.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        brand = new JLabel("Brand");
        brand.setBounds(20, 5, 50, 50);
        brand.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(brand);

        gear = new JLabel("GearBox");
        gear.setBounds(100, 5, 80, 50);
        gear.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(gear);

        model = new JLabel("Model");
        model.setBounds(200, 5, 50, 50);
        model.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(model);

        year = new JLabel("Year");
        year.setBounds(300, 5, 50, 50);
        year.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(year);

        speed = new JLabel("MaxSpeed");
        speed.setBounds(370, 5, 100, 50);
        speed.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(speed);

        color = new JLabel("Color");
        color.setBounds(500, 5, 70, 50);
        color.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(color);

        // Text Fields
        brand_box = new JTextField(10);
        brand_box.setBounds(20, 50, 70, 25);
        brand_box.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        brand_box.setEnabled(false);
        add(brand_box);

        gearbox = new JTextField(10);
        gearbox.setBounds(100, 50, 75, 25);
        gearbox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        gearbox.setEnabled(false);
        add(gearbox);

        model_box = new JTextField(10);
        model.enableInputMethods(false);
        model_box.setBounds(200, 50, 70, 25);
        model_box.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        model_box.setEnabled(false);
        add(model_box);

        year_box = new JTextField(20);
        year_box.setBounds(290, 50, 65, 25);
        year_box.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        year_box.setEnabled(false);
        add(year_box);

        speed_box = new JTextField(20);
        speed_box.setBounds(370, 50, 100, 25);
        speed_box.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        speed_box.setEnabled(false);
        add(speed_box);

        color_box = new JTextField(20);
        color_box.setBounds(500, 50, 80, 25);
        color_box.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        color_box.setEnabled(false);
        add(color_box);

        // Buttons
        find = new JButton("Find the Fastest Car");
        find.setBounds(20, 100, 450, 25);
        find.setFont(new Font("Times New Roman", Font.BOLD, 18));
        find.addActionListener(this);
        find.setForeground(Color.gray);
        add(find);

        clear = new JButton("Clear");
        clear.setBounds(500, 100, 80, 25);
        clear.setFont(new Font("Times New Roman", Font.BOLD, 18));
        clear.addActionListener(this);
        clear.setForeground(Color.gray);
        add(clear);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == find) searchFastestCar();
        if (e.getSource() == clear) clear();
    }

    public void clear(){
        brand_box.setText("");
        model_box.setText("");
        gearbox.setText("");
        year_box.setText("");
        color_box.setText("");
        speed_box.setText("");
    }

    private void searchFastestCar() {
        try (BufferedReader reader = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            String fastestCarBrand = "";
            String fastestCarModel = "";
            String fastestCarGear = "";
            int fastestCarYear = 0;
            String fastestCarColor = "";
            int fastestSpeed = Integer.MIN_VALUE;

            while ((line = reader.readLine()) != null) {
                String[] carInfo = line.split("\\s+");

                if (carInfo.length == 6) {
                    String brand = carInfo[0];
                    String gear = carInfo[1];
                    int year = Integer.parseInt(carInfo[2]);
                    String color = carInfo[3];
                    int speed = Integer.parseInt(carInfo[4]);
                    String model = carInfo[5];

                    if (speed > fastestSpeed) {
                        fastestSpeed = speed;
                        fastestCarBrand = brand;
                        fastestCarGear = gear;
                        fastestCarModel = model;
                        fastestCarYear = year;
                        fastestCarColor = color;
                    }
                }
            }

            if (fastestSpeed != Integer.MIN_VALUE) {
                JOptionPane.showMessageDialog(null, "The Fastest Car: " + fastestCarBrand +
                " with a speed of " + fastestSpeed + "km/h");
                brand_box.setText(fastestCarBrand);
                model_box.setText(fastestCarModel);
                gearbox.setText(fastestCarGear);
                year_box.setText(String.valueOf(fastestCarYear));
                color_box.setText(fastestCarColor);
                speed_box.setText(fastestSpeed + "km/h");
            } else {
                JOptionPane.showMessageDialog(null, "No cars found in the file.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reading file or file does not exist");
        }
    }
}