using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;
using System.IO;
using System.Net;
using System.Net.Mail;
using System.Text;

namespace HealthZonemr.demo.pages.samples
{
    public partial class Chat : System.Web.UI.Page
    {

        SqlConnection con = new SqlConnection("Data Source=LAPTOP-HF32C6EA;Initial Catalog=Healthzonemr;Integrated Security=True");
        public static string userID, usertype, chkuser;

        protected void Btnmail_Click(object sender, EventArgs e)
        {
            string to = "kavitcs455@gmail.com"; //To address    
            string from = "noreplymedonline@gmail.com"; //From address    
            MailMessage message = new MailMessage(from, to);

            string mailbody = "Your Health Condition critical Now";
            message.Subject = "Mail from MedOnline";
            message.Body = mailbody;
            message.BodyEncoding = Encoding.UTF8;
            message.IsBodyHtml = true;
            SmtpClient client = new SmtpClient("smtp.gmail.com", 587); //Gmail smtp    

            client.UseDefaultCredentials = false;
            System.Net.NetworkCredential basicCredential1 = new

            System.Net.NetworkCredential("noreplymedonline@gmail.com", "med123");

            client.EnableSsl = true;
            client.UseDefaultCredentials = false;
            client.Credentials = basicCredential1;
            try
            {
                client.Send(message);
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Mail sent')", true);
            }

            catch (Exception ex)
            {
                throw ex;
            }
        }

        protected void Button5_Click(object sender, EventArgs e)
        {

            con.Open();
            string date1 = DateTime.Now.ToString();

            SqlCommand cmd1 = new SqlCommand("insert into Message(From_Msg,To_Msg,Message,MessageDate) values ('" + userID + "','" + DropDownList1.SelectedItem.ToString() + "','" + TextBox1.Text + "','" + date1 + "')", con);
            cmd1.ExecuteNonQuery();
            con.Close();
            ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert(Message Sent')", true);


        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (HttpContext.Current.Session["drId"] != null)
            {
                userID = Session["drId"].ToString();
            }
            else if (HttpContext.Current.Session["empId"] != null)
            {
                userID = Session["empId"].ToString();
            }
            usertype = Session["Role"].ToString();
            Label2.Text = usertype;

            if (usertype == "Doctor")
            {
                chkuser = "Employee";
            }

            else if (usertype == "Employee")
            {
                chkuser = "Doctor";
            }

            con.Open();
            SqlDataAdapter da = new SqlDataAdapter("select  ID from Userreg where Usertype='" + chkuser + "'", con);
            DataSet ds = new DataSet();
            da.Fill(ds);
            DropDownList1.DataSource = ds;
            DropDownList1.DataTextField = "ID";
            DropDownList1.DataValueField = "ID";
            DropDownList1.DataBind();
            con.Close();


            con.Open();

            SqlDataAdapter sda = new SqlDataAdapter("select * from  Message where To_Msg='" + userID + "'", con);


            DataTable dt = new DataTable();

            sda.Fill(dt);
            GridView1.DataSource = dt;
            GridView1.DataBind();

            con.Close();




        }
    }
}