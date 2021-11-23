package Admin;
import Driver.Driver;
import User.User;
import java.sql.SQLException;
import java.util.List;

public interface AdminServices {

    public void verifyDriverRegistration(Driver driver) throws SQLException, ClassNotFoundException;
    public List<Driver> listPendingDrivers() throws SQLException, ClassNotFoundException;
    public void suspendAccount(User user) throws SQLException, ClassNotFoundException;





}
