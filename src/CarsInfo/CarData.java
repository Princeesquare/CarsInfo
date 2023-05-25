package CarsInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarData extends JFrame implements ActionListener {

    public CarData(){
        setLayout(new FlowLayout());
        setSize(400, 600);
        setTitle("Cars Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Implementing all the labels
        JLabel title = new JLabel("Enter the Cars Information");
        title.setForeground(Color.BLUE);
        JLabel brand = new JLabel("Choose the Brand:");
        JLabel gearbox = new JLabel("Choose the GearBox:");
        JLabel model = new JLabel("Enter the Model:");
        JLabel year = new JLabel("Enter the Year:");
        JLabel speed = new JLabel("Enter the Max Speed: ");
        JLabel color = new JLabel("Enter the Color:");

        // Implementing
        JComboBox brand_box = new JComboBox<>();
        brand_box.addItem("Mercedes");  brand_box.addItem("BMW");  brand_box.addItem("Honda");
        brand_box.addItem("Mazda");  brand_box.addItem("Suzuki");  brand_box.addItem("Hyundai");

        //Implementing TextFields
        JTextField model_box = new JTextField(20);
        JTextField year_box = new JTextField(20);
        JTextField speed_box = new JTextField(20);
        JTextField color_box = new JTextField(20);



        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
