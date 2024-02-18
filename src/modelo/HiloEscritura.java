/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cana0
 */
public class HiloEscritura {
    BufferedReader reader;
    BufferedWriter writer;
    public HiloEscritura() {
    }
    //@Override
    public boolean Generar() throws IOException{
        int numeroDeEnteros = 1000000;
        Random random = new Random();
        writer = new BufferedWriter(new FileWriter("enteros_aleatorios.txt"));
        try {
            for (int i = 0; i < numeroDeEnteros; i++) {
                int numeroAleatorio = random.nextInt(20000000 + 1) + -10000000;
                writer.write(Integer.toString(numeroAleatorio)+",");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            return false;
        }
    }
    public boolean Ordenar() throws IOException{
        try {
            reader= new BufferedReader(new FileReader("enteros_aleatorios.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HiloEscritura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String linea;
        List<Integer> enteros = new ArrayList<>();
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(",");
            for (String parte : partes) {
                enteros.add(Integer.valueOf(parte.trim()));
            }
        }
        reader.close();
        enteros.sort(Comparator.naturalOrder());
        writer = new BufferedWriter(new FileWriter("enteros_ordenados.txt"));
        for(int i : enteros){
            writer.write(i+",");
        }
        writer.close();
        return true;
    }
}
