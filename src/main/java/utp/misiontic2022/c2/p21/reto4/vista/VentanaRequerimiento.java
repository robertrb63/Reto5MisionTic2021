package utp.misiontic2022.c2.p21.reto4.vista;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import utp.misiontic2022.c2.p21.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_3;

public class VentanaRequerimiento extends JFrame {

    private ControladorRequerimientos controlador;
    private JTable tabla;

    public VentanaRequerimiento() {
        controlador = new ControladorRequerimientos();
        initUI();
        setLocationRelativeTo(null);
    }

    private void initUI() {
        setTitle("Interfaz Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        setTitle("Roberto Antonio Restrepo Builes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);


        var tbd = new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);

        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tbd.addTab("Consulta Requerimiento", panel);

        var panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Requerimiento 1"));
        panelEntrada.add(new JLabel("Requerimiento 2"));
        panelEntrada.add(new JLabel("Requerimiento 3"));

        var btnConsulta1 = new JButton("Consultar1");
        btnConsulta1.addActionListener(e -> cargarTablaConsulta());
        panelEntrada.add(btnConsulta1);
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        var btnConsulta2 = new JButton("Consultar2");
        btnConsulta2.addActionListener(e -> cargarTablaConsulta2());
        panelEntrada.add(btnConsulta2);
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        var btnConsulta3 = new JButton("Consultar3");
        btnConsulta3.addActionListener(e -> cargarTablaConsulta3());
        panelEntrada.add(btnConsulta3);
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private void cargarTablaConsulta() {
        try {
            var lista = controlador.consultarRequerimiento1();
            var tableModel = new Requerimiento1TableModel();
            tableModel.setData(lista);
            tabla.setModel(tableModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }      
    }

    private class Requerimiento1TableModel extends AbstractTableModel {
        private ArrayList<Requerimiento_1> data;


        public void setData(ArrayList<Requerimiento_1> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Nombre Material";
                case 1:
                    return "Precio por Unidad";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return registro.getNombreMaterial();
                case 1:
                    return registro.getPrecioUnidad();
                
            }
            return null;
        }
    }

    ////****2 */
    private void cargarTablaConsulta2() {
        try {
            var lista = controlador.consultarRequerimiento2();
            var tableMode = new Requerimiento2TableModel();
            tableMode.setData(lista);
            tabla.setModel(tableMode);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }      
    }

    private class Requerimiento2TableModel extends AbstractTableModel {
        private ArrayList<Requerimiento_2> data;

        public void setData(ArrayList<Requerimiento_2> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Constructora";
                case 1:
                    return "Ciudad";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return registro.getConstructora();
                case 1:
                    return registro.getCiudad();
            }
            return null;
        }
    }

           ////****3 */setData(lista)
           private void cargarTablaConsulta3() {
            try {
                var lista = controlador.consultarRequerimiento3();
                var tableMode = new Requerimiento3TableModel();
                tableMode.setData(lista);
                tabla.setModel(tableMode);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
            }      
        }
    
        private class Requerimiento3TableModel extends AbstractTableModel {
            private ArrayList<Requerimiento_3> data;
    
            public void setData(ArrayList<Requerimiento_3> data) {
                this.data = data;
            }
    
            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Proovedor";
                    case 1:
                        return "Nombre del Material";
                    case 2:
                        return "Importado";
                    case 3:
                        return "Precio de Unidad";
                    case 4:
                        return "Cantidad";
    
                }
                return super.getColumnName(column);
            }
    
            @Override
            public int getRowCount() {
                return data.size();
            }
    
            @Override
            public int getColumnCount() {
                return 5;
            }
    
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                var registro = data.get(rowIndex);
    
                switch (columnIndex) {
                    case 0:
                        return registro.getProveedor();
                    case 1:
                        return registro.getNombreMaterial();
                    case 2:
                        return registro.getImportado();
                    case 3:
                        return registro.getPrecioUnidad();
                    case 4:
                        return registro.getCantidad();    
                    }
                return null;
            }
        }

}
