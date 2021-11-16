package Admin;

import Driver.Driver;

import java.util.List;

public class AdminController implements AdminServices {


    @Override
    public void verifyDriverRegistration(Driver driver) {
        String licenseID = driver.getDrivingLicense();
        String nationalID = driver.getNationalID();


        if(licenseID.length() == 14 && nationalID.length() == 14)
        {
            driver.getStatus()
        }


    }

    @Override
    public List<Driver> listPendingDrivers() {
        return null;
    }

    @Override
    public void suspendAccount() {

    }
}
