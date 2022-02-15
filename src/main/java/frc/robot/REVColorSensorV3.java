package frc.robot;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

public class REVColorSensorV3 {

    private MUX m_mux;
    private MUX.Port m_muxPort;
    private ColorSensorV3 m_sensor;

    /**
     * 
     * @param mux  The MUX on the I2C bus
     * @param port
     */
    public REVColorSensorV3(MUX mux, MUX.Port port) {
        m_mux = mux;
        m_muxPort = port;

        m_mux.switchToPort(m_muxPort);
        m_sensor = new ColorSensorV3(I2C.Port.kMXP);
    }

    /**
     * Get the most likely color. Works best when within 2 inches and perpendicular
     * to surface of interest.
     * 
     * @return Color enum of the most likely color, including unknown if the minimum
     *         threshold is not met
     */
    public Color getColor() {
        return m_sensor.getColor();
    }

    /**
     * 
     * Get the raw proximity value from the sensor ADC (11 bit)
     * 
     * @return Proximity measurement value, ranging from 0 to 2047
     */
    public int getProximity() {
        return m_sensor.getProximity();
    }

}
