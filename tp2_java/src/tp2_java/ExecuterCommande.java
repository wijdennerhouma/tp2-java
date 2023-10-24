package tp2_java;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class ExecuterCommande {
	public static void executerCommande(String commande) {
		try {
			Process process=Runtime.getRuntime().exec(commande);
			boolean termine=process.waitFor(5,TimeUnit.SECONDS);
			if(!termine) {
				process.destroy();
				System.out.println("La commande a ete interrompue en raison du depassement du temps limite.");
				
			}
			else {
				int codeSortie=process.exitValue();
				System.out.println("code du sorie de la commande est:"+codeSortie);
			}
		}catch(	IOException  |InterruptedException e ) {
			e.printStackTrace();;
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("entrer la commande systeme a executer:");
		String commande= scanner.nextLine();
		executerCommande(commande);
	}
	

}
