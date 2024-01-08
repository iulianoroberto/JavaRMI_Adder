import java.rmi.*;

/*
 * Definizione della classe server. Serve solo a creare l'oggetto e ospitarlo nel processo che si avvierà.
 */

import java.net.*;
public class AdderServer {
  public static void main(String args[]){
    try {
      // Si istanzia un oggetto remoto a partire dalla classe AdderImpl()
      Adder a = new AdderImpl();

      /*
       * Viene invocato il metodo bind sul registro affinché il metodo remoto possa essere utilizzato dai client.
       * Questo viene fatto facendo ricorso al metodo statico bind della classe Naming.
       * Nell'invocare bind si specifica il nome dell'oggetto (ossia adder) e l'indirizzo (che è di loopback perché il registro è
       * locale al server). Il parametro "a" è il riferimento locale all'oggetto remoto.
       * Per motivi di sicurezza il registro deve essere avviato sulla stessa macchina dove si lancia il processo server,
       * ossia questo processo qui.
       */

      Naming.bind("rmi://127.0.0.1/adder", a);
      System.out.println("adder bound");

      /*
       * Si prevedono poi una serie di eccezioni:
       * - AccessExceotion: se si prova ad accedenre, tramite bind, ad un registro remoto per il quale non si hanno i permessi;
       * - RemoteException: bind è una operazione remota che potrebbe fallire come tutte le invocazioni remote;
       * - MalformedURLException: URL errato;
       * - AlreadyBoundException: se l'oggetto è già registrato tramite bind. Se si vuole veitare quella eccezione si può usare rebind(),
       * ossia l'oggeto registrato viene registrato nuovamente.
       */

    } catch(AccessException e) {
      System.err.println("Bind operation not permitted");
    } catch(RemoteException e) {
        System.err.println("Registry coul not be contacted" + e);
    } catch(MalformedURLException e) {
      System.err.println("Wrong URL for binding");
    } 
    // Eccezzione non necessaria se si utilizzase rebind().
    catch(AlreadyBoundException e) {
      System.err.println("Object already bound to the registry");
    }
  }
}
