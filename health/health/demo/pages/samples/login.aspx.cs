using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Text;
using Newtonsoft.Json;
using System.Data;
using Newtonsoft.Json.Linq;
using System.Net.Http;
using System.Net.Http.Headers;

namespace HealthZonemr.demo.pages.samples
{
    public partial class login : System.Web.UI.Page
    {
        private static HttpClient _httpClient = new HttpClient();

        public static string name, password, id, usertype;
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnlogin_Click(object sender, EventArgs e)
        {



            if (ddlRole.SelectedItem.Text == "Doctor") {

                var obj = new HealthZonemr.Models.DrLogin ()
                {
                    doctorid = txtuser.Text,
                    password = txtpass.Text,

                };


                var myContent = JsonConvert.SerializeObject(obj);

                var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
                var byteContent = new ByteArrayContent(buffer);
                byteContent.Headers.ContentType = new MediaTypeHeaderValue("application/json");



                HttpResponseMessage result = _httpClient.PostAsync("https://medimok-m.herokuapp.com/doctor/login", byteContent).Result;
                if (result.StatusCode == System.Net.HttpStatusCode.OK)
                {
                    Session["drId"] = txtuser.Text;
                    Session["Role"] = ddlRole.SelectedItem.Text;
                    Response.Redirect("/index.aspx");
                    
                }
                else
                { ScriptManager.RegisterStartupScript(this, GetType(), "ServerControlScript", "alert(\"Please try again!\");", true); 
                }
             
            }
            else
            {

                var obj = new HealthZonemr.Models.EmpLogin()
                {
                    registerno = txtuser.Text,
                    password = txtpass.Text,

                };


                var myContent = JsonConvert.SerializeObject(obj);

                var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
                var byteContent = new ByteArrayContent(buffer);
                byteContent.Headers.ContentType = new MediaTypeHeaderValue("application/json");



                HttpResponseMessage result = _httpClient.PostAsync("https://medimok-m.herokuapp.com/employee/login", byteContent).Result;
                if (result.StatusCode == System.Net.HttpStatusCode.OK)
                {
                    Session["empId"] = txtuser.Text;
                    Session["Role"] = ddlRole.SelectedItem.Text;
                    Response.Redirect("OverEmployee.aspx");
                    
                }
                else
                {
                    ScriptManager.RegisterStartupScript(this, GetType(), "ServerControlScript", "alert(\"Please try again!\");", true);
                }
            }

          

        }
    }
}