import java.util.Objects;
public class Complex {
    private final double re;   // partie réelle
    private final double im;   // partie imaginaire

    // création du nombre complexe associé à la partie réelle et imaginaire données
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // renvoie le nombre complexe invoqué
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im < 0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // donne le module
    public double abs() {
        return Math.hypot(re, im);
    }

    // donne l'argument (entre -pi et pi)
    public double phase() {
        return Math.atan2(im, re);
    }

    // renvoie la somme de deux complexes
    public Complex plus(Complex b) {
        Complex a = this;             // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    // renvoie la soustraction de deux complexes
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // renvoie le produit de deux complexes
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    // renvoie le produit par un scalaire
    public Complex scale(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    // renvoie le conjugué
    public Complex conjugate() {
        return new Complex(re, -im);
    }

    // renvoie l'inverse
    public Complex reciprocal() {
        double scale = re * re + im * im;
        return new Complex(re / scale, -im / scale);
    }

    // renvoie la partie reelle / imaginaire
    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    // division de nombres complexes
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // return a new Complex object whose value is the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex tangent of this
    public Complex tan() {
        return sin().divides(cos());
    }


    // a static version of plus
    public static Complex plus(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }