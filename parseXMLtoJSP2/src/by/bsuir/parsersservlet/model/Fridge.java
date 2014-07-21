package by.bsuir.parsersservlet.model;

import org.apache.log4j.Logger;

import by.bsuir.parsersservlet.exceptions.LogicalException;
import by.bsuir.parsersservlet.exceptions.TechnicalException;
import by.bsuir.parsersservlet.modelabstractions.ElectricalAppliance;


public class Fridge extends ElectricalAppliance {

    static Logger log = Logger.getLogger(Fridge.class.getName());
    private String consumptionClass;
    private int volume;

    enum PowerConsumptionClass {

        A, B, C, D, E, F, G;

        public boolean checkPowerConsumptionByClass(int powerConsumption) {
            boolean result = false;
            switch (this) {
                case A:
                    if (powerConsumption <= 550) {
                        result = true;
                    }
                    break;
                case B:
                    if (powerConsumption > 550 && powerConsumption <= 750) {
                        result = true;
                    }
                    break;
                case C:
                    if (powerConsumption > 750 && powerConsumption <= 900) {
                        result = true;
                    }
                    break;
                case D:
                    if (powerConsumption > 900 && powerConsumption <= 1000) {
                        result = true;
                    }
                    break;
                case E:
                    if (powerConsumption > 1000 && powerConsumption <= 1100) {
                        result = true;
                    }
                    break;
                case F:
                    if (powerConsumption > 1100 && powerConsumption <= 1250) {
                        result = true;
                    }
                    break;
                case G:
                    if (powerConsumption > 1250) {
                        result = true;
                    }
                    break;
                default:
                    result = false;
                    break;

            }
            return result;
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

    public Fridge(boolean isSwithedOn, int maxPowerConsumption, String consumptionClass, String producer) {
        super(isSwithedOn, maxPowerConsumption, producer);
        this.consumptionClass = consumptionClass;
    }

    public Fridge(boolean isSwitchedOn, int maxPowerConsumption, String producer, String model, String consumptionClass, int volume) {
        super(isSwitchedOn, maxPowerConsumption, producer, model);
        this.consumptionClass = consumptionClass;
        this.volume = volume;
    }

    public String getConsumptionClass() {
        return consumptionClass;
    }

    public void setConsumptionClass(String consumptionClass) throws TechnicalException {
        try {
            PowerConsumptionClass className = PowerConsumptionClass.valueOf(consumptionClass.toUpperCase());
            if (this.maxPowerConsumption != 0) // если уже установлена мощность - определяем соответствие классу потребляемой мощности
            {
                if (!className.checkPowerConsumptionByClass(this.maxPowerConsumption)) {
                    throw new LogicalException("power consumption class \'" + consumptionClass + "\' does not suit max power consumption = " + this.maxPowerConsumption);
                }
            }
            this.consumptionClass = consumptionClass;

        } catch (IllegalArgumentException ex) {
            throw new TechnicalException("\'" + consumptionClass + "\' - there is no such power consumption class ", ex);
        } catch (LogicalException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void setMaxPowerConsumption(int maxPowerConsumption) {
        try {
            if (this.consumptionClass != null) {
                PowerConsumptionClass className = PowerConsumptionClass.valueOf(this.consumptionClass.toUpperCase());
                if (!className.checkPowerConsumptionByClass(maxPowerConsumption)) {
                    throw new LogicalException("max power consumption = " + maxPowerConsumption + " does not suit power consumption class \'" + this.consumptionClass + "\'");
                }
            }
            this.maxPowerConsumption = maxPowerConsumption;
        } catch (LogicalException ex) {
            log.error(ex.getMessage());
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
        return super.toString() + " consumptionClass = " + this.consumptionClass + " volume = " + volume + "\n";
    }
}

