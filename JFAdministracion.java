import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
public class JFAdministracion extends JFrame implements ActionListener
{
    //Definimos atributos del formulario Administracion.
    private JPanel p1, p2, p3;
    private JLabel lblNombre, lblPropietario, lblArea, lblHabitantes, lblValorPagar;
    private JTextArea txtNombre, txtPropietario, txtArea, txtHabitantes, txtValorPagar;
    private JButton btnBuscar, btnCalcular, btnLimpiar;
    private JCheckBox checkProntoPago, checkPagoPlataforma;
    private Propiedad propiedad;
    
    public JFAdministracion(){
        setTitle("Ejercicio de Administracion de Condominio");
        setVisible(true);
        setSize(350,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        
        //Crear Panel p1: "Datos de la Propiedad".
        p1 = new  JPanel();
        p1.setLayout(new GridLayout(5,2,5,5));
        p1.setPreferredSize(new Dimension(350,200));
        p1.setBackground(Color.green);
        p1.setBorder(new TitledBorder("Datos de la Propiedad"));
        
        //Crear Panel p2: "Descuentos"
        p2 = new  JPanel();
        p2.setLayout(new FlowLayout());
        p2.setPreferredSize(new Dimension(350,100));
        p2.setBackground(Color.orange);
        p2.setBorder(new TitledBorder("Descuentos"));
        
        //Crear Panel p3: "Calculos y Resultados"
        p3 = new  JPanel();
        p3.setLayout(new GridLayout(2,2,5,5));
        p3.setPreferredSize(new Dimension(350,100));
        p3.setBackground(Color.red);
        p3.setBorder(new TitledBorder("Calculos y Resultados"));
        //Añadir P1 al formulario
        
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
        
        //Crear los Elementos graficos del p1
        lblNombre = new JLabel("Nombre:");
        lblPropietario = new JLabel("Propietario:");
        lblArea = new JLabel("Area (m2):");
        lblHabitantes = new JLabel("No Habitantes:");
        btnBuscar = new JButton("Buscar");
        txtNombre = new JTextArea("");
        txtPropietario = new JTextArea("");
        txtArea = new JTextArea("");
        txtHabitantes = new JTextArea("");
        
        //Añadir los elementos graficos del p1
        p1.add(lblNombre);
        p1.add(txtNombre);
        p1.add(lblPropietario);
        p1.add(txtPropietario);
        p1.add(lblArea);
        p1.add(txtArea);
        p1.add(lblHabitantes);
        p1.add(txtHabitantes);
        p1.add(btnBuscar);

        //Crear los Elementos graficos del p2
        checkProntoPago = new JCheckBox("Pronto Pago", false);
        checkPagoPlataforma = new JCheckBox("Pago Plataforma", false);
        
        //Añadir los elementos graficos del p2
        p2.add(checkProntoPago);
        p2.add(checkPagoPlataforma);

        //Crear los Elementos graficos del p3
        lblValorPagar = new JLabel("Valor Pagar($):");
        txtValorPagar = new JTextArea("");
        btnCalcular = new JButton("Calcular");
        btnLimpiar = new JButton("Limpiar");
        
        //Añadir los elementos graficos del p3
        p3.add(lblValorPagar);
        p3.add(txtValorPagar);
        p3.add(btnCalcular);
        p3.add(btnLimpiar);
        btnBuscar.addActionListener(this);
        btnCalcular.addActionListener(this);
        btnLimpiar.addActionListener(this);
        
        checkProntoPago.addActionListener(this);
        checkPagoPlataforma.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evento){
        String comando = evento.getActionCommand();
        if(comando.equals("Calcular")){
            Propiedad p = new Propiedad(txtNombre.getText(), txtPropietario.getText(),Double.parseDouble(txtArea.getText()),
                                        Integer.parseInt(txtHabitantes.getText()));
            Double pago=0.0;
            if(Double.parseDouble(txtArea.getText())<=120){
                pago = 107000.00;
            }
                else if(Double.parseDouble(txtArea.getText())<=250){
                    pago = 155000.00;
                }
                    else if(Double.parseDouble(txtArea.getText())<=320){
                        pago = 222916.67;
                    }
                        else{
                            pago = 285333.33;
                        }
            txtValorPagar.setText(pago.toString());                        
            System.out.println("El pago de condominio es:"+ pago);
            
        if(checkProntoPago.isSelected()==true){
            pago += pago * 0.05;
        }
            else if(checkPagoPlataforma.isSelected()==true){ 
        }
        }
        
        else if(comando.equals("Limpiar")){
            txtNombre.setText("");
            txtPropietario.setText("");
            txtArea.setText("");
            txtHabitantes.setText("");
        }
    }
}

