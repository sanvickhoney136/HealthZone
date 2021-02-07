using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Text;
using Newtonsoft.Json;
using System.Data;
using Newtonsoft.Json.Linq;
using HealthZonemr.Models;
using System.Data.SqlClient;

namespace HealthZonemr.demo.pages.samples
{


    public partial class register : System.Web.UI.Page
    {

        SqlConnection con = new SqlConnection("Data Source=LAPTOP-HF32C6EA;Initial Catalog=Healthzonemr;Integrated Security=True");

        private static HttpClient _httpClient = new HttpClient();


        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnreg_Click(object sender, EventArgs e)
        {
            if (txtfirstname.Text != "" && txtlastname.Text != "" && txtemail.Text != "" && txtmobile.Text != "" && txtID.Text != "")
            {
                if (drpusertype.SelectedItem.Text == "Doctor")
                {
                    var obj = new DoctorRegisterModel()
                    {
                        firstname = txtfirstname.Text,
                        lastname = txtlastname.Text,
                        email = txtemail.Text,
                        password = txtpwd.Text,
                        phone = txtmobile.Text,
                        doctorid = txtID.Text
                    };


                    var myContent = JsonConvert.SerializeObject(obj);

                    var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
                    var byteContent = new ByteArrayContent(buffer);
                    byteContent.Headers.ContentType = new MediaTypeHeaderValue("application/json");


                    HttpResponseMessage result = _httpClient.PostAsync("https://medimok-m.herokuapp.com/doctor/register", byteContent).Result;
                    if (result.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        try
                        {
                            string fname = txtfirstname.Text;
                            string lname = txtlastname.Text;
                            string email = txtemail.Text;
                            string pass = txtpwd.Text;
                            string phone = txtmobile.Text;
                            string id = txtID.Text;
                            string usertype = drpusertype.SelectedValue.ToString();

                            con.Open();
                            SqlCommand cmd = new SqlCommand("insert into Userreg(Firstname,Lastname,Email,Password,Mobile,ID,Usertype) values('" + fname + "','" + lname + "','" + email + "','" + pass + "','" + phone + "','" + id + "','" + usertype + "')", con);
                            cmd.ExecuteNonQuery();
                            con.Close();
                        }
                        catch (Exception ex) { }
                        Response.Redirect("login.aspx");

                    }
                    else
                    {
                        ScriptManager.RegisterStartupScript(this, GetType(), "ServerControlScript", "alert(\"Please try again!\");", true);
                    }

                }
                else
                {
                    var obj = new EmployeeRegisterModel()
                    {
                        firstname = txtfirstname.Text,
                        lastname = txtlastname.Text,
                        email = txtemail.Text,
                        password = txtpwd.Text,
                        phone = txtmobile.Text,
                        registerno = txtID.Text,
                        companyname = "TCS"

                    };


                    var myContent = JsonConvert.SerializeObject(obj);

                    var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
                    var byteContent = new ByteArrayContent(buffer);
                    byteContent.Headers.ContentType = new MediaTypeHeaderValue("application/json");


                    HttpResponseMessage result = _httpClient.PostAsync("https://medimok-m.herokuapp.com/employee/register", byteContent).Result;
                    if (result.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        try
                        {
                            string fname = txtfirstname.Text;
                            string lname = txtlastname.Text;
                            string email = txtemail.Text;
                            string pass = txtpwd.Text;
                            string phone = txtmobile.Text;
                            string id = txtID.Text;
                            string usertype = drpusertype.SelectedValue.ToString();

                            con.Open();
                            SqlCommand cmd = new SqlCommand("insert into Userreg(Firstname,Lastname,Email,Password,Mobile,ID,Usertype) values('" + fname + "','" + lname + "','" + email + "','" + pass + "','" + phone + "','" + id + "','" + usertype + "')", con);
                            cmd.ExecuteNonQuery();
                            con.Close();
                        }
                        catch (Exception ex) { }
                        
                        Response.Redirect("login.aspx");
                    }



                    else { ScriptManager.RegisterStartupScript(this, GetType(), "ServerControlScript", "alert(\"Please try again!\");", true); }

                }
            }
            else
            {
                ScriptManager.RegisterStartupScript(this, GetType(), "ServerControlScript", "alert(\"Please Enter All the field!\");", true);
            }


            
        }
    }
}