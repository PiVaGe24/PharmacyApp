package View.event;

import Model.MenuItem;

public interface EventMenu {
    //Solo pueden haber metodos abstractos y publicos
    //Obligan a las subclases a sobreescribirse
    public abstract void selected(MenuItem item);
}
