package com.beesion.ms.serie1;

import java.util.Arrays;

public class SecuenciaFibonacci {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fibonacci(new int[]{0, 1}, 9)));
        System.out.println(Arrays.toString(fibonacci(new int[]{2, 3}, 5)));
        System.out.println(Arrays.toString(fibonacci(new int[]{5, 7}, 0)));
    }

    public static int[] fibonacci(int[] inicio, int n) {
        if (n == 0) return new int[0];

        int[] resultado = new int[n];

        // Copiar los dos primeros si n >= 1 o n >= 2
        if (n >= 1) resultado[0] = inicio[0];
        if (n >= 2) resultado[1] = inicio[1];

        for (int i = 2; i < n; i++) {
            resultado[i] = resultado[i - 1] + resultado[i - 2];
        }

        return resultado;
    }
}
