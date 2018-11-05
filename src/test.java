import org.mariuszgromada.math.mxparser.*;

public class test {

    public static void main(String[] args) {
        double dt = 0.001;
        double tk = 1;
        double n = tk / dt;
        double t0 = 0;
        double x[] = new double[(int) n+1];
        double t[] = new double[(int) n+1];
        String rownanie1 = "f(x) = -x";
        String rownanie2 = "g'(x) = v*(1-(x/b))*x";

        Function f1 = new Function(rownanie1);
        Function g1 = new Function(rownanie2);

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
}
