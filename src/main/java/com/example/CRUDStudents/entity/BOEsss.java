package com.example.CRUDStudents.entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BOEsss {

    public static void main(String[] args) {
        String url = buildUrlForCurrentDate();
        String content = extractSumario(url);
        System.out.println(content);
    }

    public static String buildUrlForCurrentDate() {
        // Obtener la fecha actual en el formato correcto
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        // Construir la URL para el BOE del día actual
        return "https://www.boe.es/boe/dias/" + formattedDate + "/index.php?s=1";
    }

    public static String extractSumario(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Element sumario = doc.selectFirst("div.sumario");

            if (sumario != null) {
                return sumario.text();
            } else {
                return "No se pudo encontrar el contenido del sumario.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al conectar con el Boletín Oficial del Estado.";
        }
    }
}
