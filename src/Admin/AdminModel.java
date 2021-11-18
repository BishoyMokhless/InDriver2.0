package Admin;

import Client.Client;
import Driver.Driver;
import User.User;
import java.util.List;

public class AdminModel {
    List<User> users ;
    List<User> verifiedUsers;
    List<User> suspendedUsers;
    List<Client> clients;
    List<Driver> drivers ;

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getVerifiedUsers() {
        return verifiedUsers;
    }

    public void setVerifiedUsers(List<User> verifiedUsers) {
        this.verifiedUsers = verifiedUsers;
    }

    public List<User> getSuspendedUsers() {
        return suspendedUsers;
    }

    public void setSuspendedUsers(List<User> suspendedUsers) {
        this.suspendedUsers = suspendedUsers;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
