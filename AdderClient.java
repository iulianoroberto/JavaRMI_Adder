import java.rmi.*;
import java.util.*;
import java.net.*;

/*
 * In questo codice viene definito il client che accederà al metodo esposto remotamente, tramite l'interfaccia, dall'oggetto remoto.
 */

public class AdderClient {
	public static void main(String[] args) {
		Scanner s  = null;
	
		try {

			/*
			 *  Il client prova ad eseguire una operazione di lookup sul registro, quindi prova a recuperare il riferimento all'oggetto 
			 * remoto (alias proxy) (il cui nome è Adder), passando come parametro alla lookup il suo indirizzo (URL).
			 */
			
			// Adder è l'interface e l'oggetto è una istanza del proxy, l'operazione di conversione è necessaria perché lookup restituisce un Remote generico
			Adder a = (Adder)Naming.lookup("rmi://127.0.0.1/adder");
			// L'esecuzione viene interrotta e vengono richiesti all'utente i numeri da sommare.
			System.out.println("Inserisci i numeri da sommare:");
			s = new Scanner(System.in);
			int op1 = s.nextInt();
			int op2 = s.nextInt();
			// Viene invocato il metodo remoto add sull rference remoto (sul proxy) (trasparenza sugli accesi)
			System.out.println("La somma di " + op1 + "+" + op2 + " e' " + a.add(op1, op2));

			/*
			 * Si prevedono diverse eccezioni tra cui:
			 * - NotBounException: se l'oggetto Adder non è associato (tramite bind) al registro.
			 * - MalformedURLException: se l'URL ha un formato errato.
			 * - RemoteException: se l'invocazione rempta non va a buon fine.
			 */

		} catch (NotBoundException e) {
			System.err.println("Request object not bound " + e);
		} catch (MalformedURLException e) {
			System.err.println("Wrong URL" + e);
		} catch (RemoteException e) {
			System.err.println("Network or Server Error" + e);
		} finally {
			if (s != null) s.close();
		}
	}
}