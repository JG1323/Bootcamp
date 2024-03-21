//import javax.swing.*;
//	import java.awt.*;
//	import java.awt.event.*;
//	import java.io.*;
//	import java.util.ArrayList;
//	import java.util.List;
//	import java.util.Scanner;
//
//public class Main1 {
//	    public static void main(String[] args) {
//	        SwingUtilities.invokeLater(() -> {
//	            TiendaGUI tiendaGUI = new TiendaGUI();
//	            tiendaGUI.mostrar();
//	        });
//	    }
//	}
//
//	public class TiendaGUI {
//		TiendaGUI tiendaGUI = new TiendaGUI();
//	    private JFrame frame;
//	    private JComboBox<String> tipoTiendaCombo;
//	    private Tienda tienda;
//
//	    public void mostrar() {
//	        frame = new JFrame("Tienda");
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        frame.setSize(400, 300);
//	        frame.setLayout(new BorderLayout());
//
//	        JLabel tipoLabel = new JLabel("Tipo de Tienda:");
//	        String[] tiposTienda = {"Física", "Virtual"};
//	        tipoTiendaCombo = new JComboBox<>(tiposTienda);
//
//	        JButton abrirTiendaBtn = new JButton("Abrir Tienda");
//	        abrirTiendaBtn.addActionListener(e -> {
//	            String tipoSeleccionado = (String) tipoTiendaCombo.getSelectedItem();
//	            if (tipoSeleccionado.equals("Física")) {
//	                tienda = new TiendaFisica("Mi Tienda Física", "123 Calle Principal");
//	            } else if (tipoSeleccionado.equals("Virtual")) {
//	                tienda = new TiendaVirtual("Mi Tienda Virtual");
//	            }
//	            tienda.ejecutar();
//	            frame.getContentPane().removeAll();
//	            frame.add(tienda.getPanel(), BorderLayout.CENTER);
//	            frame.revalidate();
//	            frame.repaint();
//	        });
//
//	        JPanel panelSeleccion = new JPanel(new FlowLayout());
//	        panelSeleccion.add(tipoLabel);
//	        panelSeleccion.add(tipoTiendaCombo);
//	        panelSeleccion.add(abrirTiendaBtn);
//
//	        frame.add(panelSeleccion, BorderLayout.NORTH);
//	        frame.setVisible(true);
//	    }
//	}
//
//	abstract class Tienda {
//	    protected String nombre;
//	    protected Carrito carrito = new Carrito();
//	    protected JPanel panel;
//
//	    public Tienda(String nombre) {
//	        this.nombre = nombre;
//	        inicializarBaseDeDatos();
//	    }
//
//	    protected abstract void inicializarBaseDeDatos();
//
//	    protected abstract void ejecutar();
//
//	    protected abstract void modoAdmin();
//
//	    protected abstract void verificarStockBajo();
//
//	    protected abstract List<Producto> obtenerProductos();
//
//	    protected JPanel getPanel() {
//	        return panel;
//	    }
//	}
//
//	class TiendaFisica extends Tienda {
//	    private String direccion;
//
//	    public TiendaFisica(String nombre, String direccion) {
//	        super(nombre);
//	        this.direccion = direccion;
//	    }
//
//	    @Override
//	    protected void inicializarBaseDeDatos() {
//	        // No es necesario inicializar la base de datos para la tienda física
//	    }
//
//	    @Override
//	    protected void ejecutar() {
//	        panel = new JPanel();
//	        panel.setLayout(new BorderLayout());
//
//	        JTextArea productosTextArea = new JTextArea(10, 20);
//	        productosTextArea.setEditable(false);
//	        JScrollPane scrollPane = new JScrollPane(productosTextArea);
//	        panel.add(scrollPane, BorderLayout.CENTER);
//
//	        JButton listarProductosBtn = new JButton("Listar Productos");
//	        listarProductosBtn.addActionListener(e -> {
//	            List<Producto> productos = obtenerProductos();
//	            StringBuilder listaProductos = new StringBuilder();
//	            listaProductos.append("--- Productos Disponibles en ").append(nombre).append(" ---\n");
//	            for (Producto producto : productos) {
//	                listaProductos.append(producto.toString()).append("\n");
//	            }
//	            productosTextArea.setText(listaProductos.toString());
//	        });
//	        panel.add(listarProductosBtn, BorderLayout.SOUTH);
//	    }
//
//	    @Override
//	    protected void modoAdmin() {
//	        // Implementación de modo admin para la tienda física
//	    }
//
//	    @Override
//	    protected void verificarStockBajo() {
//	        // Implementación de verificar stock bajo para la tienda física
//	    }
//
//	    @Override
//	    protected List<Producto> obtenerProductos() {
//	        List<Producto> productos = new ArrayList<>();
//	        try (Scanner scanner = new Scanner(new File("productos.txt"))) {
//	            while (scanner.hasNextLine()) {
//	                String[] datosProducto = scanner.nextLine().split(",");
//	                String nombre = datosProducto[0];
//	                int cantidad = Integer.parseInt(datosProducto[1]);
//	                double precio = Double.parseDouble(datosProducto[2]);
//	                double iva = Double.parseDouble(datosProducto[3]);
//	                productos.add(new Producto(nombre, cantidad, precio, iva));
//	            }
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        }
//	        return productos;
//	    }
//	}
//
//	class TiendaVirtual extends Tienda {
//	    public TiendaVirtual(String nombre) {
//	        super(nombre);
//	    }
//
//	    @Override
//	    protected void inicializarBaseDeDatos() {
//	        // No es necesario inicializar la base de datos para la tienda virtual
//	    }
//
//	    @Override
//	    protected void ejecutar() {
//	        panel = new JPanel();
//	        panel.setLayout(new BorderLayout());
//
//	        JButton agregarProductoBtn = new JButton("Agregar Producto");
//	        agregarProductoBtn.addActionListener(e -> {
//	            // Lógica para agregar producto
//	        });
//	        panel.add(agregarProductoBtn, BorderLayout.CENTER);
//	    }
//	    @Override
//	    protected void modoAdmin() {
//	        // Implementación de modo admin para la tienda virtual
//	    }
//
//	    @Override
//	    protected void verificarStockBajo() {
//	        // Implementación de verificar stock bajo para la tienda virtual
//	    }
//
//	    @Override
//	    protected List<Producto> obtenerProductos() {
//	        // Implementación de obtener productos para la tienda virtual
//	        return null;
//	    }
//}