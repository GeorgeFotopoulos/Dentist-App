package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile;

public class DentistViewProfileViewStub implements DentistViewProfileView {

    public int x=0;

    @Override
    public void updateAccount() {
      this.x++;
    }

    public int getX(){
        return x;
    }
}
