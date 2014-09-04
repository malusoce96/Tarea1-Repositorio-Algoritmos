package musictecplayer.vistas;

import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
 
/**
 * @author Lucia Solis Ceciliano  
 * @author Joseph Vega Vargas
 * @author Miller Ruiz Urbina
 */
public class TestTheme extends DefaultMetalTheme {
 
    public String getName() { return "Toms"; }
 
    private final ColorUIResource primary1 = new ColorUIResource(164, 49, 151);
    private final ColorUIResource primary2 = new ColorUIResource(0, 255, 255);
    private final ColorUIResource primary3 = new ColorUIResource(255, 0, 255);
 
    protected ColorUIResource getPrimary1() { return primary1; }
    protected ColorUIResource getPrimary2() { return primary2; }
    protected ColorUIResource getPrimary3() { return primary3; }
}