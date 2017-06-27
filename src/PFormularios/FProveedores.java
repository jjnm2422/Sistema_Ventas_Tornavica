/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFormularios;

import Atxy2k.CustomTextField.RestrictedTextField;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Navarro
 */
public class FProveedores extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    DefaultTableModel model;
    public FProveedores() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        this.restringir();
        this.LlenarTabla();
    }
    
    public void setlook() {
       try{
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
          e.printStackTrace();
        }  
    }
    public void setTitle(String title) {
        super.setTitle(title);
        lblTitulo.setText(title);
    }
    public void restringir(){
        RestrictedTextField restricted3 = new RestrictedTextField(this.txtCedula1);
        restricted3.setOnlyNums(true);
        RestrictedTextField restricted4 = new RestrictedTextField(this.txtTelefono11);
        restricted4.setOnlyNums(true);
        RestrictedTextField restricted = new RestrictedTextField(this.txtTelefono12);
        restricted.setOnlyNums(true);
    }
    
    public void LlenarTabla(){
        try {
            String[]titulos={"Codigo","Nombre","Telefono","Telefono",
                        "Direccion","Pagina Web","Horario","Comentario"};
            String sql="select * from proveedores";
            model= new DefaultTableModel(null,titulos);
            ResultSet rs= acciones.Consultar(sql);
            String[]fila=new String[8];
            while(rs.next()){
            fila[0]=rs.getString("codpro");
            fila[1]=rs.getString("nompro");
            fila[2]=rs.getString("telpro");
            fila[3]=rs.getString("tel2pro");
            fila[4]=rs.getString("dirpro"); 
            fila[5]=rs.getString("pagpro"); 
            fila[6]=rs.getString("horpro"); 
            fila[7]=rs.getString("despro"); 
                model.addRow(fila);      
            }
            tbl.setModel(model);
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());    
        }
    }
    
    private void restaurarVentana() {
        if(getExtendedState() == JFrame.MAXIMIZED_BOTH){//1
            setExtendedState(JFrame.NORMAL);//2
        }else{
            setExtendedState(JFrame.MAXIMIZED_BOTH);//3
        }
    }
    public void Ajustar(JLabel label, ImageIcon icon){
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint();
    }
    
    private void Habilitar(int x) {
        switch (x) {
            case 2:
            txtNombre2.setEnabled(true);
//            txtApellido2.setEnabled(true);
            txtComentario2.setEnabled(true);
            txtTelefono22.setEnabled(true);
            txtTelefono21.setEnabled(true);
            txtDireccion2.setEnabled(true);
            txtHorario2.setEnabled(true);
            txtPagina2.setEnabled(true);
                break; 
            case 3:
            txtNombre2.setEnabled(false);
//            txtApellido2.setEnabled(false);
            txtComentario2.setEnabled(false);
            txtTelefono21.setEnabled(false);
            txtTelefono22.setEnabled(false);
            txtDireccion2.setEnabled(false);
            txtHorario2.setEnabled(false);
            txtPagina2.setEnabled(false);
            
                break;
            default:
        }       
    }
    
    private void Borrar(int x) {
        switch (x) {
            case 1:
            txtNombre1.setText("");
            txtPagina1.setText("");
            txtHorario1.setText("");
            txtComentario1.setText("");
            txtCedula1.setText("");
            txtTelefono11.setText("");
            txtTelefono12.setText(""); 
            txtDireccion1.setText("");
                break;
            case 2:
            txtNombre2.setText("");
            txtPagina2.setText("");
            txtHorario2.setText("");
            txtComentario2.setText("");
            txtCedula2.setText("");
            txtTelefono21.setText("");
            txtTelefono22.setText(""); 
            txtDireccion2.setText("");
                break;
            case 3:
            txtNombre2.setText("");
            txtPagina2.setText("");
            txtHorario2.setText("");
            txtComentario2.setText("");
            txtTelefono21.setText("");
            txtTelefono22.setText(""); 
            txtDireccion2.setText("");
                break;
            default:
        }
    }
    
    private boolean Verificacion1(){
        if (txtNombre1.getText().equals("")
         || txtCedula1.getText().equals("") || txtTelefono11.getText().equals("")
         || txtDireccion1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos esten llenos", "Advertencia",JOptionPane.PLAIN_MESSAGE,iconAd);
            return false;
        } else {
            return true;
        }
    }
    
    private boolean Verificacion2(){
        if (txtNombre2.getText().equals("")
         || txtCedula2.getText().equals("") || txtTelefono21.getText().equals("")
         || txtDireccion2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos esten llenos", "Advertencia",JOptionPane.PLAIN_MESSAGE,iconAd);
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo5 = new javax.swing.JLabel();
        lblTitulo9 = new javax.swing.JLabel();
        lblTitulo10 = new javax.swing.JLabel();
        lblTitulo11 = new javax.swing.JLabel();
        lblTitulo12 = new javax.swing.JLabel();
        lblTitulo13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComentario1 = new javax.swing.JTextArea();
        lblTitulo14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDireccion1 = new javax.swing.JTextArea();
        txtNombre1 = new javax.swing.JTextField();
        txtTelefono12 = new javax.swing.JTextField();
        txtHorario1 = new javax.swing.JTextField();
        txtCedula1 = new javax.swing.JTextField();
        txtTelefono11 = new javax.swing.JTextField();
        btnBorrar1 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnIngresar1 = new javax.swing.JButton();
        lblTitulo15 = new javax.swing.JLabel();
        txtPagina1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo6 = new javax.swing.JLabel();
        lblTitulo7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentario2 = new javax.swing.JTextArea();
        lblTitulo8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion2 = new javax.swing.JTextArea();
        txtNombre2 = new javax.swing.JTextField();
        txtTelefono22 = new javax.swing.JTextField();
        txtTelefono21 = new javax.swing.JTextField();
        btnSalir2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        btnEditar2 = new javax.swing.JButton();
        btnBorrar2 = new javax.swing.JButton();
        txtPagina2 = new javax.swing.JTextField();
        lblTitulo16 = new javax.swing.JLabel();
        lblTitulo17 = new javax.swing.JLabel();
        txtHorario2 = new javax.swing.JTextField();
        txtCedula2 = new javax.swing.JTextField();
        lblTitulo18 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnSalir4 = new javax.swing.JButton();
        btnSalir5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proveedores");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/cerrar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/minimizar.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 30, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabel1.setBackground(new java.awt.Color(204, 0, 204));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 204), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo5.setText("Telefono 2");
        jPanel2.add(lblTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 20));

        lblTitulo9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo9.setText("Nombre");
        jPanel2.add(lblTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblTitulo10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo10.setText("Horario");
        jPanel2.add(lblTitulo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 80, 20));

        lblTitulo11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo11.setText("Cedula/RIF");
        jPanel2.add(lblTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 70, 20));

        lblTitulo12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo12.setText("Telefono");
        jPanel2.add(lblTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        lblTitulo13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo13.setText("Direccion");
        jPanel2.add(lblTitulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

        txtComentario1.setColumns(1);
        txtComentario1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtComentario1.setLineWrap(true);
        txtComentario1.setRows(1);
        txtComentario1.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtComentario1);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 180, 60));

        lblTitulo14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo14.setText("Comentarios");
        jPanel2.add(lblTitulo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 80, 20));

        txtDireccion1.setColumns(1);
        txtDireccion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDireccion1.setLineWrap(true);
        txtDireccion1.setRows(1);
        txtDireccion1.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtDireccion1);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 170, 60));

        txtNombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 170, -1));

        txtTelefono12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtTelefono12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 180, -1));

        txtHorario1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtHorario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 180, -1));

        txtCedula1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtCedula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 180, -1));

        txtTelefono11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono11ActionPerformed(evt);
            }
        });
        jPanel2.add(txtTelefono11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 170, -1));

        btnBorrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar1.setText("Borrar");
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 100, 30));

        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 100, 30));

        btnIngresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_success.png"))); // NOI18N
        btnIngresar1.setText("Ingresar");
        btnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, 30));

        lblTitulo15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo15.setText("Pagina Web");
        jPanel2.add(lblTitulo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 20));

        txtPagina1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtPagina1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 170, -1));

        jTabbedPane1.addTab("Nuevo", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 204), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setText("Telefono 2");
        jPanel1.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 20));

        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setText("Nombre");
        jPanel1.add(lblTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblTitulo6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo6.setText("Telefono");
        jPanel1.add(lblTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        lblTitulo7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo7.setText("Direccion");
        jPanel1.add(lblTitulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

        txtComentario2.setColumns(1);
        txtComentario2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtComentario2.setLineWrap(true);
        txtComentario2.setRows(1);
        txtComentario2.setWrapStyleWord(true);
        txtComentario2.setEnabled(false);
        jScrollPane1.setViewportView(txtComentario2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 180, 60));

        lblTitulo8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo8.setText("Comentarios");
        jPanel1.add(lblTitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 80, 20));

        txtDireccion2.setColumns(1);
        txtDireccion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDireccion2.setLineWrap(true);
        txtDireccion2.setRows(1);
        txtDireccion2.setWrapStyleWord(true);
        txtDireccion2.setEnabled(false);
        jScrollPane2.setViewportView(txtDireccion2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 170, 60));

        txtNombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre2.setEnabled(false);
        jPanel1.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 170, -1));

        txtTelefono22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono22.setEnabled(false);
        jPanel1.add(txtTelefono22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 180, -1));

        txtTelefono21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono21.setEnabled(false);
        jPanel1.add(txtTelefono21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 170, -1));

        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 100, 30));

        btnEliminar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497313212_trash.png"))); // NOI18N
        btnEliminar2.setText("Eliminar");
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 100, 30));

        btnEditar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497312816_edit-find-replace.png"))); // NOI18N
        btnEditar2.setText("Editar");
        btnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 100, 30));

        btnBorrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar2.setText("Borrar");
        btnBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 100, 30));

        txtPagina2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPagina2.setEnabled(false);
        jPanel1.add(txtPagina2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 170, -1));

        lblTitulo16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo16.setText("Pagina Web");
        jPanel1.add(lblTitulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 20));

        lblTitulo17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo17.setText("Horario");
        jPanel1.add(lblTitulo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 80, 20));

        txtHorario2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtHorario2.setEnabled(false);
        jPanel1.add(txtHorario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 180, -1));

        txtCedula2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtCedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 140, -1));

        lblTitulo18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo18.setText("Cedula/RIF");
        jPanel1.add(lblTitulo18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 70, 20));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497642935_search_magnifying_glass_find.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 30, 20));

        jTabbedPane1.addTab("Modificar", jPanel1);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proveedores Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel25.setText("FILTROS:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 60, 20));

        txtB.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBActionPerformed(evt);
            }
        });
        txtB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBKeyTyped(evt);
            }
        });
        jPanel6.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 160, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 20));

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Rif", "Codigo" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        jPanel6.add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 150, 20));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tbl);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 530, 100));

        btnSalir4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497913416_gtk-refresh.png"))); // NOI18N
        btnSalir4.setText("Actualizar");
        btnSalir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir4ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalir4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, 30));

        btnSalir5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir5.setText("Salir");
        btnSalir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir5ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalir5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 110, 30));

        jTabbedPane1.addTab("Listado", jPanel6);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 570, 270));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
    x = evt.getX();
    y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
    Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
    System.out.println("Coordenadas: ("+ubicacion.x+","+ubicacion.y+")");//2
    setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
