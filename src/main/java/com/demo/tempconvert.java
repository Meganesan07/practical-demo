public class tempconvert {
    
    public static double celsiustoFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }
    public static double Fahrenheittocelsius(double Fahrenheit) {
        return (Fahrenheit - 32) * 5.0 / 9.0;
    }
    public static double celsiustoKelvin(double celsius) {
        return celsius + 273.15;
    }
    public static double Kelvintocelsius(double Kelvin) {
        return Kelvin - 273.15;
    }
}