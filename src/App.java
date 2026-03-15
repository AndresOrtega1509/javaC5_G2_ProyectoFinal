import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static String nombre = "N/A";
    static double nota1 = -1, nota2 = -1, nota3 = -1;
    static String estado = "N/A";
    public static void main(String[] args) throws Exception {
        //mostrarMenu();
        registrarEstudiante();
        //mostrarInformacionEstudiante();
        mostrarResumen();
        limpiarDatos();

    }

    static void mostrarMenu(){
        var opciones = """
                --- Sistema de Registro de Estudiantes ---
                1. Registrar datos de un estudiante
                2. Mostrar datos del estudiante actual
                3. Calcular promedio de notas
                4. Mostrar resumen completo del estudiante
                5. Limpiar datos del estudiante actual
                0. Salir
                """;
        System.out.println(opciones);
        System.out.print("Seleccione una opción: ");
    }

    public static void registrarEstudiante() {
        if (verificarEstudianteRegistrado()) {
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = sc.nextLine();
            nota1 = solicitarNota(1);
            nota2 = solicitarNota(2);
            nota3 = solicitarNota(3);
            sc.nextLine(); // Limpiar el buffer
            System.out.println("Datos del estudiante registrados exitosamente.");
            sc.close();
        }else {
            System.out.println("Registro de estudiante cancelado.");
        }
    }

    static boolean verificarEstudianteRegistrado(){
        if (!nombre.equals("N/A")) {
            System.out.print("Ya hay un estudiante registrado. ¿Desea sobrescribir los datos? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                sc.close();
                return false;
            }
            sc.close();
        }
        return true;
    }

    static double solicitarNota(int numeroNota){
        double nota;
        do{
            System.out.print("Ingrese la nota " + numeroNota + ": ");
            nota = sc.nextDouble();
            if (!esNotaValida(nota)) {
                System.out.println("Nota inválida. Debe estar entre 0 y 100");
            }
        }while(!esNotaValida(nota));
        return nota;
    }

    static boolean esNotaValida(double nota){
        return nota >= 0 && nota <= 100;
    }

    static void mostrarInformacionEstudiante(){
        if (nota1 != -1) {
            System.out.println("--- Información estudiante ---");
            System.out.println("Nombre del estudiante: " + nombre);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        }else{
            System.out.println("No hay datos de estudiante registrados actualmente.");
        }
    }

    static double calcularPromedio(){
        double promedio = -1;
        if (nota3 != -1) {
            promedio = (nota1+nota2+nota3) / 3;
        }else{
            System.out.println("No hay notas registradas para calcular promedio.");
        }
        return promedio;
    }

    static void mostrarResumen(){
        System.out.println("--- Resumen del estudiante ---");
        System.out.println("Nombre del estudiante: " + nombre);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
        System.out.printf("Promedio: %.2f%n",calcularPromedio());
        setEstado();
        System.out.printf("Estado: " + estado);
    }

    public static void setEstado() {
        double promedio = calcularPromedio();
        estado = (promedio >= 60) ? "Aprobado" : "Reprobado";
    }

    static void limpiarDatos(){
        nombre = "N/A";
        nota1 = -1;
        nota2 = -1;
        nota3 = -1;
        estado = "N/A";
        System.out.println("Los datos del estudiante actual han sido borrados exitosamente.");
    }
}
