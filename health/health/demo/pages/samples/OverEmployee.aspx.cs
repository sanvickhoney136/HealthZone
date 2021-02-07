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

namespace HealthZonemr.demo.pages.samples
{


    public class jsondata
    {

        public string registerno { get; set; }

        public string blockid { get; set; }

    }


    public class Reportdata
    {

        public string registerno { get; set; }

        public string block_code_one { get; set; }
        public string block_code_two { get; set; }

    }
    public class Doctor_login
    {

        public string doctorid { get; set; }
    }

    public partial class OverEmployee : System.Web.UI.Page
    {
        private static HttpClient _httpClient = new HttpClient();

        public static string blockcode;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (HttpContext.Current.Session["drId"] != null || HttpContext.Current.Session["empId"] != null)
            {
                if (Session["Role"].ToString() == "Doctor")
                {
                    _httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MTA5NjAwOTEsImV4cCI6MTY0MjUxNzY5MSwiYXVkIjoiNjAwNTRjYjM1M2NhZDUwMDI0ZDFlMjFiIiwiaXNzIjoiZ29vZ2xlLmNvbSJ9.puMjI9I_suRdDhSqnMsXfTYIL5Ag9ldKt4uYvhyMKKY");

                    var obj = new Doctor_login()
                    {
                        doctorid = Session["drId"].ToString()

                    };


                    var myContent = JsonConvert.SerializeObject(obj);

                    var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
                    var byteContent = new ByteArrayContent(buffer);
                    byteContent.Headers.ContentType = new MediaTypeHeaderValue("application/json");


                    HttpResponseMessage result = _httpClient.PostAsync("https://medimok-m.herokuapp.com/doctor/employeeinfo", byteContent).Result;
                    if (result.StatusCode == System.Net.HttpStatusCode.OK)
                    {


                        string returnValue = result.Content.ReadAsStringAsync().Result;

                        DataTable dtNewtonSoftLinq = ConvertJsonToDatatableLinq(returnValue);

                        GridView1.DataSource = dtNewtonSoftLinq;
                        GridView1.DataBind();

                    }

                }
                else if (Session["Role"].ToString() == "Employee")
                {
                    TextBox1.Visible = false;
                    Button4.Visible = false;
                    btnGrid1Visible.Visible = false;
                }
            }
        }

        protected void Button3_Click(object sender, EventArgs e)
        {

        }

        protected void Button2_Click(object sender, EventArgs e)
        {

        }

        public bool POSTData(string url)
        {

            //string stringjsonData = @"{'firstname':'gama','lastname':'gasel','email':'games@gmail.com','password':'game@1243','phone':'0099999998','doctorid':'9999990000'}";

            var obj = new jsondata()
            {
                blockid = ""

            };


            var myContent = JsonConvert.SerializeObject(obj);

            var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
            var byteContent = new ByteArrayContent(buffer);
            byteContent.Headers.ContentType = new MediaTypeHeaderValue("application/json");



            HttpResponseMessage result = _httpClient.PostAsync(url, byteContent).Result;
            if (result.StatusCode == System.Net.HttpStatusCode.Created)
                return true;
            string returnValue = result.Content.ReadAsStringAsync().Result;

            DataTable dtNewtonSoftLinq = ConvertJsonToDatatableLinq(returnValue);
            dtNewtonSoftLinq.Columns.Remove("block_key_one");
            dtNewtonSoftLinq.Columns.Remove("block_key_two");

            blockcode = dtNewtonSoftLinq.Rows[0][19].ToString();

            TextBox1.Text = blockcode;

            if (blockcode == TextBox1.Text)
            {

                // dtNewtonSoftLinq.DefaultView.RowFilter = "address like '%" + TextBox1.Text.Trim() + "%' ";
                GridView1.DataSource = dtNewtonSoftLinq;
                GridView1.DataBind();
            }
            else
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert(Invalid blockcode')", true);
            }

            return true;





        }

        public bool POSTGETkeyData(string url)
        {


            var obj = new Doctor_login()
            {
                doctorid = "9999999998",


            };


            var myContent = JsonConvert.SerializeObject(obj);

            var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
            var byteContent = new ByteArrayContent(buffer);
            byteContent.Headers.ContentType = new MediaTypeHeaderValue("application/json");



            HttpResponseMessage result = _httpClient.PostAsync(url, byteContent).Result;
            if (result.StatusCode == System.Net.HttpStatusCode.Created)
                return true;
            string returnValue = result.Content.ReadAsStringAsync().Result;

            JObject o = JObject.Parse(returnValue);

            blockcode = Convert.ToString(o["blockchain"]["blockcode"]);


            TextBox1.Text = blockcode;
            return true;
        }

