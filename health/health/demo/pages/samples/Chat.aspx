<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Chat.aspx.cs" Inherits="HealthZonemr.demo.pages.samples.Chat" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Health Zone</title>
    <link rel="shortcut icon" href="../assets/images/favicon.png" />
    <style>

        ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}



    </style>
    
</head>
<body style="background-image:url(images/Picture8.jpg)">
    <ul>
  <li><a  href="/demo/index.aspx">Dashboard</a></li>
  <li><a href="Chat.aspx">Chat</a></li>
 <li><a href="login.aspx">logout</a></li>
</ul>

    <form id="form1" runat="server">
      
        &nbsp;<div style="border:1px solid black;height:1128px;background-color: cornsilk;">


            <asp:TextBox ID="TextBox1" runat="server" style="z-index: 1; left: 369px; top: 220px; position: absolute; width: 402px; height: 135px;" TextMode="MultiLine"></asp:TextBox>
            
            <asp:GridView ID="GridView1" runat="server" style="z-index: 1; left: 49px; top: 563px; position: absolute; height: 119px; width: 1100px" BackColor="White" BorderColor="#999999" BorderStyle="None" BorderWidth="1px" CellPadding="3" GridLines="Vertical">
                <AlternatingRowStyle BackColor="#DCDCDC" />
                <FooterStyle BackColor="#CCCCCC" ForeColor="Black" />
                <HeaderStyle BackColor="#000084" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
                <RowStyle BackColor="#EEEEEE" ForeColor="Black" />
                <SelectedRowStyle BackColor="#008A8C" Font-Bold="True" ForeColor="White" />
                <SortedAscendingCellStyle BackColor="#F1F1F1" />
                <SortedAscendingHeaderStyle BackColor="#0000A9" />
                <SortedDescendingCellStyle BackColor="#CAC9C9" />
                <SortedDescendingHeaderStyle BackColor="#000065" />
            </asp:GridView>
       


            <asp:Button ID="Button1" runat="server" OnClick="Button5_Click" style="z-index: 1; left: 365px; top: 388px; position: absolute; height: 43px; width: 142px;" Text="Send" BackColor="#3333CC" ForeColor="#FFFFCC" />
   


            <asp:Button ID="Button2" runat="server" OnClick="Btnmail_Click" style="z-index: 1; left: 1080px; top: 152px; position: absolute; height: 36px; width: 218px;" Visible="false" Text="Send Health alert Mail " BackColor="#009933" ForeColor="#FFFFCC" />

             <asp:DropDownList ID="DropDownList1" runat="server" style="z-index: 1; left: 372px; top: 150px; position: absolute; height: 19px; width: 205px">
            </asp:DropDownList>
            <asp:Label ID="Label1" runat="server" Font-Bold="True" ForeColor="#006600" style="z-index: 1; left: 181px; top: 208px; position: absolute" Text="Message:"></asp:Label>
   
            <asp:Label ID="Label2" runat="server" Font-Bold="True" ForeColor="#006600" style="z-index: 1; left: 1149px; top: 103px; position: absolute"></asp:Label>

            <asp:Label ID="Label3" runat="server" Font-Bold="True" ForeColor="#006600" style="z-index: 1; left: 1014px; top: 104px; position: absolute" Text="WELCOME:"></asp:Label>

            <asp:Label ID="Label4" runat="server" Font-Bold="True" ForeColor="#006600" style="z-index: 1; left: 185px; top: 147px; position: absolute" Text="USER ID:"></asp:Label>




             </div>
            </form>
</body>
</html>

