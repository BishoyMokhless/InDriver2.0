package Admin;

import Client.Client;
import Driver.Driver;
import User.User;

import java.sql.SQLException;
import java.util.List;

public interface AdminServices {
    List<User> users = null;
    List<User> verifiedUsers = null;
    List<User> suspendedUsers = null;
    List<Client> clients = null;
    List<Driver> drivers = null;
    public List<Driver> getDrivers();
    public void verifyDriverRegistration(Driver driver) throws SQLException, ClassNotFoundException;
    public List<Driver> listPendingDrivers() throws SQLException, ClassNotFoundException;
    public void suspendAccount(User user) throws SQLException, ClassNotFoundException;





}
