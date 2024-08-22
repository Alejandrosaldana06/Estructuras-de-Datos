package Taller2;

public class Fibonacci {
    
    public int fibonacciBasico(int n) {
        if (n <= 1) {
            return n;
        }
        
        int a = 0, b = 1, c = 0;
        
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        
        return b;
    }
    
    public int fibonacciOptimizado(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            b = a + (a = b);
        }

        return b;
    }
    
    public long medirTiempoEjecucion(FibonacciInterface fibonacciMethod, int n, int repeticiones) {
        long tiempoTotal = 0;
        
        for (int i = 0; i < repeticiones; i++) {
            long inicio = System.nanoTime();
            fibonacciMethod.calcular(n);
            long fin = System.nanoTime();
            tiempoTotal += (fin - inicio);
        }
        
        return tiempoTotal / repeticiones;
    }
    
    public interface FibonacciInterface {
        int calcular(int n);
    }
    
    public void compararTiempos(int n) {
        FibonacciInterface metodoBasico = this::fibonacciBasico;
        FibonacciInterface metodoOptimizado = this::fibonacciOptimizado;

        int repeticiones = 10;
        
        long tiempoBasico = medirTiempoEjecucion(metodoBasico, n, repeticiones);
        long tiempoOptimizado = medirTiempoEjecucion(metodoOptimizado, n, repeticiones);
        
        System.out.println("Tiempo promedio (básico): " + tiempoBasico + " nanosegundos");
        System.out.println("Tiempo promedio (optimizado): " + tiempoOptimizado + " nanosegundos");
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 30;
        
        fibonacci.compararTiempos(n);
    }
}

