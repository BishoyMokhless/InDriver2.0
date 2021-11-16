package Admin;

import Driver.Driver;
import User.Status;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class AdminController implements AdminServices {


    @Override
    public List<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void verifyDriverRegistration(Driver driver) {
        String licenseID = driver.getDrivingLicense();
        String nationalID = driver.getNationalID();


        if(licenseID.length() == 14 && nationalID.length() == 14)
        {
            driver.getStatus();
        }


    }

    @Override
    public List<Driver> listPendingDrivers() {

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
    public void suspendAccount(User user) {
       user.getStatus().equals(Status.Suspended);
    }
}
