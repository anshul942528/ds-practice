public class Main {

    boolean sunlight = false;
    double D = 0.0;
    double DD = 0.0;
    double Vbat = 0.7;
    double Vx = 0.5;
    double Vo = 0.2;
    double Vr = 0.25;

    public static void main(String args[]) {
        function();
    }

    public static void function() {

        if (sunlight) {
            sunLightFlow();
        } else {
            D = 0.0;
            nonSunLightFlow();
        }
        function();
    }

    public static void sunLightFlow() {
        MPPTIndicatesD();
        if (Vo == Vr) {
            workWithSameDdash();
            sunLightFlow();
        } else {
            if (Vo > Vr) {
                decreaseDdash();
            } else {
                if (Vbat > Vx) {
                    increaseDdash();
                } else {
                    converterTurnOff();
                }
            }
        }
    }

    public static void nonSunLightFlow() {
        if (Vbat > Vx) {
            if (Vo == Vr) {
                nonSunLightFlow();
            } else {
                if (Vo > Vr) {
                    decreaseDdash();
                    nonSunLightFlow();
                } else {
                    increaseDdash();
                    nonSunLightFlow();
                }
            }
        } else {
            converterTurnOff();
        }
    }

    public static void converterTurnOff() {
        D = 0.0;
        DD = 0.0;
    }

    public static void decreaseDdash() {
        // decrease Ddash
    }

    public static void increaseDdash() {
        // increase Ddash
    }

    public static void MPPTIndicatesD() {
        // TODO: expected logic for MPPT
    }

    public static void workWithSameDdash() {
        // TODO: expected logic for working with same Ddash
    }
}
