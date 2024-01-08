import java.rmi.server.*;
import java.rmi.*;
/*
 * In questo codice si da vita al servizio che implementa l'interfaccia Adder e che estende la classe UnicastRemoteObject.
 * L'estensione di UnicastRemoteObject non è necessario ma il costruttore di quella classe, che sarà implicitamente invocato
 * quando si crea un oggetto AdderImpl darà vita ad un thread che metterà in ascolto quell'oggetto. Se non si estende quella classe
 * bisogna poi operare diversamente per dar vita al thread.
 */
class AdderImpl extends UnicastRemoteObject implements Adder {

  private static final long serialVersionUID = 1L;
  // Costruttore di AdderImpl senza argomenti che prevede un'eccezione di tipo RemoteException
  public AdderImpl() throws RemoteException {}
  // Metodo add (derivato dall'interfaccia) e la sua relativa implemnetazione
    public long add(int op1, int op2) throws RemoteException {
      return op1 + op2;
    }
}