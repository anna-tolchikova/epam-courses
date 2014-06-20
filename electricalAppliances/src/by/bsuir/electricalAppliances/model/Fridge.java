package by.bsuir.electricalAppliances.model;

import by.bsuir.electricalAppliances.exceptions.LogicalException;
import by.bsuir.electricalAppliances.exceptions.TechnicalException;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fridge extends ElectricalAppliance {

    private String consumptionClass;

    enum PowerConsumptionClass {

        A, B, C, D, E, F, G;

        public boolean checkPowerConsumptionByClass(int powerConsumption) {
            switch (this) {
                case A:
                    if (powerConsumption <= 550) {
                        return true;
                    }
                case B:
                    if (powerConsumption > 550 && powerConsumption <= 750) {
                        return true;
                    }
                case C:
                    if (powerConsumption > 750 && powerConsumption <= 900) {
                        return true;
                    }
                case D:
                    if (powerConsumption > 900 && powerConsumption <= 1000) {
                        return true;
                    }
                case E:
                    if (powerConsumption > 1000 && powerConsumption <= 1100) {
                        return true;
                    }
                case F:
                    if (powerConsumption > 1100 && powerConsumption <= 1250) {
                        return true;
                    }
                case G:
                    if (powerConsumption > 1250) {
                        return true;
                    }
                default:
                    return false;

            }
        }
    }

    public Fridge() {
        super();
    }

    public Fridge(String consumptionClass) {
        super();
        this.consumptionClass = consumptionClass;
    }

    public Fridge(boolean isSwithedOn, String consumptionClass) {
        super(isSwithedOn);
        this.consumptionClass = consumptionClass;
    }

    public Fridge(boolean isSwithedOn, int maxPowerConsumption, String consumptionClass) {
        super(isSwithedOn, maxPowerConsumption);
        this.consumptionClass = consumptionClass;
    }

    public String getConsumptionClass() {
        return consumptionClass;
    }

    public void setConsumptionClass(String consumptionClass) throws TechnicalException, LogicalException {
        try {
            PowerConsumptionClass className = PowerConsumptionClass.valueOf(consumptionClass.toUpperCase());
            if (this.maxPowerConsumption != 0) // если уже установлена мощность - определяем соответствие классу потребляемой мощности
                if (!className.checkPowerConsumptionByClass(this.maxPowerConsumption))
                    throw new LogicalException("power consumption class does not suit max power consumption");
            this.consumptionClass = consumptionClass;
        } 
        catch (IllegalArgumentException ex) {
            // записать в логгер уровень эррор  -
            throw new TechnicalException(ex, "no such power consumption class");
        }
    }

    @Override
    public void setMaxPowerConsumption(int maxPowerConsumption) {
        PowerConsumptionClass className = PowerConsumptionClass.valueOf(this.consumptionClass.toUpperCase());
        if (this.consumptionClass != null)
            if (!className.checkPowerConsumptionByClass(maxPowerConsumption))
                try {
            throw new LogicalException("max power consumption does not suit power consumption class");
        } catch (LogicalException ex) {

            //Logger.getLogger(Fridge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fridge other = (Fridge) obj;
        if ((this.consumptionClass == null) ? (other.consumptionClass != null) : !this.consumptionClass.equals(other.consumptionClass)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.consumptionClass != null ? this.consumptionClass.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return super.toString() + " ConsumptionClass = " + this.consumptionClass + "\n";
    }
}
