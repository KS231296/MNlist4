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
        int param = f1.getParametersNumber();
        Argument[] arguments = new Argument[param];
        for(int i = 0; i<param; i++){
            arguments[i] = f1.getArgument(i);
        }
        String expression = f1.getFunctionExpressionString();


        double dt = krokCalkowania;
        double n = tk / dt;
        double x[] = new double[(int) n+1];
        double t[] = new double[(int) n+1];

        x[0] = 1;
        t[0] = t0;

        for (int i = 0; i < n; i++) {
            t[i+1] = t[i]+dt;
            String arg = String.valueOf(x[i]);
            Argument xx = new Argument("x = " + arg);
            Expression e1 = new Expression("f(x)",f1, xx);
            double wynik = e1.calculate();

            x[i + 1] = x[i] + wynik * dt;
        }


    }

    public void eulerMod(){

    }

}
