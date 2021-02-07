<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="register.aspx.cs" Inherits="HealthZonemr.demo.pages.samples.register" %>

<!DOCTYPE html>

<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Health Zone</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="/assets/Register/fonts/material-icon/css/material-design-iconic-font.min.css">
        <link rel="shortcut icon" href="../assets/images/favicon.png" />
    <!-- Main css -->
    <link rel="stylesheet" href="/assets/Register/css/style.css">
</head>
<body>
     <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form runat="server" class="register-form">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                  <asp:textbox runat="server" name="name" placeholder="First Name (Length 4)" ID="txtfirstname"/>
                            </div>
                              <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                  <asp:textbox runat="server" name="name" placeholder="Last Name (Length 4)" ID="txtlastname"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <asp:textbox runat="server" name="email"  placeholder="Your Email (Ex: raj@gmail.com)" ID="txtemail"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                  <asp:textbox runat="server"  name="pass" ID="txtpwd" placeholder="Password (Length 8)" TextMode="Password"/>
                            </div>
                            <div class="form-group">
                                <label for="mobile"><i class="zmdi-phone"></i></label>
                                <asp:textbox runat="server" name="mobile" placeholder="Mobile Number"  ID="txtmobile"/>
                            </div>
                                <div class="form-group">
                                <label for="mobile"><i class="zmdi zmdi-lock-outline"></i></label>
                                <asp:textbox runat="server" name="id" placeholder="Your Id (Length 10)"  ID="txtID"/>
                            </div>
                            <div class="form-group">
                                <label>Your Role</label>
                                </div>
                                <div class="form-group">
                                 <asp:DropDownList ID="drpusertype" name="mobile" runat="server">
                                  <asp:ListItem>Employee</asp:ListItem>
                                  <asp:ListItem>Doctor</asp:ListItem>
                              </asp:DropDownList>
                            </div>
                            <div class="form-group form-button">
                                <asp:Button runat="server" name="signup"  ID="btnreg" text="Register" OnClick="btnreg_Click" class="form-submit"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="/assets/Register/images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="login.aspx" class="signup-image-link">Already have an account</a>
                    </div>
                </div>
            </div>
        </section>

      <script src="/assets/Register/vendor/jquery/jquery.min.js"></script>
    <script src="/assets/Register/js/main.js"></script>
</body>
</html>
