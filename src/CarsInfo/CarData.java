package CarsInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarData extends JFrame implements ActionListener {

    public CarData(){
        setLayout(null);
        setSize(450, 600);
        setTitle("Cars Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Implementing all the labels
        JLabel title = new JLabel("Enter the Cars Information");
        title.setForeground(Color.BLUE);
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        title.setBounds(50, 20, 300, 20);
        add(title);

        JLabel brand = new JLabel("Choose the Brand:");
        brand.setBounds(15, 35, 300, 100); // (left-right margin , upper margin, padding, width)
        brand.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(brand);

        JLabel gearbox = new JLabel("Choose the GearBox:");
        gearbox.setBounds(15, 80, 300, 100);
        gearbox.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel model = new JLabel("Enter the Model:");
        JLabel year = new JLabel("Enter the Year:");
        JLabel speed = new JLabel("Enter the Max Speed: ");
        JLabel color = new JLabel("Enter the Color:");


        // Implementing combo-box
        JComboBox<Object> brand_box = new JComboBox<>();
        brand_box.setBounds(170, 75, 200, 20);  brand_box.addItem("Choose");
        brand_box.addItem("Mercedes");  brand_box.addItem("BMW");  brand_box.addItem("Honda");
        brand_box.addItem("Mazda");  brand_box.addItem("Suzuki");  brand_box.addItem("Hyundai");

        //Implementing Radio Buttons
        JRadioButton manual = new JRadioButton("Manual");
        manual.setBounds(200, 120, 100, 20);        JRadioButton auto = new JRadioButton("Automatic");
        auto.setBounds(300, 120, 100, 20);

        //Implementing TextFields
        JTextField model_box = new JTextField(20);
        JTextField year_box = new JTextField(20);
        JTextField speed_box = new JTextField(20);
        JTextField color_box = new JTextField(20);

        //Implementing Buttons
        JButton add = new JButton("Add Car to File");
        JButton search = new JButton("Open the Search Form");

        ButtonGroup btn_grp = new ButtonGroup();
        btn_grp.add(add); btn_grp.add(search);

         add(brand_box); add(gearbox); add(manual); add(auto);
        add(model); add(model_box); add(year); add(year_box);



        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
