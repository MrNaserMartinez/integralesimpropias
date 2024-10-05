package umg.lab;

import java.util.function.Function;

public class integralesimpropias {
    // Método para calcular una integral impropia con el método de los trapecios
    public static double calcularIntegralImpropia(Function<Double, Double> funcion, double a, double b, int n) {
        // Definir un número grande para aproximar el infinito
        if (Double.isInfinite(b)) {
            b = 1e6; // Aproximación para el infinito
        }

        if (Double.isInfinite(a)) {
            a = -1e6; // Aproximación para el infinito negativo
        }

        double h = (b - a) / n; // El tamaño de los subintervalos
        double suma = 0.5 * (funcion.apply(a) + funcion.apply(b)); // Valor inicial

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += funcion.apply(x);
        }

        return suma * h; // Resultado de la integral aproximada
    }

    public static void main(String[] args) {
        // Definir la función que queremos integrar, por ejemplo, f(x) = 1 / x^2
        Function<Double, Double> funcion = x -> 1 / Math.pow(x, 2);

        // Definir los límites de la integral. En este caso, a = 1 y b = infinito
        double a = 1;
        double b = Double.POSITIVE_INFINITY; // Límite superior es infinito

        // Definir el número de divisiones (más divisiones => más precisión)
        int n = 100000;

        // Calcular la integral
        double resultado = calcularIntegralImpropia(funcion, a, b, n);

        // Imprimir el resultado
        System.out.println("El valor de la integral es: " + resultado);
    }
}