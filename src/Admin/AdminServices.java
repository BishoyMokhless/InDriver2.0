package Admin;

import Client.Client;
import Driver.Driver;
import User.User;

import java.util.List;

public interface AdminServices {
    List<User> users = null;
    List<User> verifiedUsers = null;
    List<User> suspendedUsers = null;
    List<Client> clients = null;
    List<Driver> drivers = null;
    public void verifyDriverRegistration();
    public List<Driver> listPendingDrivers();
    public void suspendAccount();





}
