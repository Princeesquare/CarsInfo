package CarsInfo;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class CarData extends JFrame implements ActionListener {

    JTextField model_box;
    JTextField year_box;
    JTextField speed_box;
    JTextField color_box;
    JComboBox<Object> brand_box;
    JRadioButton manual;
    JRadioButton auto;
    JButton add;
    JButton search;

    public CarData() {
        setLayout(null);
        setSize(420, 450);
        setTitle("Cars Info");
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon3.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Implementing all the labels
        JLabel title = new JLabel("Enter the Cars Information");
        title.setForeground(Color.BLUE);
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        title.setBounds(50, 20, 300, 20);
        add(title);

        JLabel brand = new JLabel("Choose the Brand:");
        brand.setBounds(15, 35, 300, 100);
        brand.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(brand);

        JLabel gearbox = new JLabel("Choose the GearBox:");
        gearbox.setBounds(15, 80, 300, 100);
        gearbox.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(gearbox);

        JLabel model = new JLabel("Enter the Model:");
        model.setBounds(15, 125, 200, 100);
        model.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(model);

        JLabel year = new JLabel("Enter the Year:");
        year.setBounds(15, 165, 200, 100);
        year.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(year);

        JLabel speed = new JLabel("Enter the Max Speed: ");
        speed.setBounds(15, 205, 200, 100);
        speed.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(speed);

        JLabel color = new JLabel("Enter the Color:");
        color.setBounds(15, 245, 200, 100);
        color.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(color);


        // Implementing combo-box
        brand_box = new JComboBox<>();
        brand_box.setFont(new Font("Times New Roman", Font.BOLD, 14));
        brand_box.setBounds(200, 75, 180, 20);
        brand_box.addItem("Choose");
        brand_box.addItem("Mercedes");
        brand_box.addItem("BMW");
        brand_box.addItem("Honda");
        brand_box.addItem("Mazda");
        brand_box.addItem("Suzuki");
        brand_box.addItem("Hyundai");
        add(brand_box);

        //Implementing Radio Buttons
        manual = new JRadioButton("Manual");
        manual.setFont(new Font("Times New Roman", Font.BOLD, 14));
        manual.setBounds(195, 120, 80, 20);
        add(manual);

        auto = new JRadioButton("Automatic");
        auto.setFont(new Font("Times New Roman", Font.BOLD, 14));
        auto.setBounds(280, 120, 100, 20);
        add(auto);

        ButtonGroup btn_grp = new ButtonGroup();
        btn_grp.add(manual);
        btn_grp.add(auto);

        //Implementing TextFields
        model_box = new JTextField(20);
        model_box.setBounds(200, 160, 185, 25);
        model_box.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(model_box);

        year_box = new JTextField(20);
        year_box.setBounds(200, 200, 185, 25);
        year_box.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(year_box);

        speed_box = new JTextField(20);
        speed_box.setBounds(200, 240, 185, 25);
        speed_box.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(speed_box);

        color_box = new JTextField(20);
        color_box.setBounds(200, 280, 185, 25);
        color_box.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(color_box);

        //Implementing Buttons
        add = new JButton("Add Car to File");
        add.setBounds(15, 330, 370, 25);
        add.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add.setForeground(Color.gray);
        add.addActionListener(this);
        add(add);

        search = new JButton("Open the Search Form");
        search.setBounds(15, 370, 370, 25);
        search.setFont(new Font("Times New Roman", Font.BOLD, 18));
        search.addActionListener(this);
        search.setForeground(Color.gray);
        add(search);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            saveCarInfo();
            clear();
        }
        if (e.getSource() == search) {
            new Search();
            this.dispose();
        }
    }
    public void clear(){
        brand_box.setSelectedIndex(0);
        model_box.setText("");
        manual.setSelected(false);
        auto.setSelected(false);
        year_box.setText("");
        color_box.setText("");
        speed_box.setText("");
    }

    private void saveCarInfo() {
        String brand = (String) brand_box.getSelectedItem();
        String gearType = manual.isSelected() ? "Manual" : "Automatic";
        String year = year_box.getText();
        String color = color_box.getText();
        String maxSpeed = speed_box.getText();
        String model = model_box.getText();

        if (Objects.equals(brand, "Choose") || year.isEmpty() || color.isEmpty() || maxSpeed.isEmpty() || model.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cars.txt", true))) {
            String formattedLine = String.format("%-10s%-10s%-10s%-10s%-10s%-10s",
                    brand, gearType, year, color, maxSpeed, model);
            writer.write(formattedLine);
            writer.newLine();
            JOptionPane.showMessageDialog(null,"Car information saved successfully.");
        } catch (IOException e) {
           JOptionPane.showMessageDialog(null,"An error occurred while saving the car information to file.");
            e.printStackTrace();
        }
    }
}
