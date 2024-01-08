import java.rmi.*;

/*
 * L'oggetto remoto deve esporre un metodo per la somma di due interi. In questo codcie si definisce l'interfaccia
 * del metodo remoto che si chiama Adder ed estende l'interfaccia Remote. 
 */

public interface Adder extends Remote {
  /*
   * Prototipo del metodo add con la previsione di un eccezione di tipo RemoteException (differenza rispetto a quanto si fa in locale).
   * 
   * L'eccezzione è necessaria per gestire anomalie che non sono presenti in un caso locale, in un sistema distribuito
   * potrebbe fallire l'invocazione. E' un eccezione non di dominio ma legata all'interazione.
   */
  public long add(int opt1, int opt2) throws RemoteException;
}