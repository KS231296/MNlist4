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

    public void euler(Argument[] arguments){
        Function f1  = new Function(rownanie);
        int param = f1.getParametersNumber();

        PrimitiveElement[] args = new  PrimitiveElement[param+1];
        args[0] = f1;
        for(int i = 0; i<param; i++){
             args[i+1] = arguments[i];
        }
        String expression = f1.getFunctionExpressionString();



        double dt = krokCalkowania;
        double n = tk / dt;
        double x[] = new double[(int) n+1];
        double t[] = new double[(int) n+1];

        x[0] = arguments[param-1].getArgumentValue();
        t[0] = t0;

        for (int i = 0; i < n; i++) {
            t[i+1] = t[i]+dt;
            String arg = String.valueOf(x[i]);
            args[param] = new Argument("x = " + arg);
            Expression e1 = new Expression(expression,args);
            double wynik = e1.calculate();

            x[i + 1] = x[i] + wynik * dt;
        }


    }

    public void eulerMod(){

    }

}
