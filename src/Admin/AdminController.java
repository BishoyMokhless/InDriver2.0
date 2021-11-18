package Admin;

import Driver.Driver;
import User.Status;
import User.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminController extends AdminModel implements AdminServices {


    @Override
    public void verifyDriverRegistration(Driver driver) throws SQLException, ClassNotFoundException {
        String licenseID = driver.getDrivingLicense();
        String nationalID = driver.getNationalID();


        if(licenseID.length() == 14 && nationalID.length() == 14)
        {
            driver.getStatus();
        }


    }

    @Override
    public List<Driver> listPendingDrivers() throws SQLException, ClassNotFoundException {

        List<Driver> pendingDrivers = new ArrayList<Driver>();
        for (int i=0; i < drivers.size(); i++)
        {
            Driver  testDriver = drivers.get(i);
            if(testDriver.getStatus() == Status.UnVerified)
            {
             pendingDrivers.add(testDriver);
            }

        }
        return pendingDrivers;
    }

    @Override
    public void suspendAccount(User user) throws SQLException, ClassNotFoundException {
       user.getStatus().equals(Status.Suspended);
    }
}
