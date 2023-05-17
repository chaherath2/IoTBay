package dao;


import model.Device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBDeviceManager {
    private Connection conn;

    public DBDeviceManager(Connection conn) throws SQLException {
        this.conn = conn;
    }

    public List<Device> selectAllDevices() throws SQLException {
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM device");
        ResultSet rs = selectStatement.executeQuery();
        List<Device> devices = new ArrayList<>();
        while (rs.next()){
            Long id = rs.getLong(1);
            String deviceId = rs.getString(2);

            String deviceName = rs.getString(3);
            String deviceDescription = rs.getString(4);
            Double price = rs.getDouble(5);
            Integer stock = rs.getInt(6);
            Long cTime = rs.getLong(7);
            Long uTime = rs.getLong(8);

            Boolean availability = rs.getBoolean(9);
            Integer type = rs.getInt(10);
            devices.add(new Device(id, deviceId, type, deviceName, deviceDescription, price, stock, cTime, uTime, availability));
        }
        selectStatement.close();
        return devices;
    }

    public void updateDevice(Device device) throws SQLException {
        String sql = "update device set device_type = ?, device_name = ?, device_description = ?, price = ?, stock = ?, uTime = ? where id = ?";
        PreparedStatement updateStatement = conn.prepareStatement(sql);
        updateStatement.setInt(1, device.getType());
        updateStatement.setString(2, device.getDeviceName());
        updateStatement.setString(3, device.getDeviceDescription());
        updateStatement.setDouble(4, device.getPrice());
        updateStatement.setInt(5, device.getStock());
        updateStatement.setLong(6, System.currentTimeMillis());
        updateStatement.setLong(7, device.getId());
        updateStatement.executeUpdate();
        updateStatement.close();
    }

    public void deleteDeviceById(Long id) throws SQLException {
        String sql = "delete from device where id = ?";
        PreparedStatement deleteStatement = conn.prepareStatement(sql);
        deleteStatement.setLong(1, id);
        deleteStatement.executeUpdate();
        deleteStatement.close();
    }

    public void addDevice(Device device) throws SQLException {
        String sql = "insert into device(device_id, device_type, device_name, device_description, price, stock, cTime, uTime, availability)" +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = conn.prepareStatement(sql);
        insertStatement.setString(1, device.getDeviceId());;
        insertStatement.setInt(2, device.getType());
        insertStatement.setString(3, device.getDeviceName());
        insertStatement.setString(4, device.getDeviceDescription());
        insertStatement.setDouble(5, device.getPrice());
        insertStatement.setInt(6, device.getStock());
        insertStatement.setLong(7, device.getCTime());
        insertStatement.setLong(8, device.getUTime());
        insertStatement.setBoolean(9, true);
        insertStatement.executeUpdate();
        insertStatement.close();
    }

}
