package frc.robot;

import edu.wpi.first.wpilibj.I2C;

public class MUX {
    private I2C m_i2cBus;

    public enum Port {
        ONE(new byte[] { (byte) 1 }), // single byte array to configure mux for port 3 0b00000001
        TWO(new byte[] { (byte) 2 }), // single byte array to configure mux for port 3 0b00000010
        THREE(new byte[] { (byte) 4 }); // single byte array to configure mux for port 3 0b00000100

        public final byte[] value;

        Port(byte[] value) {
            this.value = value;
        }
    }

    public MUX(I2C.Port i2cPort, int muxAddress) {
        m_i2cBus = new I2C(i2cPort, muxAddress);
    }

    public void switchToPort(MUX.Port port) {
        m_i2cBus.writeBulk(port.value);
    }

    public I2C getI2CBus() {
        return m_i2cBus;
    }
}