        public static DataTable ConvertJsonToDatatableLinq(string jsonString)
        {
            var jsonLinq = JObject.Parse(jsonString);

            // Find the first array using Linq
            var linqArray = jsonLinq.Descendants().Where(x => x is JArray).First();
            var jsonArray = new JArray();
            foreach (JObject row in linqArray.Children<JObject>())
            {
                var createRow = new JObject();
                foreach (JProperty column in row.Properties())
                {
                    // Only include JValue types
                    if (column.Value is JValue)
                        createRow.Add(column.Name, column.Value);
                }
                jsonArray.Add(createRow);
            }

            return JsonConvert.DeserializeObject<DataTable>(jsonArray.ToString());
        }

        protected void Button4_Click(object sender, EventArgs e)
        {

            //Doctor & Employee can see the below details
            if (hdnRegId.Value != "" && hdnblockcode1.Value != "" && hdnblockcode2.Value != "")
            {
                _httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MTIzNzEwMTMsImV4cCI6MTY0MzkyODYxMywiYXVkIjoiNjAxYWQzNWNiMWZiMGI0MmZjOTA3ZjJkIiwiaXNzIjoiZ29vZ2xlLmNvbSJ9.RBwpKC51Q-2DkM8RERXtN0B-Q5swWb0gxHj4oI6K7o4");

                var obj = new Reportdata()
                {
                    registerno = hdnRegId.Value,
                    block_code_one = hdnblockcode1.Value,
                    block_code_two = hdnblockcode2.Value,

                };


                var myContent = JsonConvert.SerializeObject(obj);

                var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
                var byteContent = new ByteArrayContent(buffer);
                byteContent.Headers.ContentType = new MediaTypeHeaderValue("application/json");


                HttpResponseMessage result = _httpClient.PostAsync("https://medimok-m.herokuapp.com/doctor/sensor", byteContent).Result;
                if (result.StatusCode == System.Net.HttpStatusCode.OK)
                {


                    string returnValue = result.Content.ReadAsStringAsync().Result;

                    DataTable dtNewtonSoftLinq = ConvertJsonToDatatableLinq(returnValue);
                    if (dtNewtonSoftLinq.Columns.Contains("longitude") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("longitude");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("latitude") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("latitude");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("city") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("city");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("state") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("state");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("county") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("county");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("postalcode") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("postalcode");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("knownName") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("knownName");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("companyname") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("companyname");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("email") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("email");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("firstname") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("firstname");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("lastname") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("lastname");
                    }

                    if (dtNewtonSoftLinq.Columns.Contains("phone") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("phone");
                    }
                    if (dtNewtonSoftLinq.Columns.Contains("registerno") == true)
                    {
                        dtNewtonSoftLinq.Columns.Remove("registerno");
                    }

                    GridView2.DataSource = dtNewtonSoftLinq;
                    GridView2.DataBind();
                    GridView1.Visible = false;
                    GridView2.Visible = true;
                }

            }


        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            TextBox1.Text = GridView1.SelectedRow.Cells[3].Text;
            hdnRegId.Value = GridView1.SelectedRow.Cells[8].Text;
            hdnblockcode1.Value = GridView1.SelectedRow.Cells[4].Text;
            hdnblockcode2.Value = GridView1.SelectedRow.Cells[3].Text;
        }

        protected void btnGridVisible_Click(object sender, EventArgs e)
        {
            GridView2.Visible = false;
            GridView1.Visible = true;
        }

        protected void GridView2_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.Cells[13].Text.Equals("Abnormal"))
            {
                e.Row.Cells[13].BackColor = System.Drawing.Color.DarkRed;
                e.Row.Cells[13].ForeColor = System.Drawing.Color.White;
            }
            if (e.Row.Cells[13].Text.Equals("Normal"))
            {
                e.Row.Cells[13].BackColor = System.Drawing.Color.Green;
                e.Row.Cells[13].ForeColor = System.Drawing.Color.White;
            }
        }
    }
}