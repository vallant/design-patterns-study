package controller.javafx;

import data.User;
import model.impl.LoginModelImpl;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import view.javafx.login.LoginViewFX;

import java.util.Arrays;

public class LoginControllerFX
{
  private LoginViewFX    view;
  private LoginModelImpl model;

  public LoginControllerFX()
  {

  }


  public void resetPasswordClicked()
  {
    view.switchToResetPassword();
  }


  public void loginClicked()
  {
    String username = view.getEnteredUsername();
    char[] password = view.getEnteredPassword();
    if(username.isEmpty())
      view.showError("Please provide a valid username");
    else if(password.length == 0)
      view.showError("Please provide a valid password");
    else
      try
      {
        model.login(username, password);
      }
      catch(Exception e)
      {
        e.printStackTrace();
        view.showError(e.getLocalizedMessage());
      }
  }


  public void addUserClicked()
  {
    view.switchToAddNewUser();
  }


  public void backToLoginClicked()
  {
    view.switchToLogin();
  }


  public void addClicked()
  {
    User u = view.getEnteredUser();
    if((u.getEmail().isEmpty() ||
        u.getFirstName().isEmpty() ||
        u.getLastName().isEmpty() ||
        u.getLoginName().isEmpty() ||
        u.getNewPassword().length == 0))
      view.showError("Please fill all fields");
    else if(!Arrays.equals(u.getNewPassword(), u.getNewPasswordAgain()))
      view.showError("The passwords do not match");
    else
      try
      {
        model.saveNewUser(u);
      }
      catch(Exception e)
      {
        e.printStackTrace();
        view.showError(e.getLocalizedMessage());
      }


  }


  public void resetClicked()
  {
    throw new NotImplementedException();
  }


  public void setView(LoginViewFX view)
  {
    this.view = view;
  }


  public void showDialog(String message)
  {
    view.showDialog(message);
  }


  public void loginFailed()
  {
    view.showLoginFailed();
  }

  private boolean isValid(User u)
  {
    return !(u.getEmail().isEmpty() ||
             u.getFirstName().isEmpty() ||
             u.getLastName().isEmpty() ||
             u.getLoginName().isEmpty() ||
             u.getNewPassword().length == 0);
  }


  public void setModel(LoginModelImpl model)
  {
    this.model = model;
  }
}