restaurarVentana();
setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        // TODO add your handling code here:
            try {
            String sql = "delete from proveedores where rifpro='"+txtCedula2.getText()+"'" ;
            Statement st = acciones.Eliminar(sql);
            int n = st.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(null,"Proveedor eliminado correctamente del sistema", "Informacion",JOptionPane.PLAIN_MESSAGE,iconCorrecto);
                this.Borrar(2);
                this.Habilitar(3);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al eliminar Proveedor\ncodigo error:"+e.getMessage()
        ,"Error",JOptionPane.PLAIN_MESSAGE,iconError);
        }
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar2ActionPerformed
   String cedula = txtCedula2.getText();
if (Verificacion2()) {
    try {
    String sql = "update proveedores set nompro=?, pagpro=?, rifpro=?,"
            + "telpro=?, tel2pro=?, dirpro=?, despro=?, horpro=? where rifpro = '"+cedula+"'";

    PreparedStatement ps = acciones.Actualizar(sql);
    ps.setString(1, this.txtNombre2.getText().toLowerCase());    
    ps.setString(2, this.txtPagina2.getText().toLowerCase());
    ps.setString(3, this.txtCedula2.getText().toLowerCase());
    ps.setString(4, this.txtTelefono21.getText().toLowerCase());
    ps.setString(5, this.txtTelefono22.getText().toLowerCase());
    ps.setString(6, this.txtDireccion2.getText().toLowerCase());
    ps.setString(7, this.txtComentario2.getText().toLowerCase());
    ps.setString(8, this.txtHorario2.getText().toLowerCase());
    int n = ps.executeUpdate();
    if (n > 0) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente","Informacion"
                    ,JOptionPane.PLAIN_MESSAGE,iconCorrecto);
            this.Habilitar(3);
            this.Borrar(3);
    }
    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos " + e.getMessage()
                    ,"Error",JOptionPane.PLAIN_MESSAGE,new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"))); 
    }
}
    }//GEN-LAST:event_btnEditar2ActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        // TODO add your handling code here:
        this.dispose();    
    
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void txtTelefono11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono11ActionPerformed

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed
        if (Verificacion1()) {
        try {
	String sql = "insert into proveedores(nompro, rifpro, telpro,"
                + "tel2pro, dirpro, pagpro, despro, horpro) values(?,?,?,?,?,?,?,?)";
	PreparedStatement ps = acciones.Ingresar(sql);
	ps.setString(1, txtNombre1.getText().toLowerCase());
	ps.setString(2, txtCedula1.getText().toLowerCase());
	ps.setString(3, txtTelefono11.getText().toLowerCase());
	ps.setString(4, txtTelefono12.getText().toLowerCase());
	ps.setString(5, txtDireccion1.getText().toLowerCase());
	ps.setString(6, txtPagina1.getText().toLowerCase());
	ps.setString(7, txtComentario1.getText().toLowerCase());
	ps.setString(8, txtHorario1.getText().toLowerCase());
	int n = ps.executeUpdate();
		if (n > 0) {
			JOptionPane.showMessageDialog(null, "Proveedor ingresado con exito"
                        ,"Informacion",JOptionPane.PLAIN_MESSAGE,iconCorrecto);
                        this.Borrar(1);
		}
	} catch (Exception e) {
	JOptionPane.showMessageDialog(null,"Error al guardar cliente\ncodigo error:"+e.getMessage()
        ,"Error",JOptionPane.PLAIN_MESSAGE,iconError);
}
    }
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
        this.Borrar(1);
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //    selecciono el codigo del cliente para no tener problemas al no copiar la cedula completa
        boolean resultado=false;
        this.Borrar(3);
        int codigo = 0;
        String cedula  = this.txtCedula2.getText();
        try {
            String sql = "select * from proveedores  where rifpro = '"+cedula+"'";
            ResultSet rs = acciones.Consultar(sql);
            while(rs.next()){
                resultado = true;
                this.Habilitar(2);
                codigo = rs.getInt("codpro");
                txtNombre2.setText(rs.getString("nompro"));
                txtPagina2.setText(rs.getString("pagpro"));
                txtHorario2.setText(rs.getString("horpro"));
                txtCedula2.setText(rs.getString("rifpro"));
                txtTelefono21.setText(rs.getString("telpro"));
                txtTelefono22.setText(rs.getString("tel2pro"));
                txtDireccion2.setText(rs.getString("dirpro"));
                txtComentario2.setText(rs.getString("despro"));
            }
            if (resultado==false) {
                JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda", "Advertencia"
                    ,JOptionPane.PLAIN_MESSAGE,iconAd);
                this.Habilitar(3);
                resultado = false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al consultar cliente\ncodigo error:"+e.getMessage()
                ,"Error",JOptionPane.PLAIN_MESSAGE,iconError);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar2ActionPerformed
    this.Borrar(2);
    }//GEN-LAST:event_btnBorrar2ActionPerformed

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
        if (!txtB.getText().equals("")) {
            int var = cbxFiltro.getSelectedIndex();
            switch (var) {
                case 0:
                try {
                    String[]titulos={"Codigo","Nombre","Telefono","Telefono",
                        "Direccion","Pagina Web","Horario","Comentario"};
                    String sql="select * from proveedores where nompro like '"+txtB.getText()+"%'";
                    model= new DefaultTableModel(null,titulos);
                    ResultSet rs= acciones.Consultar(sql);
                    String[]fila=new String[8];
                    while(rs.next()){
                    fila[0]=rs.getString("codpro");
                    fila[1]=rs.getString("nompro");
                    fila[2]=rs.getString("telpro");
                    fila[3]=rs.getString("tel2pro");
                    fila[4]=rs.getString("dirpro"); 
                    fila[5]=rs.getString("pagpro"); 
                    fila[6]=rs.getString("horpro"); 
                    fila[7]=rs.getString("despro"); 
                        model.addRow(fila);      
                    }
                    tbl.setModel(model);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
                case 1:
                try {
                    String[]titulos={"Codigo","Nombre","Telefono","Telefono",
                        "Direccion","Pagina Web","Horario","Comentario"};
                    String sql="select * from proveedores where rifpro like '"+txtB.getText()+"%'";
                    model= new DefaultTableModel(null,titulos);
                    ResultSet rs= acciones.Consultar(sql);
                    String[]fila=new String[8];
                    while(rs.next()){
                    fila[0]=rs.getString("codpro");
                    fila[1]=rs.getString("nompro");
                    fila[2]=rs.getString("telpro");
                    fila[3]=rs.getString("tel2pro");
                    fila[4]=rs.getString("dirpro"); 
                    fila[5]=rs.getString("pagpro"); 
                    fila[6]=rs.getString("horpro"); 
                    fila[7]=rs.getString("despro"); 
                        model.addRow(fila);      
                    }
                    tbl.setModel(model);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
                case 2:
                try {
                    String[]titulos={"Codigo","Nombre","Telefono","Telefono",
                        "Direccion","Pagina Web","Horario","Comentario"};
                    String sql="select * from proveedores where codpro = '"+txtB.getText()+"'";
                    model= new DefaultTableModel(null,titulos);
                    ResultSet rs= acciones.Consultar(sql);
                    String[]fila=new String[8];
                    while(rs.next()){
                    fila[0]=rs.getString("codpro");
                    fila[1]=rs.getString("nompro");
                    fila[2]=rs.getString("telpro");
                    fila[3]=rs.getString("tel2pro");
                    fila[4]=rs.getString("dirpro"); 
                    fila[5]=rs.getString("pagpro"); 
                    fila[6]=rs.getString("horpro"); 
                    fila[7]=rs.getString("despro"); 
                        model.addRow(fila);      
                    }
                    tbl.setModel(model);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
                default:

            }
        } else {
            this.LlenarTabla();
        }
    }//GEN-LAST:event_txtBKeyReleased

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked

    }//GEN-LAST:event_tblMouseClicked

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed

    }//GEN-LAST:event_tblKeyPressed

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased

    }//GEN-LAST:event_tblKeyReleased

    private void btnSalir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir4ActionPerformed
        this.LlenarTabla();
        this.txtB.setText("");
    }//GEN-LAST:event_btnSalir4ActionPerformed

    private void btnSalir5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir5ActionPerformed
     this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir5ActionPerformed

    private void txtBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBKeyTyped
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnBorrar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir4;
    private javax.swing.JButton btnSalir5;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo10;
    private javax.swing.JLabel lblTitulo11;
    private javax.swing.JLabel lblTitulo12;
    private javax.swing.JLabel lblTitulo13;
    private javax.swing.JLabel lblTitulo14;
    private javax.swing.JLabel lblTitulo15;
    private javax.swing.JLabel lblTitulo16;
    private javax.swing.JLabel lblTitulo17;
    private javax.swing.JLabel lblTitulo18;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtCedula1;
    private javax.swing.JTextField txtCedula2;
    private javax.swing.JTextArea txtComentario1;
    private javax.swing.JTextArea txtComentario2;
    private javax.swing.JTextArea txtDireccion1;
    private javax.swing.JTextArea txtDireccion2;
    private javax.swing.JTextField txtHorario1;
    private javax.swing.JTextField txtHorario2;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtPagina1;
    private javax.swing.JTextField txtPagina2;
    private javax.swing.JTextField txtTelefono11;
    private javax.swing.JTextField txtTelefono12;
    private javax.swing.JTextField txtTelefono21;
    private javax.swing.JTextField txtTelefono22;
    // End of variables declaration//GEN-END:variables
}
