<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="OverEmployee.aspx.cs" Inherits="HealthZonemr.demo.pages.samples.OverEmployee" %>

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

        td.Tag1 {
            display: none;
        }

        th.Tag1 {
            display: none;
        }

        .active {
            background-color: #4CAF50;
        }


    </style>

</head>
<body style="background-image: url(images/Picture8.jpg); background-color: #0001053b;">
    <ul>
        <li><a href="/demo/index.aspx">Dashboard</a></li>
        <li><a href="Chat.aspx">Chat</a></li>
        <li><a href="login.aspx">logout</a></li>
    </ul>

    <form id="form1" runat="server">
        &nbsp;<div id="outPopUp">

            <asp:HiddenField ID="hdnRegId" runat="server" />
            <asp:HiddenField ID="hdnblockcode1" runat="server" />
            <asp:HiddenField ID="hdnblockcode2" runat="server" />

            <asp:TextBox ID="TextBox1" runat="server" Style="z-index: 1; left: 706px; top: 148px; position: absolute; width: 329px;" Enabled="False"></asp:TextBox>



            <asp:GridView ID="GridView1" class="center" AutoGenerateSelectButton="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" AutoGenerateColumns="false"
                runat="server" Style="z-index: 1; left: 200px;  top: 232px; position: absolute; height: 119px" BackColor="White" BorderColor="#999999"
                BorderStyle="None" BorderWidth="1px" CellPadding="3" GridLines="Vertical">
                <Columns>
                    <asp:TemplateField ItemStyle-Width="10">
                        <HeaderTemplate>
                            Serial No.
                        </HeaderTemplate>
                        <ItemTemplate>
                            <%# Container.DataItemIndex + 1 %>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:BoundField HeaderText="Employee ID" DataField="_id" ItemStyle-Width="100" />
                    <asp:BoundField HeaderStyle-CssClass="Tag1" ItemStyle-CssClass="Tag1" DataField="block_code_one" />
                    <asp:BoundField HeaderStyle-CssClass="Tag1" ItemStyle-CssClass="Tag1" DataField="block_code_two" />
                    <asp:BoundField DataField="firstname" HeaderText="First name" ItemStyle-Width="150" />
                    <asp:BoundField DataField="lastname" HeaderText="Last name" ItemStyle-Width="150" />
                    <asp:BoundField DataField="email" HeaderText="Email" ItemStyle-Width="150" />
                    <asp:BoundField DataField="registerno" HeaderText="Register Number" ItemStyle-Width="150" />
                    <asp:BoundField DataField="companyname" HeaderText="Company Name" ItemStyle-Width="50" />
                </Columns>
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

            <asp:GridView ID="GridView2" OnRowDataBound="GridView2_RowDataBound" AutoGenerateColumns="false" runat="server" Style="z-index: 1; left: 150px; top: 232px; position: absolute; height: 119px; width: 1100px" BackColor="White" BorderColor="#999999" BorderStyle="None" BorderWidth="1px" CellPadding="3" GridLines="Vertical">

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
                
                <Columns>
                <asp:BoundField HeaderText="Body Temperature" DataField="bodyTemperature" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="BP" DataField="bloodPressure" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Respiration" DataField="respiration" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Glucose" DataField="glucose" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="HeartRate" DataField="heartRate" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Cholesterol" DataField="cholesterol" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Oxygen" DataField="oxygen" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Cardiogram" DataField="cardiogram" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Asthma" DataField="asthma" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Depression" DataField="depression" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Sugar" DataField="sugar" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Headaches" DataField="headaches" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Anxiety" DataField="anxiety" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Status" DataField="status" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Last Update" DataField="update" ItemStyle-Width="100" />
                <asp:BoundField HeaderText="Address" DataField="address" ItemStyle-Width="100" />
                    </Columns>
            </asp:GridView>




            <asp:Button ID="Button4" runat="server" BackColor="#3333CC" ForeColor="#FFFFCC" OnClick="Button4_Click" Style="z-index: 1; left: 1069px; top: 145px; position: absolute; height: 31px" Text="View Record" />
            &nbsp &nbsp
            
            <asp:Button ID="btnGrid1Visible" runat="server" BackColor="#3333CC" ForeColor="#FFFFCC" OnClick="btnGridVisible_Click" Style="z-index: 1; left: 1169px; top: 145px; position: absolute; height: 31px" Text="Show List of Employees" />
        </div>
    </form>
</body>
</html>
