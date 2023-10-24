package compte_rendu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InteractiveProcessBuilder {
    public static void main(String[] args) {
        // Créez une liste de chaînes pour stocker la commande système
        List<String> commands = new ArrayList<>();

        // Demandez à l'utilisateur d'entrer un paramètre pour la commande
        try {
        	//creez un objet BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Entrez un paramètre pour la commande : ");
            String parameter = reader.readLine();

            // Ajoutez la commande et le paramètre à la liste
            commands.add("ping");
            commands.add(parameter);

            // Créez un bloc try-catch pour gérer les exceptions
            try {
                
                ProcessBuilder processBuilder = new ProcessBuilder(commands);

                Process process = processBuilder.start();

                // Créez un objet BufferedReader pour lire la sortie standard du processus
                BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                // Lisez la sortie standard du processus ligne par ligne et affichez-la en temps réel
                String line;
                while ((line = processOutputReader.readLine()) != null) {
                    System.out.println(line);
                }

                // Attendez que le processus se termine et affichez le code de sortie
                int exitCode = process.waitFor();
                System.out.println("Code de sortie : " + exitCode);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
