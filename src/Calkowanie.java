import org.mariuszgromada.math.mxparser.*;

public class Calkowanie {
    private double krokCalkowania;
    private double t0;
    private double tk;
    private String rownanie;

    public Calkowanie(double krokCalkowania, double t0, double tk, String rownanie) {
        this.krokCalkowania = krokCalkowania;
        this.t0 = t0;
        this.tk = tk;
        this.rownanie = rownanie;
    }

    public void euler(){
        Function f1  = new Function(rownanie);
        Expression e1 = new Expression(f1);


    }

    public void eulerMod(){

    }

}
