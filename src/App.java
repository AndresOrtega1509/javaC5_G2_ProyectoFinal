public class App {
    public static void main(String[] args) throws Exception {
        mostrarMenu();
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
}
