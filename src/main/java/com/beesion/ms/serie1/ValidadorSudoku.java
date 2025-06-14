package com.beesion.ms.serie1;

public class ValidadorSudoku {
    public static void main(String[] args) {
            // Ejemplo 1 - Tablero válido
            char[][] tableroValido = {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };

            // Ejemplo 2 - Tablero inválido (hay dos 8 en el mismo subcuadro)
            char[][] tableroInvalido = {
                    {'8', '3', '.', '.', '7', '.', '.', '.', '.'}, // <- Aquí está el error: dos '8' en subcuadro
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };

            System.out.println("Ejemplo 1 (válido): " + esValidoSudoku(tableroValido));     // true
            System.out.println("Ejemplo 2 (inválido): " + esValidoSudoku(tableroInvalido)); // false
        }

        public static boolean esValidoSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                boolean[] fila = new boolean[9];
                boolean[] columna = new boolean[9];
                boolean[] caja = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    // Validar fila
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        if (fila[num]) return false;
                        fila[num] = true;
                    }

                    // Validar columna
                    if (board[j][i] != '.') {
                        int num = board[j][i] - '1';
                        if (columna[num]) return false;
                        columna[num] = true;
                    }

                    // Validar subcuadro 3x3
                    int filaCaja = 3 * (i / 3) + j / 3;
                    int colCaja = 3 * (i % 3) + j % 3;
                    if (board[filaCaja][colCaja] != '.') {
                        int num = board[filaCaja][colCaja] - '1';
                        if (caja[num]) return false;
                        caja[num] = true;
                    }
                }
            }
            return true;
        }

    }

