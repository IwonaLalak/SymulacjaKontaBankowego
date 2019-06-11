package system;

import kontoTypes.E_KontoType;

interface I_KontoCreator {
   public abstract I_AbstractKonto create(E_KontoType kontoType);
}
